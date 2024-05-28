package jobs4u.base.app.backoffice.console.presentation.InterviewManagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.app.backoffice.console.presentation.ApplicationManagement.ListApplicationsUI;
import jobs4u.base.app.backoffice.console.presentation.recruitmentProcess.SetupRecruitmentProcessUI_DTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.RegisterCandidateFileWithAnswersToInterviewController;
import jobs4u.base.jobApplications.domain.JobApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterInterviewAnswerFileUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterInterviewAnswerFileUI.class);

    private final ListApplicationsUI listApplicationsUI = new ListApplicationsUI();

    private final RegisterCandidateFileWithAnswersToInterviewController controller = new RegisterCandidateFileWithAnswersToInterviewController(PersistenceContext.repositories().jobApplications(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        try {

            JobApplication applicationSelected = listApplicationsUI.selectApplicationToAnalyse();

            String fileName = Console.readLine("Answer File name");
            controller.registerCandidateFileWithAnswers(fileName, applicationSelected);
            System.out.println("Answer File registered successfully");
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Register Interview Answer File";
    }

}
