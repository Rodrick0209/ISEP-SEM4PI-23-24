package jobs4u.server.deamon.followup.server;

import eapli.framework.infrastructure.authz.application.Authenticator;
import eapli.framework.infrastructure.authz.domain.model.Role;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.ListJobOpeningForCustomerController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.utils.ClientCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
    protected final static byte GET_AVAILABLE_MEALS = 6;

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
                    case GET_AVAILABLE_MEALS:
                        request = parseGetAvailableJobOpeningsRequest(message);
                        break;


                }
            }
        } catch (Exception e) {
            LOGGER.error("Unable to parse request: {}", message);
            request = new BadRequest(message, "Unable to parse request");
        }
        return request;
    }

    private FollowUpRequest parseGetAvailableJobOpeningsRequest(final byte[] message) {
        ListJobOpeningForCustomerController controller = new ListJobOpeningForCustomerController();

        StringBuilder sb = new StringBuilder();
        int DATA1_PREFIX = 4;

        for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 5; i++) {
            sb.append((char)message[i]);
        }
        String result = sb.toString();



        Iterable<JobOpening> jobs=controller.getJobOpeningsForCustomer(ClientCode.valueOf(result));

        return new JobOpeningRequest(jobs);
    }

    private FollowUpRequest parseAuthRequest(final byte[] message) {
        String username = "";
        String password = "";
        byte anterior = 127;

        try {

             int data1Frame = message[2] + message[3] * 256;
             int data2Frame = message[2 + data1Frame] + message[3 + data1Frame] * 256;

            int i = 4;
            byte atual = message[i];

            // Parse username
            do {
                username += (char) atual;
                anterior = atual;
                i++;
                atual = message[i];
            } while ((anterior != 0 && atual != 0) && i < 6 + data1Frame);

            i = skipToNextField(message, i);

            atual = message[i];

            // Parse password
            do {
                password += (char) atual;
                anterior = atual;
                i++;
                atual = message[i];
            } while ((anterior != 0 && atual != 0) && i < 6 + data1Frame + data2Frame);


            return new AuthRequest(authenticationService, username, password);

        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.error("Insufficient data in auth message: {}", message);
            return new BadRequest(message, "Insufficient data in auth message");
        } catch (IllegalArgumentException e) {
            LOGGER.error("Invalid role in auth message: {}", message);
            return new BadRequest(message, "Invalid role in auth message");
        }
    }


    private int skipToNextField(byte[] message, int i) {
        byte atual = message[i];
        while (atual == 0) {
            i++;

            atual = message[i];
        }

        return i;
    }

}
