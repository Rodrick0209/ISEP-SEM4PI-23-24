package jobs4u.base.jobOpeningsManagement.domain;

import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobReferenceServiceTest {

    @Test
    public void testCreateJobReference() {
        JobReferenceService jobReferenceService = new JobReferenceService();
        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference expectedJobReference = new JobReference(clientCode, 1);
        JobReference actualJobReference = jobReferenceService.createJobReference(clientCode);
        assertEquals(expectedJobReference, actualJobReference);
    }


    @Test
    public void ensureReferenceNumberCounterReset() {
        JobReferenceService jobReferenceService = new JobReferenceService();
        ClientCode clientCode = ClientCode.valueOf("isep");
        for (int i = 0; i < 1000000; i++) {
            jobReferenceService.createJobReference(clientCode);
        }
        JobReference expectedJobReference = new JobReference(clientCode, 1);
        JobReference actualJobReference = jobReferenceService.createJobReference(clientCode);
        assertEquals(expectedJobReference, actualJobReference);
    }

}