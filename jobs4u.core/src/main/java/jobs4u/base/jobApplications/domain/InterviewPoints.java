package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class InterviewPoints implements ValueObject {
    private double points;

    private InterviewPoints(double points){
        this.points = points;
    }

    protected InterviewPoints(){}

    public static InterviewPoints valueOf(double points){
        return new InterviewPoints(points);
    }
}
