#ifndef MY_HEADER_H
#define MY_HEADER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <semaphore.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/mman.h>
#include <stdbool.h>


#define MAX_SIZE 256

#define SEM_NAME "/notification"
#define SEM_MEM "/sem_memory"
#define SEM_PARW "/par_write"
#define SHM_NAME "/my_shared_memory"


#define MAX_FILES 10

#define MAX_APPLICATIONS 10

typedef struct
{
  char input_directory[MAX_SIZE];
  char output_directory[MAX_SIZE];
  int worker_children;
  char check_interval[3];
  char report_name[MAX_SIZE];
} Config;


typedef struct
{
  char files[MAX_FILES][MAX_SIZE];
  int file_counts;
  int num_prefixes;
} FileMatrix;

void read_config(Config *config, const char *config_file_path);
sem_t *init_sem();
void *init_shm();
char **get_to_shm(const char *dir_name);
void read_from_shm(void *shm_ptr);
void distribute_files();
void organize_files(const char *directory, FileMatrix buffer[]);
void print_file_matrix(FileMatrix *buffer, int num_prefixes);


// Function ProcessFile.c
//void processCandidateFile(char file_names[][MAX_SIZE], int array_size,const char input,const char output);




#endif // MY_HEADER_H