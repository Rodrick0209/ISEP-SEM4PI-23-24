package jobs4u.base.jobOpeningsManagement.domain.utils;

import eapli.framework.domain.model.ValueObject;
import jobs4u.base.utils.ClientCode;

import java.io.Serializable;

public class JobReference implements ValueObject, Serializable, Comparable<JobReference> {

    private static final long serialVersionUID = 1L;

    private static int counter = 0;

    private final ClientCode clientCode;
    private final int referenceNumber;

    public JobReference(ClientCode clientCode) {
        this.clientCode = clientCode;
        this.referenceNumber = ++counter;
    }


    public String reference() {
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
            return this.reference().equals(other.reference());
        }
    }

    @Override
    public int hashCode() {
        return this.reference().hashCode();
    }

    @Override
    public int compareTo(JobReference other) {
        return this.reference().compareTo(other.reference());
    }
}
