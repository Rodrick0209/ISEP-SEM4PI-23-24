package jobs4u.base.recruitmentProcessManagement.domain;


import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.recruitmentProcessManagement.domain.Phase;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RecruitmentProcess {
    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phase> phases;


    protected RecruitmentProcess() {
    }

    public RecruitmentProcess(List<Phase> phases) {
        validatePhases(phases);
        this.phases = phases;
    }


    /**
     * this is the domain validation of the phases
     * @param phases recruitment process phases
     */

    private void validatePhases(List<Phase> phases) {
        Preconditions.nonEmpty(phases);
        validatePhasesOrder(phases);
        validatePhasesStartEndDates(phases);
    }


    /**
     * validate if the phases are in one of the possible orders
     * @param phases list of phases
     */
    private void validatePhasesOrder(List<Phase> phases) {
        List<String> expectedPhaseIfInterview = List.of(
                Phases.APPLICATION.name(),
                Phases.RESUME_SCREEN.name(),
                Phases.INTERVIEWS.name(),
                Phases.ANALYSIS.name(),
                Phases.RESULT.name());

        List<String> expectedPhaseIfNotInterview = List.of(
                Phases.APPLICATION.name(),
                Phases.RESUME_SCREEN.name(),
                Phases.ANALYSIS.name(),
                Phases.RESULT.name());


        List<String> currentPhases = new ArrayList<>();

        for (Phase phase : phases) {
            currentPhases.add(phase.designation().toString().toUpperCase());
        }

        if (!currentPhases.equals(Phases.getExpectedPhases(false)) && !currentPhases.equals(Phases.getExpectedPhases(true))) {
            throw new IllegalArgumentException("Phases are not in the correct order");
        }


    }

    /**
     * @return the active phase of the recruitment process
     */
    public Phase returnActivePhase(){
        for (Phase phase : phases) {
            if (phase.state.equals(State.OPEN)) {
                return phase;
            }
        }
        return null;

    }

    /**
     * Método que ativa a próxima fase do processo de recrutamento fechando a anterior
     */
    public void activateNextPhase() {
        for (int i = 0; i < phases.size(); i++) {
            if (phases.get(i).state.equals(State.OPEN)) {
                phases.get(i).state = State.CLOSED;
                phases.get(i + 1).state = State.OPEN;
                return;
            }
        }
    }


    /**
     * Método verifies if the recruitment process has already started
     * @return true if the recruitment process has already started, false otherwise
     */
    public boolean hasRecruitmentStarted() {
        for (Phase phase : phases) {
            if (phase.state.equals(State.OPEN)) {
                return true;
            }
        }

        return false;
    }


    /**
     * this is the domain validation of the phases start and end dates
     * @param phases list of recruitment process phases
     */

    private static void validatePhasesStartEndDates(List<Phase> phases) {
        for (int i = 0; i < phases.size() - 1; i++) {
            Phase currentPhase = phases.get(i);
            Phase nextPhase = phases.get(i + 1);

            /*
            // Verifica se a data final da fase atual é igual à data inicial da próxima fase
            if (!currentPhase.endDate().isEqual(nextPhase.startDate())) {
                throw new IllegalArgumentException("Error in the dates setup ");

            }

             */

            // Verifica se não há datas de fases anteriores que ocorrem após as datas das fases seguintes
            if (i > 0 && currentPhase.startDate().isBefore(phases.get(i - 1).endDate())) {
                throw new IllegalArgumentException("Error in the dates setup ");
            }
        }


    }
}

