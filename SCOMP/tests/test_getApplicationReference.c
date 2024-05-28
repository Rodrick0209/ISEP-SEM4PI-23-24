#include "assert_test.h"
#include "../CFileBot/header.h"
#include <string.h>
#include <stdio.h>

// Ensure this matches your implementation's header file and function signatures
char *getJobApplicationReference(const char *filename, const char *input_directory);

void test_getJobApplicationReference(void) {
    const char *input_directory = "resources";
    const char *filename = "1-candidate-data.txt";
    char expected_output[256];

    
    printf("\n\n---------Get Application Reference Test----------\n");


    // Test case 1: File with printable characters
    strcpy(expected_output, "IBM-000123");
    assert_test(strcmp(getJobApplicationReference(filename, input_directory), expected_output) == 0, "test_getJobApplicationReference 1");

    // Test case 2: File with non-printable characters
    strcpy(expected_output, "IBM-000123");
    assert_test(strcmp(getJobApplicationReference(filename, input_directory), expected_output) == 0, "test_getJobApplicationReference 2");

    // Test case 3: Empty file
    assert_test(getJobApplicationReference("emptyfile.txt", input_directory) == NULL, "test_getJobApplicationReference 3");


    // Test case 4: File does not exist
    assert_test(getJobApplicationReference("nonExistentFile.txt", input_directory) == NULL, "test_getJobApplicationReference 4");

    // Clean up: remove the test directory
    rmdir(input_directory);
}


