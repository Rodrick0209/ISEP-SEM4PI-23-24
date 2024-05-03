#include "assert_test.h"
#include "../FileBot/header.h"


char input_directory[256];
char output_directory[256];
int worker_children;
int check_interval;
char report_file[256];

void test_read_config(void)
{
  // Call the function
  read_config();

  // Check the global variables
  assert_test(strcmp(input_directory, "../input")==0, "test_read_config 1");
  assert_test(strcmp(output_directory, "../output")==0, "test_read_config 2");
  assert_test(worker_children == 3, "test_read_config 3");
  assert_test(check_interval ==5, "test_read_config 4");
  assert_test(strcmp(report_file, "report")==0, "test_read_config 5");
}
