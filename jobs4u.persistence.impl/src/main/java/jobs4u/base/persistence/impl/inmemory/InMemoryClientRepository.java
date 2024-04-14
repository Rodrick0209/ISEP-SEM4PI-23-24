package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;

import java.util.Optional;

public class InMemoryClientRepository extends InMemoryDomainRepository<Client, String> implements ClientRepository {

    static {
        InMemoryInitializer.init();
    }


}
