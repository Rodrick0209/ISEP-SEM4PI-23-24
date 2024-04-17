package jobs4u.base.recruitmentProcessManagement.domain;

import eapli.framework.general.domain.model.Designation;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.recruitmentProcessManagement.utils.DateUtils;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecruimentProcessTest {


    @Test
    public void testCreateValidRecruitmentProcessWithoutInterview() {
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Designation.valueOf("Resume_Screen"), DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Analysis"), DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-07-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Result"), DateUtils.parseDate("18-07-2025"), DateUtils.parseDate("18-08-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase4);
        phases.add(phase5);
        assertDoesNotThrow(() -> new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));

    }

    @Test
    public void testCreateValidRecruitmentProcessWithInterview() {
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Designation.valueOf("Resume_Screen"), DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Analysis"), DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Result"), DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        assertDoesNotThrow(() -> new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));

    }
    @Test
    public void testCreateValidRecruitmentPhasesOrderButOnePhaseInExcessWithValidDesignationWithInterview() {
        List<Phase> phases = new ArrayList<>();
        Phase phase3 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-04-2025"), DateUtils.parseDate("18-05-2025"));
        Phase phase2 = new Phase(Designation.valueOf("Resume_Screen"), DateUtils.parseDate("18-05-2025"), DateUtils.parseDate("18-06-2025"));
        Phase phase6 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-06-2025"), DateUtils.parseDate("18-09-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Analysis"), DateUtils.parseDate("18-09-2025"), DateUtils.parseDate("18-10-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Result"), DateUtils.parseDate("18-10-2025"), DateUtils.parseDate("18-11-2025"));
        Phase phase1 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-11-2025"), DateUtils.parseDate("18-12-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase6);
        phases.add(phase4);
        phases.add(phase5);
        phases.add(phase1);
        assertThrows(IllegalArgumentException.class, () ->
                new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));
    }

    @Test
    public void testCreateRecruitmentProcessWithInvalidNumberOfPhases() {
        List<Phase> phases = new ArrayList<>();
        Phase phase1 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase2 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase3 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase6 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase7 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        phases.add(phase1);
        phases.add(phase2);
        phases.add(phase3);
        phases.add(phase4);
        phases.add(phase5);
        phases.add(phase6);
        phases.add(phase7);
        assertThrows(IllegalArgumentException.class, () ->
                new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));

    }


    @Test
    public void testCreateRecruitmentProcessWithoutInterviewAndInvalidPhasesOrder() {
        List<Phase> phases = new ArrayList<>();
        Phase phase2 = new Phase(Designation.valueOf("Resume_Screen"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase3 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Analysis"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Result"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        phases.add(phase2);
        phases.add(phase3);
        phases.add(phase4);
        phases.add(phase5);
        assertThrows(IllegalArgumentException.class, () ->
                new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));

    }

    @Test
    public void testCreateRecruitmentProcessWithoutInterviewAndInvalidPhasesOrder2() {
        List<Phase> phases = new ArrayList<>();
        Phase phase2 = new Phase(Designation.valueOf("Resume_Screen"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase3 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Analysis"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Result"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase4);
        phases.add(phase5);
        assertThrows(IllegalArgumentException.class, () ->
                new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));

    }

    @Test
    public void testCreateRecruitmentProcessWithInterviewAndInvalidPhasesOrder() {
        List<Phase> phases = new ArrayList<>();
        Phase phase1 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase2 = new Phase(Designation.valueOf("Resume_Screen"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase3 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Analysis"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Result"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        phases.add(phase1);
        phases.add(phase2);
        phases.add(phase3);
        phases.add(phase4);
        phases.add(phase5);
        assertThrows(IllegalArgumentException.class, () ->
                new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));


    }

    @Test
    void testCreateRecruitmentProcessWithInvalidStartEndDates() {
        List<Phase> phases = new ArrayList<>();
        Phase phase1 = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase2 = new Phase(Designation.valueOf("Resume_Screen"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase3 = new Phase(Designation.valueOf("Application"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase4 = new Phase(Designation.valueOf("Analysis"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        Phase phase5 = new Phase(Designation.valueOf("Result"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        phases.add(phase3);
        phases.add(phase2);
        phases.add(phase4);
        phases.add(phase5);
        assertThrows(IllegalArgumentException.class, () ->
                new RecruitmentProcess(phases, new JobReference(ClientCode.valueOf("isep"), 1)));
    }


}


