package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCandidateRepository
        extends JpaAutoTxRepository<Candidate, EmailAddress, EmailAddress>
        implements CandidateRepository {

    public JpaCandidateRepository(final TransactionalContext autoTx) {
        super(autoTx, "email");
    }

    public JpaCandidateRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "email");
    }

    @Override
    public Optional<Candidate> findByEmail(EmailAddress email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("emailAddress", email.toString());
        return matchOne("e.email.email=:emailAddress", params);
    }


}
