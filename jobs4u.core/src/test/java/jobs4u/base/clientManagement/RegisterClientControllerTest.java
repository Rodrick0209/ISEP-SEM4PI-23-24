package jobs4u.base.clientManagement;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import jobs4u.base.clientManagement.application.RegisterClientController;
import jobs4u.base.clientManagement.application.eventhandlers.ClientRegistedEvent;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RegisterClientControllerTest {

    private RegisterClientController subject;
    private ClientRepository clientRepository;
    private AuthorizationService authorizationService;
    private EventPublisher dispatcher;

    @BeforeEach
    void setUp() {
        clientRepository = mock(ClientRepository.class);
        authorizationService = mock(AuthorizationService.class);
        dispatcher = mock(EventPublisher.class);

        subject = new RegisterClientController(clientRepository, authorizationService, dispatcher);
    }

    @Test
    void ensureClientIsRegisteredAndClientRegisteredEventIsPublished() {
        final Client client = new Client("code", "name", "4890-238");

        when(clientRepository.save(client)).thenReturn(client);

        final var ret = subject.registerClient("code", "name", "rodrigo@gmail.com", "966270703", "4890-239", "representativeName", "representativeLastName");

        assertNotNull(ret);
        verify(dispatcher).publish(ArgumentMatchers.any(ClientRegistedEvent.class));
    }
}