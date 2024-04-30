package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationJarFile;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecificationJarFile;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class JobOpeningTest {

    @Test
    public void testCreateJobOpening() {
        JobReference jobReference = new JobReference("Isep-0001");
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
        JobOpening actualJobOpening = new JobOpening(jobReference,  workingMode, nrVacancy, address, description, function, contractType, creationDate,null);

        assertEquals(expectedJobOpening, actualJobOpening);
    }

    @Test
    public void ensurePossibleToSelectAJobRequirementSpecificationForAJobOpening() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));

        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(), client);
        JobRequirementSpecificationIdentifier jobRequirementSpecificationIdentifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        JobRequirementSpecificationJarFile jobRequirementSpecificationJarFile = JobRequirementSpecificationJarFile.valueOf("src/test/resources/test.jar");
        JobRequirementSpecification jobRequirementSpecification = new JobRequirementSpecification(jobRequirementSpecificationIdentifier, jobRequirementSpecificationJarFile);
        jobOpening.selectJobRequirementSpecification(jobRequirementSpecification);
    }

    @Test
    public void ensureNotPossibleToSelectAJobRequirementSpecificationForAInvalidJobOpening() {
        JobOpening jobOpening = null;
        JobRequirementSpecificationIdentifier jobRequirementSpecificationIdentifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        JobRequirementSpecificationJarFile jobRequirementSpecificationJarFile = JobRequirementSpecificationJarFile.valueOf("src/test/resources/test.jar");
        JobRequirementSpecification jobRequirementSpecification = new JobRequirementSpecification(jobRequirementSpecificationIdentifier, jobRequirementSpecificationJarFile);
        assertThrows(NullPointerException.class, () -> {
            jobOpening.selectJobRequirementSpecification(jobRequirementSpecification);
        });
    }

    @Test
    public void ensureNotPossibleToSelectAInvalidJobRequirementSpecificationForAJobOpening() {
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Calendar creationDate = Calendar.getInstance();
        JobOpeningStatus status = JobOpeningStatus.INACTIVE;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));

        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        JobRequirementSpecification jobRequirementSpecification = null;
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.selectJobRequirementSpecification(jobRequirementSpecification);
        });
    }

    @Test
    public void ensurePossibleToSelectAInterviewModelSpecificationForAJobOpening() {
        JobReference jobReference = new JobReference("String123");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));

        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(), client);
        InterviewModelSpecificationIdentifier identifier = InterviewModelSpecificationIdentifier.valueOf("teste");
        InterviewModelSpecificationJarFile jarFile = InterviewModelSpecificationJarFile.valueOf("src/test/resources/test.jar");
        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification(identifier, jarFile);
        jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
    }

    @Test
    public void ensureNotPossibleToSelectAInterviewModelSpecificationForAInvalidJobOpening() {
        JobOpening jobOpening = null;
        InterviewModelSpecificationIdentifier identifier = InterviewModelSpecificationIdentifier.valueOf("teste");
        InterviewModelSpecificationJarFile jarFile = InterviewModelSpecificationJarFile.valueOf("src/test/resources/test.jar");
        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification(identifier, jarFile);
        assertThrows(NullPointerException.class, () -> {
            jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
        });
    }

    @Test
    public void ensureNotPossibleToSelectAInvalidInterviewModelSpecificationForAJobOpening() {
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        InterviewModelSpecification interviewModelSpecification = null;
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
        });
    }
}