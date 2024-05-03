package jobs4u.base.persistence.impl.jpa;

import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.InterviewModelSpecificationRepository;

public class JpaInterviewModelSpecificationRepository extends BaseJpaRepositoryBase<InterviewModelSpecification, InterviewModelSpecificationIdentifier, InterviewModelSpecificationIdentifier> implements InterviewModelSpecificationRepository {
    JpaInterviewModelSpecificationRepository() {
        super("identifier");
    }
}
