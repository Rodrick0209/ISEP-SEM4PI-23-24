#include "../CFileBot/header.h"

// Declare the test functions
void test_read_config();
void test_reorganize_array();
void test_remove_non_printable_chars();
void test_getJobApplicationReference(void);
void test_get_candidate_data_file_prefixes();
void test_validate_filename();



int main() {

  test_reorganize_array();
  test_read_config();
  test_remove_non_printable_chars();
  test_getJobApplicationReference();

  test_get_candidate_data_file_prefixes();
  test_validate_filename();


  return 0;
}