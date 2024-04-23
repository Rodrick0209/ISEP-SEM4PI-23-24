package jobs4u.base.app.backoffice.console.presentation.costumerManagerUser;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.SelectJobRequirementSpecificationForJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class SelectJobRequirementSpecificationForJobOpeningUI extends AbstractUI {

   private static final Logger LOGGER = LoggerFactory.getLogger(jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.SelectJobRequirementSpecificationForJobOpeningUI.class);

    private final SelectJobRequirementSpecificationForJobOpeningController theController = new SelectJobRequirementSpecificationForJobOpeningController(PersistenceContext.repositories().jobRequirementsSpecification(), PersistenceContext.repositories().jobOpenings(),AuthzRegistry.authorizationService());
    @Override
    protected boolean doShow() {
        final Iterable<JobOpening> jobOpenings = theController.listJobOpenings();
        final SelectWidget<JobOpening> jobOpeningSelector = new SelectWidget<>("Select a Job Opening", jobOpenings);
        jobOpeningSelector.show();
        final JobOpening jobOpening = jobOpeningSelector.selectedElement();

        final Iterable<JobRequirementSpecification> jobRequirementsSpecification = theController.listJobRequirementsSpecification();
        final SelectWidget<JobRequirementSpecification> jobRequirementSpecificationSelector = new SelectWidget<>("Select a Job Requirement Specification", jobRequirementsSpecification);
        jobRequirementSpecificationSelector.show();
        final JobRequirementSpecification jobRequirementSpecification = jobRequirementSpecificationSelector.selectedElement();

        try{
            theController.selectJobRequirementSpecificationForJobOpening(jobRequirementSpecification, jobOpening);
            System.out.println("Job Requirement Specification successfully selected for the Job Opening!");
        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Select Job Requirement Specification for a Job Opening";
    }
}
