package jobs4u.base.jobApplications.application;

import jakarta.persistence.Persistence;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;

public class ListApplicationController {

    private final JobApplicationRepository repository = PersistenceContext.repositories().jobApplications();

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    public Iterable<JobApplication> listApplications() {
        return repository.findAll();
    }

    public JobOpening getJobOpeningForJobApplication(JobApplication jobApplication) {
        return jobOpeningRepository.findByJobApplication(jobApplication);
    }




}
