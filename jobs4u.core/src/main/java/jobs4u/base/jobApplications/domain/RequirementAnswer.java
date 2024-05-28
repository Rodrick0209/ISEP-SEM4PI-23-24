package jobs4u.base.jobApplications.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@Entity
public class RequirementAnswer {

    @Id
    @GeneratedValue
    private Long id;
    private FileName fileName;

    @Enumerated(EnumType.STRING)
    private RequirementResult result;

    protected RequirementAnswer() {
    }

    public RequirementAnswer(String fileName) {
        Preconditions.nonNull(fileName, "File name cannot be null");
        this.fileName =FileName.valueOf(fileName);
    }


    public void defineResult(boolean result) {
        if (result) {
            this.result = RequirementResult.ACCEPTED;
        } else {
            this.result = RequirementResult.REJECTED;
        }
    }

    public FileName requirementAnswer(){
        return this.fileName;
    }

    public RequirementResult result() {
        return this.result;
    }


    public InputStream inputStreamFromResourceOrFile() {
        InputStream content;
        final var classLoader = this.getClass().getClassLoader();
        content = classLoader.getResourceAsStream(fileName.fileName());
        if (content == null) {
            try {
                content = new FileInputStream(this.fileName.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return content;
    }


}
