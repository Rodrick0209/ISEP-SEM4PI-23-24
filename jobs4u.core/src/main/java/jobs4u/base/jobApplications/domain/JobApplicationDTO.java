package jobs4u.base.jobApplications.domain;

import lombok.Setter;

@Setter
public class JobApplicationDTO {

    public Long id;
    public String jobOpeningReference;
    public String candidateName;
    public String state;
    public String creationDate;
    public String interviewDate;
    public String requirementAnswerStatus;
    public String numApplicants;

    public JobApplicationDTO(Long id) {
        this.id = id;
    }

    public JobApplicationDTO() {
    }
}
