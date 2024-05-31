package jobs4u.server.deamon.followup.server;

import eapli.framework.infrastructure.authz.application.Authenticator;

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
        throw new UnsupportedOperationException("Not yet implemented");
        
    }
}
