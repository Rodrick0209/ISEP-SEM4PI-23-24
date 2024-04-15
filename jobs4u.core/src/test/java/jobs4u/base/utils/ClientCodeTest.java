package jobs4u.base.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientCodeTest {

    @Test
    void ensureClientCodeIsCreated() {
        assertDoesNotThrow(() -> ClientCode.valueOf("isep"));

    }

    @Test
    void ensureClientCodeCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> ClientCode.valueOf(null));
    }

    @Test
    void ensureClientCodeCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> ClientCode.valueOf(""));
    }

    @Test
    void ensureClientCodeCannotExceedMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> ClientCode.valueOf("code12345678901"));
    }

    @Test
    void ensureClientCodeIsEqualToItself() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        assertTrue(clientCode.equals(clientCode));
    }

    @Test
    void ensureClientCodeIsNotEqualToDifferentClientCode() {
        ClientCode clientCode1 = ClientCode.valueOf("isep");
        ClientCode clientCode2 = ClientCode.valueOf("isep2");
        assertFalse(clientCode1.equals(clientCode2));
    }

    @Test
    void ensureClientCodeIsNotEqualToNull() {
        ClientCode clientCode = ClientCode.valueOf("code4567");
        assertFalse(clientCode.equals(null));
    }

    @Test
    void ensureClientCodeIsNotEqualToDifferentType() {
        ClientCode clientCode = ClientCode.valueOf("code567");
        assertFalse(clientCode.equals("code567"));
    }

    @Test
    void ensureClientCodeCompareToWorksCorrectly() {
        ClientCode clientCode1 = ClientCode.valueOf("code1567");
        ClientCode clientCode2 = ClientCode.valueOf("code7321");
        assertTrue(clientCode1.compareTo(clientCode2) < 0);
    }
}
