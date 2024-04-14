package jobs4u.base.usermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Jobs4uPasswordGeneratorTest {

    Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();

    @Test
    void EnsurePasswordIsGenerated() {
        String password = passwordGenerator.generatePassword();
        assertNotNull(password);
    }

    @Test
    void EnsurePasswordLengthIsCorrect() {
        String password = passwordGenerator.generatePassword();
        assertEquals(8, password.length());
    }

    @Test
    void EnsurePasswordContainsAtLeastOneCapitalLetter() {
        String password = passwordGenerator.generatePassword();
        assertTrue(password.matches(".*[A-Z].*"));
    }

    @Test
    void EnsurePasswordContainsAtLeastOneDigit() {
        String password = passwordGenerator.generatePassword();
        assertTrue(password.matches(".*[0-9].*"));
    }

    @Test
    void EnsurePasswordMeetsPolicy() {
        String password = passwordGenerator.generatePassword();
        assertTrue(new Jobs4uPasswordPolicy().isSatisfiedBy(password));
    }
}