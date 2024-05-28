#include "assert_test.h"
#include "../CFileBot/header.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool validate_filename(const char *filename, char *prefix);
char** get_candidate_data_file_prefixes(const char *directory_path, int *count);


void test_validate_filename(void) {
    printf("\n\n----------Validate Filename Test----------\n");

    char prefix[256];

    // Test case 1: Valid filename
    assert_test(validate_filename("1-candidate-data.txt", prefix) == true, "test_validate_filename 1");
    assert_test(strcmp(prefix, "1") == 0, "test_validate_filename 1.1");

    // Test case 2: Invalid filename (missing number)
    assert_test(validate_filename("e-candidate-data.txt", prefix) == false, "test_validate_filename 2");

    // Test case 3: Invalid filename (incorrect pattern)
    assert_test(validate_filename("1234-candiate-data.tx", prefix) == false, "test_validate_filename 3");

    // Test case 4: Invalid filename (no hyphen)
    assert_test(validate_filename("1234candidate-data.txt", prefix) == false, "test_validate_filename 4");

    // Test case 5: Valid filename with longer number
    assert_test(validate_filename("56232117891-candidate-data.txt", prefix) == true, "test_validate_filename 5");
    assert_test(strcmp(prefix, "56232117891") == 0, "test_validate_filename 5.1");
}


void test_get_candidate_data_file_prefixes(void) {
    const char *test_directory = "resources";

    printf("\n\n----------Get Candidate Data File Prefixes Test----------\n");


    int count = 0;
    char **prefixes = get_candidate_data_file_prefixes(test_directory, &count);

    // Test case 1: Check count of valid prefixes
    assert_test(count == 2, "test_get_candidate_data_file_prefixes 1");

    // Test case 2: Check values of valid prefixes
    assert_test(strcmp(prefixes[0], "1") == 0, "test_get_candidate_data_file_prefixes 2");
    assert_test(strcmp(prefixes[1], "56232117891") == 0, "test_get_candidate_data_file_prefixes 3");

    // Free allocated memory
    for (int i = 0; i < count; i++) {
        free(prefixes[i]);
    }
    free(prefixes);

    // Clean up test directory
}


