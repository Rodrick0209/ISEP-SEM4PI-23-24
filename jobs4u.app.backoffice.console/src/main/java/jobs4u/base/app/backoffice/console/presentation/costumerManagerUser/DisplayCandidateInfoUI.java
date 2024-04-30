//package jobs4u.base.app.backoffice.console.presentation.costumerManagerUser;
//
//import eapli.framework.actions.Action;
//import eapli.framework.infrastructure.authz.application.AuthzRegistry;
//import eapli.framework.io.util.Console;
//import eapli.framework.presentation.console.AbstractUI;
//import jobs4u.base.candidateManagement.application.DisplayCandidateInfoController;
//import jobs4u.base.candidateManagement.domain.Candidate;
//import jobs4u.base.infrastructure.persistence.PersistenceContext;
//import jobs4u.base.jobAplications.domain.JobApplication;
//import jobs4u.base.jobOpeningsManagement.application.RegisterJobOpeningController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//public class DisplayCandidateInfoUI extends AbstractUI {
//
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.DisplayCandidateInfoUI.class);
//
//
//    private final DisplayCandidateInfoController theController = new DisplayCandidateInfoController(PersistenceContext.repositories().candidates());
//
//    @Override
//    protected boolean doShow() {
//        boolean exit = false;
//        while (!exit) {
//            System.out.println("1. See all candidates");
//            System.out.println("2. Select candidate by Job Opening");
//            System.out.println("0. Exit");
//
//            int option = Console.readOption(0, 2, -1);
//
//            switch (option) {
//                case 1:
//                    seeAllCandidates();
//                    break;
//                case 2:
//                    //selectCandidateByJobOpening();
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
//    private void displayApplicationDetails(Candidate candidate) {
//        // List all applications
//        for (int i = 0; i < candidate.applications().size(); i++) {
//            System.out.println((i + 1) + ". " + candidate.applications().get(i).toString());
//        }
//
//        // Ask the user to select an application
//        int applicationIndex = Console.readOption(1, candidate.applications().size(), -1) - 1;
//        JobApplication selectedApplication = candidate.applications().get(applicationIndex);
//
//        // Display the selected application's details
//        System.out.println(selectedApplication.toString());
//    }
//
//    private void seeAllCandidates() {
//        List<Candidate> candidates = theController.candidates();
//
//        // List all candidate emails
//        for (int i = 0; i < candidates.size(); i++) {
//            System.out.println((i + 1) + ". " + candidates.get(i).emailAddress().toString());
//        }
//
//        // Ask the user to select a candidate
//        int candidateIndex = Console.readOption(1, candidates.size(), -1) - 1;
//        Candidate selectedCandidate = candidates.get(candidateIndex);
//
//        // Display the selected candidate's information
//        System.out.println(theController.getCandidateInfo(selectedCandidate));
//
//        // Display the selected candidate's application details
//        displayApplicationDetails(selectedCandidate);
//    }
//
//    @Override
//    public String headline() {
//        return "Display Candidate Information";
//    }
//}
