package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobOpeningsManagement.utils.*;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobOpeningFactoryTest {

    @Test
    public void testCreateJobOpening() {
        JobOpeningFactory jobOpeningFactory = new JobOpeningFactory();

        JobReference jobReference = new JobReference(ClientCode.valueOf("isep").code());
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Calendar creationDate = Calendar.getInstance();
        JobOpeningStatus status = JobOpeningStatus.INACTIVE;

        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate,null);
        JobOpening actualJobOpening = jobOpeningFactory.createJobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate,null);

        assertEquals(expectedJobOpening, actualJobOpening);
    }
}