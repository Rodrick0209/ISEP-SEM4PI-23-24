#include "header.h"



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
    
    // Allocate memory for the array of child pids
    child_pids = (int *)malloc((worker_children+1) * sizeof(int));
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

    // Free memory allocated for the array of child pids
    free(child_pids);
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


//count the number of unique identifiers in the input directory
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


// Remove non-printable characters from a string
void remove_non_printable_chars(char* str) {
    char* i = str;
    char* j = str;
    while(*i) {
        if(isprint((unsigned char)*i)) {
            *j++ = *i;
        }
        i++;
    }
    *j = 0;
}

// Reorganize the array of file names to move the candidate file to the beginning
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


int getChildIndex()
{
    int childIndex;
    int n = read(fd[0], &childIndex, sizeof(childIndex));
    return childIndex;
}


// Inicializa os pipes e o array de status dos filhos
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

