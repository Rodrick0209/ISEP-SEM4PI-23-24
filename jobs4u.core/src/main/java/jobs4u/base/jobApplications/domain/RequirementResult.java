package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public enum RequirementResult implements ValueObject {

    REJECTED,
    ACCEPTED,

}
