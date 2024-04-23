package jobs4u.base.jobRequirement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class JobRequirementSpecificationJarFile implements ValueObject, Serializable, Comparable<JobRequirementSpecificationJarFile> {
    private static final long serialVersionUID = 1L;

    private final File jarFile;
    private final File configFile;

    protected JobRequirementSpecificationJarFile() {
        // for ORM
        jarFile = null;
        configFile = null;
    }

    protected JobRequirementSpecificationJarFile(final File jarFile, final File configFile) {
        Preconditions.ensure(jarFile != null, "jar file should not be null");
        Preconditions.ensure(configFile != null, "config file should not be null");
        this.jarFile = jarFile;
        this.configFile = configFile;
    }

    public static JobRequirementSpecificationJarFile valueOf(final JobRequirementSpecificationJarFile jarFile) {
        return new JobRequirementSpecificationJarFile(jarFile.jarFile, jarFile.configFile);
    }

    @Override
    public String toString() {
        return jarFile.getName() + " " + configFile.getName();
    }

    @Override
    public int compareTo(final JobRequirementSpecificationJarFile o) {
        return jarFile.compareTo(o.jarFile);
    }
}
