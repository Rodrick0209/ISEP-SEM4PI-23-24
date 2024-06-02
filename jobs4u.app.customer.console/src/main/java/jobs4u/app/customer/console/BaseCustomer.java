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
package jobs4u.app.customer.console;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import eapli.framework.io.util.Console;
import jobs4u.app.customer.console.authz.CredentialStore;
import jobs4u.app.customer.console.followup.customer.client.FollowUpServerProxy;
import jobs4u.app.customer.console.jobOpenings.application.GetJobOpeningsController;
import jobs4u.app.customer.console.presentation.JobOpening.DisplayJobOpeningUI;
import jobs4u.app.customer.console.presentation.MainMenu;
import jobs4u.base.app.common.console.BaseApplication;
import jobs4u.base.app.common.console.authz.LoginUI;
import jobs4u.base.authz.AuthenticationCredentialHandler;
import jobs4u.base.clientManagement.application.eventhandlers.ClientRegistedEvent;
import jobs4u.base.clientManagement.application.eventhandlers.ClientRegistedWatchDog;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.jobs4uusermanagement.application.eventhandlers.NewUserRegisteredFromClientRegistedWatchDog;
import jobs4u.base.jobs4uusermanagement.domain.events.NewUserRegisteredFromClientRegistedEvent;
import jobs4u.base.usermanagement.domain.Jobs4uPasswordPolicy;
import jobs4u.base.utils.ClientCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public final class BaseCustomer extends BaseApplication{

    private static final Logger LOGGER = LogManager.getLogger(BaseCustomer.class);

    /**
     * avoid instantiation of this class.
     */
    private BaseCustomer() {
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(final String[] args) {

        //AuthzRegistry.configure(PersistenceContext.repositories().users(),
                //new Jobs4uPasswordPolicy(), new PlainTextEncoder());
        new BaseCustomer().run(args);
      //
    }

    @Override
    protected void doMain(final String[] args) {
        final var correctPin = new LoginUI(CredentialStore.STORE_CREDENTIALS).show();
        if (correctPin) {
            final MainMenu menu = new MainMenu();
            menu.mainLoop();
        } else {
            System.out.println("Invalid Credentials");
        }

    }


    @Override
    protected String appTitle() {
        return "Base Customer";
    }

    @Override
    protected String appGoodbye() {
        return "Base Customer";
    }

    @Override
    protected void configureAuthz() {
        //AuthzRegistry.configure(PersistenceContext.repositories().users(), new Jobs4uPasswordPolicy(),
          //      new PlainTextEncoder());
    }
    @SuppressWarnings("unchecked")
    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
        dispatcher.subscribe(new NewUserRegisteredFromClientRegistedWatchDog(),
                NewUserRegisteredFromClientRegistedEvent.class);

        dispatcher.subscribe(new ClientRegistedWatchDog(), ClientRegistedEvent.class);
    }




}
