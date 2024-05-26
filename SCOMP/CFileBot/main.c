#include "header.h"
#include <dirent.h>
#include <signal.h>

int main(int argc, char *argv[])
{

    //read the config file
    Config config;
    read_config(&config, argv[1]);
    worker_children = config.worker_children;
    
    
    // Register the signal handler for SIGINT
    struct sigaction sigint_action;
    sigemptyset(&sigint_action.sa_mask);
    sigint_action.sa_flags = SA_SIGINFO;
    sigint_action.sa_sigaction = sigint_handler;
    sigaction(SIGINT, &sigint_action, NULL);

    //This sem is the notification semaphore for the parent and the monitor_directory child
    sem_t *sem_notification = init_sem();   

    //this is the semaphore for the parent and the worker children
    void *shm_ptr = init_shm(); // init_shm should return a pointer to the shared memory segment

    
    
    //This is the sem for parent know that children have read the data, and can write again
    sem_t *sem_parent_write = sem_open(SEM_PARENT_WRITE, O_CREAT, 0644, 0);

    sem_t *semaphores[config.worker_children];

    //This is the sems for childrens wait for parent to write in shm
    char sem_name[256];
    for (int i = 0; i < config.worker_children; i++) {
        snprintf(sem_name, sizeof(sem_name), "%s%d", SEM_CHILD_READ, i);
        semaphores[i] = sem_open(sem_name, O_CREAT|O_EXCL|O_RDWR, 0644, 0);
        if (semaphores[i] == SEM_FAILED) {
            perror("sem_open");
            exit(EXIT_FAILURE);
        }
    }


    pid_t pid;
    int i;
    int sem_index;
    //create the monitor_directory and the worker children
    for (i = 0; i < (config.worker_children + 1); i++)
    {
        pid = fork();
        if (pid == 0)
        {
            if (i == 0)
            {
                sleep(1);
                //monitor_directory child
                //pass input_directory and check_interval as arguments
                execlp("./monitor_directory", "monitor_directory", config.input_directory, config.check_interval, NULL);
                exit(0);
            }
            else
            {
                char sem_name_child[256]={0};
                //generate the name of the semaphore for the child
                snprintf(sem_name_child, sizeof(sem_name_child), "%s%d", SEM_CHILD_READ, i-1);

                //worker children
                //pass input_directory and output_directory as arguments
                execlp("./child", "child", config.input_directory, config.output_directory,sem_name_child , NULL);
                exit(0);
            }
        }
    }

    while (1)
    {
        //waits for the notification from the monitor_directory child
        sem_wait(sem_notification);

        //var to count the prefixes
        int prefixe_count;

        //get the prefixes from the candidate-data files
        char **prefixes = get_candidate_data_file_prefixes(config.input_directory, &prefixe_count);
        
        if (prefixes != NULL)
        {
            for (int i = 0; i < prefixe_count; i++)
            {   
                int sem_index = i % config.worker_children; // Cycle through the children
                //write the prefix in the shared memory
                strcpy(shm_ptr, prefixes[i]); 
                free(prefixes[i]);//free the prefix
                
                sem_post(semaphores[sem_index]); //notify the children that the data is in the shared memory

                sem_wait(sem_parent_write); //wait for the children to read the data
            }
            free(prefixes); // Free the array of pointers
        }
        else
        {
            printf("An error occurred while retrieving prefixes.\n");
        }

        //After all the prefixes are written in the shared memory, the parent waits for the children to finish and then generates the report
        generateReport(config.output_directory); // Generate the report
        
    }

    return 0;
}
