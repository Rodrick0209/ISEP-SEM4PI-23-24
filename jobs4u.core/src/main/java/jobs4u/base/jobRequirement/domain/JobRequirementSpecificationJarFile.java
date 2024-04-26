package jobs4u.base.jobRequirement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class JobRequirementSpecificationJarFile implements ValueObject, Serializable, Comparable<JobRequirementSpecificationJarFile> {
    private static final long serialVersionUID = 1L;

    @Column(name = "JobRequirementSpecificationJarFile")
    private final String value;

    protected JobRequirementSpecificationJarFile() {
        // for ORM
        value = null;
    }

    protected JobRequirementSpecificationJarFile(final String value){
        Preconditions.ensure(value != null, "jar file should not be null");
        Preconditions.ensure(isAFile(value), "jar file should exist in the system");
        this.value = value;
    }

    private boolean isAFile(String value){
        try {
            File file = new File(value);
            return file.exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static JobRequirementSpecificationJarFile valueOf(final String jarFile) {
        return new JobRequirementSpecificationJarFile(jarFile);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(final JobRequirementSpecificationJarFile o) {
        return value.compareTo(o.value);
    }
}
