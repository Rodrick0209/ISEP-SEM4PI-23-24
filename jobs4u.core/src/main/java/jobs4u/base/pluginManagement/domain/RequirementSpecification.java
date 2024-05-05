package jobs4u.base.pluginManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jobs4u.base.pluginManagement.application.RequirementEvaluation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.InvocationTargetException;

@XmlRootElement
@Table(name = "JobRequirementSpecification")
@Entity
public class RequirementSpecification implements AggregateRoot<JobRequirementSpecificationIdentifier> {

    @EmbeddedId
    private JobRequirementSpecificationIdentifier identifier;

    private FQClassName className;


    private static final Logger LOGGER = LogManager.getLogger(RequirementSpecification.class);

    protected RequirementSpecification() {
        // for ORM
        identifier = null;
        className = null;
    }

    public RequirementSpecification(String identifier, String className) {
        Preconditions.nonNull(identifier,className);
        this.identifier = JobRequirementSpecificationIdentifier.valueOf(identifier);
        this.className = FQClassName.valueOf(className);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobRequirementSpecificationIdentifier identity() {
        return identifier;
    }


    /**
     * build the evaluator
     * @return evalutor-> RequirementEvaluation
     */
    public RequirementEvaluation buildEvaluator() {
        try {
          return (RequirementEvaluation) Class.forName(className.toString()).getDeclaredConstructor().newInstance();
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
