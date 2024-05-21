package jobs4u.base.jobApplications.application;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;

public class ListApplicationController {

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();
        public Iterable<JobOpening> listJobOpenings() {
            return jobOpeningRepository.findAll();
        }
        

        public Iterable<JobApplication> listApplications(JobOpening jobOpening) {
            return jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);
        }
        public JobOpening getJobOpeningForJobApplication(JobApplication jobApplication) {
            return jobApplication.getJobOpening();
        }




    }