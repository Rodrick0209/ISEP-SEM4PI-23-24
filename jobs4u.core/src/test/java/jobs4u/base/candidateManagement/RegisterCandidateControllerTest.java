package jobs4u.base.candidateManagement;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import jobs4u.base.candidateManagement.application.RegisterCandidateController;
import jobs4u.base.candidateManagement.application.eventhandlers.CandidateRegisteredEvent;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.mockito.ArgumentMatchers;
import static org.mockito.Mockito.*;



public class RegisterCandidateControllerTest {

    private RegisterCandidateController subject;
    private CandidateRepository candidateRepository;
    private AuthorizationService authorizationService;
    private EventPublisher dispatcher;

    @BeforeEach
    void setUp() {
        candidateRepository = mock(CandidateRepository.class);
        authorizationService = mock(AuthorizationService.class);
        dispatcher = mock(EventPublisher.class);

        subject = new RegisterCandidateController(candidateRepository, authorizationService, dispatcher);
    }

    @Test
    void ensureCandidateIsRegistered() {
        final Candidate candidate = new Candidate("nome", "apelido", "email@email.pt", "965430293");

        when(candidateRepository.save(candidate)).thenReturn(candidate);

        final var ret = subject.registerCandidate("email@email.pt", "nome", "apelido", "965430293");

        assertNotNull(ret);
        verify(dispatcher).publish(ArgumentMatchers.any(CandidateRegisteredEvent.class));
    }

    @Test
    void ensureCandidateDoesRegisterWithExistingEmail() {

        // TODO - FIND HOW TO THE EMAIL ID'ING WORKS

        final Candidate candidate = new Candidate("nome", "apelido", "email@email.pt", "965430293");
        final Candidate candidate2 = new Candidate("nomedois", "apelidodois", "email@email.pt", "965430293");

        when(candidateRepository.save(candidate)).thenReturn(candidate);
        when(candidateRepository.save(candidate2)).thenReturn(candidate2);

        final var reg1 = subject.registerCandidate("email@email.pt", "nome", "apelido", "965430293");
        final var reg2 = subject.registerCandidate("email@email.pt", "nomedois", "apelidodois", "965430293");

    }
}
