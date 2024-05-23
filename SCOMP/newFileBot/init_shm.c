#include "header.h"

void *init_shm() {
    int shm_fd;
    void *ptr;

    /* remove the shared memory segment in case it already exists */
    shm_unlink(SHM_NAME);

    /* create the shared memory segment */
    shm_fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, 0644);

    if (shm_fd == -1) {
        perror("shm_open");
        exit(EXIT_FAILURE);
    }

    /* configure the size of the shared memory segment */
    ftruncate(shm_fd, sizeof(FileMatrix));

    /* map the shared memory segment in the address space of the process */
    ptr = mmap(0, sizeof(FileMatrix), PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
    if (ptr == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    return ptr;
}