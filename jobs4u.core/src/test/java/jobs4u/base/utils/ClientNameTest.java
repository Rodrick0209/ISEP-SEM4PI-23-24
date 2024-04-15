package jobs4u.base.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientNameTest {

    @Test
    void ensureClientNameIsCreated() {
        assertDoesNotThrow(() -> ClientName.valueOf("name"));
    }

    @Test
    void ensureClientNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> ClientName.valueOf(null));
    }

    @Test
    void ensureClientNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> ClientName.valueOf(""));
    }

    @Test
    void ensureClientNameIsEqualToItself() {
        ClientName clientName = ClientName.valueOf("name");
        assertTrue(clientName.equals(clientName));
    }

    @Test
    void ensureClientNameIsNotEqualToDifferentClientName() {
        ClientName clientName1 = ClientName.valueOf("name1");
        ClientName clientName2 = ClientName.valueOf("name2");
        assertFalse(clientName1.equals(clientName2));
    }

    @Test
    void ensureClientNameIsNotEqualToNull() {
        ClientName clientName = ClientName.valueOf("name");
        assertFalse(clientName.equals(null));
    }

    @Test
    void ensureClientNameIsNotEqualToDifferentType() {
        ClientName clientName = ClientName.valueOf("name");
        assertFalse(clientName.equals("name"));
    }
}