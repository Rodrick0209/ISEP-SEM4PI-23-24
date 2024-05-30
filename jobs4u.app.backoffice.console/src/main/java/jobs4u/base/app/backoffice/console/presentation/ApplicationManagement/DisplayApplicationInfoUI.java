package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.DisplayApplicationInfoController;
import jobs4u.base.jobApplications.application.RecordTimeDateInterviewController;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class DisplayApplicationInfoUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayApplicationInfoUI.class);

    private final DisplayApplicationInfoController controller = new DisplayApplicationInfoController(PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobApplications());


    @Override
    protected boolean doShow() {


        // Get all job openings
        List<JobOpening> jobOpenings = controller.jobOpeningsFromRepository();

        // Display job openings and ask user to choose one
        System.out.println("Please choose a job opening:");
        for (int i = 0; i < jobOpenings.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpenings.get(i).jobReference() + " - " + jobOpenings.get(i).function());
            ;
        }
        int jobOpeningIndex = Console.readOption(1, jobOpenings.size(), -1) - 1;
        JobOpening selectedJobOpening = jobOpenings.get(jobOpeningIndex);

        // Get all job applications for the selected job opening
        List<JobApplication> jobApplications = controller.getApplicationsFromJobOpening(selectedJobOpening);

        // Display job applications and ask user to choose one
        System.out.println("Please choose an application:");
        for (int i = 0; i < jobApplications.size(); i++) {
            System.out.println((i + 1) + ". " + jobApplications.get(i));
        }
        int jobApplicationIndex = Console.readOption(1, jobApplications.size(), -1) - 1;
        JobApplication selectedJobApplication = jobApplications.get(jobApplicationIndex);


        // Display all data of the selected application
        String applicationData = controller.seeAllData(selectedJobApplication);
        System.out.println(applicationData);

        return true;
    }

    @Override
    public String headline() {
        return "See all data of an application";
    }
}
