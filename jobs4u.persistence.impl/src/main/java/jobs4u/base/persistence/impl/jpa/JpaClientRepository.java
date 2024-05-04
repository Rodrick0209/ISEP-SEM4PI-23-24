package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.ClientCode;

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




}
