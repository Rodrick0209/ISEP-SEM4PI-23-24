package jobs4u.base.jobOpeningsManagement.utils;

import eapli.framework.domain.model.ValueObject;

public class NrVacancy implements ValueObject {
    private final int nrVacancy;

    public NrVacancy(int nrVacancy) {
        this.nrVacancy = nrVacancy;
    }

    public int nrVacancy() {
        return this.nrVacancy;
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

    @Override
    public int hashCode() {
        return Integer.hashCode(this.nrVacancy);
    }
}
