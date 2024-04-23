package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;

import java.util.List;

class InMemoryJobOpeningRepository extends InMemoryDomainRepository<JobOpening, JobReference> implements JobOpeningRepository {


    static {
        InMemoryInitializer.init();
    }

    //TODO implement
    @Override
    public List<JobOpening> findByCustomerManager(SystemUser customer) {
        return List.of();
    }
}
