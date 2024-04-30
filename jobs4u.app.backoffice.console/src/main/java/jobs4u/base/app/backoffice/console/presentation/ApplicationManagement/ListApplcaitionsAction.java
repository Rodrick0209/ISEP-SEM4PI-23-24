package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.actions.Action;

public class ListApplcaitionsAction implements Action{
    @Override
    public boolean execute() {
        return new ListApplicationsUI().show();
    }
}
