package jobs4u.base.app.backoffice.console.presentation.candiateManagement;


import jobs4u.base.candidateManagement.application.ListCandidateController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import jobs4u.base.candidateManagement.domain.Candidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class ListCandidateUI extends AbstractUI {


    private final ListCandidateController controller = new ListCandidateController();

    @Override
    protected boolean doShow() {

        System.out.println("Registered Candidates:\n");
        showAllCandidates();

        return true;
    }

    private void showAllCandidates() {
        List<Candidate> candidates = controller.candidates();

        for (int i = 0; i < candidates.size(); i++) {
            System.out.printf("%dddd.\n\t\t%s\n ", (i + 1), candidates.get(i).emailAddress().toString());
            System.out.printf("\t\t%s\n\n", candidates.get(i).nameString());

        }

    }

    @Override
    public String headline() {
        return "List Candidates";
    }
}
