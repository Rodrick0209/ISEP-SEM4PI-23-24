package jobs4u.base.clientManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.pubsub.EventHandler;
import eapli.framework.validations.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientRegistedWatchDog implements EventHandler{

    private static final Logger LOGGER = LogManager.getLogger(ClientRegistedWatchDog.class);


    public void onEvent(DomainEvent domainEvent){
        Preconditions.ensure(domainEvent instanceof ClientRegistedEvent);
        final ClientRegistedEvent event = (ClientRegistedEvent) domainEvent;

        final AddUserOnClientRegistedController controller = new AddUserOnClientRegistedController();

        try {
            controller.addUser(event);
        }catch (final IntegrityViolationException e) {
            LOGGER.error("Unable to register new user on client registed event", e);
        }

}











}
