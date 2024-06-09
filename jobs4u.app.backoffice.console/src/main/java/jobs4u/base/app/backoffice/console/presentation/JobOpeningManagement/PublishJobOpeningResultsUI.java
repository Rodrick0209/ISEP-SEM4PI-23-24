package jobs4u.base.app.backoffice.console.presentation.JobOpeningManagement;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.PublishJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublishJobOpeningUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(PublishJobOpeningUI.class);

    private final PublishJobOpeningController theController = new PublishJobOpeningController(
            AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobOpenings(), PersistenceContext.repositories().jobApplications());


    public boolean show() {


        Iterable<JobOpening> jobOpenings = this.theController.getJobOpenings();
        if(jobOpenings == null){
            System.out.println("There are no job openings to publish.");
            return false;
        }
        int i =1;
        for (JobOpening jobOpening : jobOpenings) {
            System.out.printf("%4d - %s",i ,jobOpening.jobReference());
            i++;
        }
        System.out.println("Please choose the job opening to publish:");
        int option = Integer.parseInt(System.console().readLine());
        while(option <= 0 || option > i){
            System.out.println("Invalid option. Please choose a valid job opening:");
            option = Integer.parseInt(System.console().readLine());
        }
        JobOpening jobOpening = null;
        int j = 0;
        for (JobOpening job : jobOpenings) {
            if(j == option-1){
                jobOpening = job;
                break;
            }
            j++;
        }
        theController.publishJobOpeningResults(jobOpening);

        System.out.println("Job Opening Results Published!");




        return true;

    }

}
