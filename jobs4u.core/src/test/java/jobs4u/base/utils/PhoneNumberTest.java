package jobs4u.base.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneNumberTest {


    @Test
    public void testWithInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> PhoneNumber.valueOf("123456789"));
        assertThrows(IllegalArgumentException.class, () -> PhoneNumber.valueOf("1234567890000"));
        assertThrows(IllegalArgumentException.class, () -> PhoneNumber.valueOf("964124"));
        assertThrows(IllegalArgumentException.class, () -> PhoneNumber.valueOf("9312345678414141"));
    }

    @Test
    public void testWithValidPhoneNumber() {
        assertDoesNotThrow(() -> PhoneNumber.valueOf("912345678"));
        assertDoesNotThrow(() -> PhoneNumber.valueOf("961234567"));
        assertDoesNotThrow(() -> PhoneNumber.valueOf("931234567"));

    }



}
