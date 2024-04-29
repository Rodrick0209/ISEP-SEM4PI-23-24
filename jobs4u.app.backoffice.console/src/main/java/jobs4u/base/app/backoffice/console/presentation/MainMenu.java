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
import jobs4u.base.app.backoffice.console.presentation.ApplicationManagement.RegisterApplicationUI;
import jobs4u.base.app.backoffice.console.presentation.authz.EnableUserAction;
import jobs4u.base.app.backoffice.console.presentation.authz.AddUserUI;
import jobs4u.base.app.backoffice.console.presentation.authz.DisableUserAction;
import jobs4u.base.app.backoffice.console.presentation.authz.ListUsersAction;
import jobs4u.base.app.backoffice.console.presentation.candiateManagement.ListCandidateUI;
import jobs4u.base.app.backoffice.console.presentation.candiateManagement.RegisterCandidateAction;
import jobs4u.base.app.backoffice.console.presentation.candiateManagement.RegisterCandidateUI;
import jobs4u.base.app.backoffice.console.presentation.clientuser.RegisterClientUI;
import jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.ListJobOpeningUI;
import jobs4u.base.app.backoffice.console.presentation.costumerManagerUser.RegisterJobOpeningUI;
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

    // OPERATOR
    private static final int REGISTER_CANDIDATE = 1;
    private static final int LIST_CANDIDATE = 2;

    // JOB OPENING
    private static final int REGISTER_JOB_OPENING = 1;
    private static final int LIST_JOB_OPENING = 2;

    // APPLICATIONS
    private static final int REGISTER_APPLICATION = 1;

    // SETTINGS
    private static final int Option = 1;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int CUSTOMERS_OPTION = 3;
    private static final int JOB_OPENING_OPTION = 4;
    private static final int APPLICATION_OPTION = 5;
    private static final int SETTINGS_OPTION = 6;

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

        if (!authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.BackgroundUserValues())){
            throw new IllegalArgumentException("User not authorized to access this menu");
        }

        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.POWER_USER, Jobs4uRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER)) {
            final Menu customersMenu = buildCustomersMenu();
            mainMenu.addSubMenu(CUSTOMERS_OPTION, customersMenu);
            final Menu jobOpeningMenu = buildJobOpeningMenu();
            mainMenu.addSubMenu(JOB_OPENING_OPTION, jobOpeningMenu);
//            final Menu  candidateMenu = buildCandidateMenu();
//            mainMenu.addSubMenu(CANDIDATE_OPTION, candidateMenu);

            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        }

        if (authz.isAuthenticatedUserAuthorizedTo(Jobs4uRoles.POWER_USER, Jobs4uRoles.OPERATOR)) {
            final Menu applicationMenu = buildApplicationsMenu();
            mainMenu.addSubMenu(APPLICATION_OPTION, applicationMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
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

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildOperatorMenu() {
        final Menu menu = new Menu("Operator >");

        menu.addItem(REGISTER_CANDIDATE, "Register Candidate", new RegisterCandidateUI()::show);
        menu.addItem(LIST_CANDIDATE, "List Candidates", new ListCandidateUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }



    private Menu buildJobOpeningMenu() {
        final Menu menu = new Menu("Job Opening >");

        menu.addItem(REGISTER_JOB_OPENING, "Register Job Opening", new RegisterJobOpeningUI()::show);
        menu.addItem(LIST_JOB_OPENING, "List Job Openings", new ListJobOpeningUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildApplicationsMenu() {
        final Menu menu = new Menu("Applications >");

        menu.addItem(REGISTER_JOB_OPENING, "Register Application", new RegisterApplicationUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


}
