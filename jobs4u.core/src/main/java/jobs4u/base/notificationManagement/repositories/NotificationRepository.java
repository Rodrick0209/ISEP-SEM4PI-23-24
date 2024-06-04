package jobs4u.base.notificationManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.utils.ClientCode;

public interface NotificationRepository extends DomainRepository<Long, Notification> {

        //TODO implement method find notifications by candidate

    Iterable<Notification> findNotificationsNotReadByCandidate(ClientCode clientCode);
    Iterable<Notification> findNotificationsReadByCandidate(ClientCode clientCode);

}
