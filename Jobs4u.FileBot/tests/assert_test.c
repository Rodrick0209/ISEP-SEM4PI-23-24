#include <stdio.h>

void assert_test(int condition, const char *test_name)
{
    if (condition)
    {
        printf("[PASS] Test '%s'\n", test_name);
    }
    else
    {
        printf("[FAIL] Test '%s'\n", test_name);
    }
}