package jobs4u.app.candidate.console.presentation.jobApplications;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.app.candidate.console.JobApplications.application.GetJobApplicationController;
import jobs4u.app.customer.console.authz.CredentialStore;
import jobs4u.app.customer.console.jobOpenings.application.GetJobOpeningsController;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationDTO;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.utils.ClientCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DisplayJobApplicationsUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayJobApplicationsUI.class);


    @Override
    protected boolean doShow() {
        GetJobApplicationController controller = new GetJobApplicationController();


        try {
            Iterable<JobApplicationDTO> list = controller.getJobApplicationsForCandidate(EmailAddress.valueOf(CredentialStore.getUsername()));

        System.out.println("Job openings:");

        for (JobApplicationDTO jobApplicationDTO : list) {
            System.out.println("- Job Reference: "+jobApplicationDTO.jobOpeningReference);
            System.out.println("- Application State: "+jobApplicationDTO.state);
            System.out.println("- Num applicants: "+jobApplicationDTO.numApplicants);
            System.out.println("\n");

        }

            /*
            for (JobOpeningDTO jobOpeningDTO : list) {
                System.out.println("- Job Reference: "+jobOpeningDTO.JobReference);
                System.out.println("    - Function: "+jobOpeningDTO.function);
                System.out.println("    - Active Since: "+jobOpeningDTO.creationDate);
                System.out.println("    - Number of Applications: "+jobOpeningDTO.numApplications);
                System.out.println("\n");
            }

             */
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
