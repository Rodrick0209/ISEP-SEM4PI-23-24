package jobs4u.base.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;

public class JpaClientRepository extends JpaAutoTxRepository<Client,String,String> implements ClientRepository {



    public JpaClientRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "code");
    }






}
