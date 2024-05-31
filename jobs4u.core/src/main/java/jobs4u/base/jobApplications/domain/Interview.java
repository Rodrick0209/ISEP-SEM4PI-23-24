package jobs4u.base.jobApplications.domain;
import jakarta.persistence.*;
import lombok.Getter;

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

    @Getter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private InterviewAnswer answer;


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
        if (this.answer != null)
            throw new IllegalStateException("Answer file already registered");

        this.answer = new InterviewAnswer(FileName.valueOf(answer));
    }

    public InterviewAnswer answer() {
        return this.answer;
    }

    public void grade(InterviewPoints points){
        if (this.answer == null){
            throw new IllegalStateException("Answer file not registered");
        }
        answer().grade(points);
    }

    public InterviewPoints points(){
        return answer().points();
    }

}
