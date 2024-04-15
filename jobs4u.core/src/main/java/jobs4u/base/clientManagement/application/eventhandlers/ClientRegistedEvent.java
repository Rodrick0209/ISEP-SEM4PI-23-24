package jobs4u.base.clientManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEventBase;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.PhoneNumber;

public class ClientRegistedEvent extends DomainEventBase {

    private static final long serialVersionUID = 1L;

    private final Client client;

    private final EmailAddress emailAddress;

    private final Name name;

    private final String password;

    private final PhoneNumber phoneNumber;

    public ClientRegistedEvent(final Client client, final Name name, final String emailAddress, final String password, final String phoneNumber){
        this.client = client;
        this.emailAddress = EmailAddress.valueOf(emailAddress);
        this.name = name;
        this.password = password;
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
    }

    public Name name() {
        return this.name;
    }
    public EmailAddress emailAddress() {
        return this.emailAddress;
    }

    public String password() {
        return this.password;
    }

    public Client client() {
        return this.client;
    }

    public PhoneNumber phoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return "ClientRegistedEvent{" + "theClient=" + client + '}';
    }






}
