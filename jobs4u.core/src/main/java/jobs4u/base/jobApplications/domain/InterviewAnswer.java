package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@Entity
public class InterviewAnswer implements ValueObject {

    @Id
    @GeneratedValue
    private long id;
    private FileName fileName;
    private InterviewPoints points;

    public InterviewAnswer(FileName fileName){
        Preconditions.noneNull(fileName, "File cannot be null");
        this.fileName = fileName;
    }

    protected InterviewAnswer(){}

    public InputStream inputStreamFromResourceOrFile() throws FileNotFoundException {
        InputStream content;
        final var classLoader = this.getClass().getClassLoader();
        content = classLoader.getResourceAsStream(this.fileName.fileName());
        if (content == null) {
            try {
                content = new FileInputStream(this.fileName.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public FileName fileName(){
        return this.fileName;
    }

    public String toString(){
        return this.fileName.toString();
    }

    public void grade(InterviewPoints points){
        this.points = points;
    }

    public InterviewPoints points(){
        return this.points;
    }


}
