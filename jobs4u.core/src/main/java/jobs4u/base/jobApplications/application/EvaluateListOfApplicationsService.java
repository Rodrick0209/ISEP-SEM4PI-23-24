package jobs4u.base.jobApplications.application;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.FileName;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.recruitmentProcessManagement.utils.State;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EvaluateListOfApplicationsService {


    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    private final TransactionalContext context = PersistenceContext.repositories().newTransactionalContext();

    public void evaluateListOfApplications(JobOpening jobOpening,List<JobApplication> jobApplications,Iterable<Notification>notifications) {

        try {
            context.beginTransaction();
            for (JobApplication jobApplication : jobApplications) {
                if (!jobOpening.getRecruitmentProcess().returnNotClosedPhase().designation().toString().equals("Interview"))
                    throw new IllegalStateException("The recruitment process is not in the interview phase");

                InputStream inputStream = jobApplication.getRequirementAnswer().inputStreamFromResourceOrFile();
                boolean result = jobOpening.requirementSpecification().buildEvaluator().evaluate(inputStream);
                jobApplication.getRequirementAnswer().defineResult(result);
                jobApplicationRepository.save(jobApplication);
            }
            checkIfRequirementPhaseStateChanges(jobOpening,jobApplications,notifications);
            context.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkIfRequirementPhaseStateChanges(JobOpening jobOpening, List<JobApplication> jobApplications,Iterable<Notification> notificationList) {
        if (jobApplications.isEmpty())
            return;

        if (isScreenPhaseConcluded(jobApplications,notificationList)) {
            jobOpening.recruitmentProcess().resumeScreenPhase().setState(State.FINISHED);
            return;
        }

        if (isScreeningPhaseStarted(jobApplications) && jobOpening.recruitmentProcess().resumeScreenPhase().state().equals(State.OPEN)) {
            jobOpening.recruitmentProcess().resumeScreenPhase().setState(State.ACTIVE);
        }
    }


    public boolean isScreeningPhaseStarted(List<JobApplication> jobApplicationList) {
        for (JobApplication application : jobApplicationList) {
            if (application.isApplicationRequirementAnswerEvaluated()) {
                return true;
            }
        }

        return false;
    }



    public boolean isScreenPhaseConcluded(List<JobApplication> jobApplicationList, Iterable<Notification> notificationList){
        boolean thereIsNotificationForCandidate ;
        for (JobApplication application : jobApplicationList) {

            if (!application.isApplicationRequirementAnswerEvaluated()) {
                return false;
            }
            thereIsNotificationForCandidate = false;
            EmailAddress emailAddressCandidate = application.getCandidate().emailAddress();
            for (Notification notification: notificationList) {
                if (notification.emailAddress().equals(emailAddressCandidate)) {
                    thereIsNotificationForCandidate = true;
                }
            }
            if (!thereIsNotificationForCandidate) {
                return false;
            }

        }

        return true;
    }

}
