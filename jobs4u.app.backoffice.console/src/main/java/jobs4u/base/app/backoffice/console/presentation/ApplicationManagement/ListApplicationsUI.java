package jobs4u.base.app.backoffice.console.presentation.ApplicationManagement;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.base.jobApplications.application.ListApplicationController;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

import java.util.Iterator;

public class ListApplicationsUI extends AbstractUI{

    private final ListApplicationController controller = new ListApplicationController();

    @Override
    protected boolean doShow() {

        Iterable<JobOpening> jobOpenings = controller.listJobOpenings();
        if (!jobOpenings.iterator().hasNext()) {
            System.out.println("\nNo job openings found");
            return true;
        }
        int i = 0;

        for (JobOpening j: jobOpenings) {
            i++;
            System.out.printf("%4d.\n", i);
            System.out.printf("\t\t%s\n", j.jobReference().toString());
            System.out.printf("\t\t%s\n", j.status().toString());
        }
        int opcaoInt;
        boolean valid = false;
        do {
            String opcao = Console.readLine("Select a job opening");
            //check if option has letters
            if (opcao.matches(".*[a-zA-Z]+.*")) {
                System.out.println("Invalid option");
            } else {

                opcaoInt = Integer.parseInt(opcao);

                if (opcaoInt > i || opcaoInt < 1) {
                    System.out.println("Invalid option");
                } else {
                    opcaoInt--;
                    valid = true;
                    JobOpening jobOpening = getElementByIndex(jobOpenings.iterator(), opcaoInt);
                    showApplications(jobOpening);
                }
            }
        }while (!valid);



        return true;
    }

    private void showApplications(JobOpening jobOpening) {
        Iterable<JobApplication> jobApplications = controller.listApplications(jobOpening);
        if (!jobApplications.iterator().hasNext()) {
            System.out.println("\nNo applications found");
            return;
        }
        int i = 0;

        for (JobApplication j: jobApplications) {
            i++;
            System.out.printf("%4d.\n", i);
            System.out.printf("\t\tJobReference: %s\n", controller.getJobOpeningForJobApplication(j).identity().getJobReference());
            System.out.printf("\t\tid: %s\n", j.getId());
            System.out.printf("\t\temail: %s\n", j.getCandidate().emailAddress());
            System.out.printf("\t\tnome: %s\n", j.getCandidate().nameString());
            System.out.printf("\t\tstatus: %s\n", j.getState().toString());
        }
    }

    private static <T> T getElementByIndex(Iterator<T> iterator, int index) {
        int i = 0;
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (i == index) {
                return element;
            }
            i++;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }


    
    @Override
    public String headline() {
        return "Applications List";
    }

}
