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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        jobOpeningRepository.findJobOpeningsWithInterviewPhaseByCustomer(user.get()).forEach(jobOpening -> {
            jobOpenings.add(jobOpening);
        });

        return jobOpenings;

    }

    public List<JobApplication> getJobApplicationsByJobOpening(JobOpening jobOpening) {
        return jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);
    }


    public void editTimeDateInterview(JobApplication jobApplication, String time, String date) throws ParseException {
        jobs4u.base.jobApplications.domain.Date interviewDate = jobs4u.base.jobApplications.domain.Date.valueOf(date);

        Time interviewTime = Time.valueOf(time);

        Interview newInterview = new Interview(interviewDate, interviewTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false);

        Date currentDate = new Date();
        Date inputDate = dateFormat.parse(date);
        Date inputTime = timeFormat.parse(time);

        if (inputDate.before(currentDate)) {
            throw new IllegalArgumentException("The date cannot be in the past.");
        }

        if (inputDate.equals(currentDate) && inputTime.before(new Date())) {
            throw new IllegalArgumentException("The time cannot be in the past.");
        }

        jobApplication.setInterview(newInterview);
    }

}




