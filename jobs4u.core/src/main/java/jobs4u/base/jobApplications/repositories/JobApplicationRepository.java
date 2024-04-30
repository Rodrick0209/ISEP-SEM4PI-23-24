package jobs4u.base.jobApplications.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;

public interface JobApplicationRepository
        extends DomainRepository<Long, JobApplication> {

    Iterable<JobApplication> findJobApplicationsByCandidate(Candidate candidate);


}
