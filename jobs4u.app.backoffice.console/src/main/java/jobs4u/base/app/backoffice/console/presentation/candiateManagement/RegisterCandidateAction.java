package jobs4u.base.app.backoffice.console.presentation.candiateManagement;
import eapli.framework.actions.Action;

public class RegisterCandidateAction implements Action{

    @Override
    public boolean execute() {
        return new RegisterCandidateUI().show();
    }
}
