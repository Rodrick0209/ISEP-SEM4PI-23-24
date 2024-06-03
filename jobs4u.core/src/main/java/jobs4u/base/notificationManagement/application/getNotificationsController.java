package jobs4u.base.notificationManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;
import jobs4u.base.utils.ClientCode;

public class getNotificationsController {


    private final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();

    private final ClientUserRepository clientRepository = PersistenceContext.repositories().clientUsers();

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();



    public Iterable<Notification> listNotificationsByClient(ClientCode clientCode){
        final var user = clientRepository.ofIdentity(clientCode).orElseThrow(IllegalArgumentException::new);
        return notificationRepository.findNotificationsByCandidate(clientCode);
    }




}
