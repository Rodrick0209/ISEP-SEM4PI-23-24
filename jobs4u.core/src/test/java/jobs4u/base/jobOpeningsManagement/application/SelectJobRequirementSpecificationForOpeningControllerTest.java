package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class SelectJobRequirementSpecificationForOpeningControllerTest {
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

        @Override
        public JobOpening findByJobApplication(JobApplication jobApplication) {
            return null;
        }

        @Override
        public List<JobOpening> findByCustomerManagerAndInAnalysisPhase(SystemUser customermanager) {
            return List.of();
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

        private HashSet<RequirementSpecification> jobRequirementsSpecification = new HashSet<>();

        @Override
        public <S extends RequirementSpecification> S save(S entity) {
            return null;
        }

        @Override
        public Iterable<RequirementSpecification> findAll() {
            return jobRequirementsSpecification;
        }

        @Override
        public Optional<RequirementSpecification> ofIdentity(JobRequirementSpecificationIdentifier id) {
            return Optional.empty();
        }

        @Override
        public void delete(RequirementSpecification entity) {

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
