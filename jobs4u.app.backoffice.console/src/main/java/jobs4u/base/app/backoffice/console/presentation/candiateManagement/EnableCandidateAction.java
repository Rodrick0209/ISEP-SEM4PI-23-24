package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import eapli.framework.actions.Action;

public class EnableCandidateAction implements Action {
    @Override
    public boolean execute() {
        return new EnableCandidateUI().show();
    }
}
