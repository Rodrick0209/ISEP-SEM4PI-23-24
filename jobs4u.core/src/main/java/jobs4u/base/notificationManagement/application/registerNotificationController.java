package jobs4u.base.notificationManagement.application;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.PubSubRegistry;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;

public class registerNotificationController {
    private final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();
    private final EventPublisher dispatcher = PubSubRegistry.publisher();

    public Notification registerNotification(Notification notification) {
            //get current session

            return notificationRepository.save(notification);

    }
}
