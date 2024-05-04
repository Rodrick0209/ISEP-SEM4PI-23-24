package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.candidateManagement.application.DisplayCandidateInfoController;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DisplayCandidateInfoUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayCandidateInfoUI.class);


    private final DisplayCandidateInfoController theController = new DisplayCandidateInfoController(PersistenceContext.repositories().candidates(), PersistenceContext.repositories().jobApplications(), PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    // ... existing code ...

    @Override
    protected boolean doShow() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. See all candidates");
            System.out.println("2. Select candidate trough a Job Opening");
            System.out.println("0. Exit");

            int option = Console.readOption(0, 2, -1);

            switch (option) {
                case 1:
                    selectCandidateFromList();
                    break;
                case 2:
                    selectCandidateByJobOpening();
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

    private void selectCandidateFromList() {
        List<Candidate> candidates = theController.candidates();
        if (candidates.isEmpty()) {
            System.out.println("There are no candidates to display.");
            return;
        }
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).name());
        }

        int selectedOption = Console.readOption(1, candidates.size(), -1);

        Candidate selectedCandidate = candidates.get(selectedOption - 1);
        System.out.println(theController.getCandidateInfo(selectedCandidate));
        selectApplicationFromList(selectedCandidate);
    }

    private void selectApplicationFromList(Candidate candidate) {
        List<JobApplication> applications = theController.getCandidateApplications(candidate);
        if (applications.isEmpty()) {
            System.out.println("There are no applications to display.");
            return;
        }
        for (int i = 0; i < applications.size(); i++) {
            JobOpening jobOpening = theController.getJobOpeningByJobApplication(applications.get(i));
            System.out.println((i + 1) + ". " + jobOpening.identity());
        }
        int selectedOption = Console.readOption(1, applications.size(), -1);
        JobApplication selectedApplication = applications.get(selectedOption - 1);
        System.out.println("From job opening: \n");
        System.out.println(theController.getJobApplicationInfo(selectedApplication));
    }



    private void selectCandidateByJobOpening() {
        List<JobOpening> jobOpenings = theController.jobOpeningsFromRepository();
        if (jobOpenings.isEmpty()) {
            System.out.println("There are no jobOpenings to display.");
            return;
        }
        for (int i = 0; i < jobOpenings.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpenings.get(i).jobReference() + " - " + jobOpenings.get(i).function());
        }
        int selectedOption = Console.readOption(1, jobOpenings.size(), -1);
        JobOpening selectedJobOpening = jobOpenings.get(selectedOption - 1);
        selectApplicationFromJobOpeningList(selectedJobOpening);
    }

    private void selectApplicationFromJobOpeningList(JobOpening jobOpening) {
        List<JobApplication> applications = theController.getCandidateApplicationsFromJobOpening(jobOpening);
        if (applications.isEmpty()) {
            System.out.println("There are no applications to display.");
            return;
        }
        for (int i = 0; i < applications.size(); i++) {
            System.out.println((i + 1) + ". " + applications.get(i).identity() + " - " + applications.get(i).candidate().name());
        }

        int selectedOption = Console.readOption(1, applications.size(), -1);
        JobApplication selectedApplication = applications.get(selectedOption - 1);
        System.out.println("From job opening: \n");
        System.out.println(theController.getJobApplicationInfo(selectedApplication));
        System.out.println("From candidate: ");
        System.out.println(theController.getCandidateInfo(selectedApplication.candidate()));
    }


    @Override
    public String headline() {
        return "Display Candidate Information";
    }
}
