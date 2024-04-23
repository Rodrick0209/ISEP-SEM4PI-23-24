package jobs4u.base.interviewModel.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class InterviewModelSpecification implements AggregateRoot<InterviewModelSpecificationIdentifier> {

    @EmbeddedId
    private InterviewModelSpecificationIdentifier identifier;

    private InterviewModelSpecificationJarFile jarFile;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public InterviewModelSpecificationIdentifier identity() {
        return this.identifier;
    }
}
