package jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement;

import eapli.framework.actions.Action;

public class EditJobOpeningAction implements Action {
    @Override
    public boolean execute() {
        return new EditJobOpeningUI().show();
    }
}
