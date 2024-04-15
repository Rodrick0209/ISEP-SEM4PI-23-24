package jobs4u.base.clientManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUser;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.ClientName;
import jobs4u.base.utils.PostalAddress;
import org.springframework.security.core.userdetails.User;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Table(name = "Client")
@Entity
public class Client implements AggregateRoot<ClientCode> {


    @Id
    private ClientCode code;
    private ClientName name;
    private PostalAddress address;

    public Client() {

    }

    public Client(String code, String clientName, String address) {

        this.code = ClientCode.valueOf(code);
        this.name = ClientName.valueOf(clientName);
        this.address = PostalAddress.valueOf(address);
    }

    public ClientCode code() {
        return code;
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

    @Override
    public ClientCode identity() {
        return this.code;
    }
}
