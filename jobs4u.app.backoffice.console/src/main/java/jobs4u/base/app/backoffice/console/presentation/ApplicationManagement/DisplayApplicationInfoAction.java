package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.actions.Action;

public class DisplayApplicationInfoAction implements Action {
    @Override
    public boolean execute() {
        return new DisplayApplicationInfoUI().show();
    }
}
