#include "header.h"
#include <dirent.h>
#include <string.h>

#define MAX_FILENAME 256 // Add the missing definition of the "MAX_FILENAME" constant

char distribute_files(Config config)
{
    
    DIR *dir;
    struct dirent *ent;
    int child = 0;
    int total_applications = count_unique_identifiers(config.input_directory);
    int files_per_child = total_applications / config.worker_children;


    if ((dir = opendir(config.input_directory)) != NULL)
    {

        while (((ent = readdir(dir)) != NULL))
        {
            // Ignore files that start with a dot
            if (strncmp(ent->d_name, ".", 1) == 0)
            {
                continue;
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
            if ((dir2 = opendir(config.input_directory)) != NULL)
            {
                char files[NUM_FILES][MAX_SIZE]; // Array to store the filenames
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

            }
            else
            {
                perror("Não foi possível abrir o diretório");
                exit(EXIT_FAILURE);
            }
        }

        closedir(dir);
        return files;

    }
    else
    {
        perror("Não foi possível abrir o diretório");
        exit(EXIT_FAILURE);
    }

}