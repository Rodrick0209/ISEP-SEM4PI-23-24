package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.ClientCode;

import java.util.Optional;

class InMemoryClientRepository extends InMemoryDomainRepository<Client, ClientCode> implements ClientRepository {

    static {
        InMemoryInitializer.init();
    }


    @Override
    public Optional<Client> findByEmail(String email) {
        return null;
    }
}
