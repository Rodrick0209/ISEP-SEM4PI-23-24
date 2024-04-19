package jobs4u.base.jobOpeningsManagement.domain;

import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.utils.ClientCode;

public class JobReferenceService {

    private static int counter = 0;

    public JobReference createJobReference(ClientCode clientCode) {
        int referenceNumber = ++counter;
        // Reset counter if it exceeds 999999
        if (counter >= 1000000) {
            counter = 0;
        }
        return new JobReference(clientCode, referenceNumber);
    }
}