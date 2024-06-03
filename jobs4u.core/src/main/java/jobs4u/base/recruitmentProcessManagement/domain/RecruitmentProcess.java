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
    public Phase returnPhaseOpen() {
        List<Phase> phases = getAllPhases();
        for (Phase phase : phases) {
            if (phase.state().equals(State.OPEN)) {
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
    public Phase nextPhase() {
        Phase phaseThatGoingToClose = returnPhaseOpen();
        if (phaseThatGoingToClose == null) {
            return inicialPhaseOfRecruitmentProcess();
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
        if (phase.equals(inicialPhaseOfRecruitmentProcess())) {
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

    public boolean checkIfPhaseIsInProgress(List<JobApplication> jobApplicationList, Phase phase) {
        if (phase.designation().equals(Phases.APPLICATION)) {
            return isApplicationPhaseStarted(jobApplicationList);
        } else if (phase.designation().equals(Phases.RESUME_SCREEN)) {
            return isScreeningPhaseStarted(jobApplicationList);
        } else if (phase.designation().equals(Phases.INTERVIEWS)) {
            return isInterviewPhaseStarted(jobApplicationList);
        } else if (phase.designation().equals(Phases.ANALYSIS)) {
            return isAnalysisPhaseStarted(jobApplicationList);
        } else if (phase.designation().equals(Phases.RESULT)) {
            return isResultPhaseStarted(jobApplicationList);
        }
        return false;

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
    public void movesNextPhase(List<JobApplication> jobApplications) {
        Phase nextPhase = nextPhase();
        Phase activePhase = returnPhaseOpen();
        if (activePhase == null) {
            //Quer dizer que o recruitment process ainda nao começou
            nextPhase.openPhase();

        } else if (nextPhase == null) {
            //Se a proxima fase for nula quer dizer que o processo de recrutamento acabou
            closePhase(activePhase);
        } else if (!checkIfIsAtLastPhase()) {
            //Se nao for nem a primeira nem a ultima fecha a atual e abre a seguinte
            closePhase(activePhase);
            openPhase(activePhase, nextPhase);
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
     * Since there aren´t 2 or more options to change the state for any of the phase states whe dont need to receive nothing through parameter
     */
    public void executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(List<JobApplication> jobApplications) {
        Phase phase = returnPhaseOpen();

        if (phase == null) {
            movesNextPhase(jobApplications);
        } else if (phase.state().equals(State.OPEN) && !checkIfPhaseIsInProgress(jobApplications, phase)) {
            closeOpenPhaseAndOpenPhaseBefore(phase);
        } else if (checkIsPhaseConcluded(jobApplications, phase)) {
            if (checkIfIsAtLastPhase()) {
                closePhase(phase);
            } else {
                movesNextPhase(jobApplications);
            }
        } else {
            throw new IllegalStateException("The are no actions available for the phase");
        }

    }


    public void openPhase(Phase previousPhase, Phase nextPhase) {
        if (previousPhase.state().equals(State.CLOSED)) {
            nextPhase.openPhase();
        } else {
            throw new IllegalStateException("The previous phase is not closed");
        }


    }

    /**
     * @return first phase of the recruitment process
     */
    public Phase inicialPhaseOfRecruitmentProcess() {
        return getAllPhases().get(0);
    }


    /**
     * Since the recruitment process knows the options available accordingly with each state we made this method in
     * the recruitment process class to made the message for the user
     *
     * @return
     */
    public String messageForOpenClosePhase(List<JobApplication> jobApplicationList) {
        Phase phase = returnPhaseOpen();
        String text;

        if (phase == null) {
            text = "1- Open " + inicialPhaseOfRecruitmentProcess().designation() + " phase and consequently start the Recruitment Process\n" +
                    "2- Exit \n";

        } else if (!checkIfPhaseIsInProgress(jobApplicationList, phase)) {
            if (inicialPhaseOfRecruitmentProcess().state().equals(State.OPEN)) {
                text = "Active phase: " + phase.designation() + "\n1- Rollback and make the Recruitment Process not started\n" +
                        "2- Exit \n";
            }else {
                text = "Active phase: " + phase.designation() + "\n1- Rollback to phase before " + previousPhase(phase).designation()+"\n"+
                        "2- Exit \n";
            }

        } else if (phase.state().equals(State.OPEN) && checkIsPhaseConcluded(jobApplicationList, phase) && !checkIfIsAtLastPhase()) {

            //When the phase is concluded, the user can move to the next phase or exit
            text = "Active phase: " + phase.designation() + "\n1- Move to next phase " + nextPhase().designation() + " and close phase before " + phase.designation() + "\n" +
                    "2- Exit \n";

        } else if (checkIsPhaseConcluded(jobApplicationList, phase) && checkIfIsAtLastPhase()) {

                text = "Active phase: " + phase.designation() + "\n1- Close " + phase + " and consequently end the Recruitment Process (no more phases left)\n" +
                        "2- Exit \n";
        } else {
            text = "There are no available actions because the phase is not concluded/is in progress";
        }

        return text;
    }


    public boolean checkIsPhaseConcluded(List<JobApplication> jobApplicationList, Phase phase) {

        if (phase.designation().equals(Phases.RESUME_SCREEN)) {
            return isScreenPhaseConcluded(jobApplicationList);
        } else if (phase.designation().equals(Phases.INTERVIEWS)) {
            return isInterviewPhaseConcluded(jobApplicationList);
        } else if (phase.designation().equals(Phases.ANALYSIS)) {
            return isAnalysisPhaseConcluded(jobApplicationList);
        } else if (phase.designation().equals(Phases.RESULT)) {
            return isResultPhaseConcluded(jobApplicationList);
        }

        return true;
    }


    public boolean isScreenPhaseConcluded(List<JobApplication> jobApplicationList) {
        for (JobApplication application : jobApplicationList) {
            if (!application.isApplicationRequirementAnswerEvaluated()) {
                return false;
            }
        }
        return true;
    }

    public boolean isInterviewPhaseConcluded(List<JobApplication> jobApplicationList) {
        for (JobApplication application : jobApplicationList) {
            if (!application.isApplicationInterviewAvaliationDone()) {
                return false;
            }
        }
        return true;
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

    public boolean isScreeningPhaseStarted(List<JobApplication> jobApplicationList) {
        for (JobApplication application : jobApplicationList) {
            if (application.isApplicationRequirementAnswerEvaluated()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInterviewPhaseStarted(List<JobApplication> jobApplicationsList) {
        for (JobApplication jobApplication : jobApplicationsList) {
            if (jobApplication.isApplicationInterviewAvaliationDone()) {
                return true;
            }
        }
        return false;
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





