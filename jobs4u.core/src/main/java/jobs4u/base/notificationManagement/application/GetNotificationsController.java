package jobs4u.base.notificationManagement.application;

import eapli.framework.general.domain.model.EmailAddress;
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


    public Iterable<Notification> listNotificationsRead(EmailAddress emailAddress) {
        //System.out.println("TRACKING CONTROLLER");
        return notificationRepository.findNotificationsRead(emailAddress);

    }


    public Iterable<Notification> listNotificationsNotRead(EmailAddress emailAddress) {
        //System.out.println("TRACKING CONTROLLER");
        return notificationRepository.findNotificationsNotRead(emailAddress);

    }

    public void markNotificationAsRead(Iterable<Notification> notification) {
        for (Notification notification1: notification){
            notification1.markAsRead();
            notificationRepository.save(notification1);
        }
    }


}
