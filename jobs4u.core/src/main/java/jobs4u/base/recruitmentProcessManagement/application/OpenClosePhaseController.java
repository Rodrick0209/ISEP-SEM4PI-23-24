package jobs4u.base.recruitmentProcessManagement.application;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.PubSubRegistry;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.notificationManagement.application.eventhandlers.SendNotificationOnjobOpeningStateChangedEvent;
import jobs4u.base.recruitmentProcessManagement.utils.State;

import java.util.List;

public class OpenClosePhaseController {


    private AuthorizationService authz;

    private final EventPublisher dispatcher = PubSubRegistry.publisher();

    private JobOpeningRepository jobOpeningRepository;
    private JobApplicationRepository jobApplicationRepository;

    public OpenClosePhaseController(JobOpeningRepository jobOpeningRepository ,AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }



    public String getMessageAccordinglyWithPhaseState(JobOpening jobOpening) {
        return jobOpening.recruitmentProcess().messageForOpenClosePhase();
    }

    public void changePhase(JobOpening jobOpening){
        JobOpeningStatus status = jobOpening.getStatus();
        jobOpening.changePhase();
        JobOpeningStatus newStatus = jobOpening.getStatus();
        if(status != newStatus){
            DomainEvent domainEvent = new SendNotificationOnjobOpeningStateChangedEvent(jobOpening);
            dispatcher.publish(domainEvent);
        }

        jobOpeningRepository.save(jobOpening);
    }

}
