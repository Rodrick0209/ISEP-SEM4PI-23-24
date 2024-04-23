package jobs4u.base.jobOpeningsManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;

import java.util.List;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {

    //implementar todos os metodos de job openings relacionados com base de dados ou memorias
    List<JobOpening> findByCustomerManager(SystemUser customer);

}
