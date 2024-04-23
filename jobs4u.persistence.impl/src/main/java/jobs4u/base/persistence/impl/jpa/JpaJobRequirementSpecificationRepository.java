package jobs4u.base.persistence.impl.jpa;

import jobs4u.base.jobRequirementSpecification.domain.JobRequirementSpecification;
import jobs4u.base.jobRequirementSpecification.repositories.JobRequirementSpecificationRepository;

public class JpaJobRequirementSpecificationRepository extends BasepaRepositoryBase<JobRequirementSpecification, Long, Long> implements JobRequirementSpecificationRepository {

    JpaJobRequirementSpecificationRepository() {
        super("id");
    }
}
