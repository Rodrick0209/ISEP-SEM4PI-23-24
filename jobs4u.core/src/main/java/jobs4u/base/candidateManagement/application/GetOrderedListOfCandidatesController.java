package jobs4u.base.candidateManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.List;

public class GetOrderedListOfCandidatesController {
    private final JobOpeningRepository jobOpeningRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final AuthorizationService authz;

    public GetOrderedListOfCandidatesController(JobOpeningRepository jobOpeningRepository,
                                                JobApplicationRepository jobApplicationRepository,
                                                AuthorizationService authz){
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.authz = authz;
    }
    public Iterable<JobOpening> jobOpeningsInAnalysisPhaseAndHadInterviewPhase(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        return jobOpeningRepository.findInAnalysisPhaseAndHadInterviewPhase();
    }

    public List<Candidate> getOrderedListOfCandidatesBasedOnInterviewPoints(JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        Iterable<JobApplication> jobApplications = jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);
        return jobOpening.getOrderedListOfCandidatesBasedOnInterviewPoints(jobApplications);
    }
}
