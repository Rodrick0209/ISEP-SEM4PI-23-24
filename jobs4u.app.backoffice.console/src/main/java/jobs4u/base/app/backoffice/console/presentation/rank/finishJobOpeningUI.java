package jobs4u.base.app.backoffice.console.presentation.rank;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.rankManagement.application.RankJobOpeningController;
import jobs4u.base.rankManagement.domain.Rank;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class finishJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(finishJobOpeningUI.class);

    private final RankJobOpeningController theController = new RankJobOpeningController();

    @Override
    protected boolean doShow() {

        JobOpening jobOpening = listAndSelectJobOpenings();

        if (jobOpening == null) {
            return false;
        }
        System.out.println("\n");
        System.out.println("Rank:");
        System.out.println(jobOpening.getRank().toString());
        System.out.println("\n");


        if (!jobOpening.getRank().isRankCompleted()){
            System.out.println("The rank is not completed. Please complete the rank before finishing the job opening.");
            return false;
        }
        System.out.println("Do you want to finish this rank phase? (1/2)");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int option = Console.readOption(1, 2, -1);
        if (option == 1) {
            boolean flag = theController.finishRankingPhase(jobOpening);
            if (flag) {
                System.out.println("The job opening was successfully finished.");
            } else {
                System.out.println("There was an error finishing the job opening.");
            }
        }else {
            return false;
        }

        return true;
    }



    private JobOpening listAndSelectJobOpenings() {
        System.out.println("Job Opening List:");
        List<JobOpening> jobOpenings = theController.getjobOpeningsInAnalysisPhaseForCustomerManager();

        if (jobOpenings==null || jobOpenings.isEmpty() ) {
            System.out.println("There are no job openings in the analysis phase.");
            return null;
        }

        for (int i = 0; i < jobOpenings.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpenings.get(i).jobReference() + " - " + jobOpenings.get(i).function());
        }
        int selectedOption = Console.readOption(1, jobOpenings.size(), -1);
        return jobOpenings.get(selectedOption - 1);

    }





    @Override
    public String headline() {
        return "Rank candidates";
    }
}
