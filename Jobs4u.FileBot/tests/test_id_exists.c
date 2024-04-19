#include "assert_test.h"
#include <stdbool.h>

int processed_ids[] = {1, 2};
int num_ids = 2;

bool id_exists(int id)
{
    for (int i = 0; i < num_ids; i++)
    {
        if (processed_ids[i] == id)
        {
            return true;
        }
    }
    return false;
}

int main(int argc, char const *argv[])
{
    assert_test(id_exists(1) == true, "id_exists(1) == true");
    assert_test(id_exists(2) == true, "id_exists(2) == true");
    assert_test(id_exists(3) == false, "id_exists(3) == false");
    return 0;
}
