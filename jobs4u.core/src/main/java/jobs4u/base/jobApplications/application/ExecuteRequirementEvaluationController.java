package jobs4u.base.jobApplications.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

public class ExecuteRequirementEvaluationController {


    private final AuthorizationService authz;

    private final JobApplicationRepository jobApplicationRepository;

    private final NotificationRepository notificationRepository;


    public ExecuteRequirementEvaluationController(JobApplicationRepository jobApplicationRepository, AuthorizationService authz, NotificationRepository notificationRepository) {
        this.authz = authz;
        this.jobApplicationRepository = jobApplicationRepository;
        this.notificationRepository = notificationRepository;
    }


    public void executeRequirementEvaluation(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.ADMIN);

        new EvaluateListOfApplicationsService().evaluateListOfApplications(jobOpening,jobApplicationRepository.findJobApplicationsByJobOpeningWithRequirementAnswerFile(jobOpening),getNotifications(jobOpening));
    }


    public Iterable<Notification> getNotifications (JobOpening jobOpening){
        //TODO not eficient and otimized way
        return notificationRepository.findAll();
    }

}
