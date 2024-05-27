package jobs4u.base.recruitmentProcessManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.recruitmentProcessManagement.utils.State;

public class OpenClosePhaseController {


    private AuthorizationService authz;

    private JobOpeningRepository jobOpeningRepository;

    public OpenClosePhaseController(JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }

    public String getMessageAccordinglyWithPhaseState(JobOpening jobOpening) {
      //  return jobOpening.getRecruitmentProcess().messageForOpenClosePhase();
    return null;
    }

    public void changePhase(JobOpening jobOpening) {
        //jobOpening.changePhase();
        jobOpeningRepository.save(jobOpening);
    }

}
