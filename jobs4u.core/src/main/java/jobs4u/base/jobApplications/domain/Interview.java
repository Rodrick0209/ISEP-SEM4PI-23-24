package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class Interview implements ValueObject {
    private Date date;
    private Time time;
    private InterviewAnswer interviewAnswer;



    public Interview(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    protected Interview() {
        // for ORM
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }


}
