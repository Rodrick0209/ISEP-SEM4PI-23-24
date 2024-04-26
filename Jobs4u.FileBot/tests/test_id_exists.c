#include "../FileBot/header.h"
#include "assert_test.h"


void test_id_exists()
{
    assert_test(id_exists(1) == true, "Test 1");
    assert_test(id_exists(2) == true, "Test 2");
    assert_test(id_exists(3) == false, "Test 3");
    assert_test(id_exists(4) == false, "Test 4");
}

