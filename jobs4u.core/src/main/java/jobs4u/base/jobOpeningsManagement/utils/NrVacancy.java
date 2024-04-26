package jobs4u.base.jobOpeningsManagement.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class NrVacancy implements ValueObject, Serializable, StringMixin {

    private final String nrVacancy;

    protected NrVacancy(final String nrVacancy) {
        Preconditions.isPositive(Long.parseLong((nrVacancy)), "Number of vacancies should be a positive integer");
        this.nrVacancy = nrVacancy;
    }

    public NrVacancy() {
        this.nrVacancy = null;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof NrVacancy)) {
            return false;
        } else {
            NrVacancy other = (NrVacancy) o;
            return this.nrVacancy == other.nrVacancy;
        }
    }

    public static NrVacancy valueOf(final String nrVacancy) {
        return new NrVacancy(nrVacancy);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(Math.toIntExact(Long.parseLong(this.nrVacancy)));
    }

    @Override
    public String toString() {
        return String.valueOf(this.nrVacancy);
    }


}
