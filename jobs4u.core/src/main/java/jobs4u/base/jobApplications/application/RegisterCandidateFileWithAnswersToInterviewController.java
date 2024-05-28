package jobs4u.base.jobApplications.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

@UseCaseController
public class RegisterCandidateFileWithAnswersToInterviewController {



    private final JobApplicationRepository jobApplicationRepository;

    private final AuthorizationService authz;

    public RegisterCandidateFileWithAnswersToInterviewController(JobApplicationRepository jobApplicationRepository,AuthorizationService authz) {
        this.authz = authz;
        this.jobApplicationRepository = jobApplicationRepository;
    }


    public void registerCandidateFileWithAnswers(String fileName, JobApplication applicationSelected) {
        authz.ensureAuthenticatedUserHasAnyOf( Jobs4uRoles.CUSTOMER_MANAGER,Jobs4uRoles.POWER_USER);
        applicationSelected.getInterview().registerInterviewAnswer(fileName);
        jobApplicationRepository.save(applicationSelected);
    }



}
