package jobs4u.base.app.backoffice.console.presentation.candiateManagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.candidateManagement.application.EnableCandidateController;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EnableCandidateUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnableCandidateUI.class);

    private EnableCandidateController controller = new EnableCandidateController(AuthzRegistry.authorizationService(), AuthzRegistry.userService(), PersistenceContext.repositories().candidates());

    @Override
    protected boolean doShow() {
        List<SystemUser> disabledCandidateUsers = controller.disabledCandidates();
        showList(disabledCandidateUsers);
        if(disabledCandidateUsers.isEmpty()) {
            System.out.println("No candidates disabled");
            return true;
        }
        int option = Console.readOption(1, disabledCandidateUsers.size(), -1);
        SystemUser userToEnable = disabledCandidateUsers.get(option-1);
        try{
            controller.enable(userToEnable);
            System.out.println("Candidate enabled successfully!");
        } catch (ConcurrencyException | IntegrityViolationException ex){
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }
        return true;
    }

    private void showList(List<SystemUser> users){
        int cont = 1;
        System.out.println("Select a disabled candidate: ");
        for (SystemUser user: users){
            System.out.printf("%-6d%-30s%-30s%-30s%n", cont, user.email(), user.name().firstName(),
                    user.name().lastName());
            cont++;
        }
    }

    @Override
    public String headline() {
        return "Enable a candidate";
    }
}
