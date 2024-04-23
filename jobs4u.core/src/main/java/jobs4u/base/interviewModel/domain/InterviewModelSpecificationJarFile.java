package jobs4u.base.interviewModel.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.io.Serializable;


@Embeddable
@EqualsAndHashCode
public class InterviewModelSpecificationJarFile implements ValueObject, Serializable, Comparable<InterviewModelSpecificationJarFile>  {

    private static final long serialVersionUID = 1L;

    private final File jarFile;
    private final File configFile;


    protected InterviewModelSpecificationJarFile() {
        // for ORM
        jarFile = null;
        configFile = null;
    }

    protected InterviewModelSpecificationJarFile(final File jarFile, final File configFile) {
        Preconditions.ensure(jarFile != null, "jar file should not be null");
        Preconditions.ensure(configFile != null, "config file should not be null");
        this.jarFile = jarFile;
        this.configFile = configFile;
    }

    public static InterviewModelSpecificationJarFile valueOf(final InterviewModelSpecificationJarFile jarFile) {
        return new InterviewModelSpecificationJarFile(jarFile.jarFile, jarFile.configFile);
    }

    @Override
    public String toString() {
        return jarFile.getName() + " " + configFile.getName();
    }

    @Override
    public int compareTo(final InterviewModelSpecificationJarFile o) {
        return jarFile.compareTo(o.jarFile);
    }



    }
