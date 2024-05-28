#include "assert_test.h"
#include "../CFileBot/header.h"
#include <string.h>
#include <stdio.h>
#include <ctype.h>

void remove_non_printable_chars(char *str);

void test_remove_non_printable_chars(void) {
    printf("\n\n----------Remove Non-Printable Chars Test----------\n");

    // Test case 1: Empty String
    char test1[] = "";
    remove_non_printable_chars(test1);
    assert_test(strcmp(test1, "") == 0, "test_remove_non_printable_chars 1");

    // Test case 2: All Printable Characters
    char test2[] = "Hello, World!";
    remove_non_printable_chars(test2);
    assert_test(strcmp(test2, "Hello, World!") == 0, "test_remove_non_printable_chars 2");

    // Test case 3: Non-Printable Characters at Beginning
    char test3[] = "\x01\x02Hello";
    remove_non_printable_chars(test3);
    assert_test(strcmp(test3, "Hello") == 0, "test_remove_non_printable_chars 3");

    // Test case 4: Non-Printable Characters at End
    char test4[] = "Hello\x01\x02";
    remove_non_printable_chars(test4);
    assert_test(strcmp(test4, "Hello") == 0, "test_remove_non_printable_chars 4");

    // Test case 5: Non-Printable Characters in Middle
    char test5[] = "Hel\x01\x02lo";
    remove_non_printable_chars(test5);
    assert_test(strcmp(test5, "Hello") == 0, "test_remove_non_printable_chars 5");

    // Test case 6: Consecutive Non-Printable Characters
    char test6[] = "He\x01\x02\x03llo";
    remove_non_printable_chars(test6);
    assert_test(strcmp(test6, "Hello") == 0, "test_remove_non_printable_chars 6");

    // Test case 7: Only Non-Printable Characters
    char test7[] = "\x01\x02\x03";
    remove_non_printable_chars(test7);
    assert_test(strcmp(test7, "") == 0, "test_remove_non_printable_chars 7");

    // Test case 8: Mixed Printable and Non-Printable Characters
    char test8[] = "He\x01l\x02l\x03o";
    remove_non_printable_chars(test8);
    assert_test(strcmp(test8, "Hello") == 0, "test_remove_non_printable_chars 8");

    // Test case 9: Newline and Tab Characters
    char test9[] = "Hello\tWorld\n";
    remove_non_printable_chars(test9);
    assert_test(strcmp(test9, "HelloWorld") == 0, "test_remove_non_printable_chars 9");
}

