package jobs4u.base.clientManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEventBase;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import jobs4u.base.clientManagement.domain.Client;

public class ClientRegistedEvent extends DomainEventBase {

    private static final long serialVersionUID = 1L;

    private final Client client;


    public ClientRegistedEvent(final Client client) {
        this.client = client;
    }

    public Name name() {
        return client.name();
    }
    public String emailAddress() {
        return client.emailAddress();
    }

    public String password() {
        return client.password();
    }



    @Override
    public String toString() {
        return "ClientRegistedEvent{" + "theClient=" + client + '}';
    }






}
