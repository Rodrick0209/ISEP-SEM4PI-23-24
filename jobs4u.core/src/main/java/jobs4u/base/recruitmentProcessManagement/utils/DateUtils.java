package jobs4u.base.recruitmentProcessManagement.utils;

import eapli.framework.validations.Preconditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {


        public static LocalDate parseDate(String dateString) {
            Preconditions.nonNull(dateString);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format. Please use dd-MM-yyyy");
            }
        }
}
