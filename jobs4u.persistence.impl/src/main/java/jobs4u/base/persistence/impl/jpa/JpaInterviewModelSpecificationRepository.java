package jobs4u.base.persistence.impl.jpa;

import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.interviewModel.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.jobRequirement.repositories.JobRequirementSpecificationRepository;

public class JpaInterviewModelSpecificationRepository extends BasepaRepositoryBase<InterviewModelSpecification, InterviewModelSpecificationIdentifier, InterviewModelSpecificationIdentifier> implements InterviewModelSpecificationRepository {
    JpaInterviewModelSpecificationRepository() {
        super("identifier");
    }
}
