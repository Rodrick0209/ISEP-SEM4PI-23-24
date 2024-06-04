package jobs4u.server.deamon.followup.server;

import eapli.framework.infrastructure.authz.application.Authenticator;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.authz.AuthenticationCredentialHandler;
import jobs4u.base.authz.CredentialHandler;

import java.util.Optional;

public class AuthRequest extends FollowUpRequest{

    private final Authenticator authenticationService;
    private final String username;
    private final String password;
    private final Role role;



    public AuthRequest(final Authenticator authenticationService, final String username, final String password, final String role) {
        super(null, null);
        this.authenticationService = authenticationService;
        this.username = username;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    @Override
    public byte[] execute() {

        byte [] response;

        Optional<UserSession> user = authenticationService.authenticate(username, password,role);
        if(user.isEmpty()) {
            response = new byte[4];
            response[0] = VERSION;
            response[1] = ERR;
            response[2] = 0;
            response[3] = 0;
            return response;
        }


        //check if it is a valid user
        response = new byte[4];
        response[0] = VERSION;
        response[1] = ACK;
        response[2] = 0;
        response[3] = 0;
        return response;

    }
}
