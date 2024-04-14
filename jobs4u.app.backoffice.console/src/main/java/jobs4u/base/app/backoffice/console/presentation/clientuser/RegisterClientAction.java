package jobs4u.base.app.backoffice.console.presentation.clientuser;

import eapli.framework.actions.Action;

public class RegisterClientAction implements Action {

    @Override
    public boolean execute() {
        return new RegisterClientUI().show();
    }
}


