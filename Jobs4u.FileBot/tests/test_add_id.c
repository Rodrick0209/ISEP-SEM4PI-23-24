#include "../FileBot/header.h"
#include "assert_test.c"

int worker_children;
int **pipes;       // Array of pipes, one for each child process
int *child_status; // Array to keep track of whether each child is busy
int num_ids;
int fd[2];
int *child_pids;
int processed_ids[] = {1, 2};
int num_ids = 2;

void test_add_id()
{
    // Test 1
    add_id(3);
    assert_test(processed_ids[2] == 3, "Test 1.1");
    assert_test(num_ids == 3, "Test 1.2");

    // Test 2
    add_id(4);
    assert_test(processed_ids[3] == 4, "Test 2.1");
    assert_test(num_ids == 4, "Test 2.2");
}

int main()
{
    test_add_id();
    return 0;
}
