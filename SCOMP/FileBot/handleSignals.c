#include "header.h"

// Função que lida com o sinal de ficheiro encontrado
void handle_fileFoundSignal(int signo, siginfo_t *sinfo, void *context)
{
    if (signo == SIGUSR1)
    {
        printf("Novo Arquivo encontrado\n");
        distribute_files();
    }
}

// Função que lida com o sinal de trabalho do filho terminado
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
    if (count_unique_identifiers(input_directory) == 0)
        {
            generateReport();
        }
}

// Função que lida com o sinal de interrupção (SIGINT)
void sigint_handler(int signo, siginfo_t *sinfo, void *context)
{
    printf("Received SIGINT. Terminating child processes.\n");

    generateReport();

    // Terminate each child process
    for (int i = 0; i < worker_children; i++)
    {
        if (child_pids[i] > 0)
        {
            kill(child_pids[i], SIGTERM);
        }
    }

    // Wait for each child process to terminate
    for (int i = 0; i < worker_children; i++)
    {
        if (child_pids[i] > 0)
        {
            waitpid(child_pids[i], NULL, 0);
        }
    }

    // Fecha os pipes
    for (int i = 0; i < worker_children; i++)
    {
        close(pipes[i][0]);
        close(pipes[i][1]);
    }
    close(fd[0]);
    close(fd[1]);

    // Libera a memória alocada
    free_memory();

    printf("All child processes terminated. Exiting.\n");
    exit(0);
}
