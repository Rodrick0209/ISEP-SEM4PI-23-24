package jobs4u.base.recruitmentProcessManagement.domain;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Phase {

    @Id
    private Designation designation;

    private LocalDate startDate;
    private LocalDate endDate;


    @Enumerated(EnumType.STRING)
    State state;

    protected Phase() {
    }


    public Phase(Designation designation, LocalDate startDate, LocalDate endDate) {
        Preconditions.noneNull(designation, startDate, endDate);
        validations(designation, startDate, endDate);
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = State.CLOSED;
    }


    private void validations(Designation designation, LocalDate startDate, LocalDate endDate) {
        validateDesignationPhase(designation);
        validatePhasesDates(startDate, endDate);
    }

    public Designation designation() {
        return designation;
    }

    public LocalDate startDate() {
        return startDate;
    }

    public LocalDate endDate() {
        return endDate;
    }

    private void validateDesignationPhase(Designation designation) {
        boolean isValidPhase = false;

        for (Phases phase : Phases.values()) {
            if (phase.name().equalsIgnoreCase(designation.toString())) {
                isValidPhase = true;
                break;
            }
        }
        if (!isValidPhase) {
            throw new IllegalArgumentException("Invalid phase designation: " + designation);
        }
    }

    private void validatePhasesDates(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Invalid Date, start date should be before after date");
        }
    }


    public void openPhase() {
        this.state = State.OPEN;
    }

    public void closePhase() {
        this.state = State.CLOSED;
    }


}
