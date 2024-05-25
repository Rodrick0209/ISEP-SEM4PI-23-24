package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.actions.Action;

public class RecordTimeDateInterviewAction implements Action{
    @Override
    public boolean execute() {
        return new RecordTimeDateInterviewUI().show();
    }
}
