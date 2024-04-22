package jobs4u.base.candidateManagement;

import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateTest {

    @Test
    void ensureClientWithCodeNameAndAddress() {
        new Candidate("nome", "apelido", "email@email.pt", "965430293");
        assertTrue(true);
    }

    @Test
    void ensureMustHaveFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Candidate(null, "apelido", "email@email.pt", "965430293"));
    }

    @Test
    void ensureMustHaveLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Candidate("nome", null, "email@emial.pt", "965430293"));
    }

    @Test
    void ensureMustHaveEmailAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Candidate("nome", "apelido", null, "965430293"));
    }

    @Test
    void ensureMustHavePhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Candidate("nome", "apelido", "email@email.pt", null));

    }
}

