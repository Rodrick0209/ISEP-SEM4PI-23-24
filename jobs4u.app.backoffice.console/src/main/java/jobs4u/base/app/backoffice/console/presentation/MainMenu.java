/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jobs4u.base.app.backoffice.console.presentation;

import jobs4u.base.Application;
import jobs4u.base.app.backoffice.console.presentation.ApplicationManagement.DisplayApplicationInfoAction;
import jobs4u.base.app.backoffice.console.presentation.ApplicationManagement.ListApplicationsUI;
import jobs4u.base.app.backoffice.console.presentation.ApplicationManagement.RecordTimeDateInterviewUI;
import jobs4u.base.app.backoffice.console.presentation.ApplicationManagement.RegisterApplicationUI;
import jobs4u.base.app.backoffice.console.presentation.InterviewManagement.ExecuteInterviewEvaluationUI;
import jobs4u.base.app.backoffice.console.presentation.InterviewManagement.SelectInterviewModelSpecificationForJobOpeningUI;
import jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement.EditJobOpeningUI;
import jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement.ListJobOpeningUI;
import jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement.PublishJobOpeningResultsUI;
import jobs4u.base.app.backoffice.console.presentation.RequirementsManagement.ExecuteRequirementEvaluationUI;
import jobs4u.base.app.backoffice.console.presentation.RequirementsManagement.NotifyCandidatesVerificationProcessUI;
import jobs4u.base.app.backoffice.console.presentation.RequirementsManagement.RegisterRequirementAnswerFileUI;
import jobs4u.base.app.backoffice.console.presentation.candiateManagement.*;
import jobs4u.base.app.backoffice.console.presentation.rank.finishJobOpeningAction;
import jobs4u.base.app.backoffice.console.presentation.rank.rankJobOpeningAction;
import jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement.RegisterJobOpeningUI;
import jobs4u.base.app.backoffice.console.presentation.RequirementsManagement.SelectJobRequirementSpecificationForJobOpeningUI;
import jobs4u.base.app.backoffice.console.presentation.authz.EnableUserAction;
import jobs4u.base.app.backoffice.console.presentation.authz.AddUserUI;
import jobs4u.base.app.backoffice.console.presentation.authz.DisableUserAction;
import jobs4u.base.app.backoffice.console.presentation.authz.ListUsersAction;
import jobs4u.base.app.backoffice.console.presentation.clientuser.RegisterClientUI;
import jobs4u.base.app.backoffice.console.presentation.languageEngineer.ConfigureInterviewModelPluginUI;
import jobs4u.base.app.backoffice.console.presentation.languageEngineer.ConfigureJobRequirementPluginUI;
import jobs4u.base.app.backoffice.console.presentation.recruitmentProcess.OpenClosePhaseUI;
import jobs4u.base.app.backoffice.console.presentation.recruitmentProcess.SetupRecruitmentProcessUI_DTO;
import jobs4u.base.app.common.console.authz.MyUserMenu;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int ACTIVATE_USER_OPTION = 3;
    private static final int DISABLE_USER_OPTION = 4;
    //private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // CUSTOMERS
    private static final int ADD_CUSTOMER_OPTION = 1;
    private static final int SETUP_RECRUITMENT_PROCESS = 2;

    private static final int CHANGE_PHASE = 3;

    // OPERATOR CANDIDATE
    private static final int REGISTER_CANDIDATE = 1;
    private static final int LIST_CANDIDATE = 2;
    private static final int ENABLE_CANDIDATE = 3;
    private static final int DISABLE_CANDIDATE = 4;
    private static final int REGISTER_REQUIREMENT_ANSWER_FILE = 5;

    // CUSTOMER MANAGER CANDIDATE
    private static final int DISPLAY_CANDIDATE_INFO = 1;
    private static final int RECORD_TIME_DATE_INTERVIEW = 2;
    private static final int EXECUTE_REQUIREMENT_EVALUATION = 3;
    private static final int EXECUTE_INTERVIEW_EVALUATION = 4;
    private static final int GET_ORDERED_LIST_OF_CANDIDATES = 5;

    // JOB OPENING
    private static final int REGISTER_JOB_OPENING = 1;
    private static final int LIST_JOB_OPENING = 2;
    private static final int SELECT_JOB_REQUIREMENT_SPECIFICATION_FOR_JOB_OPENING = 3;
    private static final int SELECT_INTERVIEW_MODEL_SPECIFICATION_FOR_JOB_OPENING = 4;
    private static final int EDIT_JOB_OPENING = 5;
    private static final int PUBLISH_JOB_OPENING_RESULTS = 6;
    private static final int NOTIFY_CANDIDATES_VERIFICATION_PROCESS = 7;

    // PLUGINS
    private static final int CONFIGURE_JOB_REQUIREMENT_PLUGIN = 1;
    private static final int CONFIGURE_INTERVIEW_MODEL_PLUGIN = 2;


    // PLUGINS
    private static final int REGISTER_RANK_FOR_JOB_OPENING = 1;
    private static final int FINISH_RANK_FOR_JOB_OPENING = 2;

    // APPLICATIONS
    private static final int REGISTER_APPLICATION = 1;
    private static final int LIST_APPLICATION = 2;
    private static final int DISPLAY_APPLICATION_INFO = 3;

    // SETTINGS
    private static final int Option = 1;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {


        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.CUSTOMER, Jobs4uRoles.CANDIDATE)) {
            throw new IllegalArgumentException("User not authorized to access this menu");
        }


        //System.out.println(authz.hasSession());

        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(1, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(2, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(3, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER)) {
            final Menu customersMenu = buildCustomersMenu();
            mainMenu.addSubMenu(2, customersMenu);
            final Menu customerManagerCandidateMenu = buildCustomerManagerCandidateMenu();
            mainMenu.addSubMenu(3, customerManagerCandidateMenu);
            final Menu jobOpeningMenu = buildJobOpeningMenu();
            mainMenu.addSubMenu(4, jobOpeningMenu);
            final Menu rankMenu = buildRankMenu();
            mainMenu.addSubMenu(5, rankMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(6, settingsMenu);
            final Menu applicationMenu = buildApplicationMenu();
            mainMenu.addSubMenu(7, applicationMenu);

        }

        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.POWER_USER, Jobs4uRoles.OPERATOR)) {

            final Menu operatorCandidateMenu = buildOperatorCandidateMenu();
            mainMenu.addSubMenu(2, operatorCandidateMenu);
            final Menu applicationMenu = buildApplicationsOperatorMenu();
            mainMenu.addSubMenu(3, applicationMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(4, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.POWER_USER, Jobs4uRoles.LANGUAGE_ENGINEER)) {
            final Menu pluginsMenu = buildPluginsMenu();
            mainMenu.addSubMenu(1, pluginsMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(2, settingsMenu);
        }


        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(Option, "Option",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(ACTIVATE_USER_OPTION, "Activate User", new EnableUserAction());
        menu.addItem(DISABLE_USER_OPTION, "Deactivate User", new DisableUserAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCustomersMenu() {
        final Menu menu = new Menu("Customers >");

        menu.addItem(ADD_CUSTOMER_OPTION, "Add Customer", new RegisterClientUI()::show);
        menu.addItem(SETUP_RECRUITMENT_PROCESS, "SetupRecruitmentProcess", new SetupRecruitmentProcessUI_DTO()::show);
        menu.addItem(CHANGE_PHASE, "Change Phase", new OpenClosePhaseUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildJobOpeningMenu() {
        final Menu menu = new Menu("Job Opening >");

        menu.addItem(REGISTER_JOB_OPENING, "Register Job Opening", new RegisterJobOpeningUI()::show);
        menu.addItem(LIST_JOB_OPENING, "List Job Openings", new ListJobOpeningUI()::show);
        menu.addItem(SELECT_JOB_REQUIREMENT_SPECIFICATION_FOR_JOB_OPENING, "Select Job Requirement Specification for Job Opening", new SelectJobRequirementSpecificationForJobOpeningUI()::show);
        menu.addItem(SELECT_INTERVIEW_MODEL_SPECIFICATION_FOR_JOB_OPENING, "Select Interview Model Specification for Job Opening", new SelectInterviewModelSpecificationForJobOpeningUI()::show);
        menu.addItem(EDIT_JOB_OPENING, "Edit a Job Opening", new EditJobOpeningUI()::show);
        menu.addItem(PUBLISH_JOB_OPENING_RESULTS, "Publish Job Opening Results", new PublishJobOpeningResultsUI()::show);
        menu.addItem(NOTIFY_CANDIDATES_VERIFICATION_PROCESS, "Notify Candidates Verification Process", new NotifyCandidatesVerificationProcessUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildApplicationsOperatorMenu() {
        final Menu menu = new Menu("Applications >");

        menu.addItem(REGISTER_APPLICATION, "Register Application", new RegisterApplicationUI()::show);
        menu.addItem(LIST_APPLICATION, "List Applications", new ListApplicationsUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildOperatorCandidateMenu() {
        final Menu menu = new Menu("Candidate >");

        menu.addItem(REGISTER_CANDIDATE, "Register Candidate", new RegisterCandidateUI()::show);
        menu.addItem(LIST_CANDIDATE, "List Candidates", new ListCandidateUI()::show);
        menu.addItem(ENABLE_CANDIDATE, "Enable Candidate", new EnableCandidateUI()::show);
        menu.addItem(DISABLE_CANDIDATE, "Disable Candidate", new DisableCandidateUI()::show);
        menu.addItem(REGISTER_REQUIREMENT_ANSWER_FILE, "Register Requirement Answer File",  new RegisterRequirementAnswerFileUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


    private Menu buildCustomerManagerCandidateMenu() {
        final Menu menu = new Menu("Candidate >");

        menu.addItem(DISPLAY_CANDIDATE_INFO, "Display Candidate Information", new DisplayCandidateInfoUI()::show);
        menu.addItem(RECORD_TIME_DATE_INTERVIEW, "Schedule Interview", new RecordTimeDateInterviewUI()::show);
        menu.addItem(EXECUTE_REQUIREMENT_EVALUATION,"Execute Requirement Evaluation", new ExecuteRequirementEvaluationUI()::show);
        menu.addItem(EXECUTE_INTERVIEW_EVALUATION, "Execute Interview Evaluation", new ExecuteInterviewEvaluationUI()::show);
        menu.addItem(GET_ORDERED_LIST_OF_CANDIDATES, "Get Ordered List of Candidates based on Interview Points", new GetOrderedListOfCandidatesUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildPluginsMenu() {
        final Menu menu = new Menu("Plugins >");

        menu.addItem(CONFIGURE_JOB_REQUIREMENT_PLUGIN, "Configure Job Requirement Plugin", new ConfigureJobRequirementPluginUI()::show);
        menu.addItem(CONFIGURE_INTERVIEW_MODEL_PLUGIN, "Configure Interview Model Plugin", new ConfigureInterviewModelPluginUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildRankMenu() {
        final Menu menu = new Menu("Rank >");

        menu.addItem(REGISTER_RANK_FOR_JOB_OPENING, "Register Rank for Job Opening", new rankJobOpeningAction());
        menu.addItem(FINISH_RANK_FOR_JOB_OPENING, "Finish rank state for Job Opening", new finishJobOpeningAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildApplicationMenu() {
        final Menu menu = new Menu("Application >");

        menu.addItem(REGISTER_RANK_FOR_JOB_OPENING, "See all data of an application", new DisplayApplicationInfoAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


}
