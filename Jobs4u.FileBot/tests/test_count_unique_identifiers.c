#include "../FileBot/header.h"
#include "assert_test.h"


int worker_children;
int **pipes;       // Array of pipes, one for each child process
int *child_status; // Array to keep track of whether each child is busy
int num_ids;
int fd[2];
int *child_pids;
int processed_ids[] = {1, 2};
int num_ids = 2;

void test_count_unique_identifiers()
{
    // Test 1: Empty directory
    const char *empty_directory = "dir/empty";
    int result = count_unique_identifiers(empty_directory);
    assert_test(result == 0, "test_count_unique_identifiers 1");

    // Test 2: Directory with one "type" of file
    const char *directory_with_one_file = "dir/oneFile";
    result = count_unique_identifiers(directory_with_one_file);
    assert_test(result == 1, "test_count_unique_identifiers 2");

    // Test case 3: Directory with three "types" of file
    const char *directory_with_three_files = "dir/threeFile";
    result = count_unique_identifiers(directory_with_three_files);
    assert_test(result == 3, "test_count_unique_identifiers 3");
}

