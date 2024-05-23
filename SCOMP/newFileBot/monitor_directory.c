#include "header.h"

#define MAX_BUFFER_SIZE 1024

int main(int argc, char *argv[])
{   
    sem_t *sem;

    sem = sem_open(SEM_NAME, O_CREAT);
    if (sem == SEM_FAILED) {
        perror("sem_open");
        exit(EXIT_FAILURE);
    }

    // Check if a directory and time interval were provided as arguments
    if (argc != 3)
    {
        fprintf(stderr, "Usage: %s <directory> <time_interval>\n", argv[0]);
        return 1;
    }

    // Check if the directory exists and is readable
    if (access(argv[1], R_OK) != 0)
    {
        fprintf(stderr, "Error: Directory '%s' does not exist or is not readable.\n", argv[1]);
        return 1;
    }

    // Convert time_interval from string to integer
    int time_interval = atoi(argv[2]);

    while (1) {
        // Change the current working directory to the provided directory
        if (chdir(argv[1]) != 0)
        {
            perror("chdir");
            return 1;
        }

        // Create a temporary file to store the output of ls
        char temp_file[] = "/tmp/ls_outputXXXXXX";
        int fd = mkstemp(temp_file);
        if (fd == -1)
        {
            perror("mkstemp");
            return 1;
        }

        // Close the file descriptor as we only need the file name
        close(fd);

        // Command to list files in the directory and redirect output to temporary file
        char command[MAX_BUFFER_SIZE];
        snprintf(command, sizeof(command), "ls -1 %s > %s", argv[1], temp_file);

        // Execute the ls command and redirect output to temporary file
        int ret = system(command);
        if (ret != 0)
        {
            fprintf(stderr, "Error: Failed to execute ls command.\n");
            return 1;
        }

        // Open the temporary file for reading
        FILE *ls_output = fopen(temp_file, "r");
        if (ls_output == NULL)
        {
            perror("fopen");
            return 1;
        }

        // Check if the file is empty
        fseek(ls_output, 0, SEEK_END);
        long size = ftell(ls_output);
        if (size!= 0)
        {
            printf("New Files detected.\n");
            sem_post(sem);

        }

        // Close the temporary file
        fclose(ls_output);

        // Remove the temporary file
        remove(temp_file);

        // Wait for the specified time interval
        sleep(time_interval);
    }

    return 0;
}
