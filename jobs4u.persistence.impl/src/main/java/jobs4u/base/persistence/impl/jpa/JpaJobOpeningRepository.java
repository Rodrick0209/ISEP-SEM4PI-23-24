package jobs4u.base.persistence.impl.jpa;

import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;

class JpaJobOpeningRepository extends BasepaRepositoryBase<JobOpening, JobReference,JobReference> implements JobOpeningRepository {

    public JpaJobOpeningRepository() {
        super("jobReference");
    }

}
