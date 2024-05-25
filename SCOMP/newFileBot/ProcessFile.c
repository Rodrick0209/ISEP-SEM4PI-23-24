#include "header.h"
#include <ctype.h>

// Remove non-printable characters from a string
void remove_non_printable_chars(char *str)
{
    char *i = str;
    char *j = str;
    while (*i)
    {
        if (isprint((unsigned char)*i))
        {
            *j++ = *i;
        }
        i++;
    }
    *j = 0;
}



// Get the job application reference from the first line of the file
char *getJobApplicationReference(const char *filename, const char *input_directory)
{
    char path[256];
    sprintf(path, "%s/%s", input_directory, filename);

    static char firstLine[256];
    FILE *file = fopen(path, "r");
    if (file == NULL)
    {
        printf("Could not open file %s\n", path);
        return NULL;
    }

    if (fgets(firstLine, sizeof(firstLine), file) == NULL)
    {
        printf("Could not read from file %s\n", path);
        fclose(file);
        return NULL;
    }

    fclose(file);

    remove_non_printable_chars(firstLine);

    return firstLine;
}

// Ensure that the directory for the job opening exists
void ensure_JobOpening_directory_exists(const char *dir, const char *output_directory)
{

    char path[256];
    sprintf(path, "%s/%s", output_directory, dir);

    struct stat st = {0};

    if (stat(path, &st) == -1)
    {
        mkdir(path, 0700);
    }
}

// Ensure that the directory for the application exists
void ensure_Application_directory_exists(const char *dirJobOpening, int dirApplication, const char *output_directory)
{

    char path[256];
    sprintf(path, "%s/%s/%d", output_directory, dirJobOpening, dirApplication);

    struct stat st = {0};

    if (stat(path, &st) == -1)
    {
        mkdir(path, 0700);
    }
}

// Move the file to the appropriate directory
void moveFile(const char *filename, const char *dir, int dirApplication, const char *input_directory, const char *output_directory)
{
    char path[256];
    sprintf(path, "%s/%s", input_directory, filename);

    char newPath[256];
    sprintf(newPath, "%s/%s/%d/%s", output_directory, dir, dirApplication, filename);

    if (rename(path, newPath) != 0)
    {
        printf("Could not move file %s to %s\n", path, newPath);
    }
}

// Reorganize the array of file names to move the candidate file to the beginning
bool reorganize_array(char **files, int fileCount)
{
    int candidate_index = -1;

    // Find the index of the file with the format "X-candidate-data.txt"
    for (int i = 0; i < fileCount; i++)
    {
        if (strstr(files[i], "-candidate-data.txt") != NULL)
        {
            candidate_index = i;
            break;
        }
    }

    // If the candidate file is found, move it to the beginning of the array
    if (candidate_index != -1)
    {
        char *temp = files[candidate_index]; // Store the candidate file pointer temporarily

        // Shift the other pointers to the right
        for (int i = candidate_index; i > 0; i--)
        {
            files[i] = files[i - 1];
        }

        files[0] = temp; // Move the candidate file pointer to the beginning
        return true;
    }
    else
    {
        return false;
    }
}

// Function that call all the functions above to process the candidate files
void processCandidateFile(char **file_names, int array_size, int prefix,const char *input, const char *output)
{
    //organiza os ficheiros de maneira a ter o candidate-data em primeiro lugar, para ler os valores
    reorganize_array(file_names, array_size);

    // Get the job application reference from the first file (candidate-data.txt)
    char *jobReference = getJobApplicationReference(file_names[0], input);

    ensure_JobOpening_directory_exists(jobReference, output);
    ensure_Application_directory_exists(jobReference, prefix, output);

    // Move all files to the appropriate directories
    for (int i = 0; i < array_size; i++)
    {
        printf("Moving file %s\n", file_names[i]);
        moveFile(file_names[i], jobReference, prefix, input, output);
    }
}
