package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.Date;
import jobs4u.base.jobApplications.domain.Interview;
import jobs4u.base.jobApplications.domain.Time;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class InterviewTest {

    @Test
    public void testInterviewIsCreatedSuccessfully() {
        Date date = Date.valueOf(LocalDate.now().toString());
        Time time = Time.valueOf(LocalTime.now().toString());
        Interview interview = new Interview(date, time);
        assertNotNull(interview);
        assertEquals(date, interview.date());
        assertEquals(time, interview.time());
    }

    @Test
    public void testInterviewDateIsSetCorrectly() {
        Date date = Date.valueOf(LocalDate.now().toString());
        Time time = Time.valueOf(LocalTime.now().toString());
        Interview interview = new Interview(date, time);
        assertEquals(date, interview.date());
    }

    @Test
    public void testInterviewTimeIsSetCorrectly() {
        Date date = Date.valueOf(LocalDate.now().toString());
        Time time = Time.valueOf(LocalTime.now().toString());
        Interview interview = new Interview(date, time);
        assertEquals(time, interview.time());
    }



}