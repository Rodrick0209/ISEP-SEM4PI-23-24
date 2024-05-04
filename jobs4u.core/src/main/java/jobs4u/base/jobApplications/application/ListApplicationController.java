package jobs4u.base.jobApplications.application;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;

public class ListApplicationController {

    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpenings();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

        public Iterable<JobOpening> listJobOpenings() {
            return jobOpeningRepository.findAll();
        }

        public Iterable<JobOpening> listApplications() {
            return repository.findAll();
        }

        public Iterable<JobApplication> listApplications(JobOpening jobOpening) {
            return repository.ofIdentity(jobOpening.jobReference()).get().getApplications();
        }
        public JobOpening getJobOpeningForJobApplication(JobApplication jobApplication) {
            return jobOpeningRepository.findByJobApplication(jobApplication);
        }




    }