package jobs4u.base.jobOpeningsManagement.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContractTypeTest {


    @Test
    public void testFullTime() {
        assertEquals(ContractType.FULL_TIME, ContractType.valueOf("FULL_TIME"));
    }

    @Test
    public void testPartTime() {
        assertEquals(ContractType.PART_TIME, ContractType.valueOf("PART_TIME"));
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> ContractType.valueOf("INVALID"));
    }
}

