package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;

class InMemoryJobOpeningRepository extends InMemoryDomainRepository<JobOpening, JobReference> implements JobOpeningRepository {


    static {
        InMemoryInitializer.init();
    }

}
