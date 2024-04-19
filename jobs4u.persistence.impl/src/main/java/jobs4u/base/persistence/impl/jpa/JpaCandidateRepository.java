package jobs4u.base.persistence.impl.jpa;

import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;

public class JpaCandidateRepository extends BasepaRepositoryBase<Candidate, EmailAddress, EmailAddress> implements CandidateRepository {

    public JpaCandidateRepository() {
        super("email");
    }

}
