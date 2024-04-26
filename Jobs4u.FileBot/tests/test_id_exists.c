#include "../FileBot/header.h"
#include "assert_test.h"


void test_id_exists()
{
    assert_test(id_exists(1) == true, "test_id_exists 1");
    assert_test(id_exists(2) == true, "test_id_exists 2");
    assert_test(id_exists(3) == false, "test_id_exists 3");
    assert_test(id_exists(4) == false, "test_id_exists 4");
}

