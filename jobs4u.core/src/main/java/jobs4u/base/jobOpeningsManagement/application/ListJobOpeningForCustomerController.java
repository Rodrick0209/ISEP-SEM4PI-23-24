package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.utils.ClientCode;


@UseCaseController
public class ListJobOpeningForCustomerController {

    private JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();


    public Iterable<JobOpening> getJobOpeningsForCustomer(ClientCode client) {
        return jobOpeningRepository.findByCustomer(client);
    }

}
