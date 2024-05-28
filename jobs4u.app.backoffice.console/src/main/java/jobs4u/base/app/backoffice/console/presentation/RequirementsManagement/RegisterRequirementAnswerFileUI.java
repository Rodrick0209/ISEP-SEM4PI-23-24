package jobs4u.base.app.backoffice.console.presentation.RequirementsManagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.app.backoffice.console.presentation.ApplicationManagement.ListApplicationsUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.RegisterCandidateFileWIthRequirementAnswersController;
import jobs4u.base.jobApplications.domain.JobApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterRequirementAnswerFileUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterRequirementAnswerFileUI.class);

    ListApplicationsUI listApplicationsUI = new ListApplicationsUI();

    RegisterCandidateFileWIthRequirementAnswersController controller = new RegisterCandidateFileWIthRequirementAnswersController(PersistenceContext.repositories().jobApplications(), AuthzRegistry.authorizationService());


    @Override
    protected boolean doShow() {

        try {
            JobApplication applicationSelected = listApplicationsUI.selectApplicationToAnalyse();
            if (applicationSelected == null) {
                return false;
            }
            String fileName = Console.readLine("Requirement Answer File name");
            controller.registerCandidateFileWithAnswers(fileName, applicationSelected);

            System.out.println("Requirement Answer File registered successfully");
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }

        return true;
    }


    @Override
    public String headline() {
        return "Register Requirements Answer File";
    }


}
