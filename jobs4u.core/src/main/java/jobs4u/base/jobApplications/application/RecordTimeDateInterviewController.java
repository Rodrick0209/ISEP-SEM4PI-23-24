package jobs4u.base.jobApplications.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobApplications.domain.Interview;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.Time;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class RecordTimeDateInterviewController {

    private final JobOpeningRepository jobOpeningRepository;
    private final AuthorizationService authz;
    private final JobApplicationRepository jobApplicationRepository;

    public RecordTimeDateInterviewController(JobOpeningRepository jobOpeningRepository, AuthorizationService authz, JobApplicationRepository jobApplicationRepository) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
        this.jobApplicationRepository = jobApplicationRepository;
    }


    public List<JobOpening> jobOpeningsFromRepository() {

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.POWER_USER);
        ArrayList<JobOpening> jobOpenings = new ArrayList<>();
        jobOpeningRepository.findByCustomerManager(user.get()).forEach(jobOpening -> {
            jobOpenings.add(jobOpening);
        });

        return jobOpenings;

    }

    public List<JobApplication> getJobApplicationsByJobOpening(JobOpening jobOpening) {
        return jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);
    }


    public void editTimeDateInterview(JobApplication jobApplication, String time, String date) {
        jobs4u.base.jobApplications.domain.Date interviewDate = jobs4u.base.jobApplications.domain.Date.parse(date);
        Time interviewTime = Time.parse(time);
        Interview newInterview = new Interview(interviewDate, interviewTime);


        jobApplication.setInterview(newInterview);
    }

}




