package jobs4u.base.utils;

import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JobOpeningStatusTest {

    @Test
    public void testEnumValues() {
        // Test the number of enum values
        assertEquals(2, JobOpeningStatus.values().length);

        // Test the enum values
        assertEquals(JobOpeningStatus.ACTIVE, JobOpeningStatus.values()[0]);
        assertEquals(JobOpeningStatus.INACTIVE, JobOpeningStatus.values()[1]);
    }

    @Test
    public void testValueOf() {
        // Test the valueOf method
        assertEquals(JobOpeningStatus.ACTIVE, JobOpeningStatus.valueOf("ACTIVE"));
        assertEquals(JobOpeningStatus.INACTIVE, JobOpeningStatus.valueOf("INACTIVE"));

        // Test the valueOf method with invalid input
        assertThrows(IllegalArgumentException.class, () -> JobOpeningStatus.valueOf("INVALID"));
    }
}