package jobs4u.base.interviewModel.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jobs4u.base.interviewModel.infrastructure.InterviewEvaluation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class InterviewModelSpecification implements AggregateRoot<InterviewModelSpecificationIdentifier> {

    @EmbeddedId
    private final InterviewModelSpecificationIdentifier identifier;

    private final String className;

    protected InterviewModelSpecification() {
        // for ORM
        identifier = null;
        className = null;
    }

    public InterviewModelSpecification(final InterviewModelSpecificationIdentifier identifier, String className) {
        this.identifier = identifier;
        this.className = className;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public InterviewModelSpecificationIdentifier identity() {
        return this.identifier;
    }

    private void buildEvaluator() {
        try {
            InterviewEvaluation plugin = (InterviewEvaluation) Class.forName(className).getDeclaredConstructor().newInstance();
            //TODO quando for preciso é aqui q se chama as funcoes de evaluation
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
