package jobs4u.base.notificationManagement.application.eventhandlers;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;

public class SendNotificationOnJobOpeningStateChangedController {


    private final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();


    public void sendNotificationOnJobOpeningStateChanged(SendNotificationOnjobOpeningStateChangedEvent event) {
        //TODO move message to Notification class
        System.out.println(event.jobOpening().getClient().clientCode());
        notificationRepository.save(new Notification("Job Opening with id "+event.jobOpening().jobReference()+" changed to status ->" + event.jobOpening().status(), event.jobOpening().getClient()));
    }


}
