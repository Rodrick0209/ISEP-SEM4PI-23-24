package jobs4u.base.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;
import jobs4u.base.utils.ClientCode;

import java.util.HashMap;
import java.util.Map;

public class JpaNotificationRepository extends JpaAutoTxRepository<Notification, Long, Long> implements NotificationRepository {

    public JpaNotificationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaNotificationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public Iterable<Notification> findNotificationsNotReadByCandidate(ClientCode clientCode) {
        final Map<String, Object> params = new HashMap<>();
        params.put("clientCode", clientCode);
        params.put("state", "NotRead");
        return match("e.client.clientCode = :clientCode AND e.state = state", params);
    }

    @Override
    public Iterable<Notification> findNotificationsReadByCandidate(ClientCode clientCode) {
        final Map<String, Object> params = new HashMap<>();
        params.put("clientCode", clientCode);
        params.put("state", "Read");
        return match("e.client.clientCode = :clientCode AND e.state = state" , params);
    }

}
