package jobs4u.base.jobRequirementSpecification.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JobRequirementSpecification implements AggregateRoot<Long> {
    @Id
    private Long id;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}
