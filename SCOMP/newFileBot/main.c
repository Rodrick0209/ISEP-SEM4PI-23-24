#include "header.h"
#include <dirent.h>

int main(int argc, char *argv[])
{
    
    //read the config file
    Config config;
    read_config(&config, argv[1]);
    

    // Unlink the shared memory and semaphore before creating them
    shm_unlink(SHM_NAME);
    sem_unlink(SEM_CHILD_READ);
    sem_unlink(SEM_PARENT_WRITE);

    // init_sem should return a pointer to the initialized semaphore
    //This sem is the notification semaphore for the parent and the monitor_directory child
    sem_t *sem_notification = init_sem();   

    //this is the semaphore for the parent and the worker children
    void *shm_ptr = init_shm(); // init_shm should return a pointer to the shared memory segment

    //This is the sem for children waits for parent to write in shm
    sem_t *shm_sem = sem_open(SEM_CHILD_READ, O_CREAT, 0644, 0);
    
    //This is the sem for parent know that children have read the data, and can write again
    sem_t *sem_parent_write = sem_open(SEM_PARENT_WRITE, O_CREAT, 0644, 0);


    pid_t pid;
    int i;
    //create the monitor_directory and the worker children
    for (i = 0; i < (config.worker_children + 1); i++)
    {
        pid = fork();
        if (pid == 0)
        {
            if (i == 0)
            {
                //monitor_directory child
                //pass input_directory and check_interval as arguments
                execlp("./monitor_directory", "monitor_directory", config.input_directory, config.check_interval, NULL);
                exit(0);
            }
            else
            {
                //worker children
                //pass input_directory and output_directory as arguments
                execlp("./child", "child", config.input_directory, config.output_directory, NULL);
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
                //write the prefix in the shared memory
                strcpy(shm_ptr, prefixes[i]); 
                
                free(prefixes[i]);//free the prefix
                sem_post(shm_sem); //notify the children that the data is in the shared memory
                sem_wait(sem_parent_write); //wait for the children to read the data
            }
            free(prefixes); // Free the array of pointers
        }
        else
        {
            printf("An error occurred while retrieving prefixes.\n");
        }
        
    }

    return 0;
}
