package jobs4u.app.candidate.console.client;


import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import jobs4u.app.candidate.console.checkNotifications.dto.NotificationDTO;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationDTO;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.utils.ClientCode;
import jobs4u.server.deamon.followup.server.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class FollowUpServerProxy {


    protected final static byte DATA1_LEN_L = 1;
    protected final static byte DATA1_LEN_M = 1;
    protected final static byte DATA2_LEN_L = 1;
    protected final static byte DATA_LEN_M = 1;

    protected final static byte VERSION = 1;

    protected final static byte COMM_TEST = 0;
    protected final static byte DISCONN = 1;
    protected final static byte ACK = 2;
    protected final static byte ERR = 3;
    protected final static byte AUTH = 4;

    protected final static String DEI_IP = "10.9.20.231";
    protected final static String ALT_IP = "127.0.0.1";
    protected final static int DEI_PORT = 9999;



    protected final static int DATA1_PREFIX = 4;
    protected final static int DATA2_PREFIX = DATA1_LEN_M * 256 + DATA1_LEN_L + 2;

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpServerProxy.class);


    private boolean authenticated = false;

    private static class ClientSocket {

        private Socket sock;
        private DataOutputStream sOut;
        private DataInputStream in;




        public void connect(final String address, final int port) throws IOException {

            try {
                sock = new Socket(InetAddress.getByName(address), port);
                sOut = new DataOutputStream(sock.getOutputStream());


                System.out.println();

                in = new DataInputStream(sock.getInputStream());

                LOGGER.debug("Connected to {}", address);
            } catch (IOException e) {
                LOGGER.error("Failed to connect to {}", address);
                throw e;
            }

        }

        public void send(final byte[] request) throws IOException {



            sOut.write(request);

            LOGGER.debug("Sent message\n-----\n{}\n-----", request);
        }



        public void stop() throws IOException {
            in.close();
            sOut.close();
            sock.close();
        }

        public byte[] recv() throws IOException {

            final List<Byte> resp = new ArrayList<>();

            while (in.available() == 0){

            }
            ;
            while(in.available() > 0)
                resp.add(in.readByte());


            byte[] response = new byte[resp.size()];

            for (int i = 0; i < resp.size(); i++) {
                response[i] = resp.get(i);
            }

            return response;
        }
    }

    public boolean auth(String username, String password, Role role) throws IOException {
        final var auth = new byte[4+ DATA1_LEN_L + DATA1_LEN_M * 256 + DATA2_LEN_L + DATA_LEN_M * 256];
        auth[0] = VERSION;
        auth[1] = AUTH;
        auth[2] = DATA1_LEN_L;
        auth[3] = DATA1_LEN_M;

        // Ensure that username and password do not exceed their respective lengths
        int usernameLength = Math.min(username.length(), DATA1_LEN_M * 256 + DATA1_LEN_L);
        int passwordLength = Math.min(password.length(), DATA2_LEN_L + DATA_LEN_M * 256);
        int roleLength = Math.min(role.toString().length(), DATA2_LEN_L + DATA_LEN_M * 256);


        auth[DATA1_PREFIX - 2] = DATA2_LEN_L;
        auth[DATA1_PREFIX - 1] = DATA_LEN_M;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(password+"\n"+role.toString());


        System.arraycopy(username.getBytes(), 0, auth, DATA1_PREFIX, usernameLength);
        System.arraycopy(stringBuilder.toString().getBytes(), 0, auth, DATA2_PREFIX, stringBuilder.length());

        //System.out.println("Sending authentication request");
        final var socket = new ClientSocket();

        socket.connect(DEI_IP, DEI_PORT);

        socket.send(auth);

        //System.out.println("waiting for response");

        byte[] response = socket.recv();

        if (response[1] == ACK) {
            authenticated = true;
            //LOGGER.info("Authentication successful");

            socket.stop();
            return true;
        } else {
            authenticated = false;
            //LOGGER.error("Authentication failed");
            socket.stop();
            return false;
        }
    }

    public Iterable<JobApplicationDTO> getJobApplicationForCandidate(final EmailAddress emailAddress)
            throws IOException {
        final var socket = new ClientSocket();

        socket.connect(DEI_IP, DEI_PORT);

        final byte[] request = new GetJobApplicationForCandidate(emailAddress).execute();

        socket.send(request);

        final byte[] response = socket.recv();

        socket.stop();

        final MarshlerUnmarshler mu = new MarshlerUnmarshler();

        return mu.parseResponseMessageGetJobApplication(response);
    }




    public Iterable<jobs4u.app.candidate.console.checkNotifications.dto.NotificationDTO> getNotificationReadForCandidate(final String email)
            throws IOException {
        final var socket = new FollowUpServerProxy.ClientSocket();

        socket.connect(DEI_IP, DEI_PORT);
        final byte[] request = new GetNotificationsReadRequestDTO(email).execute();

        socket.send(request);

        final byte[] response = socket.recv();

        socket.stop();

        final MarshlerUnmarshler mu = new MarshlerUnmarshler();

        return mu.parseResponseMessageGetNotificationsRead(response);

    }

    public Iterable<jobs4u.app.candidate.console.checkNotifications.dto.NotificationDTO> getNotificationNotReadForCandidate(final String email)
            throws IOException {
        final var socket = new FollowUpServerProxy.ClientSocket();

        socket.connect(DEI_IP, DEI_PORT);
        final byte[] request = new GetNotificationsNotReadRequestDTO(email).execute();

        socket.send(request);

        final byte[] response = socket.recv();

        socket.stop();

        final MarshlerUnmarshler mu = new MarshlerUnmarshler();

        return mu.parseResponseMessageGetNotificationsNotRead(response);

    }






}
