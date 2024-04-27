package jobs4u.base.jobOpeningsManagement.utils;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import jobs4u.base.utils.ClientCode;

import java.io.Serializable;

@Embeddable
public class JobReference implements ValueObject, Serializable, Comparable<JobReference> {

    private static final long serialVersionUID = 1L;

    private final String jobReference;

    public JobReference(String jobReference) {
        this.jobReference = jobReference;
    }

    protected JobReference() {
        this.jobReference = null;
    }

    public JobReference valueOf(String jobReference) {
        return new JobReference(jobReference);
    }

    @Override
    public String toString() {
        return this.jobReference;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof JobReference)) {
            return false;
        } else {
            JobReference other = (JobReference) o;
            return this.toString().equals(other.toString());
        }
    }


    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public int compareTo(JobReference other) {
        return this.toString().compareTo(other.toString());
    }
}
