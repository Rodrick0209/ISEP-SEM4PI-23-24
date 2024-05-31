package jobs4u.server.deamon;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import jobs4u.server.deamon.followup.server.FollowUpMessageParser;
import jobs4u.server.deamon.presentation.FollowUpServer;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.usermanagement.domain.Jobs4uPasswordPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FollowUpDeamon {

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpDeamon.class);
    private static final int FOLLOWUP_PORT = 9999;

    public FollowUpDeamon() {
        // ensure the code is not instantiated
    }

    public static void main(final String[] args) {
        LOGGER.info("Configuring the daemon");

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new Jobs4uPasswordPolicy(),
                new PlainTextEncoder());

        LOGGER.info("Starting the server socket on port {}", FOLLOWUP_PORT);
        //final var server = new CsvBookingProtocolServer(buildServerDependencies());
        //server.start(BOOKING_PORT, true);
        final var server = new FollowUpServer(buildServerDependencies());
        server.start(FOLLOWUP_PORT, true);

        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }

    private static FollowUpMessageParser buildServerDependencies() {
        return new FollowUpMessageParser(AuthzRegistry.authenticationService());
    }
}
