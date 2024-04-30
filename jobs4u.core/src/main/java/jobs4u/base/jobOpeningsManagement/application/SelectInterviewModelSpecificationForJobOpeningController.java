package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.interviewModel.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

@UseCaseController
public class SelectInterviewModelSpecificationForJobOpeningController {
    private final JobOpeningRepository jobOpeningRepository;
    private final InterviewModelSpecificationRepository interviewModelSpecificationRepository;
    private final AuthorizationService authz;

    public SelectInterviewModelSpecificationForJobOpeningController(JobOpeningRepository jobOpeningRepository, InterviewModelSpecificationRepository interviewModelSpecificationRepository, AuthorizationService authz){
        this.jobOpeningRepository = jobOpeningRepository;
        this.interviewModelSpecificationRepository = interviewModelSpecificationRepository;
        this.authz = authz;
    }

    public Iterable<JobOpening> listJobOpenings(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

        return this.jobOpeningRepository.findAll();
    }

    public Iterable<InterviewModelSpecification> listInterviewModelsSpecification(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

        return this.interviewModelSpecificationRepository.findAll();
    }

    public JobOpening selectInterviewModelSpecificationForJobOpening(InterviewModelSpecification interviewModelSpecification, JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
        return this.jobOpeningRepository.save(jobOpening);
    }

}
