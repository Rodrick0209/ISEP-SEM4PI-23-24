package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;

public class JpaJobRequirementSpecificationRepository
        extends JpaAutoTxRepository<RequirementSpecification, JobRequirementSpecificationIdentifier, JobRequirementSpecificationIdentifier>
        implements JobRequirementSpecificationRepository {


    public JpaJobRequirementSpecificationRepository(final TransactionalContext autoTx) {
        super(autoTx, "identifier");
    }

    public JpaJobRequirementSpecificationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "identifier");
    }
}
