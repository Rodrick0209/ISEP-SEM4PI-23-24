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
        else if (strcmp(key, "report_name") == 0)
        {
            strncpy(report_file, value, sizeof(report_file));
        }
    }

    // Fecha o file
    fclose(file);
}
