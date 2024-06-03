package jobs4u.base.app.backoffice.console.presentation.recruitmentProcess;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement.ListJobOpeningUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.recruitmentProcessManagement.application.OpenClosePhaseController;
import jobs4u.base.recruitmentProcessManagement.application.SetupRecruitmentProcessControlllerWithDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OpenClosePhaseUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenClosePhaseUI.class);
    private final OpenClosePhaseController theController = new OpenClosePhaseController(PersistenceContext.repositories().jobOpenings(), PersistenceContext.repositories().jobApplications(),AuthzRegistry.authorizationService());

    private final ListJobOpeningUI listJobOpeningUI = new ListJobOpeningUI();


    @Override
    protected boolean doShow() {
        try {
            JobOpening jobOpening = listJobOpeningUI.selectJobOpeningFromList();
            System.out.println("Selected job opening: " + jobOpening.toString());
            List<JobApplication> jobApplications = theController.getJobApplicationsByJobOpening(jobOpening);
            System.out.println("Selected job applications: " + jobApplications.toString());

            System.out.println(theController.getMessageAccordinglyWithPhaseState(jobOpening,jobApplications));
            final int option = Console.readOption(1, 2, 0);
            if (option == 1) {
                theController.changePhase(jobOpening,jobApplications);
            } else if (option == 2) {
                System.out.println("Exiting");
            }else {
                System.out.println("No valid option selected");
            }

            System.out.println("Phase changed successfully");
        } catch (Exception e) {
            System.out.println("An error occurred. Please check the logs.");
            LOGGER.error(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Open/Close Phase";
    }


}
