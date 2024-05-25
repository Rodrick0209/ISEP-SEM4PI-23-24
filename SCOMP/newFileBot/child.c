#include "header.h"
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include "ProcessFile.c"
#include <dirent.h>

// Function to get the files with a specific prefix
// Returns a list of filenames with the specified prefix that was received as an argument
char **list_files_with_prefix(const char *directory_path, const char *prefix, int *count)
{
    DIR *dir;
    struct dirent *ent;
    size_t prefix_len = strlen(prefix);
    char **file_list = NULL;
    int list_size = 10; // Initial allocation size
    *count = 0;

    file_list = malloc(sizeof(char *) * list_size);
    if (file_list == NULL)
    {
        perror("malloc");
        return NULL;
    }

    if ((dir = opendir(directory_path)) != NULL)
    {
        while ((ent = readdir(dir)) != NULL)
        {
            if (strncmp(ent->d_name, prefix, prefix_len) == 0)
            {
                if (*count >= list_size)
                {
                    list_size *= 2;
                    char **temp = realloc(file_list, sizeof(char *) * list_size);
                    if (temp == NULL)
                    {
                        perror("realloc");
                        for (int i = 0; i < *count; i++)
                        {
                            free(file_list[i]);
                        }
                        free(file_list);
                        closedir(dir);
                        return NULL;
                    }
                    file_list = temp;
                }
                file_list[*count] = strdup(ent->d_name);
                if (file_list[*count] == NULL)
                {
                    perror("strdup");
                    for (int i = 0; i < *count; i++)
                    {
                        free(file_list[i]);
                    }
                    free(file_list);
                    closedir(dir);
                    return NULL;
                }
                (*count)++;
            }
        }
        closedir(dir);
    }
    else
    {
        perror("opendir");
        free(file_list); // Free the initial allocation if opendir fails
        return NULL;
    }

    char **final_list = realloc(file_list, sizeof(char *) * (*count));
    if (final_list == NULL)
    {
        perror("realloc");
        for (int i = 0; i < *count; i++)
        {
            free(file_list[i]);
        }
        free(file_list);
        return NULL;
    }

    return final_list;
}

int main(int argc, char *argv[])
{
    // Get the shared memory
    int shm_fd = shm_open(SHM_NAME, O_RDWR, 0666);
    if (shm_fd == -1)
    {
        perror("shm_open");
        return 1;
    }

    char *shm_ptr = mmap(0, sizeof(char), PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
    if (shm_ptr == MAP_FAILED)
    {
        perror("mmap");
        return 1;
    }

    // get the sem for the child read
    sem_t *sem = sem_open(SEM_CHILD_READ, O_RDWR);
    if (sem == SEM_FAILED)
    {
        perror("sem_open");
        return 1;
    }

    // get the sem for the parent write
    sem_t *semPW = sem_open(SEM_PARENT_WRITE, O_RDWR);
    if (semPW == SEM_FAILED)
    {
        perror("sem_open");
        return 1;
    }

    while (1)
    {   
        //fica a espera do sinal do pai para ler do shm
        sem_wait(sem);

        char read;
        read = *shm_ptr;

        //como já leu o valor, avisa o pai que pode inserir um novo valor na shm
        sem_post(semPW); 

        int count_files;
        char prefix[2] = {read, '\0'};
        
        //get the files with the prefix
        char **files = list_files_with_prefix(argv[1], prefix, &count_files);

        //process the files
        processCandidateFile(files, count_files, read,argv[1], argv[2]);

        //sem_post(semPW);
    }

    return 0;
}
