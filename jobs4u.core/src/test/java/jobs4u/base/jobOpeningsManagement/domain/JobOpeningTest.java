package jobs4u.base.jobOpeningsManagement.domain;

import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class JobOpeningTest {

    @Test
    public void testCreateJobOpening() {
        JobReference jobReference = new JobReference(ClientCode.valueOf("isep"), 1);
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        LocalDate creationDate = LocalDate.now();

        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate);
        JobOpening actualJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate);

        assertEquals(expectedJobOpening, actualJobOpening);
    }

}