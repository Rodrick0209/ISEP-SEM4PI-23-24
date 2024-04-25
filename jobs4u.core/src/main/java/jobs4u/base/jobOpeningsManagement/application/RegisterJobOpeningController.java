package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningFactory;
import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.*;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class RegisterJobOpeningController {

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final ClientRepository clientRepository = PersistenceContext.repositories().clients();
    private final JobReferenceService jobReferenceService = new JobReferenceService();
    private final JobOpeningFactory jobOpeningFactory = new JobOpeningFactory();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientMapper clientMapper = new ClientMapper();


    public List<ClientDTO> getAllClients() {

        ArrayList<ClientDTO> clients = new ArrayList<>();

        clientRepository.findAll().forEach(client -> {
            clients.add(clientMapper.toDTO(client));
        });

        return clients;

    }


    public JobReference createJobReference(List<ClientDTO> clients, int option) {

        ClientDTO client = clients.get(option - 1);
        String clientCode = client.clientCode;
        return jobReferenceService.createJobReference(ClientCode.valueOf(clientCode));
    }

    public JobOpening registerJobOpening(WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, List<ClientDTO> clients, int option, Calendar creationDate, JobOpeningStatus status) {

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.POWER_USER);


        JobReference jobReference = createJobReference(clients, option);


        final JobOpening jobOpening = jobOpeningFactory.createJobOpening(jobReference, user.get(), workingMode, nrVacancy, address, description, function, contractType, creationDate, status);

        return saveJobOpening(jobOpening);
    }

    private JobOpening saveJobOpening(JobOpening jobOpening) {

        return this.jobOpeningRepository.save(jobOpening);

    }
}