#include "header.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>


// Reorganize the array of file names to move the candidate file to the beginning
bool reorganize_array(char files[MAX_FILES][MAX_SIZE], int fileCount)
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
        char temp[MAX_SIZE];
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

int extract_prefix(const char *filename)
{
    int prefix;
    sscanf(filename, "%d-", &prefix);
    return prefix;
}
void getFilesForPrefix(const char *directory, char array[MAX_FILES][MAX_SIZE], char prefix, int *count)
{
    struct dirent *entry;
    DIR *dp = opendir(directory);
    if (dp == NULL)
    {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    int i = 0;
    while ((entry = readdir(dp)))
    {
        if (entry->d_type == DT_REG)
        {
            char *filename = entry->d_name;
            int prefix1 = extract_prefix(filename);

            if (prefix == prefix1)
            {
                strcpy(&array[i][0], filename);
                array[i][MAX_SIZE - 1] = '\0'; // Ensure null termination
                (*count)++;
                i++;
            }
        }
    }

    // Add newline character to the last element
    array[i][0] = '\0'; // Ensure null termination

    closedir(dp);
}

// Function to check if an element exists in an array
int contains(int array[], int size, int element)
{
    for (int i = 0; i < size; ++i)
    {
        if (array[i] == element)
        {
            return 1; // Element found
        }
    }
    return 0; // Element not found
}

void organize_files(const char *directory, FileMatrix *buffer)
{
    struct dirent *entry;
    DIR *dp = opendir(directory);
    if (dp == NULL)
    {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    // reset the entire buffer
    for (int i = 0; i < MAX_APPLICATIONS; i++)
    {
        buffer->num_prefixes = 0;
        buffer->file_counts = 0;
        buffer->files[i][0] = '\0';
    }

    int prefixArray[MAX_APPLICATIONS];
    int prefixArraySize = 0;

    int j = 0;
    while ((entry = readdir(dp)))
    {
        if (entry->d_type == DT_REG)
        {
            char *filename = entry->d_name;
            int prefix = extract_prefix(filename);

            if (contains(prefixArray, prefixArraySize, prefix) == 0)
            {
                char files[MAX_FILES][MAX_SIZE] = {0};
                int count = 0;

                prefixArray[j] = prefix;
                prefixArraySize++;

                getFilesForPrefix(directory, files, prefix, &count);
                reorganize_array(files, count);

                buffer[j].num_prefixes = prefix;
                buffer[j].file_counts = count;

                for (int i = 0; i < count; i++)
                {
                    strcpy(buffer[j].files[i], files[i]);
                }

                j++;
            }
        }
    }

    closedir(dp);
}


void print_file_matrix(FileMatrix *buffer, int num_prefixes)
{
    for (int i = 0; i < num_prefixes; i++)
    {
        if (buffer[i].file_counts != 0)
        {

            printf("Prefix: %d\n", buffer[i].num_prefixes);
            printf("File count: %d\n", buffer[i].file_counts);

            reorganize_array(buffer[i].files, buffer[i].file_counts);

            for (int j = 0; j < buffer[i].file_counts; j++)
            {
                printf("File %d: %s\n", j, buffer[i].files[j]);
            }
        }
    }
}

/*
int main() {
    const char *directory = "../input";
    FileMatrix file_matrix;
    organize_files(directory, &file_matrix);
    print_file_matrix(&file_matrix);
    return 0;
}
*/