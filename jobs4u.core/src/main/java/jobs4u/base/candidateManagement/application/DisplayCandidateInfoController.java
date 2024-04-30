package jobs4u.base.candidateManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DisplayCandidateInfoController {
    private final CandidateRepository candidateRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private AuthorizationService authz;

    public DisplayCandidateInfoController(CandidateRepository candidateRepository, JobApplicationRepository jobApplicationRepository, JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.candidateRepository = candidateRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }

    public List<Candidate> candidates() {
        List<Candidate> candidates = new ArrayList<>();

        candidateRepository.findAll().forEach(candidates::add);
        return candidates;
    }

    public String getCandidateInfo(Candidate candidate) {
        StringBuilder info = new StringBuilder();

        info.append("Name: ").append(candidate.name().toString()).append("\n");
        info.append("Email: ").append(candidate.emailAddress().toString()).append("\n");
        info.append("Phone Number: ").append(candidate.phoneNumber().toString()).append("\n");


        return info.toString();
    }

    public List<JobApplication> getCandidateApplications(Candidate candidate) {
        List<JobApplication> candidateApplications = new ArrayList<>();
        jobApplicationRepository.findJobApplicationsByCandidate(candidate).forEach(candidateApplications::add);
        return candidateApplications;
    }

    public String getJobApplicationInfo(JobApplication jobApplication) {
        StringBuilder info = new StringBuilder();

        info.append("Application ID: ").append(jobApplication.identity().toString()).append("\n");
        info.append("Application State: ").append(jobApplication.getState().toString()).append("\n");
        info.append("Registration Date: ").append(jobApplication.getCreationDate().toString()).append("\n");

        return info.toString();
    }


    public List<JobOpening> jobOpeningsFromRepository() {

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.POWER_USER);
        ArrayList<JobOpening> jobOpenings = new ArrayList<>();
        jobOpeningRepository.findByCustomerManager(user.get()).forEach(jobOpening -> {
            jobOpenings.add(jobOpening);
        });

        return jobOpenings;

    }

    public List<JobApplication> getCandidateApplicationsFromJobOpening(JobOpening jobOpening) {
        List<JobApplication> candidateApplications = jobOpening.jobApplications();
        return candidateApplications;
    }



}
