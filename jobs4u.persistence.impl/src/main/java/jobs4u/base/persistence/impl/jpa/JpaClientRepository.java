package jobs4u.base.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.ClientCode;

import java.util.Optional;

class JpaClientRepository extends BasepaRepositoryBase<Client,ClientCode,ClientCode> implements ClientRepository {


    public JpaClientRepository() {
        super("code");
    }



}
