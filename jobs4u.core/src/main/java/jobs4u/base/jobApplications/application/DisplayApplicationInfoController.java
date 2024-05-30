package jobs4u.base.jobApplications.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class DisplayApplicationInfoController {

    private final JobOpeningRepository jobOpeningRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final AuthorizationService authz;


    public DisplayApplicationInfoController(JobOpeningRepository jobOpeningRepository, AuthorizationService authz, JobApplicationRepository jobApplicationRepository) {
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


    public List<JobApplication> getApplicationsFromJobOpening(JobOpening jobOpening) {
        List<JobApplication> Applications = jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);
        return Applications;
    }



    public String seeAllData(JobApplication jobApplication) {

        // Create a SimpleDateFormat instance with your desired date format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Format the Calendar instance using the SimpleDateFormat
        String formattedDate = sdf.format(jobApplication.creationDate().getTime());

        StringBuilder info = new StringBuilder();
        info.append("Application ID: ").append(jobApplication.identity().toString()).append("\n");
        info.append("Application State: ").append(jobApplication.state().toString()).append("\n");
        info.append("Registration Date: ").append(formattedDate).append("\n");
        info.append("Candidate: ").append(jobApplication.candidate().name().toString()).append("\n");
        info.append("Job Opening: ").append(jobApplication.jobOpening().toString()).append("\n");
        info.append("Attached files:\n");
        for (JobApplicationFile file : jobApplication.files()) {
            info.append(file.getName()).append("\n");
        }
        if (jobApplication.interview() != null) {
            info.append("Interview Date: ").append(jobApplication.interview().date().toString()).append("\n");
            info.append("Interview Time: ").append(jobApplication.interview().time().toString()).append("\n");
        }
        if (jobApplication.requirementAnswer() != null) {
            info.append("Requirement Answer: ").append(jobApplication.requirementAnswer().result().toString()).append("\n");
        }

        return info.toString();
    }


}
