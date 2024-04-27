package jobs4u.base.jobAplications.domain;

public class JobApplication {

    private Interview interview;
    private InterviewAnswer interviewAnswer;
    private RequirementAnswer requirementAnswer;
    private RequirementResult requirementResult;
    private JobApplicationState jobApplicationState;
    private JobApplicationFile jobApplicationFile;

    public JobApplication(Interview interview, InterviewAnswer interviewAnswer, RequirementAnswer requirementAnswer, RequirementResult requirementResult, JobApplicationState jobApplicationState, JobApplicationFile jobApplicationFile) {
        this.interview = interview;
        this.interviewAnswer = interviewAnswer;
        this.requirementAnswer = requirementAnswer;
        this.requirementResult = requirementResult;
        this.jobApplicationState = jobApplicationState;
        this.jobApplicationFile = jobApplicationFile;
    }


}
