package jobs4u.base.clientManagement.application.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.ClientCode;

import java.util.Optional;

public interface ClientRepository extends DomainRepository<ClientCode, Client> {

    Optional<Client> findByEmail(String email);

}
