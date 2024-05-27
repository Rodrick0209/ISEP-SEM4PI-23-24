package jobs4u.base;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.usermanagement.domain.Jobs4uPasswordPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FollowUpDeamon {

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpDeamon.class);
    private static final int FOLLOWUP_PORT = 9999;

    public static void main(final String[] args) {
        LOGGER.info("Configuring the daemon");

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new Jobs4uPasswordPolicy(),
                new PlainTextEncoder());

        LOGGER.info("Starting the server socket on port {}", FOLLOWUP_PORT);
        //final var server = new CsvBookingProtocolServer(buildServerDependencies());
        //server.start(BOOKING_PORT, true);
        final var server = new jobs4u.base.jobs4u.base.presentation.FollowUpServer();
        server.start(FOLLOWUP_PORT, true);

        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }
}
