package jobs4u.base.pluginManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.jar.JarFile;

@Embeddable
@EqualsAndHashCode
public class JobRequirementSpecificationIdentifier implements ValueObject, Serializable, Comparable<JobRequirementSpecificationIdentifier> {
    private static final long serialVersionUID = 1L;

    @Column(name = "JobRequirementSpecificationIdentifier")
    private final String value;

    protected JobRequirementSpecificationIdentifier() {
        // for ORM
        value = null;
    }

    protected JobRequirementSpecificationIdentifier(final String identifier) {
        Preconditions.ensure(identifier != null && !identifier.isEmpty(),
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
    public static JobRequirementSpecificationIdentifier valueOf(final String identifier) {
        return new JobRequirementSpecificationIdentifier(identifier);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(final JobRequirementSpecificationIdentifier o) {
        return value.compareTo(o.value);
    }
}
