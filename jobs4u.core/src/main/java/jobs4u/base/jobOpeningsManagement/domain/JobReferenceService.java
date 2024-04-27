package jobs4u.base.jobOpeningsManagement.domain;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.utils.ClientCode;

public class JobReferenceService {

    private static int counter = 0;

    private JobOpeningRepository repo;

    public JobReferenceService(JobOpeningRepository repo) {
        this.repo=repo;
    }

    public JobReference createJobReference(ClientCode clientCode) {
        counter= (int) repo.count();
        int referenceNumber = ++counter;
        // Reset counter if it exceeds 999999
        if (counter >= 1000000) {
            counter = 0;
        }
        String referenceNumberString = clientCode.toString().concat("-").concat(String.valueOf(referenceNumber));
        return new JobReference(referenceNumberString);
    }
}