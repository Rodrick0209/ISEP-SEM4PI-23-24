package jobs4u.base.usermanagement.application;

import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DisableUserControllerTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {

        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }



    @Test
    void EnsureUserIsEnable() {
        SystemUser user = dummyUser("dummy", Jobs4uRoles.CANDIDATE);
        user.deactivate(Calendar.getInstance());
        assertFalse(user.isActive());
    }

}