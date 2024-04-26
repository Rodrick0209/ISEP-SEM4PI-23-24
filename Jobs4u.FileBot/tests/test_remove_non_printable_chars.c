#include "../FileBot/header.h"
#include "assert_test.h"
#include <string.h>

void test_remove_non_printable_chars()
{
    char str1[] = "Hello, World!";
    remove_non_printable_chars(str1);
    assert_test(strcmp(str1, "Hello, World!") == 0, "Test 1");

    char str2[] = "Hello,\tWorld!";
    remove_non_printable_chars(str2);
    assert_test(strcmp(str2, "Hello,World!") == 0, "Test 2");

    char str3[] = "Hello,\nWorld!";
    remove_non_printable_chars(str3);
    assert_test(strcmp(str3, "Hello,World!") == 0, "Test 3");

    char str4[] = "Hello,\rWorld!";
    remove_non_printable_chars(str4);
    assert_test(strcmp(str4, "Hello,World!") == 0, "Test 4");

    char str5[] = "Hello,\bWorld!";
    remove_non_printable_chars(str5);
    assert_test(strcmp(str5, "Hello,World!") == 0, "Test 5");
}

