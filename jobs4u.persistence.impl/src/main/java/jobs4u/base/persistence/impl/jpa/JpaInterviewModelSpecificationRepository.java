package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.InterviewModelSpecificationRepository;

public class JpaInterviewModelSpecificationRepository
        extends JpaAutoTxRepository<InterviewModelSpecification, InterviewModelSpecificationIdentifier, InterviewModelSpecificationIdentifier>
        implements InterviewModelSpecificationRepository {

    public JpaInterviewModelSpecificationRepository(final TransactionalContext autoTx) {
        super(autoTx, "identifier");
    }

    public JpaInterviewModelSpecificationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "identifier");
    }

}
