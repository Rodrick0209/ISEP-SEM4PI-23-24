package jobs4u.server.deamon.followup.server;

public class UnknownRequest extends BaseErrorRequest{

    public UnknownRequest(final byte[] inputLine) {
        super(inputLine);
    }

    @Override
    protected String messageType() {
        return "UNKNOWN_REQUEST";
    }

}
