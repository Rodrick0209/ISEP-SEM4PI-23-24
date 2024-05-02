package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.*;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.usermanagement.application.DisableUserController;
import jobs4u.base.usermanagement.application.EnableUserController;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterJobOpeningControllerTest {

    private RegisterJobOpeningController controller;

    private final AuthorizationService authorizedAuthz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }
        @Override
        public Optional<SystemUser> loggedinUserWithPermissions(Role... roles) {
            return Optional.of(dummyUser("test", roles));
        }
    };

    private final JobOpeningRepository jobOpeningRepository = new JobOpeningRepository() {
        private List<JobOpening> jobOpenings = new ArrayList<>();

        @Override
        public <S extends JobOpening> S save(S entity) {
            jobOpenings.add(entity);
            return entity;
        }

        @Override
        public Iterable<JobOpening> findAll() {
            return jobOpenings;
        }

        @Override
        public Optional<JobOpening> ofIdentity(JobReference id) {
            return Optional.empty();
        }

        @Override
        public void delete(JobOpening entity) {

        }

        @Override
        public void deleteOfIdentity(JobReference entityId) {

        }

        @Override
        public long count() {
            return jobOpenings.size();
        }

        @Override
        public List<JobOpening> findByCustomerManager(SystemUser customer) {
            return List.of();
        }

        @Override
        public int countForClientCode(ClientCode clientCode) {
            return 0;
        }

        @Override
        public JobOpening findByJobApplication(JobApplication jobApplication) {
            return null;
        }
    };

    private final ClientRepository clientRepository = new ClientRepository() {
        @Override
        public <S extends Client> S save(S entity) {
            return null;
        }

        @Override
        public Iterable<Client> findAll() {
            return null;
        }

        @Override
        public Optional<Client> ofIdentity(ClientCode id) {
            return Optional.empty();
        }

        @Override
        public void delete(Client entity) {

        }

        @Override
        public void deleteOfIdentity(ClientCode entityId) {

        }

        @Override
        public long count() {
            return 0;
        }
    };

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    @BeforeEach
    void setUp() {
        ClientRepository cRepo = clientRepository; // initialize with your UserRepository
        JobOpeningRepository jRepo = jobOpeningRepository; // initialize with your UserRepository
        controller = new RegisterJobOpeningController(jRepo, cRepo, authorizedAuthz);

    }


    @Test
    public void ensureRegisterJobOpeningWorks() {

        ClientMapper clientMapper = new ClientMapper();
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));


        JobOpening jobOpening = controller.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType,clientMapper.toDTO(client));
        assertNotNull(jobOpening);
        assertEquals(1, jobOpeningRepository.size());
    }


    @Test
    public void ensureRegisterJobOpeningFailsForInvalidInput() {

        ClientMapper clientMapper = new ClientMapper();
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123",EmailAddress.valueOf("customermanager@gmail.com"));

        // Attempt to register a job opening with invalid input
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType,clientMapper.toDTO(client));
        });

        // Verify that the exception was thrown
        assertNotNull(exception);

        // Verify that the job opening was not added to the repository
        assertEquals(0, jobOpeningRepository.size());
    }
}