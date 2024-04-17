package jobs4u.base.recruitmentProcessManagement.util;

import jobs4u.base.recruitmentProcessManagement.utils.DateUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateUtilsTest {


    @Test
    public void testParseValidDate() {
        String dateString = "18-03-2025";
        assertDoesNotThrow(() -> DateUtils.parseDate(dateString));

    }

    @Test
    public void testParseInvalidDate() {
        String dateString = "2025-03-18"; // Formato errado
        assertThrows(IllegalArgumentException.class, () -> DateUtils.parseDate(dateString));
    }

    @Test
    public void testParseNullDate() {
        String dateString = null;
        assertThrows(IllegalArgumentException.class, () -> DateUtils.parseDate(dateString));
    }


}
