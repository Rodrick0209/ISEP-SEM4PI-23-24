package jobs4u.base.jobOpeningsManagement.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NrVacancyTest {

    @Test
    public void testValidNrVacancy() {
        assertDoesNotThrow(() -> NrVacancy.valueOf(5L));
    }

    @Test
    public void testInvalidNrVacancy() {
        assertThrows(IllegalArgumentException.class, () -> NrVacancy.valueOf(-7L));
    }

}