package jobs4u.base.notificationManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Entity
public class Notification implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EmailAddress emailAddress;
    private Message message;
    private LocalDate date;

    private NotificationState state;

    public Notification() {
        // for ORM
    }

    public Notification(String message, EmailAddress emailAddress) {
        this.message = Message.valueOf(message);
        this.emailAddress = emailAddress;
        this.date = LocalDate.now();
        this.state = NotificationState.NotRead;
    }

    public NotificationState state() {
        return this.state;
    }


    public void markAsRead() {
        this.state = NotificationState.Read;
    }



    public Message message() {
        return this.message;
    }

    public LocalDate date() {
        return this.date;
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
