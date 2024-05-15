package jobs4u.base.app.backoffice.console.presentation.recruitmentProcess;

import eapli.framework.actions.Action;

public class SetupRecruitmentProcessUI_DTO_Action implements Action {


    @Override
    public boolean execute() {
        return new SetupRecruitmentProcessUI_DTO().show();
    }

}
