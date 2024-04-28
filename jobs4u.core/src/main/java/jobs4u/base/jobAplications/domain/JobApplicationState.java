package jobs4u.base.jobAplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

public enum JobApplicationState implements ValueObject {
    ACCEPTED,
    REJECTED,
}
