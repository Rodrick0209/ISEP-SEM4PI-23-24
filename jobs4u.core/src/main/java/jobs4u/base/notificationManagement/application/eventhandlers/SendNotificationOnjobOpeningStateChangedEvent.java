package jobs4u.base.notificationManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.events.DomainEventBase;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

public class SendNotificationOnjobOpeningStateChangedEvent extends DomainEventBase {

    private static final long serialVersionUID = 1L;

    private final JobOpening jobOpening;



    public SendNotificationOnjobOpeningStateChangedEvent(final JobOpening jobOpening){
        this.jobOpening = jobOpening;
    }


    public JobOpening jobOpening() {
        return this.jobOpening;
    }




}
