package jobs4u.base.jobOpeningsManagement.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

public class NrVacancy implements ValueObject {
    private static final long serialVersionUID = 1L;
    private final Long nrVacancy;

    protected NrVacancy(final Long nrVacancy) {
        Preconditions.isPositive((nrVacancy), "Number of vacancies should be a positive integer");
        this.nrVacancy = Long.valueOf(nrVacancy);
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

    public static NrVacancy valueOf(final Long nrVacancy) {
        return new NrVacancy(nrVacancy);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(Math.toIntExact(this.nrVacancy));
    }
}
