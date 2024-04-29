package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import eapli.framework.actions.Action;

public class ListCandidateAction implements Action{
    @Override
    public boolean execute() {
        return new ListCandidateUI().show();
    }
}
