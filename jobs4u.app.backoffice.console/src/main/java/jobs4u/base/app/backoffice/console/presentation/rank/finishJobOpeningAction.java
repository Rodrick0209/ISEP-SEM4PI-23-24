package jobs4u.base.app.backoffice.console.presentation.rank;

import eapli.framework.actions.Action;

public class finishJobOpeningAction implements Action {
    @Override
    public boolean execute() {
        return new finishJobOpeningUI().show();
    }
}
