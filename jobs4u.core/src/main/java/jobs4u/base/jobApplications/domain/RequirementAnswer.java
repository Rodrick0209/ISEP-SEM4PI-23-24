package jobs4u.base.jobApplications.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@Entity
public class RequirementAnswer  {

    @Id
    @GeneratedValue
    private Long id;

    private String fileName;

    @Enumerated(EnumType.STRING)
    private RequirementResult result;

    protected RequirementAnswer() {
    }

    public RequirementAnswer(String fileName) {
        Preconditions.nonNull(fileName, "File name cannot be null");
        this.fileName = fileName;
    }



    public void defineResult(String result){
        this.result = RequirementResult.valueOf(result);
    }
    public RequirementResult result(){
        return this.result;
    }


    public InputStream inputStreamFromResourceOrFile() throws FileNotFoundException {
        InputStream content;
        final var classLoader = this.getClass().getClassLoader();
        final var resource = classLoader.getResource(this.fileName.toString());
        if (resource != null) {
            final var file = new File(resource.getFile());
            content = new FileInputStream(file);
        } else {
            content = new FileInputStream(this.fileName.toString());
        }
        return content;
    }





}
