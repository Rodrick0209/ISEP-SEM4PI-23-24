package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.jobAplications.domain.JobApplication;
import jobs4u.base.jobAplications.repositories.JobApplicationRepository;
import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUser;
import jobs4u.base.utils.ClientCode;

class JpaJobApplicationRepository
        extends JpaAutoTxRepository<JobApplication, Long, Long>
        implements JobApplicationRepository {


    public JpaJobApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaJobApplicationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }
}
