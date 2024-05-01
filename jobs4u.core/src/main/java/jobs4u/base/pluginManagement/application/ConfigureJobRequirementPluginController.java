package jobs4u.base.pluginManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

public class ConfigureJobRequirementPluginController {
    private final JobRequirementSpecificationRepository theRepository;
    private final AuthorizationService authz;
    public ConfigureJobRequirementPluginController(JobRequirementSpecificationRepository theRepository, AuthorizationService authz){
        this.theRepository = theRepository;
        this.authz = authz;
    }

    public JobRequirementSpecification configurePlugin(String identifier, String className){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.LANGUAGE_ENGINEER);

        JobRequirementSpecification specification = new JobRequirementSpecification(identifier, className);

        return theRepository.save(specification);
    }
}
