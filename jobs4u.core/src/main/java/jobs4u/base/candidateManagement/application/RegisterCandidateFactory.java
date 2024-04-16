package jobs4u.base.candidateManagement.application;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import jobs4u.base.Application;
import jobs4u.base.infrastructure.persistence.PersistenceContext;

public class RegisterCandidateFactory {

    private RegisterCandidateFactory() {
     }

     public static RegisterCandidateController build() {
         return new RegisterCandidateController(PersistenceContext.repositories().candidates(), AuthzRegistry.authorizationService(),
                 InProcessPubSub.publisher());
     }
}
