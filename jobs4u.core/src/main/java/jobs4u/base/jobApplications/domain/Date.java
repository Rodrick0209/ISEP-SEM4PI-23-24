package jobs4u.base.jobApplications.domain;

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

