package jobs4u.base.candidateManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.client.FollowUpServerProxy;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;

import java.net.PasswordAuthentication;


public class NotifyCandidatesVerificationProcessController {

    JobOpeningRepository jobOpeningRepository;
    AuthorizationService authz;

    public NotifyCandidatesVerificationProcessController(AuthorizationService authz, JobOpeningRepository jobOpeningRepository) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }


    public Iterable<JobOpening> getJobOpenings() {

        return jobOpeningRepository.findInFinishedScreeningPhase();

    }

    public boolean notifyCandidatesVerificationProcess(JobOpening jobOpening) {

        FollowUpServerProxy followUpServerProxy = new FollowUpServerProxy();
        return followUpServerProxy.notifyCandidatesVerificationProcess(jobOpening);


    }


}
