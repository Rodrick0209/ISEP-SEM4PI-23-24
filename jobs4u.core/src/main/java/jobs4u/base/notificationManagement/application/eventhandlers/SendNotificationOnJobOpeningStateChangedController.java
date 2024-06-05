package jobs4u.base.notificationManagement.application.eventhandlers;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUser;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;

import java.util.Optional;

public class SendNotificationOnJobOpeningStateChangedController {


    private final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();
    private final ClientUserRepository userRepository = PersistenceContext.repositories().clientUsers();

    public void sendNotificationOnJobOpeningStateChanged(SendNotificationOnjobOpeningStateChangedEvent event) {

        Optional<Jobs4uUser> jobs4uUser  =  userRepository.findByClientCode(event.jobOpening().getClient().code());
        jobs4uUser.ifPresent(uUser -> notificationRepository.save(new Notification( uUser.user().email(),event.jobOpening())));
    }


}
