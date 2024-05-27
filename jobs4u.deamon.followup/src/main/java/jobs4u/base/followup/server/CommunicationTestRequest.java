package jobs4u.base.followup.server;

public class CommunicationTestRequest extends FollowUpRequest {
    public CommunicationTestRequest() {
        super(null, null);
    }

    @Override
    public byte[] execute() {
        byte [] message = new byte[4];
        message[0] = VERSION;
        message[1] = ACK;
        message[2] = 0;
        message[3] = 0;
        return message;
    }

    protected String messageType() {
        return "COMMUNICATION_TEST";
    }
}
