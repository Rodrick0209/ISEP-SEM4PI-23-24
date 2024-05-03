package jobs4u.base.persistence.impl.jpa;

import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.utils.ClientCode;

class JpaClientRepository extends BaseJpaRepositoryBase<Client,ClientCode,ClientCode> implements ClientRepository {


    public JpaClientRepository() {
        super("code");
    }



}
