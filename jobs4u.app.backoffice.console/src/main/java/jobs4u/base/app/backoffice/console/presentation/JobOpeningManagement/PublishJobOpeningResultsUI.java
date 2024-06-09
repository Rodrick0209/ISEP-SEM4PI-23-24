package jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.PublishJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PublishJobOpeningResultsUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(PublishJobOpeningResultsUI.class);

    private final PublishJobOpeningController theController = new PublishJobOpeningController(
            AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobOpenings(), PersistenceContext.repositories().jobApplications());


    public boolean doShow() {


        List<JobOpening> jobOpenings = theController.getJobOpenings();
        if(jobOpenings == null){
            System.out.println("There are no job openings to publish.");
            return false;
        }
        int i =1;
        for (JobOpening jobOpening : jobOpenings) {
            System.out.printf("%4d - %s",i ,jobOpening.jobReference());
            i++;
        }
        //System.out.println("Please choose the job opening to publish:");
        int option = Integer.parseInt(Console.readLine("Please choose the job opening to publish:"));
        while(option <= 0 || option > i){
            System.out.println("Invalid option. Please choose a valid job opening:");
            option = Integer.parseInt(System.console().readLine());
        }

        JobOpening jobOpening = jobOpenings.get(option-1);

        theController.publishJobOpeningResults(jobOpening);

        LOGGER.info("Job Opening Results Published");
        
        return true;

    }

    @Override
    public String headline() {
        return "Publish Job Opening Results";
    }

}
