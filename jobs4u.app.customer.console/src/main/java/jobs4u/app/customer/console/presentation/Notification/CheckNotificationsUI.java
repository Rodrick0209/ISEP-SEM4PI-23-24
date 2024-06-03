package jobs4u.app.customer.console.presentation.Notification;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.app.customer.console.checkNotifications.application.CheckNotificationsController;
import jobs4u.app.customer.console.checkNotifications.dto.NotificationDTO;
import jobs4u.app.customer.console.presentation.JobOpening.DisplayJobOpeningUI;
import jobs4u.base.notificationManagement.application.GetNotificationsController;
import jobs4u.base.utils.ClientCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CheckNotificationsUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(CheckNotificationsUI.class);


    @Override
    protected boolean doShow() {
        CheckNotificationsController controller = new CheckNotificationsController();

        try {
            Iterable<NotificationDTO> iterable = controller.getNotificationForCustomer(ClientCode.valueOf("Isep1"));
            System.out.println("Notifications");
            for (NotificationDTO notification: iterable) {
                System.out.println("-->"+notification.message+ " - "+notification.localDate);
            }
        } catch (Exception e) {
            LOGGER.error("Error displaying notifications", e);
        }

        return false;
    }


    @Override
    public String headline() {
        return "Show Notifications";
    }


}
