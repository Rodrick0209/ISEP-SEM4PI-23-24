package jobs4u.base.notificationManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.pubsub.EventHandler;
import eapli.framework.validations.Preconditions;
import jobs4u.base.clientManagement.application.eventhandlers.AddUserOnClientRegistedController;
import jobs4u.base.clientManagement.application.eventhandlers.ClientRegistedEvent;
import jobs4u.base.clientManagement.application.eventhandlers.ClientRegistedWatchDog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SendNotificationOnJobOpeningsStateChangedWatchDog implements EventHandler {


    private static final Logger LOGGER = LogManager.getLogger(ClientRegistedWatchDog.class);


    public void onEvent(DomainEvent domainEvent) {
        Preconditions.ensure(domainEvent instanceof SendNotificationOnjobOpeningStateChangedEvent);
        final SendNotificationOnjobOpeningStateChangedEvent event = (SendNotificationOnjobOpeningStateChangedEvent) domainEvent;

        final SendNotificationOnJobOpeningStateChangedController controller = new SendNotificationOnJobOpeningStateChangedController();

        try {
            controller.sendNotificationOnJobOpeningStateChanged(event);
            System.out.println("Notification sent with success");
        } catch (final IntegrityViolationException e) {
            LOGGER.error("Unable to send client notification on event", e);
        }

    }
}