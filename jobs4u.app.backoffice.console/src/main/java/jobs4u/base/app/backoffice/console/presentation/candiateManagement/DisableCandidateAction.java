package jobs4u.base.app.backoffice.console.presentation.candiateManagement;


import eapli.framework.actions.Action;

public class DisableCandidateAction implements Action {
    @Override
    public boolean execute() {
        return new DisableCandidateUI().show();
    }
}
