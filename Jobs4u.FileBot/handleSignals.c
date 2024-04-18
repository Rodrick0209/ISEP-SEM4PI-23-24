#include "header.h"

void handle_fileFoundSignal(int signo, siginfo_t *sinfo, void *context)
{
    if (signo == SIGUSR1)
    {
        printf("Novo Arquivo encontrado\n");
        sleep(2);
        distribute_files();

    }
}


void handle_childWorkFinishedSignal(int signo, siginfo_t *sinfo, void *context)
{
    if (signo == SIGUSR2)
    {

        int child = getChildIndex();
        for (int i = 0; i < worker_children; i++)
        {
            if (child - 1 == i)
            {
                child_status[i] = 0;
                printf("Processo filho %d terminou o trabalho\n", child);
            }
        }
    }
}
