#include "header.h"
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include "ProcessFile.c"


int main(int argc, char *argv[])
{
  // Get the shared memory
  int shm_fd = shm_open(SHM_NAME, O_RDWR, 0666);
  if (shm_fd == -1)
  {
    perror("shm_open");
    return 1;
  }

  char *shm_ptr = mmap(0, sizeof(FileMatrix), PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
  if (shm_ptr == MAP_FAILED)
  {
    perror("mmap");
    return 1;
  }

  sem_t *sem = sem_open(SEM_MEM, O_RDWR);
  if (sem == SEM_FAILED)
  {
    perror("sem_open");
    return 1;
  }

  sem_t *semPW = sem_open(SEM_PARW, O_RDWR);
  if (semPW == SEM_FAILED)
  {
    perror("sem_open");
    return 1;
  }

  while (1)
  {
    sem_wait(sem);
    printf("[%d] Child process\n", getpid());
  
    //get value from shared memory
    //read the buffer from the shared memory
    FileMatrix buffer;
    memcpy(&buffer, &shm_ptr[0], sizeof(FileMatrix));
    sem_post(semPW);
    

    processCandidateFile(buffer.files, buffer.file_counts, argv[3], argv[4]);

  }


  return 0;
}