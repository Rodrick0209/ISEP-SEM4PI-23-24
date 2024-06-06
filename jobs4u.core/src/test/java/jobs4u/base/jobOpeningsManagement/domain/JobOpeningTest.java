
package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;
import jobs4u.base.jobOpeningsManagement.utils.*;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.recruitmentProcessManagement.domain.Phase;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcessBuilder;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcessDirector;
import jobs4u.base.recruitmentProcessManagement.dto.RecruitmentProcessDto;
import jobs4u.base.recruitmentProcessManagement.utils.DateUtils;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;
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


        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        JobOpening actualJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);

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
*//*

     */
/* @Test
    public void ensureNotPossibleToSelectAJobRequirementSpecificationForAInvalidJobOpening() {
        JobOpening jobOpening = null;
        JobRequirementSpecificationIdentifier jobRequirementSpecificationIdentifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        JobRequirementSpecification jobRequirementSpecification = new JobRequirementSpecification(jobRequirementSpecificationIdentifier, "com.example.Teste");
        assertThrows(NullPointerException.class, () -> {
            jobOpening.selectJobRequirementSpecification(jobRequirementSpecification);
        });
    }*//*


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

   */
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
*//*

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
*//*

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
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();

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
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();


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
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();

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
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();

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
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();

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
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        ContractType newContractType = ContractType.PART_TIME;
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editContractType(newContractType);
        });
    }

    // Edit client

    @Test
    void ensureEditingClientIsSuccessfullWhenJobOpeningIsInative() {
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
        Client newClient = new Client("ISEP124", "DEI", "4513-123", EmailAddress.valueOf("customer@gmail.com"));
        assertDoesNotThrow(() -> {jobOpening.editClient(newClient);});
        assertEquals(newClient.toString(), jobOpening.getClient().toString());
    }

    @Test
    void ensureEditingClientFailsWhenJobOpeningIsActive() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();

        // Constructor method with an active Job Opening
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);
        Client newClient = new Client("ISEP124", "DEI", "4513-123", EmailAddress.valueOf("customer@gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.editClient(newClient);
        });
    }

    @Test
    void ensureOrderCandidatesBasedOnInterviewPointsIsSuccessfulWhenJobOpeningHadInterviewPhaseAndCurrentlyInAnalysisPhase(){
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();
        recruitmentProcess.analysisPhase().openPhase();

        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);

        Candidate candidate1 = new Candidate("Teste", "Ola", "teste@gmail.com", "967543123");
        Candidate candidate2 = new Candidate("Ola", "Arminda", "teste1@gmail.com", "964253123");

        JobApplication jobApplication1 = new JobApplication(11L, jobOpening, null, candidate1);
        JobApplication jobApplication2 = new JobApplication(12L, jobOpening, null, candidate2);

        //TODO: implement the method to grade an interview for an Application
        throw new UnsupportedOperationException("Not supported yet.");
        /*List<JobApplication> jobApplications = new ArrayList<>(List.of(jobApplication1, jobApplication2));
        assertDoesNotThrow(() -> {
            List<Candidate> orderedCandidates = jobOpening.getOrderedListOfCandidatesBasedOnInterviewPoints(jobApplications);
        });
        List<Candidate> orderedCandidates = jobOpening.getOrderedListOfCandidatesBasedOnInterviewPoints(jobApplications);
        assertEquals(candidate1, orderedCandidates.get(1));
        assertEquals(candidate2, orderedCandidates.get(0));
         */
    //  }
/*
    @Test
    void ensureOrderCandidatesBasedOnInterviewPointsFailedWhenJobOpeningNotHadInterviewPhase(){
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();
        recruitmentProcess.analysisPhase().openPhase();

        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);

        Candidate candidate1 = new Candidate("Teste", "Ola", "teste@gmail.com", "967543123");
        Candidate candidate2 = new Candidate("Ola", "Arminda", "teste1@gmail.com", "964253123");

        JobApplication jobApplication1 = new JobApplication(11L, jobOpening, null, candidate1);
        JobApplication jobApplication2 = new JobApplication(12L, jobOpening, null, candidate2);

        //TODO: implement the method to grade an interview for an Application
        throw new UnsupportedOperationException("Not supported yet.");
        /*List<JobApplication> jobApplications = new ArrayList<>(List.of(jobApplication1, jobApplication2));
        assertThrows(IllegalArgumentException.class, () -> {
            List<Candidate> orderedCandidates = jobOpening.getOrderedListOfCandidatesBasedOnInterviewPoints(jobApplications);
        });

//    }

*/

   /* @Test
    void ensureOrderCandidatesBasedOnInterviewPointsFailedWhenJobOpeningNotCurrentlyInAnalysisPhase() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        recruitmentProcessBuilder.withApplicationPhase(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        recruitmentProcessBuilder.withResumeScreenPhase(DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        recruitmentProcessBuilder.withInterviewsPhase(DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        recruitmentProcessBuilder.withAnalysisPhase(DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        recruitmentProcessBuilder.withResultPhase(DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        RecruitmentProcess recruitmentProcess = recruitmentProcessBuilder.getRecruitmentProcess();

        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client, recruitmentProcess);

        Candidate candidate1 = new Candidate("Teste", "Ola", "teste@gmail.com", "967543123");
        Candidate candidate2 = new Candidate("Ola", "Arminda", "teste1@gmail.com", "964253123");

        JobApplication jobApplication1 = new JobApplication(11L, jobOpening, null, candidate1);
        JobApplication jobApplication2 = new JobApplication(12L, jobOpening, null, candidate2);

        //TODO: implement the method to grade an interview for an Application
        throw new UnsupportedOperationException("Not supported yet.");
        List<JobApplication> jobApplications = new ArrayList<>(List.of(jobApplication1, jobApplication2));
        assertThrows(IllegalArgumentException.class, () -> {
            List<Candidate> orderedCandidates = jobOpening.getOrderedListOfCandidatesBasedOnInterviewPoints(jobApplications);
        });

    }*/



    @Test
    public void testJobOpeningStateChangesToActiveWhenFirstPhaseStarts(){
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);

        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        jobOpening.addRecruitmentProcess(recruitmentProcess);
        assertEquals(JobOpeningStatus.INACTIVE,jobOpening.status());
        jobOpening.changePhase();
        assertEquals(JobOpeningStatus.ACTIVE, jobOpening.status());



    }

    @Test
    public void testJobOpeningStateChangesToInactiveWhenLastPhaseEnds() {
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);

        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        jobOpening.addRecruitmentProcess(recruitmentProcess);
        jobOpening.changeStatusToActive();
        jobOpening.recruitmentProcess().resultPhase().setState(State.FINISHED);
        jobOpening.changePhase();
        assertEquals(JobOpeningStatus.INACTIVE, jobOpening.status());

    }

    @Test
    public void testJobOpeningStateChangesToInactiveWhenRollbackFirstPhase(){
        JobReference jobReference = new JobReference("Isep-0001");
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening jobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, client);

        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        jobOpening.addRecruitmentProcess(recruitmentProcess);
        jobOpening.changeStatusToActive();
        jobOpening.recruitmentProcess().applicationPhase().setState(State.OPEN);
        jobOpening.changePhase();
        assertEquals(JobOpeningStatus.INACTIVE, jobOpening.status());




    }



}


