package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

@UseCaseController
public class SelectJobRequirementSpecificationForJobOpeningController {

    private final JobRequirementSpecificationRepository jobRequirementSpecificationRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final AuthorizationService authz;

    public SelectJobRequirementSpecificationForJobOpeningController(JobRequirementSpecificationRepository jobRequirementSpecificationRepository, JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobRequirementSpecificationRepository = jobRequirementSpecificationRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }

    public Iterable<JobOpening> listJobOpenings(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

        return this.jobOpeningRepository.findAll();
    }

    public Iterable<RequirementSpecification> listJobRequirementsSpecification(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

        return this.jobRequirementSpecificationRepository.findAll();
    }

    public JobOpening selectJobRequirementSpecificationForJobOpening(RequirementSpecification requirementSpecification, JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.selectJobRequirementSpecification(requirementSpecification);
        return this.jobOpeningRepository.save(jobOpening);
    }


}
