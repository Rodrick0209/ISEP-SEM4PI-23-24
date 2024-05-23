#include "header.h"
#include <dirent.h>

int main()
{
    Config config;
    read_config(&config, "configFile");

    FileMatrix buffer[MAX_APPLICATIONS];
    memset(buffer, 0, sizeof(buffer));


    // Unlink the shared memory and semaphore before creating them
    shm_unlink(SHM_NAME);
    sem_unlink(SEM_MEM);
    sem_unlink(SEM_PARW);

    sem_t *sem = init_sem();    // init_sem should return a pointer to the initialized semaphore
    void *shm_ptr = init_shm(); // init_shm should return a pointer to the shared memory segment

    sem_t *shm_sem = sem_open(SEM_MEM, O_CREAT, 0644, 0);
    sem_t *shm_semPW = sem_open(SEM_PARW, O_CREAT, 0644, 0);

    pid_t pid;
    int i;
    for (i = 0; i < (config.worker_children+1); i++)
    //for (i = 0; i < 2; i++)
    {
        pid = fork();
        if (pid == 0)
        {
            if (i == 0)
            {
                execlp("./monitor_directory", "monitor_directory", config.input_directory, config.check_interval, NULL);
                exit(0);
            }
            else
            {
                execlp("./child", "child", SHM_NAME, SEM_MEM, config.input_directory, config.output_directory, NULL);
                exit(0);
            }
        }
    }

    while (1)
    {
        sem_wait(sem);
        organize_files(config.input_directory,buffer);

        //print_file_matrix(buffer,MAX_APPLICATIONS);
        //memcpy(shm_ptr, &buffer[0], sizeof(FileMatrix));


        //sem_post(shm_sem);

        //write the buffer to the shared memory
        for (i = 0; i < MAX_APPLICATIONS; i++)
        {
            if (buffer[i].file_counts != 0){
                memcpy(shm_ptr, &buffer[i], sizeof(FileMatrix));
                sem_post(shm_sem);
                sem_wait(shm_semPW);
            }
        }
        

        
    }

    return 0;
}
