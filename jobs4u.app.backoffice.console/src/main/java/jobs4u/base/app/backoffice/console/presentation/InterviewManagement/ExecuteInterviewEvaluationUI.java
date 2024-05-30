package jobs4u.base.app.backoffice.console.presentation.InterviewManagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.ExecuteInterviewEvaluationController;
import jobs4u.base.jobApplications.application.ExecuteInterviewEvaluationService;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecuteInterviewEvaluationUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteInterviewEvaluationUI.class);

    private final ExecuteInterviewEvaluationController controller = new ExecuteInterviewEvaluationController(
            AuthzRegistry.authorizationService(),
            PersistenceContext.repositories().jobOpenings(),
            PersistenceContext.repositories().jobApplications(),
            new ExecuteInterviewEvaluationService(
                    PersistenceContext.repositories().jobApplications())
            );


    @Override
    protected boolean doShow() {
        Iterable<JobOpening> jobOpenings = controller.jobOpeningsInInterviewPhase();
        if(jobOpenings == null){
            System.out.println("No job openings found");
            return true;
        }
        SelectWidget<JobOpening> jobOpeningSelector = new SelectWidget<>("Select a Job Opening in interview phase", jobOpenings);
        jobOpeningSelector.show();
        JobOpening jobOpening = jobOpeningSelector.selectedElement();

        try{
            controller.executeInterviewEvaluation(jobOpening);
            System.out.println("Execute interview evaluation successfully completed");
        } catch (ConcurrencyException | IntegrityViolationException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Execute process of evaluation of interviews for a Job Opening";
    }
}
