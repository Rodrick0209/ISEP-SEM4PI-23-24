package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
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

    private final JobOpeningRepository jobOpeningRepository;
    private final ClientRepository clientRepository;
    private final JobReferenceService jobReferenceService = new JobReferenceService();
    private final AuthorizationService authz;
    private final ClientMapper clientMapper = new ClientMapper();
    private final JobOpeningFactory jobOpeningFactory = new JobOpeningFactory();


    public RegisterJobOpeningController(JobOpeningRepository jobOpeningRepository, ClientRepository clientRepository, AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.clientRepository = clientRepository;
        this.authz = authz;
    }

    public List<ClientDTO> getAllClients() {

        ArrayList<ClientDTO> clients = new ArrayList<>();

        clientRepository.findAll().forEach(client -> {
            clients.add(clientMapper.toDTO(client));
        });

        return clients;

    }


    public JobReference createJobReference(ClientDTO client) {
        String clientCode = client.clientCode;
        return jobReferenceService.createJobReference(ClientCode.valueOf(clientCode));
    }

    public JobOpening registerJobOpening(WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType,ClientDTO client, JobOpeningStatus status) {

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.POWER_USER);

        JobReference jobReference = createJobReference(client);

        final JobOpening jobOpening = jobOpeningFactory.createJobOpening(jobReference, user.get(), workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(), status);

        return saveJobOpening(jobOpening);

    }

    private JobOpening saveJobOpening(JobOpening jobOpening) {
        return this.jobOpeningRepository.save(jobOpening);

    }
}