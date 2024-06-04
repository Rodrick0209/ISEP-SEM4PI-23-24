package jobs4u.app.customer.console.checkNotifications.application;

import jobs4u.app.customer.console.checkNotifications.dto.NotificationDTO;
import jobs4u.app.customer.console.followup.customer.client.FollowUpServerProxy;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.utils.ClientCode;

import java.io.IOException;

public class CheckNotificationsController {

    private final FollowUpServerProxy proxy = new FollowUpServerProxy();


    public Iterable<NotificationDTO> getNotificationReadNotificationsForCustomer(final ClientCode code)
            throws IOException {

        return proxy.getNotificationReadForCustomer(code);
    }


    public Iterable<NotificationDTO> getNotificationNotReadForCustomer(final ClientCode code)
            throws IOException {

        return proxy.getNotificationNotReadForCustomer(code);
    }


}
