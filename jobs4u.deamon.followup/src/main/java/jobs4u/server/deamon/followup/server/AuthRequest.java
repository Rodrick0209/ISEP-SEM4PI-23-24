package jobs4u.server.deamon.followup.server;

import eapli.framework.infrastructure.authz.application.Authenticator;
import jobs4u.base.authz.AuthenticationCredentialHandler;
import jobs4u.base.authz.CredentialHandler;

public class AuthRequest extends FollowUpRequest{

    private final Authenticator authenticationService;
    private final String username;
    private final String password;



    public AuthRequest(final Authenticator authenticationService, final String username, final String password) {
        super(null, null);
        this.authenticationService = authenticationService;
        this.username = username;
        this.password = password;


    }

    @Override
    public byte[] execute() {

        //TODO implemenent authentication

        byte [] response;

        authenticationService.authenticate(username, password);


        //check if it is a valid user
        response = new byte[4];
        response[0] = VERSION;
        response[1] = ACK;
        response[2] = 0;
        response[3] = 0;
        return response;

    }
}
