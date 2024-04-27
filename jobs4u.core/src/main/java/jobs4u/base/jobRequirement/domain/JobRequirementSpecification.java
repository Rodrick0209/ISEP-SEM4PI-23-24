package jobs4u.base.jobRequirement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class JobRequirementSpecification implements AggregateRoot<JobRequirementSpecificationIdentifier> {

    @EmbeddedId
    private JobRequirementSpecificationIdentifier identifier;
    private JobRequirementSpecificationJarFile jarFile;

    protected JobRequirementSpecification(){
        // for ORM
        identifier = null;
        jarFile = null;
    }

    public JobRequirementSpecification(JobRequirementSpecificationIdentifier identifier, JobRequirementSpecificationJarFile jarFile){
        this.identifier = identifier;
        this.jarFile = jarFile;
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
