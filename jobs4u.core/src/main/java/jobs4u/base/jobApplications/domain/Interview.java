package jobs4u.base.jobApplications.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Entity
public class Interview {

    @Id
    @GeneratedValue
    private long id;
    private Date date;
    private Time time;

    private InterviewPoints points;

    private FileName answerFileName;


    public Interview(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    protected Interview() {
        // for ORM
    }

    public Date date() {
        return date;
    }

    public Time time() {
        return time;
    }

    public void registerInterviewAnswer(String answer) {
        if (this.answerFileName != null)
            throw new IllegalStateException("Answer file already registered");

        this.answerFileName = FileName.valueOf(answer);
    }

    public InputStream inputStreamFromResourceOrFile() throws FileNotFoundException {
        InputStream content;
        final var classLoader = this.getClass().getClassLoader();
        content = classLoader.getResourceAsStream(this.answerFileName.fileName());
        if (content == null) {
            try {
                content = new FileInputStream(this.answerFileName.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public void grade(InterviewPoints points){
        this.points = points;
    }

    public InterviewPoints points(){
        return this.points;
    }

    public FileName answer() {
        return this.answerFileName;
    }

}
