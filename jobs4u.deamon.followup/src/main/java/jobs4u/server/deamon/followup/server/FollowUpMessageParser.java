package jobs4u.server.deamon.followup.server;

import eapli.framework.infrastructure.authz.application.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FollowUpMessageParser {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FollowUpMessageParser.class);

    protected final Authenticator authenticationService;

    protected final static byte DATA1_LEN_L = 1;
    protected final static byte DATA1_LEN_M = 2;
    protected final static byte DATA2_LEN_L = 1;
    protected final static byte DATA_LEN_M = 2;

    protected final static byte VERSION = 1;

    protected final static byte COMM_TEST = 0;
    protected final static byte DISCONN = 1;
    protected final static byte ACK = 2;
    protected final static byte ERR = 3;
    protected final static byte AUTH = 4;

    public FollowUpMessageParser(Authenticator authenticationService) {
        this.authenticationService = authenticationService;
    }

    public FollowUpRequest parse(final byte[] message) {

        FollowUpRequest request = new UnknownRequest(message);

        try {

            byte version = message[0];
            byte type = message[1];
            if (version == 1) {

                switch (type) {
                    case COMM_TEST:
                        request = new CommunicationTestRequest();
                        break;
                    case DISCONN:
                        LOGGER.debug("Client Disconnected");
                        break;
                    case AUTH:
                        request = parseAuthRequest(message);
                        break;

                }
            }
        }catch (Exception e){
            LOGGER.error("Unable to parse request: {}", message);
            request = new BadRequest(message, "Unable to parse request");
        }
        return request;
    }

    private FollowUpRequest parseAuthRequest(final byte[] message) {
        String username = "";
        String password = "";
        byte anterior = 127;


        try {

             int data1Frame = message[2] + message[3] * 256;
             int data2Frame = message[2 + data1Frame] + message[3 + data1Frame] * 256;

            int i = 4; int j = i+data1Frame;
            byte atual = message[i];

            do{

                username += (char)atual;
                anterior = atual;
                i++;
                atual = message[i];


            }while ((anterior != 0 && atual != 0) || i < data1Frame);

            do{

                password += (char)atual;
                anterior = atual;
                i++;
                atual = message[i];
            }while ((anterior != 0 && atual != 0) || i < data1Frame+data2Frame);

            return new AuthRequest(authenticationService, username, password);

        } catch (ArrayIndexOutOfBoundsException e){
            LOGGER.error("Insuficient data in auth message: {}", message);
            return new BadRequest(message, "Insuficient data in auth message");
        }



    }

}
