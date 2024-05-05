package jobs4u.base.pluginManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jobs4u.base.pluginManagement.application.InterviewEvaluation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.InvocationTargetException;

@XmlRootElement
@Table (name = "InterviewModelSpecification")
@Entity
public class InterviewModelSpecification implements AggregateRoot<InterviewModelSpecificationIdentifier> {

    @EmbeddedId
    private final InterviewModelSpecificationIdentifier identifier;

    private final FQClassName className;

    private static final Logger LOGGER = LogManager.getLogger(InterviewModelSpecification.class);

    protected InterviewModelSpecification() {
        // for ORM
        identifier = null;
        className = null;
    }

    public InterviewModelSpecification(final String identifier, String className) {
        Preconditions.nonEmpty(identifier, className);
        this.identifier = InterviewModelSpecificationIdentifier.valueOf(identifier);
        this.className = FQClassName.valueOf(className);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public InterviewModelSpecificationIdentifier identity() {
        return this.identifier;
    }


    /**
     * build the evaluator
     *
     * @return evalutor-> InterviewEvaluation
     */
    public InterviewEvaluation buildEvaluator() {
        try {
            return (InterviewEvaluation) Class.forName(className.toString()).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | SecurityException ex) {
            LOGGER.error("Unable to dynamically load the Plugin", ex);
            throw new IllegalStateException("Unable to dynamically load the Plugin: " + className.toString(), ex);

        }

    }

    @Override
    public String toString() {
        return identifier.toString();
    }
}
