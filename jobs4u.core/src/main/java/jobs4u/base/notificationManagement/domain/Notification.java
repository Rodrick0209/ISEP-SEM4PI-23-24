package jobs4u.base.notificationManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.*;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

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


    @Enumerated(EnumType.STRING)
    private NotificationState state;

    public Notification() {
        // for ORM
    }

    public Notification(EmailAddress emailAddress, JobOpening jobOpening) {
        this.message = Message.valueOf(messageForJobOpeningStateChange(jobOpening));
        this.emailAddress = emailAddress;
        this.date = LocalDate.now();
        this.state = NotificationState.NotRead;
    }

    public Notification(EmailAddress emailAddress, JobApplication jobApplication) {
        this.message = Message.valueOf(messageForJobApplication(jobApplication));
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

    public EmailAddress emailAddress() {
        return this.emailAddress;
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

    public String messageForJobOpeningStateChange(JobOpening jobOpening) {
        return "Job Opening :" + jobOpening.jobReference() + " has changed its Status to " + jobOpening.status();
    }

    public String messageForJobApplication(JobApplication jobApplication) {
        return "Job Application for Job opening :" + jobApplication.getJobOpening().jobReference() + " has changed its Status to " + jobApplication.getState();
    }


    @Override
    public Long identity() {
        return this.id;
    }


}
