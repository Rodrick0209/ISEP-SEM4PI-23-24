package jobs4u.base.jobApplications.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.File;
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


    private Score pontuaction;

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

    public void definePontuation(double pontuation) {
        this.pontuaction = Score.valueOf(pontuation);
    }

    public Score pontuation() {
        return this.pontuaction;
    }

    public InputStream inputStreamFromResourceOrFile() throws FileNotFoundException {
        InputStream content;
        final var classLoader = this.getClass().getClassLoader();
        final var resource = classLoader.getResource(this.answerFileName.toString());
        if (resource != null) {
            final var file = new File(resource.getFile());
            content = new FileInputStream(file);
        } else {
            content = new FileInputStream(this.answerFileName.toString());
        }
        return content;
    }

}
