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










int main()
{

    read_config();

    pipe(fd);

    allocate_memory();

    inicializa();

    struct sigaction act, act2,act1;

    // setup do sinal do ficheiro encontrado
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_sigaction = handle_fileFoundSignal;
    act.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR1, &act, NULL);

    memset(&act2, 0, sizeof(struct sigaction));
    act2.sa_sigaction = handle_childWorkFinishedSignal;
    act2.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR2, &act2, NULL);


    for (int i = 0; i < (worker_children + 1); i++)
    {
        pid_t pid = fork();

        if (pid == 0)
        {
            // Este é o processo filho

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

                while (1)
                {

                    char filename[MAX_FILES][MAX_FILENAME];
                    ssize_t bytesRead = 0;

                    // close(pipes[i - 1][1]); // Close write end of the pipe

                    int fileIndex = 0;

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

                    bool flag = reorganize_array(filename, fileIndex);

                    if (!flag)
                    {
                        printf("Arquivo candidate-data não encontrado\n");
                    }
                    else
                    {

                        processCandidateFile(filename, fileIndex);

                        // Close read end of the pipe after reading is done
                        // close(pipes[i - 1][0]);

                        // Send child index to parent
                        write(fd[1], &i, sizeof(i));

                        kill(getppid(), SIGUSR2);
                    }

                    sleep(check_interval);
                }
            }
            // close(pipes[i - 1][0]);
            exit(0);
        }
        sleep(1);
    }

    while (1)
    {
        sleep(check_interval);
        if (count_unique_identifiers(input_directory) > 0)
        {
            kill(getpid(), SIGUSR1);
        }

    }

    for (int i = 0; i < worker_children; i++)
    {
        close(pipes[i][0]);
        close(pipes[i][1]);
    }

    close(fd[0]);
    close(fd[1]);

    free_memory();

    return 0;
}