package jobs4u.base.followup.server;

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

}
