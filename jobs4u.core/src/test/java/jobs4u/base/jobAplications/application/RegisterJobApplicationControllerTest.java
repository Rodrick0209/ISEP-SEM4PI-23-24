package jobs4u.base.jobAplications.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.application.RegisterJobApplicationController;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

class RegisterJobApplicationControllerTest {

    private RegisterJobApplicationController controller;

    private AuthorizationService authorizedAuthz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }
        @Override
        public Optional<SystemUser> loggedinUserWithPermissions(Role... roles) {
            return Optional.of(dummyUser("test", roles));
        }
    };

    private JobApplicationRepository  jobApplicationRepository = new JobApplicationRepository() {
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

    private CandidateRepository CandidateRepository = new CandidateRepository() {
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

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }



    @BeforeEach
    void setUp() {
        JobApplicationRepository applicationRepository = jobApplicationRepository;
        CandidateRepository candidateRepository = this.CandidateRepository;
        //controller = new RegisterJobApplicationController(applicationRepository, candidateRepository, authorizedAuthz);
    }



}