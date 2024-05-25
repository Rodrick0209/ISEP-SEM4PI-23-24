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

#define SEM_NOTIFICATION "/notification" //SEM_NAME
#define SEM_CHILD_READ "/sem_memory" //SEM_MEM
#define SEM_PARENT_WRITE "/par_write" //SEM_PARW
#define SHM_NAME "/my_shared_memory" //SHM_NAME


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



void read_config(Config *config, char *config_file_path);
sem_t *init_sem();
void *init_shm();
char **get_to_shm(const char *dir_name);
void read_from_shm(void *shm_ptr);
void distribute_files();

char** get_candidate_data_file_prefixes(const char *directory_path, int *count);




#endif // MY_HEADER_H