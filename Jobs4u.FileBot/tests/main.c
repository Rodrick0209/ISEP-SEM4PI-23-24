#include "../FileBot/header.h"

// Declare the test functions
void test_id_exists();
void test_add_id();
void test_reorganize_array();
void test_count_unique_identifiers();
void test_remove_non_printable_chars();
void test_read_config();



int main() {
  //Call ALL test functions
  test_id_exists();
  test_add_id();
  test_reorganize_array();
  test_remove_non_printable_chars();
  test_count_unique_identifiers();
  test_read_config();

  return 0;
}