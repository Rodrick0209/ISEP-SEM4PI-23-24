package jobs4u.base.recruitmentProcessManagement.domain;


import jakarta.persistence.*;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;

import java.util.LinkedList;
import java.util.List;

@Entity
public class RecruitmentProcess {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phase> phases;*/

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Phase applicationPhase;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Phase resumeScreenPhase;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Phase interviewsPhase;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Phase analysisPhase;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Phase resultPhase;


    protected RecruitmentProcess() {
    }

    public boolean hasRecruitmentStarted() {
        List<Phase> allPhases = getAllPhases();
        for (Phase phase : allPhases) {
            if (phase.state().equals(State.OPEN)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que retorna todas as fases do processo de recrutamento
     * Este método permite que nos metodos que temos de processar todas as fases do processo de recrutamento nao tenhamos que ter hardcoded cada phase
     *
     * @return Lista de phases
     */
    public List<Phase> getAllPhases() {
        List<Phase> phases = new LinkedList<>();
        phases.add(applicationPhase);
        phases.add(resumeScreenPhase);
        if (interviewsPhase != null) {
            phases.add(interviewsPhase);
        }
        phases.add(analysisPhase);
        phases.add(resultPhase);
        return phases;
    }


    public Phase applicationPhase() {
        return applicationPhase;
    }


    /**
     * Método que ativa a próxima fase do processo de recrutamento fechando a anterior
     * public void activateNextPhase() {
     * for (int i = 0; i < phases.size(); i++) {
     * if (phases.get(i).state.equals(State.OPEN)) {
     * phases.get(i).state = State.CLOSED;
     * phases.get(i + 1).state = State.OPEN;
     * return;
     * }
     * }
     * }
     */

    public Phase resumeScreenPhase() {
        return resumeScreenPhase;
    }

    public Phase interviewsPhase() {
        return interviewsPhase;
    }

    public Phase analysisPhase() {
        return analysisPhase;
    }

    public Phase resultPhase() {
        return resultPhase;
    }

    public void setResultPhase(Phase resultPhase) {
        this.resultPhase = resultPhase;
    }

    public void setApplicationPhase(Phase applicationPhase) {
        this.applicationPhase = applicationPhase;
    }

    public void setResumeScreenPhase(Phase resumeScreenPhase) {
        this.resumeScreenPhase = resumeScreenPhase;
    }

    public void setInterviewsPhase(Phase interviewsPhase) {
        this.interviewsPhase = interviewsPhase;
    }

    public void setAnalysisPhase(Phase analysisPhase) {
        this.analysisPhase = analysisPhase;
    }


    /**
     * Método que retorna a fase aberta do processo de recrutamento
     *
     * @return
     */
    public Phase returnNotClosedPhase() {
        List<Phase> phases = getAllPhases();
        for (Phase phase : phases) {
            if (!phase.state().equals(State.CLOSED)) {
                return phase;
            }
        }
        return null;
    }

    /**
     * Método que retorna a próxima fase do processo de recrutamento
     *
     * @return Next phase
     */
    public Phase returnNextPhase() {
        Phase phaseThatGoingToClose = returnNotClosedPhase();
        if (phaseThatGoingToClose == null) {
            return applicationPhase;
        }

        boolean flag = false;
        for (Phase phase : getAllPhases()) {
            if (flag && phase != null) {
                return phase;
            }


            if (phase.equals(phaseThatGoingToClose)) {
                flag = true;
            }


        }

        return null;
    }

    /**
     * Método que retorna a fase anterior
     *
     * @param phase fase atual
     * @return fase anterior
     */
    public Phase previousPhase(Phase phase) {
        List<Phase> phases = getAllPhases();
        if (phase.equals(applicationPhase)) {
            return null;
        } else {

            int index = 0;
            for (Phase phase1 : phases) {
                if (phase1.equals(phase)) {
                    return phases.get(index - 1);
                }
                index++;
            }
        }
        return null;
    }



    public void closePhase(Phase phase) {
        phase.setState(State.CLOSED);
    }

    /**
     * Método que reabre a fase anterior
     */
    public void closeOpenPhaseAndOpenPhaseBefore(Phase phaseToClose) {

        if (phaseToClose == null) {
            throw new IllegalStateException("Invalid Phase");
        }

        Phase phaseToOpen = previousPhase(phaseToClose);

        phaseToClose.closePhase();
        if (phaseToOpen != null) {
            phaseToOpen.setState(State.OPEN);
        }

    }


    /**
     * Método que fecha a fase atual e abre a seguinte
     */
    public void movesNextPhase() {
        Phase nextPhase = returnNextPhase();
        Phase notClosedPhase = returnNotClosedPhase();

        if (notClosedPhase == null) {
            //Quer dizer que o recruitment process ainda nao começou
            nextPhase.openPhase();

        } else if (nextPhase == null) {
            //Se a proxima fase for nula quer dizer que o processo de recrutamento acabou
            notClosedPhase.closePhase();
        } else  {
            //Se nao for nem a primeira nem a ultima fecha a atual e abre a seguinte
            notClosedPhase.closePhase();
            nextPhase.openPhase();
        }

    }


    /**
     * Method that check if the recruitment process is at the last phase
     *
     * @return true if is the last false if not
     */
    public boolean checkIfIsAtLastPhase() {
        int nrPhases = getAllPhases().size();
        Phase phase = getAllPhases().get(nrPhases - 1);
        if (phase.state().equals(State.OPEN)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that will execute the action according to the state that the phase is at
     * Case 1: If the phase is null we have to show the option to start the recruitment process
     * Case 2: If the phase is open we have to show the option to rollback the phase
     * Case 3: If the phase is finished we have to show the option to move to the next phase
     */
    public void executeActionForOpenClosePhaseAccordinglyWithAvailableChoice() {
        Phase phase = returnNotClosedPhase();

        if (phase == null || phase.state().equals(State.FINISHED)) {
            movesNextPhase();
        } else if (phase.state().equals(State.OPEN)) {
            closeOpenPhaseAndOpenPhaseBefore(phase);
        } else {
            throw new IllegalStateException("The are no actions available for the phase");
        }

    }



    /**
     * Since the recruitment process knows the options available accordingly with each state we made this method in
     * the recruitment process class to made the message for the user
     * <p>
     * Case 1: If the phase is null we have to show the option to start the recruitment process
     * Case 2: If the phase is open we have to show the option to rollback the phase
     * Case 3: If the phase is finished we have to show the option to move to the next phase
     *
     * @return
     */
    public String messageForOpenClosePhase() {
        Phase phase = returnNotClosedPhase();
        String text;

        if (phase == null) {
            text = "1- Open " + applicationPhase.designation() + " phase and consequently start the Recruitment Process\n" +
                    "2- Exit \n";

        } else if (phase.state().equals(State.OPEN)) {

            if (phase.equals(applicationPhase)) {
                text = "Active phase: " + phase.designation() + "\n1- Rollback and make the Recruitment Process not started\n" +
                        "2- Exit \n";
            } else {
                text = "Active phase: " + phase.designation() + "\n1- Rollback to phase before " + previousPhase(phase).designation() + "\n" +
                        "2- Exit \n";
            }

        } else if (phase.state().equals(State.FINISHED)) {
            if (!phase.equals(resultPhase)) {
                text = "Active phase: " + phase.designation() + "\n1- Move to next phase " + returnNextPhase().designation() + " and close phase before " + phase.designation() + "\n" +
                        "2- Exit \n";
            } else {
                text = "Active phase: " + phase.designation() + "\n1- Close " + phase + " and consequently end the Recruitment Process (no more phases left)\n" +
                        "2- Exit \n";
            }
        } else {
            text = "There are no available actions because the phase is not concluded/is in progress\n" +
                    "2- Exit \n";

        }

        return text;
    }








    public boolean isResultPhaseConcluded(List<JobApplication> jobApplicationList) {
        for (JobApplication application : jobApplicationList) {
            if (!application.isApplicationResultDone()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnalysisPhaseConcluded(List<JobApplication> jobApplicationList) {
        for (JobApplication application : jobApplicationList) {
            if (!application.isApplicationAnalysisDone()) {
                return false;
            }
        }
        return true;
    }

    public boolean isApplicationPhaseStarted(List<JobApplication> jobApplicationList) {
        return !jobApplicationList.isEmpty();

    }




    public boolean isAnalysisPhaseStarted(List<JobApplication> jobApplicationsList) {
        for (JobApplication jobApplication : jobApplicationsList) {
            if (jobApplication.isApplicationAnalysisDone()) {
                return true;
            }
        }
        return false;

    }

    public boolean isResultPhaseStarted(List<JobApplication> jobApplicationList) {
        for (JobApplication jobApplication : jobApplicationList) {
            if (jobApplication.isApplicationResultDone()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasInterviewPhase() {
        List<Phase> allPhases = getAllPhases();
        for (Phase phase : allPhases) {
            if (phase.designation() == Phases.INTERVIEWS) {
                return true;
            }
        }
        return false;
    }


}





