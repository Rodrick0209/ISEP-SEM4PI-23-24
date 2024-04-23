package jobs4u.base.candidateManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import jobs4u.base.utils.ClientName;
import jobs4u.base.utils.PhoneNumber;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Table(name = "Candidate")
@Entity
public class Candidate implements AggregateRoot<EmailAddress> {

    private Name name;

    @Id
    private EmailAddress email;
    private PhoneNumber phoneNumber;

    public Candidate(){}

    public Candidate (String firstname, String surname, String email, String phoneNumber){

        this.email = EmailAddress.valueOf(email);
        this.name = Name.valueOf(firstname, surname);
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);

    }

    public EmailAddress emailAddress(){
        return email;
    }

    public Name name(){
        return name;
    }

    public String nameString(){
        return name.toString();
    }

    public PhoneNumber phoneNumber(){
        return phoneNumber;

    }


    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }
    @Override
    public EmailAddress identity() {
        return null;
    }
}
