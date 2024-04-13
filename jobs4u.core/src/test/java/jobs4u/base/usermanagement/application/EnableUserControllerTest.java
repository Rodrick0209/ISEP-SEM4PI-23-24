package jobs4u.base.usermanagement.application;

import java.util.*;
import java.util.stream.Collectors;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthorizedException;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class EnableUserControllerTest {

    private EnableUserController controller;
    private DisableUserController Dcontroller;

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    // mock objects
    private final AuthorizationService unauthorizedAuthz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
            throw new UnauthorizedException(dummyUser("X"), actions);
        }
    };
    private final AuthorizationService authorizedAuthz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }
    };

    private final UserRepository repoSave = new UserRepository() {

        private List<SystemUser> users = new ArrayList<>();

        @Override
        public <S extends SystemUser> S save(final S entity) {
            users.add(entity);
            return entity;
        }

        @Override
        public Iterable<SystemUser> findAll() {
            return users;
        }

        @Override
        public Optional<SystemUser> ofIdentity(Username id) {
            return users.stream().filter(user -> user.identity().equals(id)).findFirst();
        }

        @Override
        public boolean contains(SystemUser entity) {
            return users.contains(entity);
        }

        @Override
        public void delete(SystemUser entity) {

        }

        @Override
        public void deleteOfIdentity(Username entityId) {

        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public Iterable<SystemUser> findByActive(boolean active) {
            return users.stream().filter(user -> user.isActive() == active).collect(Collectors.toList());
        }

        // ... other methods ...
    };

    @BeforeEach
    void setUp() {
        UserRepository userRepo = repoSave; // initialize with your UserRepository
        PasswordPolicy policy = new NilPasswordPolicy(); // initialize with your PasswordPolicy
        PasswordEncoder encoder = new PlainTextEncoder(); // initialize with your PasswordEncoder

        AuthzRegistry.configure(userRepo, policy, encoder);

        // Now you can create the EnableUserController
        controller = new EnableUserController(authorizedAuthz,AuthzRegistry.userService());
        Dcontroller = new DisableUserController(authorizedAuthz,AuthzRegistry.userService());
    }


    @Test
    void EnsureDisableUsersWork() {

        SystemUser user1 = dummyUser("testUser1");
        SystemUser user2 = dummyUser("testUser2");
        SystemUser user3 = dummyUser("testUser3");
        Dcontroller.deactivateUser(user1);
        Dcontroller.deactivateUser(user3);
        controller.enableUser(user2);

        Iterable<SystemUser> disableUsers = controller.disableUsers();
        Iterable<SystemUser> expectedDisable = Arrays.asList(user1, user3);

        Iterable<SystemUser> activeUsers = Dcontroller.activeUsers();
        Iterable<SystemUser> expectedactive = Arrays.asList(user2);

        assertEquals(expectedactive, activeUsers);
        assertEquals(expectedDisable, disableUsers);
    }

    @Test
    void EnsureUserEnableWorks() {
        SystemUser user = dummyUser("testUser");
        controller.enableUser(user);
        assertTrue(user.isActive());
    }

    @Test
    void EnsureStateIsEnableWhenUserIsCreated() {
        SystemUser user = dummyUser("testUser");
        assertTrue(user.isActive());
    }
}