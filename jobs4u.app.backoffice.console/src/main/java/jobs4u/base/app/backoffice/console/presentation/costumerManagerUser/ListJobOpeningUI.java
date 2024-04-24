//package jobs4u.base.app.backoffice.console.presentation.costumerManagerUser;
//
//import eapli.framework.io.util.Console;
//import eapli.framework.presentation.console.AbstractUI;
//import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import jobs4u.base.jobOpeningsManagement.application.ListJobOpeningContoller;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.List;
//
//public class ListJobOpeningUI extends AbstractUI {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.ListJobOpeningUI.class);
//
//    private final ListJobOpeningContoller theController = new ListJobOpeningContoller();
//
//    @Override
//    protected boolean doShow() {
//        boolean exit = false;
//        while (!exit) {
//            System.out.println("1. List all job openings");
//            System.out.println("2. List active job openings");
//            System.out.println("3. List job openings in a date range");
//            System.out.println("0. Exit");
//
//            int option = Console.readOption(0, 3, -1);
//
//            switch (option) {
//                case 1:
//                    listAllJobOpenings();
//                    break;
//                case 2:
//                    listActiveJobOpenings();
//                    break;
//                case 3:
//                    listJobOpeningsInDateRange();
//                    break;
//                case 0:
//                    exit = true;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//        return true;
//    }
//
//    private void listAllJobOpenings() {
//        List<JobOpeningDTO> allJobOpenings = theController.jobOpeningsFromRepository();
//        allJobOpenings.forEach(System.out::println);
//    }
//
//    private void listActiveJobOpenings() {
//        List<JobOpeningDTO> activeJobOpenings = theController.activeJobOpenings();
//        activeJobOpenings.forEach(System.out::println);
//    }
//
//    private void listJobOpeningsInDateRange() {
//        Date startDate = Console.readDate("Enter the start date (yyyy-MM-dd): ");
//        Date endDate = Console.readDate("Enter the end date (yyyy-MM-dd): ");
//        List<JobOpeningDTO> jobOpeningsInDateRange = theController.jobOpeningsInDateRange(convertToLocalDateViaInstant(startDate), convertToLocalDateViaInstant(endDate));
//        jobOpeningsInDateRange.forEach(System.out::println);
//    }
//
//    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
//        return dateToConvert.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//    }
//
//    @Override
//    public String headline() {
//        return "List job openings";
//    }
//}
