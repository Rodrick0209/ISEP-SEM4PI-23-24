package jobs4u.base.app.backoffice.console.presentation.customerManagerUser;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.jobOpeningsManagement.application.SelectInterviewModelSpecificationForJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectInterviewModelSpecificationForJobOpeningUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(jobs4u.base.app.backoffice.console.presentation.customerManagerUser.SelectInterviewModelSpecificationForJobOpeningUI.class);
    private final SelectInterviewModelSpecificationForJobOpeningController theController = new SelectInterviewModelSpecificationForJobOpeningController(PersistenceContext.repositories().jobOpenings(), PersistenceContext.repositories().interviewModelsSpecification(), AuthzRegistry.authorizationService());
    @Override
    protected boolean doShow() {
        final Iterable<JobOpening> jobOpenings = theController.listJobOpenings();
        final SelectWidget<JobOpening> jobOpeningSelector = new SelectWidget<>("Select a Job Opening", jobOpenings);
        jobOpeningSelector.show();
        final JobOpening jobOpening = jobOpeningSelector.selectedElement();

        final Iterable<InterviewModelSpecification> interviewModelsSpecification = theController.listInterviewModelsSpecification();
        final SelectWidget<InterviewModelSpecification> interviewModelSpecificationSelector = new SelectWidget<>("Select a Interview Model Specification", interviewModelsSpecification);
        interviewModelSpecificationSelector.show();
        final InterviewModelSpecification interviewModelSpecification = interviewModelSpecificationSelector.selectedElement();
        if (interviewModelSpecification == null || jobOpening == null) {
            return false;
        }
        try{
            theController.selectInterviewModelSpecificationForJobOpening(interviewModelSpecification, jobOpening);
            System.out.println("Interview Model Specification successfully selected for the Job Opening!");
        } catch (IntegrityViolationException | ConcurrencyException ex){
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Select Interview Model Specification for a Job Opening";
    }
}
