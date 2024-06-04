package jobs4u.app.customer.console.presentation.JobOpening;

import com.zaxxer.hikari.util.ConcurrentBag;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.app.customer.console.authz.CredentialStore;
import jobs4u.app.customer.console.jobOpenings.application.GetJobOpeningsController;
import jobs4u.base.authz.CredentialHandler;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.ListJobOpeningContoller;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.utils.ClientCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

public class DisplayJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayJobOpeningUI.class);

    //private final ListJobOpeningContoller theController = new ListJobOpeningContoller(PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        GetJobOpeningsController controller = new GetJobOpeningsController();

        try {

            String code=controller.getCustomerCode(CredentialStore.getUsername());
            Iterable<JobOpeningDTO> list = controller.getJobOpeningsForCustomer(ClientCode.valueOf(code));
            System.out.println("Job openings:");

            for (JobOpeningDTO jobOpeningDTO : list) {
                System.out.println("- Job Reference: "+jobOpeningDTO.JobReference);
                System.out.println("    - Function: "+jobOpeningDTO.function);
                System.out.println("    - Active Since: "+jobOpeningDTO.creationDate);
                System.out.println("    - Number of Applications: "+jobOpeningDTO.numApplications);
                System.out.println("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }



    @Override
    public String headline() {
        return "List job openings";
    }
}
