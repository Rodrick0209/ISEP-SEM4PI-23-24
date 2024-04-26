package jobs4u.base.interviewModel.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class InterviewModelSpecification implements AggregateRoot<InterviewModelSpecificationIdentifier> {

    @EmbeddedId
    private final InterviewModelSpecificationIdentifier identifier;

    private final InterviewModelSpecificationJarFile jarFile;

    protected InterviewModelSpecification(){
        // for ORM
        identifier = null;
        jarFile = null;
    }

    public InterviewModelSpecification(final InterviewModelSpecificationIdentifier identifier, InterviewModelSpecificationJarFile jarFile) {
        this.identifier = identifier;
        this.jarFile = jarFile;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public InterviewModelSpecificationIdentifier identity() {
        return this.identifier;
    }
}
