#include "assert_test.h"
#include "../CFileBot/header.h"


void test_read_config(void)
{
  // Call the function
  Config config;
  read_config(&config,"resources/configFile");

  // Check the global variables
  printf("\n\n----------Read Config Test----------\n");
  assert_test(strcmp(config.input_directory, "../input")==0, "test_read_config 1");
  assert_test(strcmp(config.output_directory, "../output")==0, "test_read_config 2");
  assert_test(config.worker_children == 3, "test_read_config 3");
  assert_test(atoi(config.check_interval) == 5, "test_read_config 4");
  assert_test(strcmp(config.report_name, "report")==0, "test_read_config 5");
}
