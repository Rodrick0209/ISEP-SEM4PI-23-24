#include "header.h"
#include <errno.h>

void read_config(Config *config, char *config_file_path)
{

    //config file path
    char *configName = config_file_path;

    //validations for the config file
    if (access(configName, F_OK) == -1)
    {
        printf("The file %s does not exist.\n", configName);
        exit(1);
    }
    if (config == NULL || config_file_path == NULL)
    {
        fprintf(stderr, "Error: config or config_file_path is NULL.\n");
        exit(EXIT_FAILURE);
    }

    //open the file
    FILE *file = fopen(config_file_path, "r");
    if (file == NULL)
    {
        fprintf(stderr, "Error: could not open the configuration file.\n");
        exit(EXIT_FAILURE);
    }


    //Read the config file
    char line[256];
    while (fgets(line, sizeof(line), file))
    {
        char *key = strtok(line, "=");
        char *value = strtok(NULL, "=");

        if (key == NULL || value == NULL)
        {
            fprintf(stderr, "Error: invalid line in configuration file.\n");
            continue;
        }

        value[strcspn(value, "\n")] = 0;

        if (strcmp(key, "input_directory") == 0)
        {
            strncpy(config->input_directory, value, sizeof(config->input_directory) - 1);
        }
        else if (strcmp(key, "output_directory") == 0)
        {
            strncpy(config->output_directory, value, sizeof(config->output_directory) - 1);
        }
        else if (strcmp(key, "worker_children") == 0)
        {
            errno = 0;
            config->worker_children = atoi(value);
            if (errno != 0)
            {
                fprintf(stderr, "Error: invalid worker_children value.\n");
            }
        }
        else if (strcmp(key, "check_interval") == 0)
        {
            strncpy(config->check_interval, value, sizeof(config->check_interval) - 1);

        }
        else if (strcmp(key, "report_name") == 0)
        {
            strncpy(config->report_name, value, sizeof(config->report_name) - 1);
        }
    }

    fclose(file);
}