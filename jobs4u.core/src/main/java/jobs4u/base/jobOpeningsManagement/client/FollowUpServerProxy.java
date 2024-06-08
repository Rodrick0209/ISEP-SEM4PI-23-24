package jobs4u.base.jobOpeningsManagement.client;

import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
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
    protected final static byte PUBLISHOPN = 87;

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

            while (in.available() == 0) {

            }
            ;
            while (in.available() > 0)
                resp.add(in.readByte());


            byte[] response = new byte[resp.size()];

            for (int i = 0; i < resp.size(); i++) {
                response[i] = resp.get(i);
            }

            return response;
        }
    }


    public boolean sendResultEmailRequest(JobOpening jobOpening) {

        try{
            ClientSocket client = new ClientSocket();
            client.connect(DEI_IP, DEI_PORT);

            byte[] request = new byte[4+DATA1_LEN_L+DATA1_LEN_M*256];

            request[0] = VERSION;
            request[1] = PUBLISHOPN;
            request[2] = DATA1_LEN_M;
            request[3] = DATA1_LEN_L;

            byte [] data = jobOpening.toString().getBytes();

            System.arraycopy(data, 0, request, 4, DATA1_LEN_L+DATA1_LEN_M*256);

            client.send(request);

            byte[] response = client.recv();

            client.stop();

            if (response[0] == ACK) {
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            LOGGER.error("Failed to send request to server");
            return false;
        }


    }

}
