package jobs4u.base.jobRequirement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

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
       /* try {
           Plugin plugin = (Plugin) Class.forName(className).getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }*/

    }



}
