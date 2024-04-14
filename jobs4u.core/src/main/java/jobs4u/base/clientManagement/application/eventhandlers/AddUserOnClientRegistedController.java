package jobs4u.base.clientManagement.application.eventhandlers;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.PubSubRegistry;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUserBuilder;
import jobs4u.base.jobs4uusermanagement.domain.MecanographicNumber;
import jobs4u.base.jobs4uusermanagement.domain.SignupRequest;
import jobs4u.base.jobs4uusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.usermanagement.domain.Jobs4uPasswordPolicy;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.usermanagement.domain.UserBuilderHelper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@UseCaseController
public class AddUserOnClientRegistedController {

    private final UserRepository userRepository = PersistenceContext.repositories().users();

    private final EventPublisher dispatcher = PubSubRegistry.publisher();

    public SystemUser addUser(final ClientRegistedEvent clientRegistedEvent) {
        try {
            System.out.println("Entrou 1");
            final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
            System.out.println("Erro aqui?");
            userBuilder.withUsername(Username.valueOf(clientRegistedEvent.name().firstName())).withPassword(clientRegistedEvent.password())
                    .withName(clientRegistedEvent.name()).withEmail(clientRegistedEvent.emailAddress())
                    .withRoles(Jobs4uRoles.CUSTOMER);
            System.out.println("Ficou no meio");
            final SystemUser newUser = userRepository.save(userBuilder.build());
            System.out.println("Saiu 1");
            // notify interested parties
            final DomainEvent event = new NewUserRegisteredFromSignupEvent(MecanographicNumber.valueOf(clientRegistedEvent.emailAddress()), newUser.username());
            dispatcher.publish(event);
            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
