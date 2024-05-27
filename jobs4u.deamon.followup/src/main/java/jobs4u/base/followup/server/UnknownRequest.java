package jobs4u.base.followup.server;

public class UnknownRequest extends BaseErrorRequest{

    public UnknownRequest(final byte[] inputLine) {
        super(inputLine);
    }

    @Override
    protected String messageType() {
        return "UNKNOWN_REQUEST";
    }

}
