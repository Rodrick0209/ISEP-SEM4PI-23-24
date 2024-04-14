package jobs4u.base.app.backoffice.console.presentation.clientuser;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.clientManagement.application.RegisterClientController;
import jobs4u.base.clientManagement.application.RegisterClientFactory;
import jobs4u.base.jobs4uusermanagement.application.AcceptRefuseSignupFactory;
import jobs4u.base.jobs4uusermanagement.application.AcceptRefuseSignupRequestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterClientUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterClientUI.class);

    private final RegisterClientController theController = RegisterClientFactory
            .build();

    @Override
    protected boolean doShow() {
        final String clientName = Console.readLine("Client Name");

        final String address = Console.readLine("Address");

        final String clientCode = Console.readLine("Client Code");

        final String clientRepresentativeName = Console.readLine("Client Representative Name");

        final String clientRepresentativeMail = Console.readLine("Client Representative Mail");

        final String clientRepresentativePhone = Console.readLine("Client Representative Phone");

        final String clientRepresentativePassword = Console.readLine("Client Representative Password");

        try {
        this.theController.registerClient(clientCode,clientName, clientRepresentativeMail, clientRepresentativePassword, clientRepresentativePhone,address);
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }


        return true;
    }







    @Override
    public String headline() {
        return "Register Client";
    }










}
