package jobs4u.base.jobRequirement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.pluginManagement.application.ConfigureJobRequirementPluginController;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigureJobRequirementPluginControllerTest {
    private ConfigureJobRequirementPluginController theController;
    private JobRequirementSpecificationRepository repository = new JobRequirementSpecificationRepository() {
        private List<JobRequirementSpecification> jobRequirementsSpecification = new ArrayList<>();
        @Override
        public <S extends JobRequirementSpecification> S save(S entity) {
            jobRequirementsSpecification.add(entity);
            return entity;
        }

        @Override
        public Iterable<JobRequirementSpecification> findAll() {
            return null;
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
        JobRequirementSpecificationRepository repo = repository;
        AuthorizationService authzz = authz;
        theController = new ConfigureJobRequirementPluginController(repo, authzz);
    }

    @Test
    public void ensureJobRequirementPluginIsSuccessfullyConfigured(){
        JobRequirementSpecification specification = theController.configurePlugin("teste", "com.example.Teste");
        assertNotNull(specification);
    }
}
