package jobs4u.base.clientManagement.application;


import eapli.framework.application.UseCaseController;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import jobs4u.base.clientManagement.application.eventhandlers.ClientRegistedEvent;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

@UseCaseController
public class RegisterClientController {
    private final ClientRepository clientRepository;
    private final AuthorizationService authorizationService;
    private final EventPublisher dispatcher;


    public RegisterClientController(final ClientRepository clientRepository,final AuthorizationService authorizationService,final EventPublisher dispatcher) {
        this.clientRepository = clientRepository;
        this.authorizationService = authorizationService;
        this.dispatcher = dispatcher;
    }



    public Client registerClient(String code, String name, String emailAddress, String password, String phoneNumber,String address) {
      //  authorizationService.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);
        final Client client = new Client(code,name,"Default", address, emailAddress, password);
        return saveClient(client);
    }


    private Client saveClient(Client client) {
        client = this.clientRepository.save(client);

        final DomainEvent event = new ClientRegistedEvent(client);
        dispatcher.publish(event);
        return client;

    }


}
