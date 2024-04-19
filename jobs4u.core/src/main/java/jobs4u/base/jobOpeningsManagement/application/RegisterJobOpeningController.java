package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.general.domain.model.Designation;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningFactory;
import jobs4u.base.jobOpeningsManagement.application.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;

public class RegisterJobOpeningController {

    private final JobOpeningRepository jobOpeningRepository;
    private final JobReferenceService jobReferenceService;
    private final ClientCode clientCode;
    private final JobOpeningFactory jobOpeningFactory;

    public RegisterJobOpeningController(final JobOpeningRepository jobOpeningRepository, final JobReferenceService jobReferenceService, final ClientCode clientCode) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobReferenceService = jobReferenceService;
        this.clientCode = clientCode;
        this.jobOpeningFactory = new JobOpeningFactory();
    }

    public JobReference createJobReference(String clientCode) {

        JobReferenceService jobReferenceService = new JobReferenceService();
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