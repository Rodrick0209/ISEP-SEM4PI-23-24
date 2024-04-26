#include "../FileBot/header.h"
#include "assert_test.h"
#include <stdbool.h>


void test_reorganize_array() {
    char files[MAX_FILES][MAX_FILENAME] = {
        "file1.txt",
        "file2.txt",
        "3-candidate-data.txt",
        "file4.txt"
    };
    int fileCount = 4;

    bool result = reorganize_array(files, fileCount);

    assert_test(result == true, "Test 1");
    assert_test(strcmp(files[0], "3-candidate-data.txt") == 0, "Test 2");
    assert_test(strcmp(files[1], "file1.txt") == 0, "Test 3");
    assert_test(strcmp(files[2], "file2.txt") == 0, "Test 4");
    assert_test(strcmp(files[3], "file4.txt") == 0, "Test 5");

    char files_no_candidate[MAX_FILES][MAX_FILENAME] = {
        "file1.txt",
        "file2.txt",
        "file3.txt",
        "file4.txt"
    };

    result = reorganize_array(files_no_candidate, fileCount);

    assert_test(result == false, "Test 6");
    assert_test(strcmp(files_no_candidate[0], "file1.txt") == 0, "Test 7");
    assert_test(strcmp(files_no_candidate[1], "file2.txt") == 0, "Test 8");
    assert_test(strcmp(files_no_candidate[2], "file3.txt") == 0, "Test 9");
    assert_test(strcmp(files_no_candidate[3], "file4.txt") == 0, "Test 10");
}

