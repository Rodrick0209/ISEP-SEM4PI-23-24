package jobs4u.base.jobApplications.application;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.validations.Preconditions;
import jobs4u.base.jobApplications.domain.InterviewPoints;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.RequirementResult;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;

import java.io.InputStream;
import java.util.List;

public class ExecuteInterviewEvaluationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final TransactionalContext ctx;
    public ExecuteInterviewEvaluationService(JobApplicationRepository jobApplicationRepository,
                                             TransactionalContext ctx) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.ctx = ctx;
    }
    public void executeInterviewEvaluation(JobOpening jobOpening, List<JobApplication> jobApplication){
        Preconditions.ensure(jobOpening.getRecruitmentProcess().returnNotClosedPhase().designation().equals(Phases.INTERVIEWS), "job opening is not in interview phase");

        try{
            ctx.beginTransaction();
            for(JobApplication ja: jobApplication){
                if(ja.interview().answer() != null && ja.interview().points() == null && ja.requirementAnswer().result().equals(RequirementResult.ACCEPTED)) {
                    InputStream interviewAnswer = ja.interviewAnswer();
                    double interviewPoints = jobOpening.evaluateInterview(interviewAnswer);
                    ja.interview().grade(InterviewPoints.valueOf(interviewPoints));
                    jobApplicationRepository.save(ja);
                }
            }
            //Change interview phase state using transactional context
            checkIfInterviewPhaseStateChanges(jobOpening, jobApplication);
            ctx.commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }




    private void checkIfInterviewPhaseStateChanges(JobOpening jobOpening,List<JobApplication> jobApplications){
        if (jobApplications.isEmpty())
            return;

        if(isInterviewPhaseConcluded(jobApplications)){
            jobOpening.recruitmentProcess().interviewsPhase().setState(State.FINISHED);
            return;
        }

        if (isInterviewPhaseStarted(jobApplications) && jobOpening.recruitmentProcess().interviewsPhase().state().equals(State.OPEN)){
            jobOpening.recruitmentProcess().interviewsPhase().setState(State.ACTIVE);
        }
    }

    public boolean isInterviewPhaseConcluded(List<JobApplication> jobApplicationList) {
        for (JobApplication application : jobApplicationList) {
            if (!application.isApplicationInterviewAvaliationDone()) {
                return false;
            }
        }
        return true;
    }

    private boolean isInterviewPhaseStarted(List<JobApplication> jobApplicationsList) {
        for (JobApplication jobApplication : jobApplicationsList) {
            if (jobApplication.isApplicationInterviewAvaliationDone()) {
                return true;
            }
        }
        return false;
    }
}
