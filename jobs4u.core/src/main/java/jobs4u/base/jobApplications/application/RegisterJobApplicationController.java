package jobs4u.base.jobApplications.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.candidateManagement.application.RegisterCandidateController;
import jobs4u.base.candidateManagement.application.RegisterCandidateFactory;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.*;

@UseCaseController
public class RegisterJobApplicationController {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final CandidateRepository candidateRepository;
    private final AuthorizationService authz;

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();

    private final GetApplicationDataService getApplicationDataService = new GetApplicationDataService();

    private final RegisterCandidateController registerCandidateController = RegisterCandidateFactory.build();

    public RegisterJobApplicationController(JobApplicationRepository jobApplicationRepository,
                                            CandidateRepository candidateRepository,
                                            AuthorizationService authz,
                                            JobOpeningRepository jobOpeningRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.candidateRepository = candidateRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }


    public JobApplication registerJobApplication(String id, String jobReference) {

        txCtx.beginTransaction();
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.OPERATOR, Jobs4uRoles.POWER_USER);

        //Get job opening
        JobOpening jobOpening = jobOpeningRepository.ofIdentity(new JobReference(jobReference)).get();

        //Get Files from report.txt
        List<JobApplicationFile> file = getApplicationDataService.getApplicationFiles(jobReference,id);

        //Get client info from candidate-data.txt
        Map<String,String> clientInfo=getApplicationDataService.getCandidateInfo(file);

        //create or get the candidate
        Candidate candidate= createCandidateIfCandidateDoestExists(clientInfo);

        registerCandidateController.registerCandidate(candidate);

        //Create JobApplication
        JobApplication jobApplication = new JobApplication(Long.parseLong(id),jobOpening, file, candidate);

        jobApplicationRepository.save(jobApplication);
        checkIfIsFirstApplicationsBeingAdded(jobOpening);
        txCtx.commit();

        return jobApplication;
    }


    public List<JobOpening> getJobReferenceFromReportFile(){
        return getApplicationDataService.getJobReferencesFromFileBot();
    }

    public List<String> getApplicationFromReportFile(String jobReference){
        return getApplicationDataService.getApplicationFromFileBot(jobReference);
    }


    private Candidate createCandidateIfCandidateDoestExists(Map<String,String> clientInfo){

        if (!candidateRepository.containsOfIdentity(EmailAddress.valueOf(clientInfo.get("email")))){
            String fullName = clientInfo.get("name");
            String[] nameParts = fullName.split(" ", 2);
            String firstName = nameParts[0];
            String lastName = nameParts.length > 1 ? nameParts[1] : "";

            return new Candidate(
                    firstName,
                    lastName,
                    clientInfo.get("email"),
                    clientInfo.get("phoneNumber")
            );

        }else {
            return candidateRepository.ofIdentity(EmailAddress.valueOf(clientInfo.get("email"))).get();
        }

    }

    public void wantsToCloseApplicationPhase(JobOpening jobOpening){
        jobOpening.recruitmentProcess().applicationPhase().setState(State.FINISHED);
        jobOpeningRepository.save(jobOpening);
    }

    private void checkIfIsFirstApplicationsBeingAdded(JobOpening jobOpening){
      if ( (long) jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening).size() == 1)
            jobOpening.recruitmentProcess().resumeScreenPhase().setState(State.ACTIVE);
    }

}