package jobs4u.base.pluginManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

public class ConfigureJobRequirementPluginController {
    private final JobRequirementSpecificationRepository theRepository;
    private final AuthorizationService authz;
    public ConfigureJobRequirementPluginController(JobRequirementSpecificationRepository theRepository, AuthorizationService authz){
        this.theRepository = theRepository;
        this.authz = authz;
    }

    public RequirementSpecification configurePlugin(String identifier, String className){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.LANGUAGE_ENGINEER);

        RequirementSpecification specification = new RequirementSpecification(identifier, className);

        return theRepository.save(specification);
    }
}
