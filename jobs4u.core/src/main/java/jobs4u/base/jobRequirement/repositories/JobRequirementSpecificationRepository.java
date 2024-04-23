package jobs4u.base.jobRequirement.repositories;


import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecificationIdentifier;

public interface JobRequirementSpecificationRepository extends DomainRepository<JobRequirementSpecificationIdentifier, JobRequirementSpecification> {
}
