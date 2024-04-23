package jobs4u.base.interviewModel.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class InterviewModelSpecification {

    @EmbeddedId
    private InterviewModelSpecificationIdentifier identifier;

    private InterviewModelSpecificationJarFile jarFile;
}
