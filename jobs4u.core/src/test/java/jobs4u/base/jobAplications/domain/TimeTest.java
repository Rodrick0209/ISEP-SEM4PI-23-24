/*
package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.Time;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {

    @Test
    public void testParseReturnsValidTime() {
        String timeString = "10:15:30";
        Time time = Time.parse(timeString);
        assertNotNull(time);
        assertEquals(LocalTime.parse(timeString), time.getTime());
    }

    @Test
    public void testParseThrowsExceptionWhenTimeStringIsInvalid() {
        String timeString = "invalid-time";
        assertThrows(IllegalArgumentException.class, () -> {
            Time.parse(timeString);
        });
    }
}*/
