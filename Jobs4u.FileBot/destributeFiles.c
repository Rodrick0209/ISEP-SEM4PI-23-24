#include "header.h"



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