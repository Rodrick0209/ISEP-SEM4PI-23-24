package jobs4u.base.notificationManagement.application.eventhandlers;

import eapli.framework.domain.events.DomainEventBase;
import jobs4u.base.jobApplications.domain.JobApplication;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendNotificationWhenAppStateChangeEvent extends DomainEventBase{

        final private JobApplication jobApplication;

        private static final long serialVersionUID = 1L;


        public SendNotificationWhenAppStateChangeEvent(JobApplication jobApp){

            this.jobApplication = jobApp;
        }


        public String toString() {
            return "NotificationEvent{" +
                    "jobApplication=" + jobApplication +
                    '}';
        }




}
