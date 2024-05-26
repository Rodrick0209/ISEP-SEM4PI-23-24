#include "header.h"

// Função que lida com o sinal de interrupção (SIGINT)
void sigint_handler(int signo, siginfo_t *sinfo, void *context)
{
   printf("\nReceived SIGINT signal. Cleaning up and exiting...\n");

    char sem_name[256];

    // unlink semaphores
    sem_unlink(SEM_NOTIFICATION);

    for (int i = 0; i < worker_children; i++) {
        snprintf(sem_name, sizeof(sem_name), "%s%d", SEM_CHILD_READ, i);
        shm_unlink(sem_name);
    }
    sem_unlink(SEM_PARENT_WRITE);

    // Close and unlink shared memory
    shm_unlink(SHM_NAME);

    exit(EXIT_SUCCESS);
    exit(0);
}


