package jobs4u.base.app.backoffice.console.presentation.RequirementsManagement;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.candidateManagement.application.NotifyCandidatesVerificationProcessController;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NotifyCandidatesVerificationProcessUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyCandidatesVerificationProcessUI.class);

    private static final NotifyCandidatesVerificationProcessController theController =
            new NotifyCandidatesVerificationProcessController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobOpenings());


    @Override
    protected boolean doShow(){

        List<JobOpening> jobOpenings = theController.getJobOpenings();
        if(jobOpenings.isEmpty()){
            System.out.println("There are no job openings to publish.");
            return false;
        }
        int i =1;
        for (JobOpening jobOpening : jobOpenings) {
            System.out.printf("%4d - %s",i ,jobOpening.jobReference());
            i++;
        }
        System.out.println("Please choose the job opening to notify the candidates:");
        int option = Integer.parseInt(System.console().readLine());
        while(option <= 0 || option > i){
            System.out.println("Invalid option. Please choose a valid job opening:");
            option = Integer.parseInt(System.console().readLine());
        }

        JobOpening jobOpening = jobOpenings.get(option-1);

        theController.notifyCandidatesVerificationProcess(jobOpening);

        LOGGER.info("Candidates notified of the result");


        return true;

    }

    @Override
    public String headline() {
        return "Notify Candidates of the Verification Process";
    }


}
