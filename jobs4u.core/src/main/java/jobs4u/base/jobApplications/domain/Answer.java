package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.io.util.Files;
import jakarta.persistence.Embeddable;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Answer implements ValueObject {


    final String answerFileName;
    public Answer(String answerFileName) {
        this.answerFileName = answerFileName;
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
