package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.jobRequirementSpecification.domain.JobRequirementSpecification;
import jobs4u.base.jobRequirementSpecification.repositories.JobRequirementSpecificationRepository;

public class InMemoryJobRequirementSpecificationRepository extends InMemoryDomainRepository<JobRequirementSpecification, Long> implements JobRequirementSpecificationRepository {

    static {
        InMemoryInitializer.init();
    }

}
