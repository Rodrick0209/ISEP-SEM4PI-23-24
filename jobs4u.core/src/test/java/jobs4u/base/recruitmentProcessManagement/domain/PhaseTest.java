package jobs4u.base.recruitmentProcessManagement.domain;

import eapli.framework.general.domain.model.Designation;
import jobs4u.base.recruitmentProcessManagement.Phase;
import jobs4u.base.recruitmentProcessManagement.utils.DateUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PhaseTest {


    @Test
    public void testCreateValidPhase() {
        Phase phase = new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("18-03-2025"), DateUtils.parseDate("18-04-2025"));
        assertDoesNotThrow(() -> phase);
    }

    @Test
    public void testCreatePhaseWithInvalidStartDateFormat() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("20125-03-18"), DateUtils.parseDate("18-04-2025")));
    }

    @Test
    public void testCreatePhaseWithInvalidEndDateFormat() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("2025-03-18"), DateUtils.parseDate("118-04-2025")));
    }

    @Test
    public void testCreatePhaseWithEndDateBeforeStartDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("2025-03-18"), DateUtils.parseDate("11-04-2024")));


    }

    @Test
    public void testCreatePhaseWithNullDesignation() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phase(null, DateUtils.parseDate("2025-03-18"), DateUtils.parseDate("18-04-2025")));
    }


    @Test
    public void testCreatePhaseWithNullStartDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phase(Designation.valueOf("Interviews"), null, DateUtils.parseDate("18-04-2025")));
    }

    @Test
    public void testCreatePhaseWithNullEndDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phase(Designation.valueOf("Interviews"), DateUtils.parseDate("2025-03-18"), null));
    }

    @Test
    public void testCreatPhaseWithInvalidDesignation() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phase(Designation.valueOf("NaoExisteEstaPhase"), DateUtils.parseDate("2025-03-18"), DateUtils.parseDate("18-04-2025")));
    }





}