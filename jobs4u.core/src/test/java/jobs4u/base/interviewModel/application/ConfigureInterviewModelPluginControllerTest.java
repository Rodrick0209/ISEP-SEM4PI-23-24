package jobs4u.base.interviewModel.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.interviewModel.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecificationIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigureInterviewModelPluginControllerTest {

    private ConfigureInterviewModelPluginController theController;
    private InterviewModelSpecificationRepository repository = new InterviewModelSpecificationRepository() {
        private List<InterviewModelSpecification> interviewModelsSpecification = new ArrayList<>();
        @Override
        public <S extends InterviewModelSpecification> S save(S entity) {
            interviewModelsSpecification.add(entity);
            return entity;
        }

        @Override
        public Iterable<InterviewModelSpecification> findAll() {
            return null;
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

    private final AuthorizationService authz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }

        @Override
        public Optional<SystemUser> loggedinUserWithPermissions(Role... roles) {
            return Optional.of(dummyUser("test", roles));
        }
    };

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    @BeforeEach
    void setUp(){
        InterviewModelSpecificationRepository repo = repository;
        AuthorizationService authzz = authz;
        theController = new ConfigureInterviewModelPluginController(repo, authzz);
    }

    @Test
    public void ensureInterviewModelPluginIsSuccessfullyConfigured(){
        InterviewModelSpecification interviewModelSpecification = theController.configurePlugin("teste", "com.example.Teste");
        assertNotNull(interviewModelSpecification);
    }
}
