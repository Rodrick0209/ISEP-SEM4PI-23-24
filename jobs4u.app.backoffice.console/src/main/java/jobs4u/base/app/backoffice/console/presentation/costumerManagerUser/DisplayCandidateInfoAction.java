package jobs4u.base.app.backoffice.console.presentation.costumerManagerUser;

import eapli.framework.actions.Action;

public class DisplayCandidateInfoAction implements Action {
    @Override
    public boolean execute() {
        return new DisplayCandidateInfoUI().show();
    }
}
