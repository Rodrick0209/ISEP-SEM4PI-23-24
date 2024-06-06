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
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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


        recruitmentProcess.resultPhase().setState(State.FINISHED);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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

        recruitmentProcess.resultPhase().setState(State.ACTIVE);
        assertThrows(IllegalStateException.class, recruitmentProcess::executeActionForOpenClosePhaseAccordinglyWithAvailableChoice);

    }

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


        recruitmentProcess.resultPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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

        recruitmentProcess.analysisPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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

        recruitmentProcess.analysisPhase().setState(State.ACTIVE);
        assertThrows(IllegalStateException.class, recruitmentProcess::executeActionForOpenClosePhaseAccordinglyWithAvailableChoice);
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

        recruitmentProcess.analysisPhase().setState(State.FINISHED);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();

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

        recruitmentProcess.interviewsPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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

        recruitmentProcess.interviewsPhase().setState(State.ACTIVE);
        assertThrows(IllegalStateException.class, recruitmentProcess::executeActionForOpenClosePhaseAccordinglyWithAvailableChoice);

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

        recruitmentProcess.interviewsPhase().setState(State.FINISHED);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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

        
        recruitmentProcess.resumeScreenPhase().setState(State.OPEN);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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

        recruitmentProcess.resumeScreenPhase().setState(State.ACTIVE);
        assertThrows(IllegalStateException.class, recruitmentProcess::executeActionForOpenClosePhaseAccordinglyWithAvailableChoice);

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

        recruitmentProcess.resumeScreenPhase().setState(State.FINISHED);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
        assertEquals(recruitmentProcess.resumeScreenPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.interviewsPhase().state(), State.OPEN);
    }

    @Test
    public void testChangePhaseWhenIsAtApplicationAndPhaseIsConcluded() {
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);

        recruitmentProcess.applicationPhase().setState(State.FINISHED);
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
        assertEquals(recruitmentProcess.applicationPhase().state(), State.CLOSED);
        assertEquals(recruitmentProcess.resumeScreenPhase().state(), State.OPEN);
    }

    @Test
    public void testChangePhaseWhenIsAtApplicationsAndPhaseIsInProgress(){
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);

        recruitmentProcess.applicationPhase().setState(State.ACTIVE);
        assertThrows(IllegalStateException.class, recruitmentProcess::executeActionForOpenClosePhaseAccordinglyWithAvailableChoice);
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

        recruitmentProcess.applicationPhase().openPhase();
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice();
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


        recruitmentProcess.applicationPhase().setState(State.OPEN);
        assertEquals(recruitmentProcess.messageForOpenClosePhase(), "Active phase: " + recruitmentProcess.applicationPhase().designation() + "\n1- Rollback and make the Recruitment Process not started\n" + "2- Exit \n");

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

        recruitmentProcess.applicationPhase().setState(State.FINISHED);
        assertEquals(recruitmentProcess.messageForOpenClosePhase(), "Active phase: " + recruitmentProcess.applicationPhase().designation() + "\n1- Move to next phase " + recruitmentProcess.resumeScreenPhase().designation() + " and close phase before " + recruitmentProcess.applicationPhase().designation() + "\n" + "2- Exit \n");
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

        recruitmentProcess.resumeScreenPhase().setState(State.OPEN);
        assertEquals(recruitmentProcess.messageForOpenClosePhase(), "Active phase: " + recruitmentProcess.resumeScreenPhase().designation() + "\n1- Rollback to phase before " + recruitmentProcess.applicationPhase().designation() + "\n" + "2- Exit \n");

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

        recruitmentProcess.resultPhase().setState(State.FINISHED);
        assertEquals(recruitmentProcess.messageForOpenClosePhase(), "Active phase: " + recruitmentProcess.resultPhase().designation() + "\n1- Close " + recruitmentProcess.resultPhase() + " and consequently end the Recruitment Process (no more phases left)\n" + "2- Exit \n");

    }

    @Test
    public void testPrintMoveNextPhaseInProgressScenario(){
        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(DateUtils.parseDate("18-04-2025"),
                DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"),
                DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-08-2025"),
                DateUtils.parseDate("19-08-2025"), DateUtils.parseDate("20-08-2025"),
                DateUtils.parseDate("21-08-2025"), DateUtils.parseDate("22-08-2025"), DateUtils.parseDate("30-08-2025"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);

        recruitmentProcess.resultPhase().setState(State.ACTIVE);
        assertEquals(recruitmentProcess.messageForOpenClosePhase(),"There are no available actions because the phase is not concluded/is in progress\n" +
                "2- Exit \n");



    }


}