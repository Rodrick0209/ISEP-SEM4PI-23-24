package jobs4u.base.jobApplications.application;

import eapli.framework.validations.Preconditions;
import jobs4u.base.jobApplications.domain.InterviewPoints;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;

import java.io.InputStream;
import java.util.List;

public class ExecuteInterviewEvaluationService {
    private final JobApplicationRepository jobApplicationRepository;
    public ExecuteInterviewEvaluationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }
    public void executeInterviewEvaluation(JobOpening jobOpening, List<JobApplication> jobApplication){
        Preconditions.ensure(jobOpening.getRecruitmentProcess().returnNotClosedPhase().designation().equals(Phases.INTERVIEWS), "job opening is not in interview phase");
        try{
            for(JobApplication ja: jobApplication){
                InputStream interviewAnswer = ja.interviewAnswer();
                double interviewPoints = jobOpening.evaluateInterview(interviewAnswer);
                ja.interview().grade(InterviewPoints.valueOf(interviewPoints));
                jobApplicationRepository.save(ja);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
