package jobs4u.base.app.backoffice.console.presentation.customerManagerUser;

import eapli.framework.actions.Action;

public class SelectInterviewModelSpecificationForJobOpeningAction implements Action {
    @Override
    public boolean execute() {
        return new SelectInterviewModelSpecificationForJobOpeningUI().show();
    }
}
