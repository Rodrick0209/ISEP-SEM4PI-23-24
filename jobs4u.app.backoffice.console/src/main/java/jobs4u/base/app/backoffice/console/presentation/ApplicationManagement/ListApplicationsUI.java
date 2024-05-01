package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.jobApplications.application.ListApplicationController;
import jobs4u.base.jobApplications.domain.JobApplication;

public class ListApplicationsUI extends AbstractUI{

    private final ListApplicationController controller = new ListApplicationController();

    @Override
    protected boolean doShow() {

        Iterable<JobApplication> jobApplications = controller.listApplications();
        int i = 0;

        for (JobApplication j: jobApplications) {
            i++;
            System.out.printf("%4d.\n", i);
            System.out.printf("\t\t%s\n", j.getId());
            System.out.printf("\t\t%s\n", j.getCandidate().emailAddress());
            System.out.printf("\t\t%s\n", j.getCandidate().nameString());
            System.out.printf("\t\t%s\n", j.getState().toString());
        }

        return true;
    }
    
    @Override
    public String headline() {
        return "Applications List";
    }

}
