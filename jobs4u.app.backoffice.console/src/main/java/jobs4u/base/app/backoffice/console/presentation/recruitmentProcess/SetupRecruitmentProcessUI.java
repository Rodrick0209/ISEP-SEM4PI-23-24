package jobs4u.base.app.backoffice.console.presentation.recruitmentProcess;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.ListJobOpeningUI;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.recruitmentProcessManagement.application.SetupRecruitmentProcessController;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SetupRecruitmentProcessUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(SetupRecruitmentProcessUI.class);

    private final SetupRecruitmentProcessController theController = new SetupRecruitmentProcessController();

    private final ListJobOpeningUI listJobOpeningUI = new ListJobOpeningUI();

    @Override
    protected boolean doShow() {
        try {
            Scanner scanner = new Scanner(System.in);
            JobOpening jobOpening = listJobOpeningUI.selectJobOpeningFromList();

            Map<Phases, Map<String, LocalDate>> phaseDates = new LinkedHashMap<>();
            for (Phases phase : Phases.values()) {
                if (phase == Phases.INTERVIEWS) {
                    System.out.print("Do you want to include the interviews phase? (yes/no): ");
                    String includeInterviews = scanner.nextLine();
                    if (!includeInterviews.equalsIgnoreCase("yes")) {
                        continue;
                    }
                }

                System.out.println("Enter the start date for the recruitment process and consequently its first phase in the format dd/MM/yyyy.");
                System.out.print("Start date(dd/MM/yyyy): ");
                String firstStartDateInput = scanner.nextLine();
                LocalDate previousEndDate = LocalDate.parse(firstStartDateInput);


                System.out.println("Enter the end date for the " + phase + " phase in the format dd/MM/yyyy.");

                LocalDate startDate = previousEndDate;
                LocalDate endDate = null;
                do {
                    System.out.println("Start date: " + startDate);

                    System.out.print("End date: ");
                    String endDateInput = scanner.nextLine();
                    endDate = LocalDate.parse(endDateInput);

                    if (endDate.compareTo(startDate) < 0) {
                        System.out.println("End date must be after start date. Please enter the dates again.");
                    }
                } while (endDate.compareTo(startDate) < 0);

                Map<String, LocalDate> dates = new HashMap<>();
                dates.put("start", startDate);
                dates.put("end", endDate);
                phaseDates.put(phase, dates);

                previousEndDate = endDate;
            }
            theController.createRecruitmentProcess(phaseDates, jobOpening);


            System.out.println("Recruitment process successfully created.");
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }







    @Override
    public String headline() {
        return "Setup Recruitment Process";
    }
}
