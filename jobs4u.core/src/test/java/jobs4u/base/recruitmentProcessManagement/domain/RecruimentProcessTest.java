package jobs4u.base.recruitmentProcessManagement.domain;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobApplications.domain.*;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.recruitmentProcessManagement.dto.RecruitmentProcessDto;
import jobs4u.base.recruitmentProcessManagement.utils.DateUtils;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecruimentProcessTest {


    @Test
    public void testCreateValidRecruitmentProcessWithInterviewBuilder() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-07-2025"),
                DateUtils.parseDate("18-08-2025"), DateUtils.parseDate("19-08-2025"),
                DateUtils.parseDate("20-08-2025"), DateUtils.parseDate("21-08-2025"),
                DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        assertDoesNotThrow(() -> recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto));

    }

    @Test
    public void testCreateValidRecruitmentProcessWithoutInterviewBuilder() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-07-2025"),
                null, null,
                DateUtils.parseDate("20-08-2025"), DateUtils.parseDate("21-08-2025"),
                DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        assertDoesNotThrow(() -> recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto));

    }


    @Test
    public void testWithInvalidPhasesDate() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-07-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        assertThrows(IllegalArgumentException.class, () ->
                recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto));

    }

    @Test
    public void testWithInvalidPhasesDate2() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        assertThrows(IllegalArgumentException.class, () ->
                recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto));

    }

    @Test
    public void testWithInvalidPhasesDate3() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        assertThrows(IllegalArgumentException.class, () ->
                recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto));

    }


    @Test
    public void testWithInvalidPhasesDate4() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("17-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        assertThrows(IllegalArgumentException.class, () ->
                recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto));

    }


    //US1010 TESTS

    @Test
    public void testChangePhaseWhenRecruitmentProcessDidntStarted() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(null);
        assertEquals(recruitmentProcess.applicationPhase().state(), State.OPEN);
    }

    @Test
    public void testChangeNextPhaseWhenIsAtResultPhaseAndResultPhaseIsFinished() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, null, files, null);
        JobApplication jobApplication2 = new JobApplication(2L, null, files, null);
        JobApplication jobApplication3 = new JobApplication(3L, null, files, null);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);
        jobApplications.add(jobApplication3);

        recruitmentProcess.resultPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.resultPhase().state(), State.CLOSED);

    }

    //TODO not finished this test
    @Test
    public void testChangeNextPhaseWhenIsAtResultPhaseAndResultPhaseIsInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, null, files, null);
        JobApplication jobApplication2 = new JobApplication(2L, null, files, null);
        JobApplication jobApplication3 = new JobApplication(3L, null, files, null);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);
        jobApplications.add(jobApplication3);

        recruitmentProcess.resultPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.resultPhase().state(), State.CLOSED);

    }

    //TODO not finished this test
    @Test
    public void testChangeNextPhaseWhenIsAtResultPhaseAndResultPhaseIsNotInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, null, files, null);
        JobApplication jobApplication2 = new JobApplication(2L, null, files, null);
        JobApplication jobApplication3 = new JobApplication(3L, null, files, null);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);
        jobApplications.add(jobApplication3);

        recruitmentProcess.resultPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.resultPhase().state(), State.CLOSED);
    }

    @Test
    public void testChangePhaseWhenIsAtAnalysisAndPhaseIsNotInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);


        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, null);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, null);
        JobApplication jobApplication3 = new JobApplication(3L, expectedJobOpening, files, null);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);
        jobApplications.add(jobApplication3);

        recruitmentProcess.analysisPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.analysisPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.interviewsPhase().state(), State.OPEN);


    }

    @Test
    public void testChangePhaseWhenIsAtAnalysisAndPhaseIsInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);
        JobApplication jobApplication3 = new JobApplication(3L, expectedJobOpening, files, candidate3);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);
        jobApplications.add(jobApplication3);
        List<Candidate> candidates = List.of(candidate1, candidate2);
        
        recruitmentProcess.analysisPhase().setState(State.OPEN);
        assertThrows(IllegalStateException.class, () -> recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications));
    }

    @Test
    public void testChangePhaseWhenIsAtAnalysisAndPhaseIsFinished() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);
        JobApplication jobApplication3 = new JobApplication(3L, expectedJobOpening, files, candidate3);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);
        jobApplications.add(jobApplication3);
        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        
        recruitmentProcess.analysisPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);

        assertEquals(recruitmentProcess.analysisPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.resultPhase().state(), State.OPEN);

    }

    @Test
    public void testChangePhaseWhenIsAtInterviewAndPhaseIsNotInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);
        JobApplication jobApplication3 = new JobApplication(3L, expectedJobOpening, files, candidate3);


        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);
        jobApplications.add(jobApplication3);
        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        
        recruitmentProcess.interviewsPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.interviewsPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.resumeScreenPhase().state(), State.OPEN);
    }

    @Test
    public void testChangePhaseWhenIsAtInterviewAndPhaseIsInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);

        jobApplication1.registerInterivew(Date.valueOf("2025-06-18"), Time.valueOf("10:00:00"));
        jobApplication2.registerInterivew(Date.valueOf("2025-06-18"), Time.valueOf("10:00:00"));

        jobApplication1.getInterview().grade(InterviewPoints.valueOf(10));


        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        
        recruitmentProcess.interviewsPhase().setState(State.OPEN);
        assertThrows(IllegalStateException.class, () -> recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications));

    }

    @Test
    public void testChangePhaseWhenIsAtInterviewAndPhaseIsFinished() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);

        jobApplication1.registerInterivew(Date.valueOf("2025-06-18"), Time.valueOf("10:00:00"));
        jobApplication2.registerInterivew(Date.valueOf("2025-06-18"), Time.valueOf("10:00:00"));

        jobApplication1.getInterview().grade(InterviewPoints.valueOf(10));
        jobApplication2.getInterview().grade(InterviewPoints.valueOf(15));

        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        
        recruitmentProcess.interviewsPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.interviewsPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.analysisPhase().state(), State.OPEN);
    }

    @Test
    public void testChangePhaseWhenIsAtScreeningAndPhaseIsNotInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);


        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        
        recruitmentProcess.resumeScreenPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.resumeScreenPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.applicationPhase().state(), State.OPEN);
    }

    @Test
    public void testChangePhaseWhenIsAtScreeningAndPhaseIsInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");


        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);

        jobApplication1.registerRequirementAnswer("aaaaa");
        jobApplication1.getRequirementAnswer().defineResult(true);


        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        
        recruitmentProcess.resumeScreenPhase().setState(State.OPEN);
        assertThrows(IllegalStateException.class, () -> recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications));

    }

    @Test
    public void testChangePhaseWhenIsAtScreeningAndPhaseIsFinished() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");


        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);

        jobApplication1.registerRequirementAnswer("aaaaa");
        jobApplication1.getRequirementAnswer().defineResult(true);
        jobApplication2.registerRequirementAnswer("bbbbbb");
        jobApplication2.getRequirementAnswer().defineResult(true);

        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        
        recruitmentProcess.resumeScreenPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.resumeScreenPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.interviewsPhase().state(), State.OPEN);
    }

    @Test
    public void testChangePhaseWhenIsAtApplicationAndMoveToNextPhase() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");


        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        jobApplication1.registerRequirementAnswer("aaaaa");
        jobApplication1.getRequirementAnswer().defineResult(true);


        recruitmentProcess.applicationPhase().openPhase();
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.applicationPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.resumeScreenPhase().state(), State.OPEN);
    }

    @Test
    public void testChangePhaseWhenIsAtApplicationPhaseAndIsNotInProgress() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");


        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        recruitmentProcess.applicationPhase().openPhase();
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        assertEquals(recruitmentProcess.applicationPhase().state(), State.CLOSED);
    }


    @Test
    public void testPrintApplicationPhaseRollbackPhaseScenario() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");


        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());


        recruitmentProcess.applicationPhase().openPhase();
        assertEquals(recruitmentProcess.messageForOpenClosePhase(jobApplications), "Active phase: " + recruitmentProcess.applicationPhase().designation() + "\n1- Rollback and make the Recruitment Process not started\n" + "2- Exit \n");

    }

    @Test
    public void testPrintPhaseMoveNextPhaseScenario() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        jobApplication1.registerRequirementAnswer("aaaaa");
        jobApplication1.getRequirementAnswer().defineResult(true);

        recruitmentProcess.applicationPhase().openPhase();
        assertEquals(recruitmentProcess.messageForOpenClosePhase(jobApplications), "Active phase: " + recruitmentProcess.applicationPhase().designation() + "\n1- Move to next phase " + recruitmentProcess.resumeScreenPhase().designation() + " and close phase before " + recruitmentProcess.applicationPhase().designation() + "\n" + "2- Exit \n");
    }

    @Test
    public void testPrintRollbackNotFirstPhaseScenario() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");


        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        recruitmentProcess.resumeScreenPhase().openPhase();
        assertEquals(recruitmentProcess.messageForOpenClosePhase(jobApplications), "Active phase: " + recruitmentProcess.resumeScreenPhase().designation() + "\n1- Rollback to phase before " + recruitmentProcess.applicationPhase().designation() + "\n" + "2- Exit \n");

    }

    @Test
    public void testPrintMoveNextPhaseLastPhaseScenario() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        JobReference jobReference = new JobReference("Isep-0001");
        SystemUser user = null;
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123", "ISEP", "4123-123", EmailAddress.valueOf("customermanager@gmail.com"));
        Calendar creationDate = Calendar.getInstance();
        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate, null);
        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nomex", "apelidot", "email2@email.pt", "962434293");
        Candidate candidate3 = new Candidate("nomexx", "apelidot", "email3@email.pt", "961434293");

        RequirementAnswer requirementAnswer = new RequirementAnswer("file");
        requirementAnswer.defineResult(true);
        List<JobApplication> jobApplications = new ArrayList<>();
        List<JobApplicationFile> files;
        files = Arrays.asList(new JobApplicationFile(), new JobApplicationFile());

        JobApplication jobApplication1 = new JobApplication(1L, expectedJobOpening, files, candidate1);
        JobApplication jobApplication2 = new JobApplication(2L, expectedJobOpening, files, candidate2);
        jobApplications.add(jobApplication1);
        jobApplications.add(jobApplication2);

        jobApplication1.registerRequirementAnswer("aaaaa");
        jobApplication1.getRequirementAnswer().defineResult(true);

        recruitmentProcess.resultPhase().openPhase();
        assertEquals(recruitmentProcess.messageForOpenClosePhase(jobApplications), "Active phase: " + recruitmentProcess.resultPhase().designation() + "\n1- Close " + recruitmentProcess.resultPhase() + " and consequently end the Recruitment Process (no more phases left)\n" + "2- Exit \n");

    }


}