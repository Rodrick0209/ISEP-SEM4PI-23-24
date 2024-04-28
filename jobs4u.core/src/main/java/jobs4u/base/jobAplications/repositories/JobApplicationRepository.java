package jobs4u.base.jobAplications.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.Application;
import jobs4u.base.jobAplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;

import java.util.List;

public interface JobApplicationRepository
        extends DomainRepository<Long, JobApplication> {



}
