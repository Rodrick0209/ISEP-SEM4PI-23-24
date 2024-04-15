package jobs4u.base.clientManagement;


import jobs4u.base.clientManagement.domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void ensureClientWithCodeNameAndAddress() {
        new Client("isep", "name", "4890-238");
        assertTrue(true);
    }

    @Test
    void ensureMustHaveCode() {
        assertThrows(IllegalArgumentException.class, () -> new Client(null, "name", "address"));
    }

    @Test
    void ensureMustHaveName() {
        assertThrows(IllegalArgumentException.class, () -> new Client("code", null, "address"));
    }

    @Test
    void ensureMustHaveAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Client("code", "name", null));
    }

    @Test
    void ensureClientIsTheSameAsItsInstance() {
        final Client aClient = new Client("isep", "name", "4890-238");


        final boolean expected = aClient.sameAs(aClient);

        assertTrue(expected);
    }

    @Test
    void ensureTwoClientsWithDifferentCodesAreNotTheSame() {
        final Client aClient = new Client("isep", "name", "4890-238");


        final Client anotherClient = new Client("isep2", "name", "4890-238");


        final boolean expected = aClient.sameAs(anotherClient);

        assertFalse(expected);
    }
}
