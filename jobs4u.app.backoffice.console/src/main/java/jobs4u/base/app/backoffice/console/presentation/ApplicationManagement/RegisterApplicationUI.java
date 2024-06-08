package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.RegisterJobApplicationController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RegisterApplicationUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterApplicationUI.class);


    private final RegisterJobApplicationController theController = new RegisterJobApplicationController(
            PersistenceContext.repositories().jobApplications(),
            PersistenceContext.repositories().candidates(),
            AuthzRegistry.authorizationService(),
            PersistenceContext.repositories().jobOpenings());

    @Override
    protected boolean doShow() {



        JobOpening jobOpening = requestJobOpening();
        if (jobOpening == null) {
            return false;
        }




        String jobApplicationId = requestApplication(jobOpening.jobReference());
        if (jobApplicationId == null) {
            return false;
        }


        try {
            this.theController.registerJobApplication(jobApplicationId, jobOpening.jobReference().toString());
            System.out.println("Job Application registered successfully.");

            System.out.println("Do you want to close the applicationPhase? (Y/N)");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            System.out.println("0 - Exit");
            int option = Console.readOption(1, 2, 0);
            switch (option){
                case 1:
                    theController.wantsToCloseApplicationPhase(jobOpening);
                    return true;
                case 2:
                    break;
                case 0:
                    return false;

            }

        } catch (IntegrityViolationException | ConcurrencyException ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
        }



        return true;
    }


    @Override
    public String headline() {
        return "Register Application";
    }


    private JobOpening requestJobOpening() {
        List<JobOpening> jobOpenings = theController.getJobReferenceFromReportFile();
        if (jobOpenings.isEmpty()) {
            System.out.println("There are no job openings available.");
            return null;
        }

        System.out.println("Select JobOpening ->");
        int i = 1;
        for (JobOpening jobOpening : jobOpenings) {
            System.out.println(i + ". " + jobOpening.jobReference());
            i++;
        }

        int option=Console.readOption(1,jobOpenings.size(),0);
        return jobOpenings.get(option-1);
    }


    private String requestApplication(JobReference jobReference) {
        List<String> jobApplication = theController.getApplicationFromReportFile(jobReference.toString());
        if (jobApplication.isEmpty()) {
            System.out.println("There are no job application available.");
            return null;
        }

        System.out.println("Select Job Application ->");
        int i = 1;
        for (String app : jobApplication) {
            System.out.println(i + ". " + app);
            i++;
        }
        int option=Console.readOption(1,jobApplication.size(),0);

        return jobApplication.get(option-1);
    }



}
