package jobs4u.base.candidateManagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationState;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.utils.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DisplayCandidateInfoControllerTest {

    private DisplayCandidateInfoController controller;
    private AuthorizationService authz;
    private CandidateRepository candidateRepository;
    private JobApplicationRepository jobApplicationRepository;
    private JobOpeningRepository jobOpeningRepository;

    @BeforeEach
    void setUp() {
        authz = mock(AuthorizationService.class);
        candidateRepository = mock(CandidateRepository.class);
        jobApplicationRepository = mock(JobApplicationRepository.class);
        jobOpeningRepository = mock(JobOpeningRepository.class);
        controller = new DisplayCandidateInfoController(candidateRepository, jobApplicationRepository, jobOpeningRepository, authz);
    }

    @Test
    void testCandidates() {
        Candidate candidate1 = mock(Candidate.class);
        Candidate candidate2 = mock(Candidate.class);
        when(candidateRepository.findAll()).thenReturn(Arrays.asList(candidate1, candidate2));

        List<Candidate> candidates = controller.candidates();

        assertEquals(2, candidates.size());
        verify(candidateRepository, times(1)).findAll();
    }

    @Test
    void testGetCandidateInfo() {
        Candidate candidate = mock(Candidate.class);
        Name name = Name.valueOf("John", "Doe");
        EmailAddress emailAddress = EmailAddress.valueOf("john.doe@gmail.com");
        PhoneNumber phoneNumber = PhoneNumber.valueOf("964511879");


        when(candidate.name()).thenReturn(name);
        when(candidate.emailAddress()).thenReturn(emailAddress);
        when(candidate.phoneNumber()).thenReturn(phoneNumber);
        String info = controller.getCandidateInfo(candidate);

        assertEquals("Name: John Doe\nEmail: john.doe@gmail.com\nPhone Number: 964511879\n", info);
    }

    @Test
    void testGetCandidateApplications() {
        Candidate candidate = mock(Candidate.class);
        JobApplication application1 = mock(JobApplication.class);
        JobApplication application2 = mock(JobApplication.class);
        when(jobApplicationRepository.findJobApplicationsByCandidate(candidate)).thenReturn(Arrays.asList(application1, application2));

        List<JobApplication> applications = controller.getCandidateApplications(candidate);

        assertEquals(2, applications.size());
        verify(jobApplicationRepository, times(1)).findJobApplicationsByCandidate(candidate);
    }

    @Test
    void testGetJobApplicationInfo() {
        JobApplication application = mock(JobApplication.class);

        when(application.identity()).thenReturn(123L);
        when(application.state()).thenReturn(JobApplicationState.ACCEPTED);
        when(application.getCreationDate()).thenReturn(new GregorianCalendar(2022, Calendar.JANUARY, 1));
        when(application.creationDate()).thenReturn(new GregorianCalendar(2022, Calendar.JANUARY, 1));

        String info = controller.getJobApplicationInfo(application);
        assertEquals("Application ID: 123\nApplication State: ACCEPTED\nRegistration Date: 2022-01-01 00:00:00\n", info);
    }

    @Test
    void testJobOpeningsFromRepository() {
        SystemUser user = mock(SystemUser.class);
        when(authz.loggedinUserWithPermissions(any())).thenReturn(Optional.of(user));
        JobOpening jobOpening1 = mock(JobOpening.class);
        JobOpening jobOpening2 = mock(JobOpening.class);
        when(jobOpeningRepository.findByCustomerManager(user)).thenReturn(Arrays.asList(jobOpening1, jobOpening2));

        List<JobOpening> jobOpenings = controller.jobOpeningsFromRepository();

        assertEquals(2, jobOpenings.size());
        verify(jobOpeningRepository, times(1)).findByCustomerManager(user);
    }

    @Test
    void testGetCandidateApplicationsFromJobOpening() {
        JobOpening jobOpening = mock(JobOpening.class);
        JobApplication application1 = mock(JobApplication.class);
        JobApplication application2 = mock(JobApplication.class);
        when(jobOpening.jobApplications()).thenReturn(Arrays.asList(application1, application2));

        List<JobApplication> applications = controller.getCandidateApplicationsFromJobOpening(jobOpening);

        assertEquals(2, applications.size());
        verify(jobOpening, times(1)).jobApplications();
    }
}