package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class Score implements ValueObject {

    private double score;

    protected Score() {
        // for ORM
    }

    protected Score(double score) {
        if (score < 0 || score > 20) {
            throw new IllegalArgumentException("Score should be between 0 and 20");
        }
        this.score = score;
    }

    public static Score valueOf(double score) {
        return new Score(score);
    }



}
