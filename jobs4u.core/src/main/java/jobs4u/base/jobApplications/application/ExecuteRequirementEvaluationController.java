package jobs4u.base.jobApplications.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

public class ExecuteRequirementEvaluationController {


    private final AuthorizationService authz;

    private final JobApplicationRepository jobApplicationRepository;


    public ExecuteRequirementEvaluationController(JobApplicationRepository jobApplicationRepository, AuthorizationService authz) {
        this.authz = authz;
        this.jobApplicationRepository = jobApplicationRepository;
    }


    public void executeRequirementEvaluation(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.ADMIN);
        new EvaluateListOfApplicationsService().evaluateListOfApplications(jobApplicationRepository.findJobApplicationsByJobOpeningWithRequirementAnswerFile(jobOpening));
    }


}
