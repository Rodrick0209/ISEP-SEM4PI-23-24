package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.utils.*;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.recruitmentProcessManagement.domain.Phase;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.utils.DateUtils;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.utils.PostalAddress;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

  /*  @Test
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
        JobRequirementSpecification jobRequirementSpecification = new JobRequirementSpecification(jobRequirementSpecificationIdentifier, "com.example.Teste");
        jobOpening.selectJobRequirementSpecification(jobRequirementSpecification);
    }
*/
   /* @Test
    public void ensureNotPossibleToSelectAJobRequirementSpecificationForAInvalidJobOpening() {
        JobOpening jobOpening = null;
        JobRequirementSpecificationIdentifier jobRequirementSpecificationIdentifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        JobRequirementSpecification jobRequirementSpecification = new JobRequirementSpecification(jobRequirementSpecificationIdentifier, "com.example.Teste");
        assertThrows(NullPointerException.class, () -> {
            jobOpening.selectJobRequirementSpecification(jobRequirementSpecification);
        });
    }*/

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
        RequirementSpecification requirementSpecification = null;
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.selectJobRequirementSpecification(requirementSpecification);
        });
    }

   /* @Test
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
        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification(identifier, "com.example.Test");
        jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
    }
*/
 /*   @Test
    public void ensureNotPossibleToSelectAInterviewModelSpecificationForAInvalidJobOpening() {
        JobOpening jobOpening = null;
        InterviewModelSpecificationIdentifier identifier = InterviewModelSpecificationIdentifier.valueOf("teste");
        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification(identifier, "com.example.Test");
        assertThrows(NullPointerException.class, () -> {
            jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
        });
    }
*/
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

    // Edit working mode
    @Test
    void ensureEditingWorkingModeIsSuccessfullWhenJobOpeningIsInative() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        // Constructor method with an inactive Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        WorkingMode newWorkingMode = WorkingMode.HYBRID;
        assertDoesNotThrow(() -> {jobOpening.editWorkingMode(newWorkingMode);});
        assertEquals(newWorkingMode.toString(), jobOpening.getWorkingMode().toString());
    }

    @Test
    void ensureEditingWorkingModeFailsWhenJobOpeningIsActive() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Phases.APPLICATION, DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Phases.RESUME_SCREEN, DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Phases.INTERVIEWS, DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Phases.ANALYSIS, DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Phases.RESULT, DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editWorkingMode(workingMode);
        });
    }

    // Edit number of vacancies

    @Test
    void ensureEditingNumberVacanciesIsSuccessfullWhenJobOpeningIsInative() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        // Constructor method with an inactive Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        NrVacancy newNumberVacancies = NrVacancy.valueOf("10");
        assertDoesNotThrow(() -> {jobOpening.editNumberVacancies(newNumberVacancies);});
        assertEquals(newNumberVacancies.toString(), jobOpening.getNrVacancy().toString());
    }

    @Test
    void ensureEditingNumberVacanciesFailsWhenJobOpeningIsActive() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Phases.APPLICATION, DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Phases.RESUME_SCREEN, DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Phases.INTERVIEWS, DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Phases.ANALYSIS, DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Phases.RESULT, DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        NrVacancy newNumberVacancies = NrVacancy.valueOf("10");
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editNumberVacancies(newNumberVacancies);
        });
    }

    // Edit address

    @Test
    void ensureEditingAddressIsSuccessfullWhenJobOpeningIsInative() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        // Constructor method with an inactive Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        PostalAddress newAddress = PostalAddress.valueOf("1265-211");
        assertDoesNotThrow(() -> {jobOpening.editAddress(newAddress);});
        assertEquals(newAddress.toString(), jobOpening.getAddress().toString());
    }

    @Test
    void ensureEditingAddressFailsWhenJobOpeningIsActive() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Phases.APPLICATION, DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Phases.RESUME_SCREEN, DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Phases.INTERVIEWS, DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Phases.ANALYSIS, DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Phases.RESULT, DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        PostalAddress newAddress = PostalAddress.valueOf("1265-211");
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editAddress(newAddress);
        });
    }

    // Edit description

    @Test
    void ensureEditingDescriptionIsSuccessfullWhenJobOpeningIsInative() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        // Constructor method with an inactive Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        Description newDescription = Description.valueOf("Software Engineer");
        assertDoesNotThrow(() -> {jobOpening.editDescription(newDescription);});
        assertEquals(newDescription.toString(), jobOpening.getDescription().toString());
    }

    @Test
    void ensureEditingDescriptionFailsWhenJobOpeningIsActive() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Phases.APPLICATION, DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Phases.RESUME_SCREEN, DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Phases.INTERVIEWS, DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Phases.ANALYSIS, DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Phases.RESULT, DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        Description newDescription = Description.valueOf("Software Engineer");
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editDescription(newDescription);
        });
    }

    // Edit function

    @Test
    void ensureEditingFunctionIsSuccessfullWhenJobOpeningIsInative() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        // Constructor method with an inactive Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        Designation newFunction = Designation.valueOf("Develop Hardware");
        assertDoesNotThrow(() -> {jobOpening.editFunction(newFunction);});
        assertEquals(newFunction.toString(), jobOpening.getFunction().toString());
    }

    @Test
    void ensureEditingFunctionFailsWhenJobOpeningIsActive() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Phases.APPLICATION, DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Phases.RESUME_SCREEN, DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Phases.INTERVIEWS, DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Phases.ANALYSIS, DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Phases.RESULT, DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        Designation newFunction = Designation.valueOf("Develop Hardware");
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editFunction(newFunction);
        });
    }

    // Edit Contract Type

    @Test
    void ensureEditingContractTypeIsSuccessfullWhenJobOpeningIsInative() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        // Constructor method with an inactive Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);
        ContractType newContractType = ContractType.PART_TIME;
        assertDoesNotThrow(() -> {jobOpening.editContractType(newContractType);});
        assertEquals(newContractType.toString(), jobOpening.getContractType().toString());
    }

    @Test
    void ensureEditingContractTypeFailsWhenJobOpeningIsActive() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Phases.APPLICATION, DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Phases.RESUME_SCREEN, DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Phases.INTERVIEWS, DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Phases.ANALYSIS, DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Phases.RESULT, DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        ContractType newContractType = ContractType.PART_TIME;
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editContractType(newContractType);
        });
    }

}
