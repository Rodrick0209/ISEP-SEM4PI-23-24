package jobs4u.base.app.backoffice.console.presentation.languageEngineer;

import eapli.framework.actions.Action;

public class ConfigureInterviewModelPluginAction implements Action {
    @Override
    public boolean execute() {
        return new ConfigureInterviewModelPluginUI().show();
    }
}
