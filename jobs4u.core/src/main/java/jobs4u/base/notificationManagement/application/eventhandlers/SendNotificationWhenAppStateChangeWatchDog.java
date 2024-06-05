package jobs4u.base.notificationManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.pubsub.EventHandler;
import eapli.framework.validations.Preconditions;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.notificationManagement.application.registerNotificationController;
import jobs4u.base.notificationManagement.domain.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SendNotificationWhenAppStateChangeWatchDog implements EventHandler {

    private static final Logger LOGGER = LogManager.getLogger(SendNotificationWhenAppStateChangeEvent.class);


    public void onEvent(DomainEvent domainEvent){

        Preconditions.ensure(domainEvent instanceof SendNotificationWhenAppStateChangeEvent);

        final SendNotificationWhenAppStateChangeEvent event = (SendNotificationWhenAppStateChangeEvent) domainEvent;

        final registerNotificationController controller = new registerNotificationController();

        try {
            JobApplication jobApplication = event.getJobApplication();
            Notification notification = new Notification(jobApplication.getCandidate().emailAddress(), jobApplication);
            controller.registerNotification(notification);

        }catch (final IntegrityViolationException e) {
            LOGGER.error("Unable to register new user on client registed event", e);
        }

    }
}
