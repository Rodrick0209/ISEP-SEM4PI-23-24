package jobs4u.app.candidate.console.checkNotifications.application;

import jobs4u.app.candidate.console.checkNotifications.dto.NotificationDTO;
import jobs4u.app.candidate.console.client.FollowUpServerProxy;

import java.io.IOException;

public class NotificationsController {

    private final FollowUpServerProxy proxy = new FollowUpServerProxy();



    public Iterable<NotificationDTO> getNotificationReadNotificationsForCandidate(final String email)
            throws IOException {

        return proxy.getNotificationReadForCandidate(email);
    }


    public Iterable<NotificationDTO> getNotificationNotReadForCandidate(final String email)
            throws IOException {

        return proxy.getNotificationNotReadForCandidate(email);
    }



}
