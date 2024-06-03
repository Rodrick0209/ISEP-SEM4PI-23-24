package jobs4u.base.notificationManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.ClientCode;
import org.hibernate.annotations.Fetch;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;

@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@Entity
public class Notification implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    private Client client;
    private Message message;

    private LocalTime time;


    public Notification() {
        // for ORM
    }

    public Notification(String message, Client client) {
        this.message = Message.valueOf(message);
        this.client = client;
        this.time = LocalTime.now();
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



    @Override
    public Long identity() {
        return this.id;
    }





}
