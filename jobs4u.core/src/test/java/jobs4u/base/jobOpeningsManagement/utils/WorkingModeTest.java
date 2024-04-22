package jobs4u.base.jobOpeningsManagement.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkingModeTest {

    @Test
    public void testValidWorkingMode() {
        assertDoesNotThrow(() -> WorkingMode.valueOf("REMOTE"));
        assertDoesNotThrow(() -> WorkingMode.valueOf("HYBRID"));
        assertDoesNotThrow(() -> WorkingMode.valueOf("ONSITE"));
    }

    @Test
    public void testInvalidWorkingMode() {
        assertThrows(IllegalArgumentException.class, () -> WorkingMode.valueOf("INVALID"));
    }


}