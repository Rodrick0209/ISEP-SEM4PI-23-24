#include "header.h"
#include <dirent.h>

int count_unique_identifiers(const char *input_directory)
{
    DIR *dir;
    struct dirent *ent;
    int unique_identifiers = 0;
    int identifiers[100] = {0}; 

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




char **get_to_shm(const char *dir_name) {
  DIR *dir;
  struct dirent *ent;

  // Create a dynamic array of strings
  char **file_names = malloc(MAX_FILES * sizeof(char *));
  for (int i = 0; i < MAX_FILES; i++) {
    file_names[i] = malloc(MAX_SIZE * sizeof(char));
  }

  int i = 0;
  if ((dir = opendir(dir_name)) != NULL) {
    /* print all the files and directories within directory */
    while ((ent = readdir(dir)) != NULL && i < MAX_FILES) {
      if (ent->d_type == DT_REG) { // regular file
        strncpy(file_names[i], ent->d_name, MAX_SIZE);
        i++;
      }
    }
    closedir(dir);
  } else {
    /* could not open directory */
    perror("opendir");
  }

  return file_names;
}

void read_from_shm(void *shm_ptr) {
    printf("Files in shared memory:\n");
    char *ptr = (char *)shm_ptr;

    while (*ptr != '\0') {
        printf("%s\n", ptr);
        ptr += strlen(ptr) + 1; // move to the next position after the null terminator
    }
}

