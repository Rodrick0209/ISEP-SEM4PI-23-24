package jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.EditJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.PostalAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EditJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(EditJobOpeningUI.class);
    private final EditJobOpeningController controller = new EditJobOpeningController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobOpenings(), PersistenceContext.repositories().clients());

    @Override
    protected boolean doShow() {
        final List<JobOpening> jobOpenings = controller.inactiveJobOpenings();
        if (jobOpenings == null) {
            System.out.println("No inactive job openings found");
            return true;
        }
        final SelectWidget<JobOpening> jobOpeningSelector = new SelectWidget<>("Select a Inactive Job Opening", jobOpenings);
        jobOpeningSelector.show();
        final JobOpening jobOpening = jobOpeningSelector.selectedElement();

        selectAttributesToEdit(jobOpening);
        return true;
    }

    @Override
    public String headline() {
        return "Edit a Job Opening";
    }

    private void selectAttributesToEdit(JobOpening jobOpening) {
        System.out.println("Select the attribute to edit:");
        System.out.println("1. Working Mode");
        System.out.println("2. Number of vacancies");
        System.out.println("3. Address");
        System.out.println("4. Description");
        System.out.println("5. Function");
        System.out.println("6. Contract Type");

        int option = Console.readOption(1, 6, 0);

        switch (option) {
            case 1:
                WorkingMode workingMode = selectNewWorkingMode();
                try {
                    controller.edit(jobOpening, workingMode);
                    successfulEdit();
                } catch (IntegrityViolationException | ConcurrencyException ex) {
                    LOGGER.error("Error performing the operation", ex);
                    System.out.println(
                            "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                }
                break;
            case 2:
                promptNewNumberVacancies(jobOpening);
                break;
            case 3:
                promptNewAddress(jobOpening);
                break;
            case 4:
                promptNewDescription(jobOpening);
                break;
            case 5:
                promptNewFunction(jobOpening);
                break;
            case 6:
                ContractType contractType = selectNewContractType();
                try {
                    controller.edit(jobOpening, contractType);
                    successfulEdit();
                } catch (IntegrityViolationException | ConcurrencyException ex) {
                    LOGGER.error("Error performing the operation", ex);
                    System.out.println(
                            "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private WorkingMode selectNewWorkingMode() {
        System.out.println("Select new working mode:");
        System.out.println("1. Remote");
        System.out.println("2. Hybrid");
        System.out.println("3. Onsite");

        int option = Console.readOption(1, 3, -1);

        switch (option) {
            case 1:
                return WorkingMode.REMOTE;
            case 2:
                return WorkingMode.HYBRID;
            case 3:
                return WorkingMode.ONSITE;
            default:
                System.out.println("Invalid option. Please try again.");
                return selectNewWorkingMode();
        }
    }

    private void promptNewNumberVacancies(JobOpening jobOpening) {
        String numberVacancies = Console.readLine("Input the new number of vacancies: ");
        NrVacancy newNumberVacancies = NrVacancy.valueOf(numberVacancies);
        try {
            controller.edit(jobOpening, newNumberVacancies);
            successfulEdit();
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }
    }

    private void promptNewAddress(JobOpening jobOpening) {
        String address = Console.readLine("Input the new address: ");
        PostalAddress newAddress = PostalAddress.valueOf(address);
        try {
            controller.edit(jobOpening, newAddress);
            successfulEdit();
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }
    }

    private void promptNewDescription(JobOpening jobOpening) {
        String description = Console.readLine("Input the new description: ");
        Description newDescription = Description.valueOf(description);
        try {
            controller.edit(jobOpening, newDescription);
            successfulEdit();
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }
    }

    private void promptNewFunction(JobOpening jobOpening) {
        String function = Console.readLine("Input the new function: ");
        Designation newFunction = Designation.valueOf(function);
        try {
            controller.edit(jobOpening, newFunction);
            successfulEdit();
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }
    }

    private ContractType selectNewContractType() {
        System.out.println("Select new contract type:");
        System.out.println("1. Full time");
        System.out.println("2. Part time");

        int option = Console.readOption(1, 2, -1);

        switch (option) {
            case 1:
                return ContractType.FULL_TIME;
            case 2:
                return ContractType.PART_TIME;
            default:
                System.out.println("Invalid option. Please try again.");
                return selectNewContractType();
        }
    }

    private void successfulEdit() {
        System.out.println("Job Opening edited successfully!");
    }
}
