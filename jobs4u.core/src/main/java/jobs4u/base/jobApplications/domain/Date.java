package jobs4u.base.jobApplications.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;


import java.time.ZoneId;
import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class Date implements ValueObject, Comparable<java.util.Date>{

    private static final long serialVersionUID = 1L;

    private LocalDate date;

    public Date(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date should not be null");
        }
        // Additional validation logic can be added here if necessary
        this.date = date;
    }

    protected Date() {
        // for ORM
    }

    public static Date valueOf(LocalDate date) {
        return new Date(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public static Date valueOf(java.util.Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return new Date(localDate);
    }

    public static Date parse(String dateString) {
        try {
            java.util.Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            LocalDate localDate = parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return new Date(localDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format.", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date that = (Date) o;

        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    @Override
    public String toString() {
        return date.toString();
    }

    @Override
    public int compareTo(java.util.Date o) {
        return 0;
    }


}

