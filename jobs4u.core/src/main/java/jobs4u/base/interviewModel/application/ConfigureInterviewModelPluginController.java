package jobs4u.base.interviewModel.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationIdentifier;
import jobs4u.base.interviewModel.domain.InterviewModelSpecificationJarFile;
import jobs4u.base.interviewModel.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecificationIdentifier;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

@UseCaseController
public class ConfigureInterviewModelPluginController {
    private final InterviewModelSpecificationRepository theRepository;
    private final AuthorizationService authz;

    public ConfigureInterviewModelPluginController(InterviewModelSpecificationRepository theRepository, AuthorizationService authz){
        this.theRepository = theRepository;
        this.authz = authz;
    }

    public InterviewModelSpecification configurePlugin(String identifier, String jarFile){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN, Jobs4uRoles.LANGUAGE_ENGINEER);

        InterviewModelSpecificationIdentifier interviewModelSpecificationIdentifier = InterviewModelSpecificationIdentifier.valueOf(identifier);
        // jarFile = JarPath + jarFile;
        InterviewModelSpecificationJarFile interviewModelSpecificationJarFile = InterviewModelSpecificationJarFile.valueOf(jarFile);
        InterviewModelSpecification specification = new InterviewModelSpecification(interviewModelSpecificationIdentifier, interviewModelSpecificationJarFile);

        return theRepository.save(specification);
    }
}
