#include "header.h"

void read_config(Config *config)
{
    // Open the config file for reading
    FILE *file = fopen(CONFIG_FILE, "r");

    // If the file cannot be opened, print an error message and terminate the program
    if (file == NULL)
    {
        printf("Não foi possível abrir o arquivo de configuração: %s\n", CONFIG_FILE);
        exit(EXIT_FAILURE);
    }

    char line[256];
    
    // Read the file line by line
    while (fgets(line, sizeof(line), file))
    {
        // Split the line into two parts: the key (before the '=') and the value (after the '=')
        char *key = strtok(line, "=");
        char *value = strtok(NULL, "=");

        // If the value is not NULL, remove the newline, if present
        if (value)
        {
            value[strcspn(value, "\n")] = 0;
        }

        // Compare the key with various possible strings and store the value in an appropriate variable
        if (strcmp(key, "input_directory") == 0)
        {
            strncpy(config->input_dir, value, sizeof(config->input_dir));
        }
        else if (strcmp(key, "output_directory") == 0)
        {
            strncpy(config->output_dir, value, sizeof(config->output_dir));
        }
        else if (strcmp(key, "worker_children") == 0)
        {
            config->num_workers = atoi(value);
        }
        else if (strcmp(key, "check_interval") == 0)
        {
            config->check_interval = atoi(value);
        }
        else if (strcmp(key, "report_name") == 0)
        {
            strncpy(config->report_name, value, sizeof(config->report_name));
        }
    }

    // Close the file
    fclose(file);
}