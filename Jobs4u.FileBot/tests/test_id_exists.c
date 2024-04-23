#include "../FileBot/header.h"
#include "assert_test.c"
#include <stdbool.h>

int worker_children;
int **pipes;       // Array of pipes, one for each child process
int *child_status; // Array to keep track of whether each child is busy
int num_ids;
int fd[2];
int *child_pids;
int processed_ids[] = {1, 2};
int num_ids = 2;


int main(int argc, char const *argv[])
{
    assert_test(id_exists(1) == true, "id_exists(1) == true");
    assert_test(id_exists(2) == true, "id_exists(2) == true");
    assert_test(id_exists(3) == false, "id_exists(3) == false");
    return 0;
}
