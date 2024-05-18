package jobs4u.base.app.backoffice.console.presentation.rank;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.rankManagement.application.RankJobOpeningController;
import jobs4u.base.rankManagement.domain.Rank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.List;

public class rankJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(rankJobOpeningUI.class);

    private final RankJobOpeningController theController = new RankJobOpeningController();

    @Override
    protected boolean doShow() {

        JobOpening jobOpening = listAndSelectJobOpenings();

        if (jobOpening == null) {
            return false;
        }

        List<Candidate> candidates = theController.getJobOpeningCandidates(jobOpening);
        if (candidates == null || candidates.isEmpty()) {
            System.out.println("There are no candidates to be ranked.");
            return false;
        }
        listCandidates(candidates);

        System.out.println("Number of elements for the rank: " + jobOpening.getRankSize());

        String emails = readEmails(jobOpening);

        Rank rank= null;
        try {
             rank=theController.rankCandidates(jobOpening, emails);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (rank == null) {
            System.out.println("There was an error ranking the candidates.");
            return false;
        }

       listRank(rank);

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

    private void listCandidates(List<Candidate> candidates) {

        if (candidates==null || candidates.isEmpty() ) {
            System.out.println("There are no candidates to be ranked.");
            return;
        }

        System.out.println("\n");
        System.out.println("Job Candidates List:");

        for (int i = 0; i < candidates.size(); i++) {
            System.out.println(" - " + candidates.get(i).name() + " | " + candidates.get(i).emailAddress());
        }
        System.out.println("\n");

    }


    public String readEmails(JobOpening jobOpening) {
        if (theController.getRankAsDTO(jobOpening).getRank().isEmpty()){

            return Console.readLine("Please enter the emails of the candidates you want to rank, separated by commas:");
        }else{
            System.out.println("This rank already has candidates ranked.");
            System.out.println(jobOpening.getRank());

            System.out.println("Ranked in input format:\n" + theController.getRankAsDTO(jobOpening).getRank());
            return Console.readLine("Please enter the emails of the candidates you want to rank, separated by commas:");
        }
    }


    private void listRank(Rank rank){
        System.out.println("Ranking:");
        System.out.println(rank);

    }


    @Override
    public String headline() {
        return "Rank candidates";
    }
}
