package jobs4u.base.recruitmentProcessManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.recruitmentProcessManagement.utils.State;

import java.util.List;

public class OpenClosePhaseController {


    private AuthorizationService authz;

    private JobOpeningRepository jobOpeningRepository;
    private JobApplicationRepository jobApplicationRepository;

    public OpenClosePhaseController(JobOpeningRepository jobOpeningRepository,JobApplicationRepository jobApplicationRepository ,AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.authz = authz;
    }

    public List<JobApplication> getJobApplicationsByJobOpening(JobOpening jobOpening) {
        return jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);
    }

    public String getMessageAccordinglyWithPhaseState(JobOpening jobOpening, List<JobApplication> jobApplications) {
        return jobOpening.getRecruitmentProcess().messageForOpenClosePhase(jobApplications);
    }

    public void changePhase(JobOpening jobOpening,List<JobApplication> jobApplications){
        jobOpening.changePhase(jobApplications);
        jobOpeningRepository.save(jobOpening);
    }

}
