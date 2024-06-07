package jobs4u.app.candidate.console.presentation.Notification;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.app.candidate.console.authz.CredentialStore;
import jobs4u.app.candidate.console.checkNotifications.application.NotificationsController;
import jobs4u.app.candidate.console.checkNotifications.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckNotificationsUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(CheckNotificationsUI.class);


    @Override
    protected boolean doShow() {
        NotificationsController controller = new NotificationsController();
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
                    Iterable<NotificationDTO> iterable = controller.getNotificationReadNotificationsForCandidate(EmailAddress.valueOf(CredentialStore.getUsername()).toString());
                    for (NotificationDTO notification : iterable) {
                        System.out.println("-->" + notification.message + " - " + notification.localDate);
                    }
                    System.out.println();
                    do {
                        option2 = Console.readInteger("Press 1 to rollback to the previous menu");
                    } while (option2 != 1);
                    break;
                case 2:
                    System.out.println("-----------Old Notifications-----------:");
                    Iterable<NotificationDTO> iterable1 = controller.getNotificationNotReadForCandidate(CredentialStore.getUsername().toString());
                    for (NotificationDTO notification : iterable1) {
                        System.out.println("-->" + notification.message + " - " + notification.localDate);
                    }
                    System.out.println();
                    do {
                        option2 = Console.readInteger("Press 1 to rollback to the previous menu");
                    } while (option2 != 1);
                    break;
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
