package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import jobs4u.base.candidateManagement.application.RegisterCandidateController;
import jobs4u.base.candidateManagement.application.RegisterCandidateFactory;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterCandidateUI extends AbstractUI{

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCandidateUI.class);

    private final RegisterCandidateController controller = RegisterCandidateFactory.build();

    @Override
    protected boolean doShow() {

        final String candidateName = Console.readLine("Candidate First Name->");
        final String candidateLastName = Console.readLine("Candidate surname->");

        final String candidateEmail = Console.readLine("Candidate Email Address->");

        final String candidatePhoneNumber = Console.readLine("Candidate Phone Number->");

        try {
            this.controller.registerCandidate(candidateName, candidateLastName, candidateEmail, candidatePhoneNumber);
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Register Candidate";
    }



}
