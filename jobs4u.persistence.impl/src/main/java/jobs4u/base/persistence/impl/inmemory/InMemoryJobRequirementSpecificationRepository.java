package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;

public class InMemoryJobRequirementSpecificationRepository extends InMemoryDomainRepository<RequirementSpecification, JobRequirementSpecificationIdentifier> implements JobRequirementSpecificationRepository {

    static {
        InMemoryInitializer.init();
    }

}
