package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningFactory;
import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;

@UseCaseController
public class RegisterJobOpeningController {

    private JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private  JobReferenceService jobReferenceService = new JobReferenceService();
    private  JobOpeningFactory jobOpeningFactory = new JobOpeningFactory();


    public JobReference createJobReference(String clientCode) {

        return jobReferenceService.createJobReference(ClientCode.valueOf(clientCode));
    }

    public JobOpening registerJobOpening(WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, String clientCode) {

        JobReference jobReference = createJobReference(clientCode);
        final JobOpening jobOpening = jobOpeningFactory.createJobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType);

        return saveJobOpening(jobOpening);
    }

    private JobOpening saveJobOpening(JobOpening jobOpening) {

        return this.jobOpeningRepository.save(jobOpening);

    }
}