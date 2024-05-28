/*
package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.Date;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    public void testValueOfReturnsValidDate() {
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        assertNotNull(date);
        assertEquals(localDate, date.getDate());
    }

    @Test
    public void testValueOfThrowsExceptionWhenLocalDateIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Date.valueOf(String.valueOf((LocalDate) null));
        });
    }

    @Test
    public void testParseReturnsValidDate() {
        String dateString = "2022-01-01";
        Date date = Date.parse(dateString);
        assertNotNull(date);
        assertEquals(LocalDate.parse(dateString), date.getDate());
    }

    @Test
    public void testParseThrowsExceptionWhenDateStringIsInvalid() {
        String dateString = "invalid-date";
        assertThrows(IllegalArgumentException.class, () -> {
            Date.parse(dateString);
        });
    }
}*/
