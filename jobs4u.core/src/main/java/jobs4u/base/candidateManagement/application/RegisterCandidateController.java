package jobs4u.base.candidateManagement.application;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import jobs4u.base.candidateManagement.application.eventhandlers.CandidateRegisteredEvent;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.usermanagement.domain.Jobs4uPasswordGenerator;

public class RegisterCandidateController {

    private final CandidateRepository candidateRepository;
    private final AuthorizationService authorizationService;
    private final EventPublisher dispatcher;


    public RegisterCandidateController(final CandidateRepository candidateRepository, final AuthorizationService authorizationService,
                                       final EventPublisher dispatcher) {
        this.candidateRepository = candidateRepository;
        this.authorizationService = authorizationService;
        this.dispatcher = dispatcher;
    }

    public Candidate registerCandidate(String email, String firstname, String surname, String phoneNumber){

        // authorizationService.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.OPERATOR);
        final Candidate candidate = new Candidate(email, firstname, surname, phoneNumber);
        return saveCandidate(candidate, email, firstname, surname, phoneNumber);
    }

    private Candidate saveCandidate(Candidate candidate, String email, String firstname, String surname, String phoneNumber){

        candidate = this.candidateRepository.save(candidate);
        Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();
        final String password = passwordGenerator.generatePassword();

        final DomainEvent event = new CandidateRegisteredEvent(candidate, Name.valueOf(firstname,surname), email, password, phoneNumber);
        dispatcher.publish(event);

        return candidate;

    }

}
