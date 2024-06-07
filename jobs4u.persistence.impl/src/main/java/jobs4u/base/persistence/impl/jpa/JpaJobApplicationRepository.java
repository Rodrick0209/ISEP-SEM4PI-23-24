package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.RequirementResult;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<JobApplication> findJobApplicationsByJobOpening(JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("reference", jobOpening.jobReference());
        return match("e.jobOpening.jobReference = :reference", params);
    }


    @Override
    public List<JobApplication> findJobApplicationsByJobOpeningWithRequirementAnswerFile(JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("reference", jobOpening.jobReference());
        return match("e.jobOpening.jobReference = :reference and e.requirementAnswer.fileName is not null and e.requirementAnswer.result IS NULL", params);
    }

    @Override
    public List<JobApplication> findJobApplicationByJobOpeningWithInterviewAnswerFileWithoutInterviewPointsAndRequirementResultAccepted(JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("reference", jobOpening.jobReference());
        params.put("accepted", RequirementResult.ACCEPTED);
        return match("e.jobOpening.jobReference = :reference and e.interview.answer is not null and e.interview.answer.points IS NULL and e.requirementAnswer.result = :accepted", params);
    }


}
