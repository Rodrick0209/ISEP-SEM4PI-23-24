package jobs4u.base.clientManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.*;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.ClientName;
import jobs4u.base.utils.PostalAddress;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@XmlRootElement
@Table(name = "Client")
@Entity
public class Client implements AggregateRoot<ClientCode> {


    @EmbeddedId
    private ClientCode clientCode;
    private ClientName name;
    private PostalAddress address;

    @Column(name = "customerManagerEmail")
    private EmailAddress customerManagerEmail;


    public Client() {

    }

    public Client(String clientCode, String clientName, String address, EmailAddress customerManagerEmail) {

        this.clientCode = ClientCode.valueOf(clientCode);
        this.name = ClientName.valueOf(clientName);
        this.address = PostalAddress.valueOf(address);
        this.customerManagerEmail = customerManagerEmail;

    }

    public ClientCode code() {
        return clientCode;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public ClientName name() {
        return name;
    }

    public PostalAddress address() {
        return address;
    }

    public ClientCode clientCode() {
        return clientCode;
    }

    @Override
    public ClientCode identity() {
        return this.clientCode;
    }


}
