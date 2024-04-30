package jobs4u.base.jobApplications.application;

import jakarta.persistence.Persistence;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;

public class ListApplicationController {

    private final JobApplicationRepository repository = PersistenceContext.repositories().jobApplications();

    public Iterable<JobApplication> listApplications() {
        return repository.findAll();
    }


}
