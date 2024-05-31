package jobs4u.server.deamon.followup.server;

public class BadRequest extends BaseErrorRequest{

    public BadRequest(final byte[] request, final String errorDescription) {
        super(request, errorDescription);
    }

    @Override
    protected String messageType() {
        return "ERROR_IN_REQUEST";
    }

}
