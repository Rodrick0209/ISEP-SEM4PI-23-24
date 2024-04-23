package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.jobRequirement.repositories.JobRequirementSpecificationRepository;

public class InMemoryJobRequirementSpecificationRepository extends InMemoryDomainRepository<JobRequirementSpecification, JobRequirementSpecificationIdentifier> implements JobRequirementSpecificationRepository {

    static {
        InMemoryInitializer.init();
    }

}
