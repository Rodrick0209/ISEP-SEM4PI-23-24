package jobs4u.base.candidateManagement.application.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.candidateManagement.domain.Candidate;

public interface CandidateRepository extends DomainRepository<EmailAddress, Candidate> {


}
