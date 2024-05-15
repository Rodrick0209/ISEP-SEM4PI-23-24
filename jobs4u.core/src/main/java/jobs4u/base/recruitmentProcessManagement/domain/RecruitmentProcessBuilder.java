package jobs4u.base.recruitmentProcessManagement.domain;

import jobs4u.base.recruitmentProcessManagement.utils.Phases;

import java.time.LocalDate;

public class RecruitmentProcessBuilder {

    private RecruitmentProcess recruitmentProcess;

    public RecruitmentProcessBuilder() {
        recruitmentProcess = new RecruitmentProcess();
    }

    public void withApplicationPhase(LocalDate startDate, LocalDate endDate) {
        Phase applicationPhase = new Phase(Phases.APPLICATION, startDate, endDate);
        recruitmentProcess.setApplicationPhase(applicationPhase);
    }

    public void withResumeScreenPhase(LocalDate startDate, LocalDate endDate) {
        Phase resumeScreenPhase = new Phase(Phases.RESUME_SCREEN, startDate, endDate);
        validatePhaseDate(recruitmentProcess.applicationPhase(),resumeScreenPhase);
        recruitmentProcess.setResumeScreenPhase(resumeScreenPhase);
    }

    public void withInterviewsPhase(LocalDate startDate, LocalDate endDate) {
        Phase interviewsPhase = new Phase(Phases.INTERVIEWS, startDate, endDate);
        validatePhaseDate(recruitmentProcess.resumeScreenPhase(),interviewsPhase);
        recruitmentProcess.setInterviewsPhase(interviewsPhase);
    }

    public void withAnalysisPhase(LocalDate startDate, LocalDate endDate) {
        Phase analysisPhase = new Phase(Phases.ANALYSIS, startDate, endDate);
        if (recruitmentProcess.interviewsPhase() == null)
            validatePhaseDate(recruitmentProcess.resumeScreenPhase(),analysisPhase);
        else
            validatePhaseDate(recruitmentProcess.interviewsPhase(),analysisPhase);

        recruitmentProcess.setAnalysisPhase(analysisPhase);
    }

    public void withResultPhase(LocalDate startDate, LocalDate endDate) {
        Phase resultPhase = new Phase(Phases.RESULT, startDate, endDate);
        validatePhaseDate(recruitmentProcess.analysisPhase(),resultPhase);
        recruitmentProcess.setResultPhase(resultPhase);
    }

    public void validatePhaseDate(Phase phaseBefore,Phase after){
        if (phaseBefore.endDate().isAfter(after.startDate())){
            throw new IllegalArgumentException("The start date of the next phase must be after the end date of the previous phase");
        }
    }



    public RecruitmentProcess getRecruitmentProcess() {
        return this.recruitmentProcess;
    }


}
