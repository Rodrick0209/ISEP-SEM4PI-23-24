package jobs4u.app.customer.console.presentation.Notification;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.app.customer.console.checkNotifications.application.CheckNotificationsController;
import jobs4u.app.customer.console.checkNotifications.dto.NotificationDTO;
import jobs4u.app.customer.console.presentation.JobOpening.DisplayJobOpeningUI;
import jobs4u.base.notificationManagement.application.GetNotificationsController;
import jobs4u.base.utils.ClientCode;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CheckNotificationsUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(CheckNotificationsUI.class);


    @Override
    protected boolean doShow() {
        CheckNotificationsController controller = new CheckNotificationsController();
        int option2;
        try {
            System.out.println("Choose the option:");
            System.out.println("1-New Notifications");
            System.out.println("2-Old Notifications");
            System.out.println("3-Exit");

            int option = Console.readOption(1, 2, 3);
            switch (option) {
                case 1:
                    System.out.println("-----------New Notifications-----------:");
                    Iterable<NotificationDTO> iterable = controller.getNotificationNotReadForCustomer(ClientCode.valueOf("Isep1"));
                    for (NotificationDTO notification : iterable) {
                        System.out.println("-->" + notification.message + " - " + notification.localDate);
                    }

                    do {
                        option2 = Console.readInteger("Press 1 to rollback to the previous menu");
                    } while (option2 != 1);

                case 2:
                    System.out.println("-----------Old Notifications-----------:");
                    Iterable<NotificationDTO> iterable1 = controller.getNotificationReadNotificationsForCustomer(ClientCode.valueOf("Isep1"));
                    for (NotificationDTO notification : iterable1) {
                        System.out.println("-->" + notification.message + " - " + notification.localDate);
                    }

                    do {
                        option2 = Console.readInteger("Press 1 to rollback to the previous menu");
                    } while (option2 != 1);

                case 3:

                    return false;
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
