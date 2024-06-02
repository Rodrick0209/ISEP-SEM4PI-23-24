package jobs4u.app.customer.console.presentation.JobOpening;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.app.customer.console.jobOpenings.application.GetJobOpeningsController;
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
            Iterable<JobOpeningDTO> list = controller.getJobOpeningsForCustomer(ClientCode.valueOf("Isep1"));
            System.out.println("Job openings:");

            for (JobOpeningDTO jobOpeningDTO : list) {
                System.out.println("-"+jobOpeningDTO.JobReference);
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
