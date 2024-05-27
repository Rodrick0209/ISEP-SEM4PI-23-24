#include "../CFileBot/header.h"
#include "assert_test.h"
#include <stdbool.h>

bool reorganize_array(char **files, int fileCount);

void test_reorganize_array() {

    printf("\n\n----------Reorganize Array Test----------\n");

    char *files[] = {
        "file1.txt",
        "file2.txt",
        "3-candidate-data.txt",
        "file4.txt"
    };
    int fileCount = sizeof(files) / sizeof(files[0]);

    bool result = reorganize_array(files, fileCount);

    assert_test(result == true, "test_reorganize_array 1");
    assert_test(strcmp(files[0], "3-candidate-data.txt") == 0, "test_reorganize_array 2");
    assert_test(strcmp(files[1], "file1.txt") == 0, "test_reorganize_array 3");
    assert_test(strcmp(files[2], "file2.txt") == 0, "test_reorganize_array 4");
    assert_test(strcmp(files[3], "file4.txt") == 0, "test_reorganize_array 5");

     char *files_no_candidate[] = {
        "file1.txt",
        "file2.txt",
        "file3.txt",
        "file4.txt"
    };

    result = reorganize_array(files_no_candidate, fileCount);

    assert_test(result == false, "test_reorganize_array 6");
    assert_test(strcmp(files_no_candidate[0], "file1.txt") == 0, "test_reorganize_array 7");
    assert_test(strcmp(files_no_candidate[1], "file2.txt") == 0, "test_reorganize_array 8");
    assert_test(strcmp(files_no_candidate[2], "file3.txt") == 0, "test_reorganize_array 9");
    assert_test(strcmp(files_no_candidate[3], "file4.txt") == 0, "test_reorganize_array 10");
}