package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;

public class InMemoryCandidateRepository extends InMemoryDomainRepository<Candidate, EmailAddress> implements CandidateRepository{

    static {
        InMemoryInitializer.init();
    }


}
