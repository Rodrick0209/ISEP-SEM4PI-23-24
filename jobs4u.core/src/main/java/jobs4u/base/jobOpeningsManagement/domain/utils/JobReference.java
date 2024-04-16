package jobs4u.base.jobOpeningsManagement.domain.utils;

import eapli.framework.domain.model.ValueObject;
import jobs4u.base.utils.ClientCode;

import java.io.Serializable;

public class JobReference implements ValueObject, Serializable, Comparable<JobReference> {

    private static final long serialVersionUID = 1L;

    private final ClientCode clientCode;
    private final int referenceNumber;

    public JobReference(ClientCode clientCode, int referenceNumber) {
        this.clientCode = clientCode;
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        return this.clientCode.code() + "-" + String.format("%06d", this.referenceNumber);
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
