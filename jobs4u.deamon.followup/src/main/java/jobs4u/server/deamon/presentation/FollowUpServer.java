package jobs4u.server.deamon.presentation;



import jobs4u.server.deamon.followup.server.FollowUpMessageParser;
import jobs4u.server.deamon.followup.server.FollowUpRequest;
import jobs4u.server.deamon.followup.server.DisconnectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FollowUpServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpServer.class);

    private static class ClientHandler extends Thread {

        private Socket clientSocket;
        private final FollowUpMessageParser parser;

        public ClientHandler(final Socket socket, final FollowUpMessageParser parser) {
            this.clientSocket = socket;
            this.parser = parser;
        }

        @Override
        public void run(){
            final var clientIP = clientSocket.getInetAddress();
            LOGGER.debug("Accepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());

            try (var out = new DataOutputStream(clientSocket.getOutputStream());
                 var in = new DataInputStream(clientSocket.getInputStream())){

                //byte[] input = readMessage(in);
                byte[] input;


                while ((input = readMessage(in)) != null){

                    LOGGER.debug("Received message:----\n{}\n----", input);
                    final FollowUpRequest request = parser.parse(input);
                    final byte[] response = request.execute();



                    LOGGER.info("sending response");
                    out.flush();
                    out.write(response);

                    System.out.println("response sent");
                    LOGGER.debug("Sent message:----\n{}\n----", response);
                    if (request.getClass().equals(DisconnectRequest.class)){
                        break;
                    }


                }
            } catch (final IOException e){
                LOGGER.error("ERROR OPENING SOCKET CONNECTION",e);
            } finally {
                try {
                    clientSocket.close();
                } catch (final IOException e){
                    LOGGER.error("ERROR CLOSING SOCKET CONNECTION",e);
                }
            }
        }

    }

    private final FollowUpMessageParser parser;

    public FollowUpServer(final FollowUpMessageParser parser){
        this.parser = parser;
    }

    private void listen(final int port){
        try (var serverSocket = new ServerSocket(port)){
            while (true){
                final var clientSocket = serverSocket.accept();
                System.out.println("client connected from " + clientSocket.getInetAddress());
                new ClientHandler(clientSocket, parser).start();
            }
        } catch (final IOException e){
            LOGGER.error("ERROR OPENING SERVER SOCKET",e);
        }
    }

    public void start(final int port, final boolean wait){
        if (wait){
            listen(port);
        } else {
            new Thread(() -> listen(port)).start();
        }
    }

    private static byte [] readMessage(DataInputStream in) throws IOException {
        System.out.println("readMessage()");
        List<Byte> input = new ArrayList<>();
        byte b = in.readByte();
        System.out.println(b);
        boolean flag = true;

        while (flag){


            input.add(b);
            try {
                if(in.available() == 0){
                    flag = false;
                }else {
                    b = in.readByte();
                    System.out.println(b);
                }
            } catch (EOFException e){
                //handle exception

                return null;


            }catch(SocketException se){
                flag = false;

            }


        }
        final byte[] message = new byte[input.size()];
        for (int i = 0; i < input.size(); i++){
            message[i] = input.get(i);
        }
        System.out.println("readMessage() done");
        return message;
    }
}
