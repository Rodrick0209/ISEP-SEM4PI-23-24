package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.RecordTimeDateInterviewController;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;


public class RecordTimeDateInterviewUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(RecordTimeDateInterviewUI.class);

    private final RecordTimeDateInterviewController controller = new RecordTimeDateInterviewController(PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobApplications());


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
        List<JobApplication> jobApplications = controller.getJobApplicationsByJobOpening(selectedJobOpening);

        // Display job applications and ask user to choose one
        System.out.println("Please choose an application:");
        for (int i = 0; i < jobApplications.size(); i++) {
            System.out.println((i + 1) + ". " + jobApplications.get(i).getId() + " - "+jobApplications.get(i).getCandidate().name());
        }
        int jobApplicationIndex = Console.readOption(1, jobApplications.size(), -1) - 1;
        JobApplication selectedJobApplication = jobApplications.get(jobApplicationIndex);

        // Ask user to enter a date and time
        String date = Console.readLine("Please enter a date (yyyy-MM-dd):");

        String time = Console.readLine("Please enter a time (HH:mm):");

        // Parse the date and get the day of the week
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int confirmation;
        do {
            // Ask for confirmation
            System.out.println("Do you confirm that you want to schedule an interview for " + dayOfWeek + " day " + date + " at " + time + " hours?");
            System.out.println("1. Confirm");
            System.out.println("2. Cancel");
            confirmation = Console.readOption(1, 2, -1);

            if (confirmation == 1) {
                // Call the controller method with the selected job application, date and time
                try {
                    controller.editTimeDateInterview(selectedJobApplication,selectedJobOpening, time, date);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return false;
                } catch (ParseException e) {
                    System.out.println("Invalid date or time format. Please try again.");
                    return false;
                }
            } else if (confirmation == 2) {
                System.out.println("Appointment cancelled.");
                return false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }

        } while (confirmation != 1 && confirmation != 2);

        return true;
    }

    @Override
    public String headline() {
        return "Record Time and Date for Interview";
    }
}


