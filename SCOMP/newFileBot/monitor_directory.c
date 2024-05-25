#include "header.h"
#include <dirent.h>
#include <ctype.h>

#define MAX_BUFFER_SIZE 1024


// Function to validate the filename,  checking if it matches the pattern "<number>-candidate-data.txt"
bool validate_filename(const char *filename) {
    // Check if the filename matches the pattern "<number>-candidate-data.txt"
    // where <number> can be any sequence of digits
    int len = strlen(filename);
    if (len < 19) // Minimum length check
        return false;

    int i = 0;
    while (isdigit(filename[i])) {
        i++;
    }

    if (filename[i] != '-') // Check for hyphen after the number
        return false;

    if (strncmp(&filename[i + 1], "candidate-data.txt", 17) != 0) // Check for the rest of the filename
        return false;

    return true;
}

int main(int argc, char *argv[])
{
    sem_t *sem;

    sem = sem_open(SEM_NOTIFICATION, O_RDWR);
    if (sem == SEM_FAILED)
    {
        perror("sem_open");
        exit(EXIT_FAILURE);
    }

    // Check if a directory and time interval were provided as arguments
    if (argc != 3)
    {
        fprintf(stderr, "Usage: %s <directory> <time_interval>\n", argv[0]);
        return 1;
    }

    // Check if the directory exists and is readable
    if (access(argv[1], R_OK) != 0)
    {
        fprintf(stderr, "Error: Directory '%s' does not exist or is not readable.\n", argv[1]);
        return 1;
    }

    // Convert time_interval from string to integer
    int time_interval = atoi(argv[2]);

    while (1)
    {
        // Inicializa as variáveis
        DIR *dir;
        struct dirent *ent;
        int current_num_files = 0;

        printf("Monitorizando o diretório: %s\n", argv[1]);
        // Change the current working directory to the provided directory
        if (chdir(argv[1]) != 0)
        {
            perror("chdir");
            return 1;
        }

        if ((dir = opendir(argv[1])) != NULL)
        {
            // Se o diretório foi aberto com sucesso, lê os arquivos nele
            while ((ent = readdir(dir)) != NULL)
            {
                // Ignora os diretórios '.' e '..'
                if (strcmp(ent->d_name, ".") != 0 && strcmp(ent->d_name, "..") != 0)
                {
                    if (validate_filename(ent->d_name)) {
                        current_num_files++;
                        
                }
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

        // Se novos arquivos foram detectados, notifica o processo pai atraves do semáforo
        if (current_num_files > 0)
        {
            printf("New Files detected.\n");
            sem_post(sem);
        }

        // Wait for the specified time interval
        sleep(time_interval);
    }

    return 0;
}


