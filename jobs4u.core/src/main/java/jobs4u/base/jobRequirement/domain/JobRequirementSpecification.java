package jobs4u.base.jobRequirement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import org.springframework.javapoet.ClassName;

import javax.xml.bind.annotation.XmlRootElement;

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

    public JobRequirementSpecification(JobRequirementSpecificationIdentifier identifier, JobRequirementSpecificationJarFile jarFile){
        this.identifier = identifier;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobRequirementSpecificationIdentifier identity() {
        return identifier;
    }
}
