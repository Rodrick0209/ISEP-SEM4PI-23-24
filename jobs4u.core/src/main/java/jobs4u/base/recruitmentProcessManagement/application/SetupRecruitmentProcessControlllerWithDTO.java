package jobs4u.base.recruitmentProcessManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcessBuilder;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcessDirector;
import jobs4u.base.recruitmentProcessManagement.dto.RecruitmentProcessDto;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.List;

public class SetupRecruitmentProcessControlllerWithDTO {


    private AuthorizationService authz;


    private JobOpeningRepository jobOpeningRepository;


    public SetupRecruitmentProcessControlllerWithDTO(JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }

    public void ensureJobOpeningSelectedIsAvailableForRecruitmentProcess(JobOpening jobOpening) {
        jobOpening.validateCanAddOrChangeRecruitmentProcess();
    }


    public void createRecruitmentProcess(RecruitmentProcessDto recruitmentProcessDto, JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.ADMIN);
        ensureJobOpeningSelectedIsAvailableForRecruitmentProcess(jobOpening);
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        jobOpening.addRecruitmentProcess(recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto));
        jobOpeningRepository.save(jobOpening);

    }


    public List<List<Phases>> getLayoutsRecruitmentProcess(JobOpening jobOpening){
        return jobOpening.layoutsRecruitmentProcess();
    }








}
