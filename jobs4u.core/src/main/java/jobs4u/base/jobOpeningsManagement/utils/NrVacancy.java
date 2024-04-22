package jobs4u.base.jobOpeningsManagement.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

public class NrVacancy implements ValueObject {
    private static final long serialVersionUID = 1L;
    private final String nrVacancy;

    protected NrVacancy(final String nrVacancy) {
        Preconditions.isPositive(Long.parseLong(nrVacancy), "Number of vacancies should be a positive integer");
        this.nrVacancy = nrVacancy;
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
        return Integer.hashCode(Integer.parseInt(this.nrVacancy));
    }
}
