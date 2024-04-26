package jobs4u.base.interviewModel.domain;

import eapli.framework.domain.model.ValueObject;
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

    @Column(name="InterviewModelSpecificationJarFile")
    private final String value;


    protected InterviewModelSpecificationJarFile() {
        // for ORM
        value = null;
    }

    protected InterviewModelSpecificationJarFile(final String value) {
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

    public static InterviewModelSpecificationJarFile valueOf(final String jarFile) {
        return new InterviewModelSpecificationJarFile(jarFile);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(final InterviewModelSpecificationJarFile o) {
        return value.compareTo(o.value);
    }



    }
