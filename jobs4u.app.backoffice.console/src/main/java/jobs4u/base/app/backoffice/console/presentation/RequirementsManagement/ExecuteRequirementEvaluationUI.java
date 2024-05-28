package jobs4u.base.app.backoffice.console.presentation.RequirementsManagement;

import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement.ListJobOpeningUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.ExecuteRequirementEvaluationController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecuteRequirementEvaluationUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteRequirementEvaluationUI.class);

    private final ExecuteRequirementEvaluationController requirementEvaluationController = new ExecuteRequirementEvaluationController(PersistenceContext.repositories().jobApplications(), AuthzRegistry.authorizationService());

    private final ListJobOpeningUI listJobOpeningUI = new ListJobOpeningUI();

    @Override
    protected boolean doShow() {
        try {

            JobOpening jobOpening = listJobOpeningUI.selectJobOpeningFromList();
            if (jobOpening!= null) {
                requirementEvaluationController.executeRequirementEvaluation(jobOpening);
            }
            System.out.println("Requirements Evaluation was successfully executed for the available applications.");
        } catch (final IntegrityViolationException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return false;
    }


    @Override
    public String headline() {
        return "Execute Requirements Evaluation";
    }


}
