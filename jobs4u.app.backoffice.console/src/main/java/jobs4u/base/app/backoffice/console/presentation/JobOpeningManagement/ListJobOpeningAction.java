package jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement;

import eapli.framework.actions.Action;

public class ListJobOpeningAction implements Action {
    @Override
    public boolean execute() {
        return new ListJobOpeningUI().show();
    }
}
