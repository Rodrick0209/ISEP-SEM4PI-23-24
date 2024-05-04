package jobs4u.base.pluginManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecificationIdentifier;

public interface InterviewModelSpecificationRepository
        extends DomainRepository<InterviewModelSpecificationIdentifier, InterviewModelSpecification>
        {
}
