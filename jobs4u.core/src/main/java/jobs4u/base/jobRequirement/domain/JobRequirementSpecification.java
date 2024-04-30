package jobs4u.base.jobRequirement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jobs4u.base.jobRequirement.infrastructure.RequirementEvaluation;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.InvocationTargetException;

@XmlRootElement
@Entity
public class JobRequirementSpecification implements AggregateRoot<JobRequirementSpecificationIdentifier> {

    @EmbeddedId
    private JobRequirementSpecificationIdentifier identifier;

    private String className;

    protected JobRequirementSpecification(){
        // for ORM
        identifier = null;
        className = null;
    }

    public JobRequirementSpecification(JobRequirementSpecificationIdentifier identifier, String className){
        this.identifier = identifier;
        this.className = className;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobRequirementSpecificationIdentifier identity() {
        return identifier;
    }


    private void buildEvaluator(){
        try {
           RequirementEvaluation plugin = (RequirementEvaluation) Class.forName(className).getDeclaredConstructor().newInstance();
            //TODO quando for preciso é aqui q se chama as funcoes de evaluation
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }



}
