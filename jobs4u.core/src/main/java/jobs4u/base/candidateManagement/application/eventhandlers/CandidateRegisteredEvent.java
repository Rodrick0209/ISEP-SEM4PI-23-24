package jobs4u.base.candidateManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEventBase;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.utils.PhoneNumber;

public class CandidateRegisteredEvent extends DomainEventBase {

    private static final long serialVersionUID = 1L;

    private final Candidate candidate;
    private final EmailAddress emailAddress;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final String password;

    public CandidateRegisteredEvent(final Candidate candidate, final Name name, final String emailAddress, final String password, final String phoneNumber){
        this.candidate = candidate;
        this.emailAddress = EmailAddress.valueOf(emailAddress);
        this.name = name;
        this.password = password;
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
    }

    public Candidate candidate() {
        return this.candidate;
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
    public PhoneNumber phoneNumber() {
        return this.phoneNumber;
    }


    public String toString() {
        return "CandidateRegisteredEvent{" + "theCandidate=" + candidate + '}';
    }



}
