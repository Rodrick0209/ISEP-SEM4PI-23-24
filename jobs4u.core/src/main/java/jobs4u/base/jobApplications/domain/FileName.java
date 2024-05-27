package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.*;


@Embeddable
public class FileName implements ValueObject {


    private static final long serialVersionUID = 1L;

    private String answerFileName;
    protected FileName(String answerFileName) {
        Preconditions.nonNull(answerFileName, "Answer file name cannot be null");
        this.answerFileName = answerFileName;
    }

    protected FileName() {
    }

    public static FileName valueOf(String answerFileName) {
        return new FileName(answerFileName);
    }

    public InputStream inputStreamFromResourceOrFile() throws FileNotFoundException {
        InputStream content;
        final var classLoader = this.getClass().getClassLoader();
        final var resource = classLoader.getResource(this.answerFileName);
        if (resource != null) {
            final var file = new File(resource.getFile());
            content = new FileInputStream(file);
        } else {
            content = new FileInputStream(this.answerFileName);
        }
        return content;
    }







}
