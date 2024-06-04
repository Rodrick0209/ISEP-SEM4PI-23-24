package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.ClientCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class JpaClientRepository
        extends JpaAutoTxRepository<Client,ClientCode,ClientCode>
        implements ClientRepository {

    public JpaClientRepository(final TransactionalContext autoTx) {
        super(autoTx, "code");
    }

    public JpaClientRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "code");
    }


    @Override
    public Optional<Client> findByEmail(String email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("emailAddress", email.toString());
        return matchOne("e.user.email.email=:emailAddress", params);
    }

}

