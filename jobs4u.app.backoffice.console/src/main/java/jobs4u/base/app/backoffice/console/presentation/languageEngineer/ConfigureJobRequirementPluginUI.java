package jobs4u.base.app.backoffice.console.presentation.languageEngineer;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobRequirement.application.ConfigureJobRequirementPluginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigureJobRequirementPluginUI extends AbstractUI {
    private final ConfigureJobRequirementPluginController theController = new ConfigureJobRequirementPluginController(PersistenceContext.repositories().jobRequirementsSpecification(), AuthzRegistry.authorizationService());

    private static final Logger LOGGER = LoggerFactory.getLogger(jobs4u.base.app.backoffice.console.presentation.languageEngineer.ConfigureJobRequirementPluginUI.class);
    @Override
    protected boolean doShow() {
       final String identifier = Console.readLine("Name->");

       final String jarFile = Console.readLine("Plugin (Jar File)->");

        try{
            this.theController.configurePlugin(identifier, jarFile);
            System.out.println("Job Requirement Specification configured successfully.");
        } catch (IntegrityViolationException | ConcurrencyException ex){
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Configure a Job Requirement Plugin";
    }
}
