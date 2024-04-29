package jobs4u.base.clientManagement;


import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.clientManagement.domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void ensureClientWithCodeNameAndAddress() {
        new Client("isep", "name", "4890-238", EmailAddress.valueOf("customermanager@gmail.com"));
        assertTrue(true);
    }

    @Test
    void ensureMustHaveCode() {
        assertThrows(IllegalArgumentException.class, () -> new Client(null, "name", "address",EmailAddress.valueOf("customermanager@gmail.com")));
    }

    @Test
    void ensureMustHaveName() {
        assertThrows(IllegalArgumentException.class, () -> new Client("code", null, "address",EmailAddress.valueOf("customermanager@gmail.com")));
    }

    @Test
    void ensureMustHaveAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Client("code", "name", null,EmailAddress.valueOf("customermanager@gmail.com")));
    }

    @Test
    void ensureClientIsTheSameAsItsInstance() {
        final Client aClient = new Client("isep", "name", "4890-238",EmailAddress.valueOf("customermanager@gmail.com"));


        final boolean expected = aClient.sameAs(aClient);

        assertTrue(expected);
    }

    @Test
    void ensureTwoClientsWithDifferentCodesAreNotTheSame() {
        final Client aClient = new Client("isep", "name", "4890-238",EmailAddress.valueOf("customermanager@gmail.com"));


        final Client anotherClient = new Client("isep2", "name", "4890-238",EmailAddress.valueOf("customermanager@gmail.com"));


        final boolean expected = aClient.sameAs(anotherClient);

        assertFalse(expected);
    }
}
