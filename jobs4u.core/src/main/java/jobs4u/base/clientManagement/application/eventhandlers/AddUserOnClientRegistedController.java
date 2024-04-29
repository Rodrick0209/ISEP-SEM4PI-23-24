package jobs4u.base.clientManagement.application.eventhandlers;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.PubSubRegistry;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobs4uusermanagement.domain.events.NewUserRegisteredFromClientRegistedEvent;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.usermanagement.domain.UserBuilderHelper;


@UseCaseController
public class AddUserOnClientRegistedController {

    private final UserRepository userRepository = PersistenceContext.repositories().users();

    private final EventPublisher dispatcher = PubSubRegistry.publisher();

    public SystemUser addUser(final ClientRegistedEvent clientRegistedEvent) {
        try {

            final SystemUserBuilder userBuilder = UserBuilderHelper.builder();

            userBuilder.withUsername(Username.valueOf(clientRegistedEvent.emailAddress().toString())).withPassword(clientRegistedEvent.password())
                    .withName(clientRegistedEvent.name()).withEmail(clientRegistedEvent.emailAddress())
                    .withRoles(Jobs4uRoles.CUSTOMER);

            final SystemUser newUser = userRepository.save(userBuilder.build());

            // notify interested parties

            final DomainEvent event = new NewUserRegisteredFromClientRegistedEvent(clientRegistedEvent.client().code(), newUser.username(),clientRegistedEvent.phoneNumber());
            dispatcher.publish(event);
            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
