package jobs4u.base.jobApplications.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

import java.util.List;

public interface JobApplicationRepository
        extends DomainRepository<Long, JobApplication> {

    Iterable<JobApplication> findJobApplicationsByCandidate(Candidate candidate);

    List<JobApplication> findJobApplicationsByJobOpening(JobOpening jobOpening);

    List<JobApplication> findJobApplicationsByJobOpeningWithRequirementAnswerFile(JobOpening jobOpening);

    List<JobApplication> findJobApplicationByJobOpeningWithInterviewAnswerFileWithoutInterviewPointsAndRequirementResultAccepted(JobOpening jobOpening);

}
