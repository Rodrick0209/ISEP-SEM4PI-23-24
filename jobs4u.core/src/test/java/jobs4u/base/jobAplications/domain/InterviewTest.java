/*
package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.Date;
import jobs4u.base.jobApplications.domain.Interview;
import jobs4u.base.jobApplications.domain.Time;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class InterviewTest {

    @Test
    public void testInterviewIsCreatedSuccessfully() {
        Date date = Date.valueOf(LocalDate.now());
        Time time = Time.valueOf(LocalTime.now());
        Interview interview = new Interview(date, time);
        assertNotNull(interview);
        assertEquals(date, interview.date());
        assertEquals(time, interview.time());
    }

    @Test
    public void testInterviewThrowsExceptionWhenDateIsNull() {
        Time time = Time.valueOf(LocalTime.now());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Interview(null, time);
        });
        assertEquals("Date should not be null", exception.getMessage());
    }

    @Test
    public void testInterviewThrowsExceptionWhenTimeIsNull() {
        Date date = Date.valueOf(LocalDate.now());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Interview(date, null);
        });
        assertEquals("Time should not be null", exception.getMessage());
    }
}*/
