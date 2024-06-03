package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;
import jobs4u.base.utils.ClientCode;

class InMemoryNotificationRepository extends InMemoryDomainRepository<Notification,Long> implements NotificationRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Notification> findNotificationsByCandidate(ClientCode candidateEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }





}
