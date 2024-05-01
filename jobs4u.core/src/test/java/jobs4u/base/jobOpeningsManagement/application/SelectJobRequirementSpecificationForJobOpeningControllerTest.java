package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class SelectJobRequirementSpecificationForJobOpeningControllerTest {
    private SelectJobRequirementSpecificationForJobOpeningController theController;

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

    private final JobRequirementSpecificationRepository jobRequirementSpecificationRepository = new JobRequirementSpecificationRepository() {

        private HashSet<JobRequirementSpecification> jobRequirementsSpecification = new HashSet<>();

        @Override
        public <S extends JobRequirementSpecification> S save(S entity) {
            return null;
        }

        @Override
        public Iterable<JobRequirementSpecification> findAll() {
            return jobRequirementsSpecification;
        }

        @Override
        public Optional<JobRequirementSpecification> ofIdentity(JobRequirementSpecificationIdentifier id) {
            return Optional.empty();
        }

        @Override
        public void delete(JobRequirementSpecification entity) {

        }

        @Override
        public void deleteOfIdentity(JobRequirementSpecificationIdentifier entityId) {

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
        JobRequirementSpecificationRepository jobRequirementSpecificationRepo = jobRequirementSpecificationRepository;
        theController = new SelectJobRequirementSpecificationForJobOpeningController(jobRequirementSpecificationRepo, jobOpeningRepo, authz);
    }

   /* @Test
    public void ensureSelectingJobRequirementSpecificationForJobOpeningWorks() {
        JobReference jobReference = new JobReference("String123");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "4123-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(), client);

        JobRequirementSpecificationIdentifier jobRequirementSpecificationIdentifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        JobRequirementSpecification jobRequirementSpecification = new JobRequirementSpecification(jobRequirementSpecificationIdentifier, "com.example.Teste");
        theController.selectJobRequirementSpecificationForJobOpening(jobRequirementSpecification, jobOpening);
        Assertions.assertNotNull(jobOpening);
    }*/
}
