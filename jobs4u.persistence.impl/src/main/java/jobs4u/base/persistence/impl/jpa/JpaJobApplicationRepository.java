package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;

import java.util.HashMap;
import java.util.Map;

class JpaJobApplicationRepository
        extends JpaAutoTxRepository<JobApplication, Long, Long>
        implements JobApplicationRepository {


    public JpaJobApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaJobApplicationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public Iterable<JobApplication> findJobApplicationsByCandidate(Candidate candidate) {
        final Map<String, Object> params = new HashMap<>();
        params.put("candidateEmail", candidate.emailAddress());
        return match("e.candidate.email = :candidateEmail", params);

    }
}
