package jobs4u.base.app.backoffice.console.presentation.costumerManagerUser;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.RegisterJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningFactory;
import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.ClientCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ConfigTreeConfigDataLoader;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class RegisterJobOpeningUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.RegisterJobOpeningUI.class);


    private final RegisterJobOpeningController theController = new RegisterJobOpeningController(PersistenceContext.repositories().jobOpenings(),
            PersistenceContext.repositories().clients(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        final ClientDTO client = selectClient(this.theController.getAllClients());
        if (client == null) {
            return false;
        }

        final WorkingMode workingMode = requestWorkingMode();

        final String nrVacancy = String.valueOf(Console.readLong("Number of Vacancies->"));

        final String address = Console.readLine("Client postal Address->");

        final String description = Console.readLine("Job Description->");

        final String function = Console.readLine("Job Function->");

        final ContractType contractType = requestContractType();


        try {
            this.theController.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType, client);
            System.out.println("Job Opening registered successfully.");

        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }


        return true;
    }


    @Override
    public String headline() {
        return "Register A Job Opening";
    }


    private WorkingMode requestWorkingMode() {
        System.out.println("Please select the desired working mode:");
        System.out.println("1. Remote");
        System.out.println("2. Hybrid");
        System.out.println("3. Onsite");

        int option = Console.readOption(1, 3, 0);

        switch (option) {
            case 1:
                return WorkingMode.REMOTE;
            case 2:
                return WorkingMode.HYBRID;
            case 3:
                return WorkingMode.ONSITE;
            default:
                System.out.println("Invalid option. Please try again.");
                return requestWorkingMode();
        }
    }


    private ContractType requestContractType() {
        System.out.println("Please select the desired working mode:");
        System.out.println("1. Full time");
        System.out.println("2. Part time");

        int option = Console.readOption(1, 2, 0);

        switch (option) {
            case 1:
                return ContractType.FULL_TIME;
            case 2:
                return ContractType.PART_TIME;
            default:
                System.out.println("Invalid option. Please try again.");
                return requestContractType();
        }
    }

    private ClientDTO selectClient(List<ClientDTO> clients) {
        int optionNumber = 1;
        if (clients.isEmpty()) {
            System.out.println("No clients available. Please register a client first.");
            return null; // return -1 or any invalid value to indicate no selection could be made
        }

        for (ClientDTO client : clients) {
            System.out.println(optionNumber + ". " + client.name + " (Code: "+client.clientCode+")");
            optionNumber++;
        }

        System.out.println("Please select a client:");
        int selectedOption = Console.readOption(1, clients.size(), -1); // read the user's selection

        return clients.get(selectedOption - 1);
    }
}
