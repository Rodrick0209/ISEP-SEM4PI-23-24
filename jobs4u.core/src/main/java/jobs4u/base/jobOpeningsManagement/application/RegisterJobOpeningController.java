package jobs4u.base.jobOpeningsManagement.application;


import jobs4u.base.jobOpeningsManagement.application.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;

public class RegisterJobOpeningController {

    private final JobOpeningRepository jobOpeningRepository;
    private final JobReferenceService jobReferenceService;

    public RegisterJobOpeningController(JobOpeningRepository jobOpeningRepository, JobReferenceService jobReferenceService) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobReferenceService = jobReferenceService;
    }

//    public JobOpening registerJobOpening(JobReference jobReference, WorkingMode workingMode, NrVacancy nrVacancy, PostalAddress address, Designation description, Designation function) {
//
//        final JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function);
//
//        return saveJobOpening(jobOpening, jobReference, workingMode, nrVacancy, address, description, function);
//    }
//
//    private saveJobOpening(JobOpening jobOpening, JobReference jobReference, WorkingMode workingMode, NrVacancy nrVacancy, PostalAddress address, Designation description, Designation function){
//
//        jobOpening = this.jobOpeningRepository.save(jobOpening);
//
//    }


}
