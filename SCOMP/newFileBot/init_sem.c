#include "header.h"


sem_t *init_sem()
{
    sem_unlink(SEM_NOTIFICATION);
    sem_t *sem = sem_open(SEM_NOTIFICATION, O_CREAT|O_EXCL, 0644, 0);
    if (sem == SEM_FAILED) {
        perror("sem_open");
        exit(EXIT_FAILURE);
    }
    return sem;
}
