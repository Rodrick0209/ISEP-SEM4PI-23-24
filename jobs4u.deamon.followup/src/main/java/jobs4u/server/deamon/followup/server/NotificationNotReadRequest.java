package jobs4u.server.deamon.followup.server;

import jobs4u.base.notificationManagement.domain.Notification;

public class NotificationNotReadRequest extends FollowUpRequest {

    protected final static int DATA1_PREFIX = 4;

    Iterable<Notification> notifications;

    public NotificationNotReadRequest(Iterable<Notification> notifications) {
        super(null, null);
        this.notifications = notifications;
    }

    @Override
    public byte[] execute() {


        byte [] response = new byte[4+ DATA1_LEN_L + DATA1_LEN_M * 256 + DATA2_LEN_L + DATA_LEN_M * 256];;
        response[0] = VERSION;
        response[1] = GET_NOTIFICATIONS_NOT_READ;
        response[2] = DATA1_LEN_L;
        response[3] = DATA1_LEN_M;

        response[DATA1_PREFIX - 2] = DATA2_LEN_L;
        response[DATA1_PREFIX - 1] = DATA_LEN_M;

        int length=0;
        String concatjob ="";


        if (notifications!=null) {
            for (Notification notification : notifications) {
                concatjob = concatjob.concat(notification.date().toString()).concat("\n");
                concatjob = concatjob.concat(notification.message().toString()).concat("\n\t");
            }
            length = concatjob.length();
            System.arraycopy(concatjob.getBytes(), 0, response, DATA1_PREFIX, length);


        }

        return response;

    }


}
