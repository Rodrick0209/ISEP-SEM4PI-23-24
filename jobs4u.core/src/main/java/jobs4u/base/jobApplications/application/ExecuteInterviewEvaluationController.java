package jobs4u.base.jobApplications.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.List;

public class ExecuteInterviewEvaluationController {
    private final AuthorizationService authz;
    private final JobOpeningRepository jobOpeningRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final ExecuteInterviewEvaluationService service;
    public ExecuteInterviewEvaluationController(AuthorizationService authz,
                                                  JobOpeningRepository jobOpeningRepository,
                                                  JobApplicationRepository jobApplicationRepository,
                                                  ExecuteInterviewEvaluationService service){
        this.authz = authz;
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.service = service;
    }
    public Iterable<JobOpening> jobOpeningsInInterviewPhase() {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);
        return jobOpeningRepository.findInInterviewPhase();
    }
    public void executeInterviewEvaluation(JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);
        List<JobApplication> jobApplications= jobApplicationRepository.findJobApplicationsByJobOpeningWithInterviewAnswerFile(jobOpening);
        service.executeInterviewEvaluation(jobOpening, jobApplications);
    }


}
