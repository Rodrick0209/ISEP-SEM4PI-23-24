package jobs4u.server.deamon.followup.server;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.Authenticator;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobApplications.application.ListJobApplicationForCandidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.application.ListJobOpeningForCustomerController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.notificationManagement.application.GetNotificationsController;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.utils.ClientCode;
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
    protected final static byte GET_AVAILABLE_MEALS = 6;

    protected final static byte GET_CUSTOMER = 7;
    protected final static byte GET_NOTIFICATIONS_READ = 8;

    protected final static byte GET_NOTIFICATIONS_NOT_READ = 9;
    protected final static byte GET_APPLICATION_CANDIDATE = 11;

    protected final static byte PUBLISHOPN = 87;
    protected final static byte NOTIFYCANDIDATES = 88;

    public FollowUpMessageParser(Authenticator authenticationService) {
        this.authenticationService = authenticationService;
    }

    public FollowUpRequest parse(final byte[] message) {

        FollowUpRequest request = new UnknownRequest(message);
        try {

            byte version = message[0];
            byte type = message[1];
            if (version == 1) {
                //System.out.println("TYPE  === " + type);
                switch (type) {
                    case COMM_TEST:
                        request = new CommunicationTestRequest();
                        break;
                    case DISCONN:
                        break;
                    case AUTH:
                        request = parseAuthRequest(message);
                        break;
                    case GET_AVAILABLE_MEALS:
                        request = parseGetAvailableJobOpeningsRequest(message);
                        break;
                    case GET_CUSTOMER:
                        request = parseGetCustomer(message);
                        break;
                    case GET_NOTIFICATIONS_READ:
                        request = parseGetNotificationsRead(message);
                        break;
                    case GET_NOTIFICATIONS_NOT_READ:
                        request = parseGetNotificationsNotRead(message);
                        break;
                    case GET_APPLICATION_CANDIDATE:
                        request = parseGetJobApplicationRequest(message);
                        break;
                    case PUBLISHOPN:
                        request = parseResultEmailRequest(message);
                        break;
                    case NOTIFYCANDIDATES:
                        request = parseNotificationVerificationResultRequest(message);
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to parse request: {}", message);
            request = new BadRequest(message, "Unable to parse request");
        }
        return request;
    }

    private FollowUpRequest parseGetNotificationsNotRead(byte[] message) {
        GetNotificationsController controller = new GetNotificationsController();
        StringBuilder sb = new StringBuilder();
        int DATA1_PREFIX = 4;
        for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 50; i++) {
            if (message[i] != 0) {
                sb.append((char) message[i]);
            }
        }
        String result = sb.toString();
        Iterable<Notification> notifications = controller.listNotificationsNotRead(EmailAddress.valueOf(result));
        controller.markNotificationAsRead(notifications);
        return new NotificationNotReadRequest(notifications);
    }

    private FollowUpRequest parseGetNotificationsRead(byte[] message) {
        GetNotificationsController controller = new GetNotificationsController();
        StringBuilder sb = new StringBuilder();
        int DATA1_PREFIX = 4;
        for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 50; i++) {
            if (message[i] != 0) {
                sb.append((char) message[i]);
            }
        }
        String result = sb.toString();
        //System.out.println("Entrou aquiii");
        Iterable<Notification> notifications = controller.listNotificationsRead(EmailAddress.valueOf(result));
        return new NotificationReadRequest(notifications);
    }


    private FollowUpRequest parseGetAvailableJobOpeningsRequest(final byte[] message) {
        ListJobOpeningForCustomerController controller = new ListJobOpeningForCustomerController();

        StringBuilder sb = new StringBuilder();
        int DATA1_PREFIX = 4;

        for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 5; i++) {
            sb.append((char) message[i]);
        }
        String result = sb.toString();


        Iterable<JobOpening> jobs = controller.getJobOpeningsForCustomer(ClientCode.valueOf(result));


        return new JobOpeningRequest(jobs);
    }


    private FollowUpRequest parseGetCustomer(final byte[] message) {
        ListJobOpeningForCustomerController controller = new ListJobOpeningForCustomerController();

        StringBuilder sb = new StringBuilder();
        int DATA1_PREFIX = 4;

        for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 50; i++) {
            if (message[i] != 0) {
                sb.append((char) message[i]);
            }
        }
        String result = sb.toString();

        Client client = controller.getCustomer(result);

        return new CustomerRequest(client.clientCode().toString());
    }


    private FollowUpRequest parseGetJobApplicationRequest(final byte[] message) {
        ListJobApplicationForCandidate controller = new ListJobApplicationForCandidate();

        StringBuilder sb = new StringBuilder();
        int DATA1_PREFIX = 4;

        for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 50; i++) {
            if (message[i] != 0) {
                sb.append((char) message[i]);
            }
        }
        String result = sb.toString();


        Iterable<JobApplication> jobs = controller.getJobApplicationForCandidate(EmailAddress.valueOf(result));

        return new JobApplicationRequest(jobs);
    }

    private FollowUpRequest parseAuthRequest(final byte[] message) {
        String username = "";
        String password = "";
        String role = "";
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
            boolean flagRole = false;
            do {
                if (atual == '\n') {
                    flagRole = true;
                }

                if (!flagRole) {
                    password += (char) atual;
                } else {
                    role += (char) atual;
                }

                anterior = atual;
                i++;
                atual = message[i];

            } while ((anterior != 0 && atual != 0) && i < 6 + data1Frame + data2Frame);

            role = role.trim();


            return new AuthRequest(authenticationService, username, password, role);

        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.error("Insufficient data in auth message: {}", message);
            return new BadRequest(message, "Insufficient data in auth message");
        } catch (IllegalArgumentException e) {
            LOGGER.error("Invalid role in auth message: {}", message);
            return new BadRequest(message, "Invalid role in auth message");
        }


    }

    public FollowUpRequest parseResultEmailRequest(final byte[] message) {
        String jobRef = "";
        int DATA1_PREFIX = 4;
        byte anterior = 127;
        byte atual = 0;

        for (int i = DATA1_PREFIX; i < DATA1_LEN_L + 1 * 256 && (atual != 0 && anterior == 0); i++) {

            atual = message[i];
            anterior = message[i - 1];
            jobRef += (char) atual;

        }

        return new ResultEmailRequest(jobRef);
    }

    public FollowUpRequest parseNotificationVerificationResultRequest(final byte[] message) {
        String jobRef = "";
        int DATA1_PREFIX = 4;
        byte anterior = 127;
        byte atual = 0;

        for (int i = DATA1_PREFIX; i < DATA1_LEN_L + 1 * 256 && (atual != 0 && anterior == 0); i++) {

            atual = message[i];
            anterior = message[i - 1];
            jobRef += (char) atual;

        }

        return new NotifyCandidatesRequest(jobRef);
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
