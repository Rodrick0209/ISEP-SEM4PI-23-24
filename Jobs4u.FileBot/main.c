#include "header.h"


// Define global variables
char input_directory[MAX_FILENAME];
char output_directory[MAX_FILENAME];
int worker_children;
int check_interval;
int **pipes;
int *child_status;
int processed_ids[MAX_FILES];
int num_ids;
int fd[2];
int num_files;
pid_t *child_pids;


int main()
{
    // Read the configuration file
    read_config();

    // Create the pipes to receive a child index
    pipe(fd);

    // allocate memory for the arrays
    allocate_memory();

    // Initialize the arrays
    inicializa();

    struct sigaction act, act2,act1;

    // setup do sinal do ficheiro encontrado
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_sigaction = handle_fileFoundSignal;
    act.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR1, &act, NULL);

    // setup do sinal de trabalho do filho terminado
    memset(&act2, 0, sizeof(struct sigaction));
    act2.sa_sigaction = handle_childWorkFinishedSignal;
    act2.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR2, &act2, NULL);

    // setup do sinal de trabalho do filho terminado
    memset(&act1, 0, sizeof(struct sigaction));
    act1.sa_sigaction = sigint_handler;
    act1.sa_flags = SA_SIGINFO;
    sigaction(SIGINT, &act1, NULL);

    // cria os filhos
    for (int i = 0; i < (worker_children + 1); i++)
    {
        pid_t pid = fork();

        if(pid==0)
        {
            // Filho que monitoriza o diretorio
            if (i == 0)
            {
                
        
                while (1)
                {
                    monitor_directory();
                    sleep(check_interval);
                }
            }
            else
            {                                
                // Filhos que processam os arquivos
                while (1)
                {

                    char filename[MAX_FILES][MAX_FILENAME];
                    ssize_t bytesRead = 0;

                    int fileIndex = 0;

                    // Lê os arquivos do pipe
                    while ((bytesRead = read(pipes[i - 1][0], filename[fileIndex], MAX_FILENAME)) > 0)
                    {
                        filename[fileIndex][bytesRead] = '\0';       // Ensure the string is null-terminated
                        if (strcmp(filename[fileIndex], "EOF") == 0) // Check for end-of-file marker
                        {
                            break; // Exit the loop
                        }
                        printf("Processo filho %d leu o arquivo %s pelo pipe %d\n", i, filename[fileIndex], i - 1);
                        fileIndex++;
                    }

                    // Verifica se o arquivo candidate-data existe e ordena
                    bool flag = reorganize_array(filename, fileIndex);
                    if (!flag)
                    {
                        printf("Arquivo candidate-data não encontrado\n");
                    }
                    else
                    {
                        // Processa os arquivos
                        processCandidateFile(filename, fileIndex);

                        // Send child index to parent
                        write(fd[1], &i, sizeof(i));
                        
                        // Send signal to parent
                        kill(getppid(), SIGUSR2);
                    }

                    sleep(check_interval);
                }
            }
            exit(0);
        }
        child_pids[i] = pid;
        sleep(1);
    }

    printf("Main process PID: %d\n", getpid()); 

    while (1)
    {
        // Verifica se todos os ficheiros foram lidos pelos filhos
        sleep(check_interval);
        if (count_unique_identifiers(input_directory) > 0)
        {
            kill(getpid(), SIGUSR1);
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

    return 0;
}