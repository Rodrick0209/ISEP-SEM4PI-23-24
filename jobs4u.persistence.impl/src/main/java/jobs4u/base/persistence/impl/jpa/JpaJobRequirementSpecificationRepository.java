package jobs4u.base.persistence.impl.jpa;

import jobs4u.base.pluginManagement.domain.JobRequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;

public class JpaJobRequirementSpecificationRepository extends BasepaRepositoryBase<JobRequirementSpecification, JobRequirementSpecificationIdentifier, JobRequirementSpecificationIdentifier> implements JobRequirementSpecificationRepository {

    JpaJobRequirementSpecificationRepository() {
        super("identifier");
    }
}
