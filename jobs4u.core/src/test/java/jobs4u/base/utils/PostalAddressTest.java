package jobs4u.base.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostalAddressTest {


    @Test
    public void testWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> PostalAddress.valueOf("1234-12"));
        assertThrows(IllegalArgumentException.class, () -> PostalAddress.valueOf("aaaa-1234"));
        assertThrows(IllegalArgumentException.class, () -> PostalAddress.valueOf("aaaa-234"));

    }

    @Test
    public void testWithValidAddress() {
        assertDoesNotThrow(() -> PostalAddress.valueOf("1234-123"));
        assertDoesNotThrow(() -> PostalAddress.valueOf("4890-123"));
    }




}
