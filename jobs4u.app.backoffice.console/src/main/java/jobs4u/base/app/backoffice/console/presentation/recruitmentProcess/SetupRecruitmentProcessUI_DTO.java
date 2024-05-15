package jobs4u.base.app.backoffice.console.presentation.recruitmentProcess;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement.ListJobOpeningUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.recruitmentProcessManagement.application.SetupRecruitmentProcessController;
import jobs4u.base.recruitmentProcessManagement.application.SetupRecruitmentProcessControlllerWithDTO;
import jobs4u.base.recruitmentProcessManagement.dto.RecruitmentProcessDto;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SetupRecruitmentProcessUI_DTO extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetupRecruitmentProcessUI_DTO.class);
    private final SetupRecruitmentProcessControlllerWithDTO theController = new SetupRecruitmentProcessControlllerWithDTO(PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    private final ListJobOpeningUI listJobOpeningUI = new ListJobOpeningUI();

    @Override
    protected boolean doShow() {

        try {
            Scanner scanner = new Scanner(System.in);
            JobOpening jobOpening = listJobOpeningUI.selectJobOpeningFromList();
            List<List<Phases>> layouts = theController.getLayoutsRecruitmentProcess(jobOpening);
            printLayouts(layouts);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date;
            List<LocalDate> listDates = new LinkedList<>();
            LocalDate startDate;
            LocalDate endDate;
            int option;
            do {
                System.out.println("Select the layout you want to use");
                System.out.print("Option: ");
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline left-over
                if (option < 1 || option > layouts.size()) {
                    System.out.println("Invalid option");
                }

            } while (option < 1 || option > layouts.size());

            for (Phases phases : layouts.get(option - 1)) {
                System.out.println("Enter the start date for the " + phases.name() + " phase");
                System.out.print("Start date(dd/MM/yyyy): ");
                date = scanner.nextLine();
                startDate = LocalDate.parse(date, formatter);
                listDates.add(startDate);
                System.out.println("Enter the end date for the " + phases.name() + " phase");
                System.out.print("End date(dd/MM/yyyy): ");
                date = scanner.nextLine();
                endDate = LocalDate.parse(date, formatter);
                listDates.add(endDate);
            }

            if (listDates.size()==8) {
                theController.createRecruitmentProcess(new RecruitmentProcessDto(listDates.get(0), listDates.get(1), listDates.get(2), listDates.get(3), null,null, listDates.get(4), listDates.get(5), listDates.get(6), listDates.get(7)), jobOpening);
            }

            if (listDates.size()==10) {
                theController.createRecruitmentProcess(new RecruitmentProcessDto(listDates.get(0), listDates.get(1), listDates.get(2), listDates.get(3), listDates.get(4), listDates.get(5),listDates.get(6),listDates.get(7),listDates.get(8),listDates.get(9)), jobOpening);
            }

            System.out.println("Recruitment process criado com sucesso");


           /* String date;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("Enter the start date for the recruitment process and consequently its first phase date start");
            System.out.print("Start date(dd/MM/yyyy): ");
            date = scanner.nextLine();
            LocalDate applicationPhaseStartDate = LocalDate.parse(date, formatter);

            System.out.println("Enter the end date for the application phase");
            System.out.print("End date(dd/MM/yyyy): ");
            String firstStartDateInput = scanner.nextLine();
            LocalDate applicationPhaseEndDate = LocalDate.parse(date, formatter);

            System.out.println("Enter the start date for the resumeScreening phase");
            System.out.print("Start date(dd/MM/yyyy): ");
            date = scanner.nextLine();
            LocalDate resumeScreeningPhaseStartDate = LocalDate.parse(date, formatter);

            System.out.println("Enter the end date for the resumeScreening phase");
            System.out.print("Start date(dd/MM/yyyy): ");
            date = scanner.nextLine();
            LocalDate resumeScreeningPhaseEndDate = LocalDate.parse(date, formatter);

            System.out.println("Do you want to include Interview?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            LocalDate interviewPhaseStartDate = null;
            LocalDate interviewPhaseEndDate = null;
            if (option == 1) {
                System.out.println("Enter the start date for the interview phase");
                System.out.print("Start date(dd/MM/yyyy): ");
                date = scanner.nextLine();
                interviewPhaseStartDate = LocalDate.parse(date, formatter);

                System.out.println("Enter the end date for the interview phase");
                System.out.print("Start date(dd/MM/yyyy): ");
                date = scanner.nextLine();
                interviewPhaseEndDate = LocalDate.parse(date, formatter);
            }

            System.out.println("Enter the start date for the analysis phase");
            System.out.print("Start date(dd/MM/yyyy): ");
            date = scanner.nextLine();
            LocalDate analysisPhaseStartDate = LocalDate.parse(date, formatter);

            System.out.println("Enter the end date for the analysis phase");
            System.out.print("Start date(dd/MM/yyyy): ");
            date = scanner.nextLine();
            LocalDate analysisPhaseEndDate = LocalDate.parse(date, formatter);

            System.out.println("Enter the start date for the results phase");
            System.out.print("Start date(dd/MM/yyyy): ");
            date = scanner.nextLine();
            LocalDate resultsPhaseStartDate = LocalDate.parse(date, formatter);

            System.out.println("Enter the end date for the results phase");
            System.out.print("Start date(dd/MM/yyyy): ");
            date = scanner.nextLine();
            LocalDate resultsPhaseEndDate = LocalDate.parse(date, formatter);
*/
            //theController.createRecruitmentProcess(new RecruitmentProcessDto(applicationPhaseStartDate, applicationPhaseEndDate, resumeScreeningPhaseStartDate, resumeScreeningPhaseEndDate, interviewPhaseStartDate, interviewPhaseEndDate, analysisPhaseStartDate, analysisPhaseEndDate, resultsPhaseStartDate, resultsPhaseEndDate), jobOpening);

        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }

        return true;
    }

    public void printLayouts(List<List<Phases>> layouts) {
        int nr = 1;
        System.out.println("Layouts of the recruitment process");
        for (List<Phases> layout : layouts) {
            System.out.print("" + nr + ": ");
            for (Phases phase : layout) {
                System.out.print(phase.name() + "  ");

            }
            System.out.println();
            nr++;
        }


    }


    @Override
    public String headline() {
        return "Setup Recruitment Process";
    }
}


