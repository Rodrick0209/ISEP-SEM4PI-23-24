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
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class RecordTimeDateInterviewUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(RecordTimeDateInterviewUI.class);

    private final RecordTimeDateInterviewController controller = new RecordTimeDateInterviewController(PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobApplications());


    @Override
    protected boolean doShow() {
        Scanner scanner = new Scanner(System.in);

        // Get all job openings
        List<JobOpening> jobOpenings = controller.jobOpeningsFromRepository();

        // Display job openings and ask user to choose one
        System.out.println("Please choose a job opening:");
        for (int i = 0; i < jobOpenings.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpenings.get(i));
        }
        int jobOpeningIndex = scanner.nextInt() - 1;
        JobOpening selectedJobOpening = jobOpenings.get(jobOpeningIndex);

        // Get all job applications for the selected job opening
        List<JobApplication> jobApplications = controller.getJobApplicationsByJobOpening(selectedJobOpening);

        // Display job applications and ask user to choose one
        System.out.println("Please choose an application:");
        for (int i = 0; i < jobApplications.size(); i++) {
            System.out.println((i + 1) + ". " + jobApplications.get(i));
        }
        int jobApplicationIndex = scanner.nextInt() - 1;
        JobApplication selectedJobApplication = jobApplications.get(jobApplicationIndex);

        // Ask user to enter a date and time
        String date;
        String time;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false);

        while (true) {
            System.out.println("Please enter a date (yyyy-MM-dd):");
            date = scanner.next();
            try {
                dateFormat.parse(date);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        while (true) {
            System.out.println("Please enter a time (HH:mm):");
            time = scanner.next();
            try {
                timeFormat.parse(time);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please try again.");
            }
        }

        // Call the controller method with the selected job application, date and time
        controller.editTimeDateInterview(selectedJobApplication, time, date);

        return true;
    }


    @Override
    public String headline() {
        return "Record Time and Date for Interview";
    }
}


