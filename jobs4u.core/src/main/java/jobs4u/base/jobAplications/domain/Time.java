package jobs4u.base.jobAplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.time.LocalTime;

@Embeddable
public class Time implements ValueObject, Comparable<Time>{
    private static final long serialVersionUID = 1L;

    private LocalTime time;

    public Time(LocalTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Time should not be null");
        }
        // Additional validation logic can be added here if necessary
        this.time = time;
    }

    protected Time() {
        // for ORM
    }

    public static Time valueOf(LocalTime time) {
        return new Time(time);
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;

        Time that = (Time) o;

        return time.equals(that.time);
    }

    @Override
    public int hashCode() {
        return time.hashCode();
    }

    @Override
    public String toString() {
        return time.toString();
    }

    @Override
    public int compareTo(Time o) {
        return 0;
    }
}
