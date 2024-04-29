package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;
import jobs4u.base.jobApplications.domain.JobApplicationState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobApplicationTest {

    private JobApplication jobApplication;
    private List<JobApplicationFile> files;

    @BeforeEach
    void setUp() {
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());
        jobApplication = new JobApplication(1L, files);
    }

    @Test
    void shouldReturnCorrectId() {
        assertEquals(1L, jobApplication.getId());
    }

    @Test
    void shouldReturnCorrectFiles() {
        assertEquals(files, jobApplication.getFile());
    }

    @Test
    void shouldReturnAcceptedStateInitially() {
        assertEquals(JobApplicationState.ACCEPTED, jobApplication.getState());
    }

    @Test
    void shouldReturnNonNullRequirementAnswerInitially() {
        assertNotNull(jobApplication.getRequirementAnswer());
    }

    @Test
    void shouldReturnNonNullInterviewInitially() {
        assertNotNull(jobApplication.getInterview());
    }

    @Test
    void shouldNotBeSameAsNull() {
        assertFalse(jobApplication.sameAs(null));
    }

    @Test
    void shouldNotBeSameAsDifferentClass() {
        assertFalse(jobApplication.sameAs("string"));
    }

    @Test
    void shouldBeSameAsItself() {
        assertTrue(jobApplication.sameAs(jobApplication));
    }

    @Test
    void shouldReturnCorrectIdentity() {
        assertEquals(1L, jobApplication.identity());
    }
}