
package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import eapli.framework.actions.Action;

public class DisplayCandidateInfoAction implements Action {
    @Override
    public boolean execute() {
        return new DisplayCandidateInfoUI().show();
    }
}
