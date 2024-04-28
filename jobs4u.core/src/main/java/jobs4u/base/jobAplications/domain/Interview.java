package jobs4u.base.jobAplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class Interview implements ValueObject {
    private Date date;
    private Time time;


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
