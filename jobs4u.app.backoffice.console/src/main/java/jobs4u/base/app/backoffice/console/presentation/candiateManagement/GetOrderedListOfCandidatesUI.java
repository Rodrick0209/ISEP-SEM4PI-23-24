package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import jobs4u.base.candidateManagement.application.GetOrderedListOfCandidatesController;
import jobs4u.base.candidateManagement.application.GetOrderedListOfCandidatesService;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

import java.util.List;

public class GetOrderedListOfCandidatesUI extends AbstractUI {
    private final GetOrderedListOfCandidatesController controller = new GetOrderedListOfCandidatesController(PersistenceContext.repositories().jobOpenings(),
            PersistenceContext.repositories().jobApplications(),
            AuthzRegistry.authorizationService(),
            new GetOrderedListOfCandidatesService());

    @Override
    protected boolean doShow() {
        Iterable<JobOpening> jobOpenings = controller.jobOpeningsInAnalysisPhaseAndHadInterviewPhase();
        if(jobOpenings == null){
            System.out.println("No job openings found");
            return true;
        }
        SelectWidget<JobOpening> jobOpeningSelector = new SelectWidget<>("Select a Job Opening: ", jobOpenings);
        jobOpeningSelector.show();
        JobOpening jobOpening = jobOpeningSelector.selectedElement();

        List<Candidate> orderedCandidates = controller.getOrderedListOfCandidatesBasedOnInterviewPoints(jobOpening);
        if(orderedCandidates.isEmpty()){
            System.out.println("Candidates not found for this Job Opening!");
            return true;
        }
        showList(orderedCandidates);
        return true;
    }

    private void showList(List<Candidate> candidates){
        int cont = 1;
        System.out.println("Ordered List of Candidates: ");
        for (Candidate candidate: candidates){
            System.out.printf("%-6d%-30s%-30s%-30s%n", cont, candidate.emailAddress(), candidate.name().firstName(),
                    candidate.name().lastName());
            cont++;
        }
    }

    @Override
    public String headline() {
        return "Get Ordered List of Candidates based on Interview Points";
    }
}
