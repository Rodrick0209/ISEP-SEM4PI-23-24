package jobs4u.base.interviewModel.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class InterviewModelSpecificationIdentifier implements ValueObject, Serializable, Comparable<InterviewModelSpecificationIdentifier> {

    private static final long serialVersionUID = 1L;

    @Column(name = "InterviewModelSpecificationIdentifier")
    private final String value;

    protected InterviewModelSpecificationIdentifier() {
        // for ORM
        value = null;
    }

    protected InterviewModelSpecificationIdentifier(final String identifier) {
        Preconditions.ensure(StringPredicates.isSingleWord(identifier),
                "username should neither be null nor empty");
        value = identifier;
    }

    /**
     * Factory method.
     *
     * @param identifier
     *
     * @return a new Username object
     */
    public static InterviewModelSpecificationIdentifier valueOf(final String identifier) {
        return new InterviewModelSpecificationIdentifier(identifier);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(final InterviewModelSpecificationIdentifier o) {
        return value.compareTo(o.value);
    }
}
