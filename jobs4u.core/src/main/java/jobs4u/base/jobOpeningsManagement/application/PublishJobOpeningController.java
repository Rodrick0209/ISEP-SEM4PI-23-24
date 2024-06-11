package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.client.FollowUpServerProxy;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.List;

public class PublishJobOpeningController {

    private AuthorizationService authz;
    private JobOpeningRepository jobOpeningRepository;
    private JobApplicationRepository jobApplicationRepository;



    public PublishJobOpeningController(AuthorizationService authz, JobOpeningRepository jobOpeningRepository, JobApplicationRepository jobApplicationRepository){
        this.authz = authz;
        this.jobOpeningRepository = jobOpeningRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public List<JobOpening> getJobOpenings(){

        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);



        //return jobOpeningRepository.findInResultPhase();

        return (List<JobOpening>) jobOpeningRepository.findAll();
    }

    public void publishJobOpeningResults(JobOpening jobOpening){

        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        FollowUpServerProxy followUpServerProxy = new FollowUpServerProxy();


        followUpServerProxy.sendResultEmailRequest(jobOpening);

        //jobOpening.recruitmentProcess().closePhase(jobOpening.recruitmentProcess().resultPhase());

        //jobOpeningRepository.save(jobOpening);

    }

}
