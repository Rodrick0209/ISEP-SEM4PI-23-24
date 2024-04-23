package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.interviewModel.repositories.InterviewModelSpecificationRepository;

public class InMemoryInterviewModelSpecificationRepository extends InMemoryDomainRepository<InterviewModelSpecification, InterviewModelSpecificationIdentifier> implements InterviewModelSpecificationRepository {
    static{
        InMemoryInitializer.init();
    }
}
