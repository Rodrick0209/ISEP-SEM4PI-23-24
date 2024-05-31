package jobs4u.server.deamon.followup.server;

public abstract class BaseErrorRequest extends FollowUpRequest{



    private final String errorMessage;

    protected BaseErrorRequest(final byte[] request, final String errorMessage) {
        super(null, request);
        this.errorMessage = errorMessage;

    }
    protected BaseErrorRequest(final byte[] request) {
        super (null, request);
        this.errorMessage = null;
    }

    @Override
    public byte[] execute() {

        return buildResponse();
    }

    protected void errorMessage(byte [] message) {

        String error = messageType();

        byte [] errorBytes = error.getBytes();

        for (int i = 0; i < errorBytes.length; i++) {
            message[i+4] = errorBytes[i];
        }
        message[4+errorBytes.length] = 0;
        message[4+errorBytes.length+1] = 0;


    }

    private byte [] buildResponse(){
        byte [] errorMessage = new byte[4+DATA1_LEN_L+DATA1_LEN_M*256];
        errorMessage[0] = VERSION;
        errorMessage[1] = ERR;
        errorMessage[2] = DATA1_LEN_L;
        errorMessage[3] = DATA1_LEN_M;

        if (this.errorMessage != null) {
            errorMessage(errorMessage);
        }else{
            errorMessage[4] = 0; errorMessage[5] = 0;
        }

        return errorMessage;
    }



    protected abstract String messageType();
}
