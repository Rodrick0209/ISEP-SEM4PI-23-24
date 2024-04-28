package jobs4u.base.jobAplications.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.application.RegisterCandidateController;
import jobs4u.base.candidateManagement.application.RegisterCandidateFactory;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobAplications.domain.Interview;
import jobs4u.base.jobAplications.domain.JobApplication;
import jobs4u.base.jobAplications.domain.JobApplicationFile;
import jobs4u.base.jobAplications.domain.RequirementAnswer;
import jobs4u.base.jobAplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningFactory;
import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UseCaseController
public class RegisterJobApplicationController {

    private final JobApplicationRepository jobApplicationRepository;
    private final CandidateRepository candidateRepository;
    private final AuthorizationService authz;

    private final GetApplicationDataService getApplicationDataService = new GetApplicationDataService();

    private final RegisterCandidateController registerCandidateController = RegisterCandidateFactory.build();

    public RegisterJobApplicationController(JobApplicationRepository jobApplicationRepository,CandidateRepository candidateRepository, AuthorizationService authz) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.candidateRepository = candidateRepository;
        this.authz = authz;
    }


    public JobApplication registerJobApplication(String id, String jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.OPERATOR, Jobs4uRoles.POWER_USER);
        List<JobApplicationFile> file = getApplicationDataService.getApplicationFiles(jobReference,id);
        JobApplication jobApplication = new JobApplication(Long.parseLong(id), file);
        Map<String,String> clientInfo=getApplicationDataService.getCandidateInfo(jobApplication.getFile());

        Candidate candidate= createCandidateIfCandidateDoestExists(clientInfo);
        candidate.addApplication(jobApplication);
        registerCandidateController.registerCandidate(candidate.emailAddress().toString(), candidate.name().firstName(), candidate.name().lastName(), candidate.phoneNumber().toString());
        return jobApplicationRepository.save(jobApplication);
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

}