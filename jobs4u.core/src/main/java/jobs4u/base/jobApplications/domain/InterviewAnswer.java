package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;


@Embeddable
public class InterviewAnswer implements ValueObject {

    private InterviewPoints points;

    private FileName answer;
}
