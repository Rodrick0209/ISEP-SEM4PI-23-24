package jobs4u.base.app.backoffice.console.presentation.costumerManagerUser;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jobs4u.base.jobOpeningsManagement.application.ListJobOpeningContoller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.ListJobOpeningUI.class);

    private final ListJobOpeningContoller theController = new ListJobOpeningContoller(PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. List all job openings");
            System.out.println("2. List active job openings");
            System.out.println("3. List job openings in a date range");
            System.out.println("4. List active job openings in a date range");
            System.out.println("0. Exit");

            int option = Console.readOption(0, 4, -1);

            switch (option) {
                case 1:
                    listAllJobOpenings();
                    break;
                case 2:
                    listActiveJobOpenings();
                    break;
                case 3:
                    listJobOpeningsInDateRange();
                    break;
                case 4:
                    listActiveJobOpeningsInDateRange();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        return true;
    }

    private void listAllJobOpenings() {
        List<JobOpening> allJobOpenings = theController.jobOpeningsFromRepository();
        allJobOpenings.forEach(System.out::println);
    }

    private void listActiveJobOpenings() {
        List<JobOpening> activeJobOpenings = theController.activeJobOpenings();
        activeJobOpenings.forEach(System.out::println);
    }

    private void listJobOpeningsInDateRange() {
        Calendar startDate = Console.readCalendar("Enter the start date (dd-MM-yyyy): ");
        Calendar endDate = Console.readCalendar("Enter the end date (dd-MM-yyyy): ");
        List<JobOpening> jobOpeningsInDateRange = theController.jobOpeningsInDateRange(startDate,endDate);
        jobOpeningsInDateRange.forEach(System.out::println);
    }

    private void listActiveJobOpeningsInDateRange() {
        Calendar startDate = Console.readCalendar("Enter the start date (dd-MM-yyyy): ");
        Calendar endDate = Console.readCalendar("Enter the end date (dd-MM-yyyy): ");
        List<JobOpening> activeJobOpeningsInDateRange = theController.activeJobOpeningsInDateRange(startDate, endDate);
        activeJobOpeningsInDateRange.forEach(System.out::println);
    }


    @Override
    public String headline() {
        return "List job openings";
    }
}
