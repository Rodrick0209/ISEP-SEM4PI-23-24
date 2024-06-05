package jobs4u.base.jobApplications.application;

import eapli.framework.infrastructure.pubsub.PubSubRegistry;
import jobs4u.base.notificationManagement.application.eventhandlers.SendNotificationWhenAppStateChangeEvent;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationState;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;

public class ChangeJobApplicationStateController {
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    public void changeState(JobApplication jobApplication, JobApplicationState newState) {

        // Retrieve the existing job application from the repository
        jobApplicationRepository.ofIdentity(jobApplication.identity()).ifPresentOrElse(existingJobApplication -> {
            // Change the state of the existing job application
            existingJobApplication.changeState(newState);
            // Save the updated job application
            jobApplicationRepository.save(existingJobApplication);

            // Publish the event after saving
            SendNotificationWhenAppStateChangeEvent event = new SendNotificationWhenAppStateChangeEvent(existingJobApplication);
            PubSubRegistry.publisher().publish(event);
        }, () -> {
            throw new IllegalArgumentException("Job Application not found");
        });
    }

}

