package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.interviewModel.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SelectInterviewModelForJobOpeningControllerTest {
    private SelectInterviewModelSpecificationForJobOpeningController theController;
    private JobReferenceService jobReferenceService;
    private ClientMapper clientMapper;

    private final AuthorizationService authz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }

        @Override
        public Optional<SystemUser> loggedinUserWithPermissions(Role... roles) {
            return Optional.of(dummyUser("test", roles));
        }
    };

    private final JobOpeningRepository jobOpeningRepository = new JobOpeningRepository() {
        @Override
        public List<JobOpening> findByCustomerManager(SystemUser customer) {
            return null;
        }

        @Override
        public int countForClientCode(ClientCode clientCode) {
            return 0;
        }

        private HashSet<JobOpening> jobOpenings = new HashSet<>();

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
            return 0;
        }
    };

    private final InterviewModelSpecificationRepository interviewModelSpecificationRepository = new InterviewModelSpecificationRepository() {

        private HashSet<InterviewModelSpecification> interviewModelsSpecification = new HashSet<>();

        @Override
        public <S extends InterviewModelSpecification> S save(S entity) {
            return null;
        }

        @Override
        public Iterable<InterviewModelSpecification> findAll() {
            return interviewModelsSpecification;
        }

        @Override
        public Optional<InterviewModelSpecification> ofIdentity(InterviewModelSpecificationIdentifier id) {
            return Optional.empty();
        }

        @Override
        public void delete(InterviewModelSpecification entity) {

        }

        @Override
        public void deleteOfIdentity(InterviewModelSpecificationIdentifier entityId) {

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
        JobOpeningRepository jobOpeningRepo = jobOpeningRepository;
        InterviewModelSpecificationRepository interviewModelSpecificationRepo = interviewModelSpecificationRepository;
        jobReferenceService = new JobReferenceService(jobOpeningRepo);
        clientMapper = new ClientMapper();
        theController = new SelectInterviewModelSpecificationForJobOpeningController(jobOpeningRepo, interviewModelSpecificationRepo, authz);
    }

    public JobReference createJobReference(ClientDTO client) {
        String clientCode = client.clientCode;
        return jobReferenceService.createJobReference(ClientCode.valueOf(clientCode));
    }

    /*
    @Test
    public void ensureSelectingJobRequirementSpecificationForJobOpeningWorks() {
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        JobReference jobReference = createJobReference(clientMapper.toDTO(client));
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(), client);

        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification();
        theController.selectInterviewModelSpecificationForJobOpening(interviewModelSpecification, jobOpening);
        assertNotNull(jobOpening);
    }
     */

}
