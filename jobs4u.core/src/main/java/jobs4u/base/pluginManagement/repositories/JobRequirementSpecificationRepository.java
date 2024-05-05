package jobs4u.base.pluginManagement.repositories;


import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;

public interface JobRequirementSpecificationRepository extends DomainRepository<JobRequirementSpecificationIdentifier, RequirementSpecification> {
}
