package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

public enum JobApplicationState implements ValueObject {
    RECEIVED,
    ACCEPTED,
    REJECTED,
    CHOSEN,
}
