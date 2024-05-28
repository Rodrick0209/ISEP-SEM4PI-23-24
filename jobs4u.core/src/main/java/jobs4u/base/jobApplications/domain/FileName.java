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

    public String fileName(){
        return this.answerFileName;
    }




}
