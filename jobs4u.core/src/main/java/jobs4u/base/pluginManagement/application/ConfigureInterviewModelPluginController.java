package jobs4u.base.pluginManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.pluginManagement.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

@UseCaseController
public class ConfigureInterviewModelPluginController {
    private final InterviewModelSpecificationRepository theRepository;
    private final AuthorizationService authz;

    public ConfigureInterviewModelPluginController(InterviewModelSpecificationRepository theRepository, AuthorizationService authz){
        this.theRepository = theRepository;
        this.authz = authz;
    }

    public InterviewModelSpecification configurePlugin(String identifier, String className){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.LANGUAGE_ENGINEER);


        InterviewModelSpecification specification = new InterviewModelSpecification(identifier, className);

        return theRepository.save(specification);
    }
}
