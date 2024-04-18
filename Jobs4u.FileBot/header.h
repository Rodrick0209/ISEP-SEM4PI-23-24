#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <signal.h>
#include <string.h>
#include <stdbool.h>
#include "ProcessFile.c"

#define CONFIG_FILE "configFile"
#define MAX_CHILDREN 3
#define MAX_FILENAME 256
#define MAX_FILES 20

char input_directory[MAX_FILENAME];
char output_directory[256];
int worker_children;
int check_interval;
int **pipes;       // Array of pipes, one for each child process
int *child_status; // Array to keep track of whether each child is busy
int processed_ids[20];
int num_ids = 0;
int fd[2];
int num_files = 0;