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
import org.springframework.security.core.userdetails.User;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Table(name = "Client")
@Entity
public class Client implements AggregateRoot<String> {


    @Id
    private String code;
    private Name name;
    private String address;
    private String clientEmailAddress;

    //TODO o cliente n pode ter a password aqui??
    private String password;




    public Client() {

    }

    public Client(String code, String firstName, String lastName, String address, String emailAddress, String password) {

        this.code = code;
        this.name = Name.valueOf(firstName, lastName);
        this.address = address;
        this.clientEmailAddress = emailAddress;
        this.password = password;
    }

    public String code() {
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


    public Name name() {
        return name;
    }

    public String address() {
        return address;
    }

    public String emailAddress() {
        return clientEmailAddress;
    }

    public String password() {
        return password;
    }


    @Override
    public String identity() {
        return null;
    }
}
