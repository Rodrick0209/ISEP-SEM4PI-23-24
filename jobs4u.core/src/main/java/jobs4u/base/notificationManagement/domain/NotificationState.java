package jobs4u.base.notificationManagement.domain;

import eapli.framework.domain.model.ValueObject;

public enum NotificationState implements ValueObject {
    Read,
    NotRead,
    EmailNotification
}
