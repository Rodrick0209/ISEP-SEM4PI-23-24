package jobs4u.base.recruitmentProcessManagement;


import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.jobOpeningsManagement.domain.utils.JobReference;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecruitmentProcess {
    private static final long serialVersionUID = 1L;

    @Version
    private Long version;


    @Id
    private JobReference jobReference;

    //TODO jakart ou hibernate import??
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phase> phases;


    protected RecruitmentProcess() {
    }

    public RecruitmentProcess(List<Phase> phases, JobReference jobReference) {
        validatePhases(phases);
        this.jobReference = jobReference;
        this.phases = phases;
    }


    private void validatePhases(List<Phase> phases) {
        Preconditions.nonEmpty(phases);
        validatePhasesOrder(phases);
        validatePhasesStartEndDates(phases);
    }


    private void validatePhasesOrder(List<Phase> phases) {
        List<String> expectedPhaseIfInterview = List.of("application", "resume_screen", "interviews", "analysis", "result");
        List<String> expectedPhaseIfNotInterview = List.of("application", "resume_screen", "analysis", "result");
        List<String> currentPhases = new ArrayList<>();

        for (Phase phase : phases) {
            currentPhases.add(phase.designation().toString().toLowerCase());
        }

        if (!currentPhases.equals(expectedPhaseIfInterview) && !currentPhases.equals(expectedPhaseIfNotInterview)) {
            throw new IllegalArgumentException("Phases are not in the correct order");
        }


    }

    private static void validatePhasesStartEndDates(List<Phase> phases) {
        for (int i = 0; i < phases.size() - 1; i++) {
            Phase currentPhase = phases.get(i);
            Phase nextPhase = phases.get(i + 1);

            // Verifica se a data final da fase atual é igual à data inicial da próxima fase
            if (!currentPhase.endDate().isEqual(nextPhase.startDate())) {
                throw new IllegalArgumentException("Error in the dates setup ");

            }

            // Verifica se não há datas de fases anteriores que ocorrem após as datas das fases seguintes
            if (i > 0 && currentPhase.startDate().isAfter(phases.get(i - 1).endDate())) {
                throw new IllegalArgumentException("Error in the dates setup ");
            }
        }


    }
}

