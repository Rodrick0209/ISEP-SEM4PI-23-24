package jobs4u.app.customer.console.checkNotifications.application;

import jobs4u.app.customer.console.checkNotifications.dto.NotificationDTO;
import jobs4u.app.customer.console.followup.customer.client.FollowUpServerProxy;

import java.io.IOException;

public class NotificationsController {

    private final FollowUpServerProxy proxy = new FollowUpServerProxy();


    public Iterable<NotificationDTO> getNotificationReadNotificationsForCustomer(final String email)
            throws IOException {

        return proxy.getNotificationReadForCustomer(email);
    }


    public Iterable<NotificationDTO> getNotificationNotReadForCustomer(final String email)
            throws IOException {

        return proxy.getNotificationNotReadForCustomer(email);
    }

    public Iterable<NotificationDTO> getNotificationReadNotificationsForCandidate(final String email)
            throws IOException {

        return proxy.getNotificationReadForCandidate(email);
    }


    public Iterable<NotificationDTO> getNotificationNotReadForCandidate(final String email)
            throws IOException {

        return proxy.getNotificationReadForCandidate(email);
    }



}
