package jobs4u.base.clientManagement.application;


import eapli.framework.application.UseCaseController;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import jobs4u.base.clientManagement.application.eventhandlers.ClientRegistedEvent;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.usermanagement.domain.Jobs4uPasswordGenerator;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.utils.PostalAddress;

@UseCaseController
public class RegisterClientController {
    private final ClientRepository clientRepository;
    private final AuthorizationService authorizationService;
    private final EventPublisher dispatcher;


    public RegisterClientController(final ClientRepository clientRepository, final AuthorizationService authorizationService, final EventPublisher dispatcher) {
        this.clientRepository = clientRepository;
        this.authorizationService = authorizationService;
        this.dispatcher = dispatcher;
    }


    public Client registerClient(String code, String name, String emailAddress, String phoneNumber, String address, String representativeName, String representativeLastName) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);
        EmailAddress emailAddress1 = authorizationService.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER).get().email();
        final Client client = new Client(code, name, address, emailAddress1);
        return saveClient(client, representativeName, representativeLastName, emailAddress, phoneNumber);
    }


    private Client saveClient(Client client, String firstName, String lastName, String emailAddress, String phoneNumber) {
        client = this.clientRepository.save(client);
        Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();
        final String password = passwordGenerator.generatePassword();
        final DomainEvent event = new ClientRegistedEvent(client, Name.valueOf(firstName, lastName), emailAddress, password, phoneNumber);
        dispatcher.publish(event);
        return client;

    }


}
