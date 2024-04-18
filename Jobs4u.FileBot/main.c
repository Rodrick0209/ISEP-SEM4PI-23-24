#include "header.h"


void read_config()
{
    // Abre o config file para leitura
    FILE *file = fopen(CONFIG_FILE, "r");

    // Se o file não puder ser aberto, imprime uma mensagem de erro e termina o programa
    if (file == NULL)
    {
        printf("Não foi possível abrir o arquivo de configuração: %s\n", CONFIG_FILE);
        exit(EXIT_FAILURE);
    }

    char line[256];
    // Lê o file linha a linha
    while (fgets(line, sizeof(line), file))
    {
        // Divide a linha em duas partes: a key (antes do '=') e o valor (depois do '=')
        char *key = strtok(line, "=");
        char *value = strtok(NULL, "=");

        // Se o valor não for NULL, remove o new line, se estiver presente
        if (value)
        {
            value[strcspn(value, "\n")] = 0;
        }

        // Compara a key com várias strings possíveis e armazena o valor em uma variável apropriada
        if (strcmp(key, "input_directory") == 0)
        {
            strncpy(input_directory, value, sizeof(input_directory));
        }
        else if (strcmp(key, "output_directory") == 0)
        {
            strncpy(output_directory, value, sizeof(output_directory));
        }
        else if (strcmp(key, "worker_children") == 0)
        {
            worker_children = atoi(value);
        }
        else if (strcmp(key, "check_interval") == 0)
        {
            check_interval = atoi(value);
        }
    }

    // Fecha o file
    fclose(file);
}

void allocate_memory()
{
    // Allocate memory for the array of pipes
    pipes = (int **)malloc(worker_children * sizeof(int *));
    if (pipes == NULL)
    {
        perror("Falha ao alocar memória para pipes");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < worker_children; i++)
    {
        pipes[i] = (int *)malloc(2 * sizeof(int));
        if (pipes[i] == NULL)
        {
            perror("Falha ao alocar memória para pipes");
            exit(EXIT_FAILURE);
        }
    }
    // Allocate memory for the array of child processes and child status
    child_status = (int *)malloc(worker_children * sizeof(int));
    if (child_status == NULL)
    {
        perror("Falha ao alocar memória para child_status");
        exit(EXIT_FAILURE);
    }
    child_pids = (int *)malloc(worker_children * sizeof(int));
    if (child_pids == NULL)
    {
        perror("Falha ao alocar memória para child_pids");
        exit(EXIT_FAILURE);
    }
}

void free_memory()
{
    // Free memory allocated for the array of pipes
    for (int i = 0; i < worker_children; i++)
    {
        free(pipes[i]);
    }
    free(pipes);

    // Free memory allocated for the array of child status
    free(child_status);
    free(child_pids);
}

void monitor_directory()
{
    // Inicializa as variáveis

    DIR *dir;
    struct dirent *ent;
    int current_num_files = 0;

    printf("Monitorando o diretório: %s\n", input_directory);

    if ((dir = opendir(input_directory)) != NULL)
    {
        // Se o diretório foi aberto com sucesso, lê os arquivos nele
        while ((ent = readdir(dir)) != NULL)
        {
            // Ignora os diretórios '.' e '..'
            if (strcmp(ent->d_name, ".") != 0 && strcmp(ent->d_name, "..") != 0)
            {
                // Incrementa o contador para cada arquivo no diretório
                current_num_files++;
            }
        }
        // Fecha o diretório após a leitura
        closedir(dir);
    }
    else
    {
        // Se o diretório não pôde ser aberto, imprime uma mensagem de erro e termina o programa
        perror("Não foi possível abrir o diretório");
        exit(EXIT_FAILURE);
    }

    // Se o número de arquivos no diretório mudou desde a última verificação
    if (current_num_files > num_files)
    {
        // Atualiza o número de arquivos
        num_files = current_num_files;
        // Envia um sinal para o processo pai
        kill(getppid(), SIGUSR1);
    }
}

bool id_exists(int id)
{
    for (int i = 0; i < num_ids; i++)
    {
        if (processed_ids[i] == id)
        {
            return true;
        }
    }
    return false;
}

void add_id(int id)
{
    processed_ids[num_ids] = id;
    num_ids++;
}

int count_unique_identifiers(const char *input_directory)
{
    DIR *dir;
    struct dirent *ent;
    int unique_identifiers = 0;
    int identifiers[100] = {0}; // Assuming a maximum of 100 identifiers

    // Open the directory
    if ((dir = opendir(input_directory)) != NULL)
    {
        // Loop through the files in the directory
        while ((ent = readdir(dir)) != NULL)
        {
            // Ignore files that start with a dot
            if (strncmp(ent->d_name, ".", 1) == 0)
            {
                continue;
            }

            // Extract the identifier from the file name
            int identifier = atoi(strtok(ent->d_name, "-"));

            // Check if the identifier is already counted
            int found = 0;
            for (int i = 0; i < unique_identifiers; i++)
            {
                if (identifiers[i] == identifier)
                {
                    found = 1;
                    break;
                }
            }

            // If the identifier is not found, count it
            if (!found)
            {
                identifiers[unique_identifiers++] = identifier;
            }
        }

        // Close the directory
        closedir(dir);
    }
    else
    {
        perror("Não foi possível abrir o diretório");
        exit(EXIT_FAILURE);
    }

    return unique_identifiers;
}


void distribute_files()
{
    DIR *dir;
    struct dirent *ent;
    int child = 0;
    int total_files = count_unique_identifiers(input_directory);
    int files_per_child = total_files / worker_children;


    if ((dir = opendir(input_directory)) != NULL)
    {

        while (((ent = readdir(dir)) != NULL))
        {
            // Ignore files that start with a dot
            if (strncmp(ent->d_name, ".", 1) == 0)
            {
                continue;
            }

            // Select a free child process
            while (child_status[child] == 1)
            {
                child = (child + 1);
                if (child == worker_children)
                {
                    child = 0;
                }
            }


            // Get the identifier from the file name
            int identifier = atoi(strtok(ent->d_name, "-"));

            // Skip if the identifier has already been processed
            if (id_exists(identifier))
            {
                continue;
            }

            // Add the identifier to the processed IDs list
            add_id(identifier);

            // Open the directory again to gather files for the current identifier
            DIR *dir2;
            struct dirent *ent2;
            if ((dir2 = opendir(input_directory)) != NULL)
            {
                char files[MAX_FILES][MAX_FILENAME]; // Array to store the filenames
                int fileCount = 0;                   // Counter for the number of files
                while ((ent2 = readdir(dir2)) != NULL)
                {
                    // Ignore files that start with a dot
                    if (strncmp(ent2->d_name, ".", 1) == 0)
                    {
                        continue;
                    }

                    int identifier2 = atoi(ent2->d_name);
                    if (identifier == identifier2)
                    {
                        // Add the filename to the array
                        strncpy(files[fileCount], ent2->d_name, MAX_FILENAME);
                        fileCount++;
                    }
                }
                closedir(dir2);

                // Distribute files to the current child process
                printf("Enviando %d arquivos para o processo filho %d\n", fileCount, child + 1);

                int n = write(pipes[child][1], files, fileCount * MAX_FILENAME);
                if (n == -1)
                {
                    perror("write");
                    exit(EXIT_FAILURE);
                }
                char eof_marker[] = "EOF";
                write(pipes[child][1], eof_marker, sizeof(eof_marker));
                child_status[child] = 1;

                // Move to the next child process
                child++;

                // If all child processes have received their share of files, exit the loop
                if (child >= worker_children)
                {
                    break;
                }
            }
            else
            {
                perror("Não foi possível abrir o diretório");
                exit(EXIT_FAILURE);
            }
        }

        closedir(dir);

    }
    else
    {
        perror("Não foi possível abrir o diretório");
        exit(EXIT_FAILURE);
    }

}




bool reorganize_array(char files[MAX_FILES][MAX_FILENAME], int fileCount)
{
    int candidate_index = -1;

    // Find the index of the file with the format "X-candidate-data.txt"
    for (int i = 0; i < fileCount; i++)
    {
        char *filename = files[i];
        if (strstr(filename, "-candidate-data.txt") != NULL)
        {
            candidate_index = i;
            break;
        }
    }

    // If the candidate file is found, move it to the beginning of the array
    if (candidate_index != -1)
    {
        char temp[MAX_FILENAME];
        strcpy(temp, files[candidate_index]); // Store the candidate file temporarily

        // Shift all elements to the right to make space for the candidate file at the beginning
        for (int i = candidate_index; i > 0; i--)
        {
            strcpy(files[i], files[i - 1]);
        }

        strcpy(files[0], temp); // Move the candidate file to the beginning
        return true;
    }
    else
    {
        // printf("Arquivo de candidato não encontrado\n");
        return false;
    }
}

void inicializa()
{
    for (int i = 0; i < worker_children; i++)
    {

        if (pipe(pipes[i]))
        {
            perror("pipe falhou");
            exit(EXIT_FAILURE);
        }
        child_status[i] = 0;
    }
}

void handle_fileFoundSignal(int signo, siginfo_t *sinfo, void *context)
{
    if (signo == SIGUSR1)
    {
        printf("Novo Arquivo encontrado\n");
        sleep(2);
        distribute_files();

    }
}


int getChildIndex()
{
    int childIndex;
    // close(fd[1]);
    int n = read(fd[0], &childIndex, sizeof(childIndex));
    return childIndex;
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
        child_pids[i] = pid;

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