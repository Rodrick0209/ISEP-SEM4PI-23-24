package jobs4u.base.notificationManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.utils.ClientCode;

public interface NotificationRepository extends DomainRepository<Long, Notification> {


    Iterable<Notification> findNotificationsNotRead(EmailAddress emailAddress);
    Iterable<Notification> findNotificationsRead(EmailAddress emailAddress);

}
