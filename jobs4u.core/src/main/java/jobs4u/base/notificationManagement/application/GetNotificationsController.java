package jobs4u.base.notificationManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;
import jobs4u.base.utils.ClientCode;

public class GetNotificationsController {


    private final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();


    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();



    public Iterable<Notification> listNotificationsReadByClient(ClientCode clientCode){

       return notificationRepository.findNotificationsReadByCandidate(clientCode);

    }



    public Iterable<Notification> listNotificationsByClientNotRead(ClientCode clientCode){

        return notificationRepository.findNotificationsNotReadByCandidate(clientCode);

    }




}
