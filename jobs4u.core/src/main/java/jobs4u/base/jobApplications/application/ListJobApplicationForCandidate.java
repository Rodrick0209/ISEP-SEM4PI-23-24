package jobs4u.base.jobApplications.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;


@UseCaseController
public class ListJobApplicationForCandidate {

    private JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();


    public Iterable<JobApplication> getJobApplicationForCandidate(EmailAddress emailAddress) {
        Candidate candidate = new Candidate();
        candidate.setEmail(emailAddress);
        return jobApplicationRepository.findJobApplicationsByCandidate(candidate);
    }

}
