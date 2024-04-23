package jobs4u.base.persistence.impl.jpa;

import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.jobRequirement.repositories.JobRequirementSpecificationRepository;

public class JpaJobRequirementSpecificationRepository extends BasepaRepositoryBase<JobRequirementSpecification, JobRequirementSpecificationIdentifier, JobRequirementSpecificationIdentifier> implements JobRequirementSpecificationRepository {

    JpaJobRequirementSpecificationRepository() {
        super("identifier");
    }
}
