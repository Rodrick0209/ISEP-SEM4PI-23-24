#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <signal.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include "readConfig.c"
#include "utils.c"

#define CONFIG_FILE "configFile"
#define MAX_CHILDREN 3
#define MAX_FILENAME 256
#define MAX_FILES 20
#define MAX_CANDIDATES 1000

// Define global variables
char input_directory[MAX_FILENAME];
char output_directory[MAX_FILENAME];
char report_file[MAX_FILENAME];
int worker_children;
int check_interval;
int **pipes;
int *child_status;
int processed_ids[MAX_FILES];
int num_ids;
int fd[2];
int num_files=0;
pid_t *child_pids;

/*
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
        else if (strcmp(key, "report_name") == 0)
        {
            strncpy(report_file, value, sizeof(report_file));
        }
    }

    // Fecha o file
    fclose(file);
}

*/



int main()
{   
    
    read_config();
    while (1)
    {
        /* code */

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

        int count_idents = count_unique_identifiers(input_directory);
        


        if (count_idents > 0)
        {
            kill(getppid(), SIGUSR1);
            
        }
                sleep(check_interval);

    }
    

    return 0;
}
