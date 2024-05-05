package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import jobs4u.base.candidateManagement.application.RegisterCandidateController;
import jobs4u.base.candidateManagement.application.RegisterCandidateFactory;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import jobs4u.base.candidateManagement.domain.Candidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterCandidateUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCandidateUI.class);

    private final RegisterCandidateController controller = RegisterCandidateFactory.build();

    @Override
    protected boolean doShow() {

        String candidateName;

        System.out.println("Please insert the following information to register a new candidate");

        do {
            candidateName = Console.readLine("Candidate First Name->");
            // check if name doesnt include numbers
            if (candidateName.matches(".*\\d.*")) {
                System.out.println("\nInvalid first name. Please insert a valid first name.\n");
            }
        } while (candidateName.matches(".*\\d.*"));

        String candidateLastName;

        do {
            candidateLastName = Console.readLine("Candidate Last Name->");
            // check if name doesnt include numbers
            if (candidateLastName.matches(".*\\d.*")) {
                System.out.println("\nInvalid last name. Please insert a valid last name.\n");
            }
        } while (candidateLastName.matches(".*\\d.*"));

        String candidateEmail;

        do {
            candidateEmail = Console.readLine("Candidate Email->");
            // check if email is valid
            if (!candidateEmail.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                System.out.println("\nInvalid email. Please insert a valid email.\n");
            }
        } while (!candidateEmail.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"));


        String candidatePhoneNumber;

        do {
            candidatePhoneNumber = Console.readLine("Candidate Phone Number->");
            // check if phone number is valid
            if (!candidatePhoneNumber.matches("^9[0-9]{8}$")) {
                System.out.println("\nInvalid phone number. Please insert a valid phone number.\n");
            }
        } while (!candidatePhoneNumber.matches("^9[0-9]{8}$"));


        System.out.println("\n\n\nCandidate Information:\n");
        System.out.println("First Name: " + candidateName);
        System.out.println("Last Name: " + candidateLastName);
        System.out.println("Email: " + candidateEmail);
        System.out.println("Phone Number: " + candidatePhoneNumber);


        int option = Console.readInteger("\n\nDo you want to register this candidate? \n1-Yes\n2-No");
        while (option != 1 && option != 2) {
            System.out.println("\nInvalid option. Please insert a valid option.\n\n");
            option = Console.readInteger("\nDo you want to register this candidate? \n1-Yes\n2-No");
        }

        if (option == 1) {
            try {
                Candidate candidate = new Candidate(candidateName, candidateLastName, candidateEmail, candidatePhoneNumber);
                this.controller.registerCandidate(candidate);
            } catch (Exception ex) {
                LOGGER.error("Error performing the operation", ex);
                System.out.println(
                        "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }
        if (option == 2) {
            System.out.println("\nCandidate not registered.");
            option = Console.readInteger("Do you still want to register a candidate? \n\n1-Yes\n2-No");
            while (option != 1 && option != 2) {
                System.out.println("\nInvalid option. Please insert a valid option.\n\n");
                option = Console.readInteger("\n\nDo you still want to register a candidate? \n\n1-Yes\n2-No");
            }
            if (option == 1) {
                return doShow();
            }else
                return true;

        }
        return true;
    }

    @Override
    public String headline() {
        return "Register Candidate";
    }




}
