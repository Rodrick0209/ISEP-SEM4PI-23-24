package jobs4u.base.usermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Jobs4uPasswordGeneratorTest {

    @Test
    void EnsurePasswordIsGenerated() {
        Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        assertNotNull(password);
    }

    @Test
    void EnsurePasswordLengthIsCorrect() {
        Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        assertEquals(8, password.length());
    }

    @Test
    void EnsurePasswordContainsAtLeastOneCapitalLetter() {
        Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        assertTrue(password.matches(".*[A-Z].*"));
    }

    @Test
    void EnsurePasswordContainsAtLeastOneDigit() {
        Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        assertTrue(password.matches(".*[0-9].*"));
    }

    @Test
    void EnsurePasswordMeetsPolicy() {
        Jobs4uPasswordGenerator passwordGenerator = new Jobs4uPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        assertTrue(new Jobs4uPasswordPolicy().isSatisfiedBy(password));
    }
}