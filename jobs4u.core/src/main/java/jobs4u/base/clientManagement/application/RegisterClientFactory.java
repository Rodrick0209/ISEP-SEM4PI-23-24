package jobs4u.base.clientManagement.application;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import jobs4u.base.Application;
import jobs4u.base.infrastructure.persistence.PersistenceContext;

public final class RegisterClientFactory {


    private RegisterClientFactory() {
        // ensure utility
    }

    public static RegisterClientController build() {

        return new RegisterClientController(PersistenceContext.repositories().clients(), AuthzRegistry.authorizationService(),
                InProcessPubSub.publisher());


    }
}
