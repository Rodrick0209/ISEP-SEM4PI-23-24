package jobs4u.app.customer.console.followup.customer.client;

import jobs4u.base.utils.ClientCode;
import jobs4u.server.deamon.followup.server.FollowUpRequest;

public class GetNotificationsForClientRequestDTO extends FollowUpRequest {

    String code;
    protected final static int DATA2_PREFIX = 4;

    public GetNotificationsForClientRequestDTO(ClientCode code){
        super(null, null);
        this.code= String.valueOf(code);

    }

    @Override
    public byte[] execute() {


        byte [] message =  new byte[4+ DATA1_LEN_L + DATA1_LEN_M * 256 + DATA2_LEN_L + DATA_LEN_M * 256];
        message[0] = VERSION;
        message[1] = GET_NOTIFICATIONS;
        message[2] = DATA1_LEN_L;
        message[3] = DATA1_LEN_M;


        message[DATA2_PREFIX - 2] = DATA2_LEN_L;
        message[DATA2_PREFIX - 1] = DATA_LEN_M;

        int clientlength = Math.min(code.length(), DATA1_LEN_M * 256 + DATA1_LEN_L);

        System.arraycopy(code.getBytes(), 0, message, DATA2_PREFIX, clientlength);


        return message;
    }

    protected String messageType() {
        return "GET_NOTIFICATIONS";
    }










}
