package jobs4u.base.candidateManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import jakarta.persistence.*;
import jobs4u.base.Application;
import jobs4u.base.jobAplications.domain.JobApplication;
import jobs4u.base.jobAplications.domain.JobApplicationFile;
import jobs4u.base.utils.ClientName;
import jobs4u.base.utils.PhoneNumber;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@XmlRootElement
public class Candidate implements AggregateRoot<EmailAddress> {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EmailAddress email;

    private PhoneNumber phoneNumber;

    private Name name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "Application")
    private List<JobApplication> applications = new ArrayList<>();

    public Candidate(){}

    public Candidate (String firstname, String surname, String email, String phoneNumber, List<JobApplication> applications){

        this.email = EmailAddress.valueOf(email);
        this.name = Name.valueOf(firstname, surname);
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
        this.applications = applications;

    }

    public Candidate (String firstname, String surname, String email, String phoneNumber){

        this.email = EmailAddress.valueOf(email);
        this.name = Name.valueOf(firstname, surname);
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
        this.applications = null;

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
    public JobApplication addApplication(JobApplication application){
        applications.add(application);
        return application;
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
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Candidate candidate = (Candidate) other;
        return Objects.equals(email, candidate.email);
    }

    @Override
    public EmailAddress identity() {
        return email;
    }
}
