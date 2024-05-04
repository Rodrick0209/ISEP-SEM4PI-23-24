package jobs4u.base.app.backoffice.console.presentation.RequirementsManagement;

import eapli.framework.actions.Action;

public class SelectJobRequirementSpecificationForJobOpeningAction implements Action {

    @Override
    public boolean execute() {
        return new SelectJobRequirementSpecificationForJobOpeningUI().show();
    }
}
