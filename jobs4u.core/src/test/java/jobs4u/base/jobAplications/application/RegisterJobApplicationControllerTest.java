package jobs4u.base.jobAplications.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobAplications.domain.JobApplication;
import jobs4u.base.jobAplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

class RegisterJobApplicationControllerTest {

    private RegisterJobApplicationController controller;

    private final JobApplicationRepository jobApplicationRepository = new JobApplicationRepository() {

        @Override
        public <S extends JobApplication> S save(S entity) {
            return null;
        }

        @Override
        public Iterable<JobApplication> findAll() {
            return null;
        }

        @Override
        public Optional<JobApplication> ofIdentity(Long id) {
            return Optional.empty();
        }

        @Override
        public void delete(JobApplication entity) {

        }

        @Override
        public void deleteOfIdentity(Long entityId) {

        }

        @Override
        public long count() {
            return 0;
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
            for (JobOpening jobOpening : jobOpenings) {
                if (jobOpening.jobReference().equals(id)) {
                    return Optional.of(jobOpening);
                }
            }
            return null;
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
    };

    private final CandidateRepository candidateRepository = new CandidateRepository() {

        @Override
        public <S extends Candidate> S save(S entity) {
            return null;
        }

        @Override
        public Iterable<Candidate> findAll() {
            return null;
        }

        @Override
        public Optional<Candidate> ofIdentity(EmailAddress id) {
            return Optional.empty();
        }

        @Override
        public void delete(Candidate entity) {

        }

        @Override
        public void deleteOfIdentity(EmailAddress entityId) {

        }

        @Override
        public long count() {
            return 0;
        }
    };

    private final AuthorizationService authorizedAuthz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }
        @Override
        public Optional<SystemUser> loggedinUserWithPermissions(Role... roles) {
            return Optional.of(dummyUser("test", roles));
        }
    };



    public static JobOpening jobOpening() {
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("IBM-000123","ISEP", "4123-123");

        JobReference jobReference = new JobReference(client.code().toString());

        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance());
    }


    public static SystemUser dummyUser(final String username, final Role... roles) {
        final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }


    @BeforeEach
    void setUp() {
        jobOpeningRepository.save(jobOpening());
        controller = new RegisterJobApplicationController(jobApplicationRepository, candidateRepository, authorizedAuthz);

    }


}