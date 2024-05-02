/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jobs4u.base.infrastructure.bootstrapers;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.application.RegisterClientController;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.RegisterJobApplicationController;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.application.RegisterJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.recruitmentProcessManagement.domain.Phase;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import eapli.framework.actions.Action;
import jobs4u.base.utils.Path;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {


    final RegisterJobOpeningController jobOpeningController = new RegisterJobOpeningController(PersistenceContext.repositories().jobOpenings(),
            PersistenceContext.repositories().clients(), AuthzRegistry.authorizationService());

    final RegisterClientController clientController = new RegisterClientController(PersistenceContext.repositories().clients(),
            AuthzRegistry.authorizationService(), InProcessPubSub.publisher());

    final RegisterJobApplicationController jobApplicationController = new RegisterJobApplicationController(PersistenceContext.repositories().jobApplications(),
            PersistenceContext.repositories().candidates(), AuthzRegistry.authorizationService(), PersistenceContext.repositories().jobOpenings());


    final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    @Override
    public boolean execute() {

        Client client = clientController.registerClient("client1", "client1", "client@gmail.com",
                "919111222", "1234-123", "First",
                "Last", EmailAddress.valueOf("customermanager1@gmail.com"));

        Client client1 = clientController.registerClient("client2", "client2", "client2@gmail.com",
                "919112222", "1224-123", "Second",
                "Last", EmailAddress.valueOf("customermanager@gmail.com"));


        List<JobApplicationFile> file = List.of(new JobApplicationFile("file1", new Path("file1")));

        Candidate candidate = new Candidate("First", "Last","candidate@gmail.com","919111222");
        candidateRepository.save(candidate);
        Candidate candidate1 = new Candidate("Doe", "asd","candidat2e@gmail.com","919111222");
        candidateRepository.save(candidate1);
        JobApplication jobApplication = new JobApplication(1L,file,candidate);
        jobApplicationRepository.save(jobApplication);


        Client client2 = clientController.registerClient("uio1", "uio", "client@gmail.com",
                "919111222", "1234-123", "First",
                "Last", EmailAddress.valueOf("customermanager1@gmail.com"));

        registerAdmin("admin@gmail.com", TestDataConstants.PASSWORD1, "Admin", "Doe Admin",
                "admin@gmail.com");

       registerCustomerManager("customermanager@gmail.com", TestDataConstants.PASSWORD1, "Customer", "Doe CustomerManager",
               "customermanager@gmail.com");

        registerOperator("operator@gmail.com", TestDataConstants.PASSWORD1, "operator", "Doe operator",
                "operator@gmail.com");

        registerCandidate("candidate@gmail.com", TestDataConstants.PASSWORD1, "candidate", "Doe candidate",
                "candidate@gmail.com");

        registerCustomer("customer@gmail.com", TestDataConstants.PASSWORD1, "customer", "Doe customer",
                "customer@gmail.com");

        registerLanguageEngineer("language@gmail.com", TestDataConstants.PASSWORD1, "languageEngineer", "Doe LanguageEngineer",
                "language@gmail.com");

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description", "Function", ContractType.FULL_TIME, client);


        JobOpening jobOpening = registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description", "Function", ContractType.FULL_TIME, client1);

        jobOpeningController.addJobApplicationToJobOpening(jobOpening, jobApplication);


        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description", "Function", ContractType.FULL_TIME, client1);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description1", "Function", ContractType.FULL_TIME, client);


        List<Phase> phases = List.of(
                new Phase(Phases.APPLICATION, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 1)),
                new Phase(Phases.RESUME_SCREEN, LocalDate.of(2024, 5, 2), LocalDate.of(2024, 6, 1)),
                new Phase(Phases.ANALYSIS, LocalDate.of(2024, 6, 2), LocalDate.of(2024, 7, 1)),
                new Phase(Phases.RESULT, LocalDate.of(2024, 7, 2), LocalDate.of(2024, 8, 1)));

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description1", "Function", ContractType.FULL_TIME, client2,recruitmentProcess);


        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomerManager(final String username, final String password, final String firstName,
                               final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.CUSTOMER_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCandidate(final String username, final String password, final String firstName,
                                         final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.CANDIDATE);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerOperator(final String username, final String password, final String firstName,
                                   final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.OPERATOR);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomer(final String username, final String password, final String firstName,
                                  final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.CUSTOMER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerLanguageEngineer(final String username, final String password, final String firstName,
                                          final String lastName, final String email){
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.LANGUAGE_ENGINEER);

        registerUser(username, password, firstName, lastName, email, roles);
    }



    public JobOpening registerJobOpening(WorkingMode workingMode
            , String nrVacancy
            , String address
            , String description
            , String function
            , ContractType contractType
            , Client client) {

        ClientDTO clientDTO = new ClientMapper().toDTO(client);

        return jobOpeningController.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType, clientDTO);
    }

    public JobOpening registerJobOpening(WorkingMode workingMode
            , String nrVacancy
            , String address
            , String description
            , String function
            , ContractType contractType
            , Client client
            , RecruitmentProcess recruitmentProcess){

        ClientDTO clientDTO = new ClientMapper().toDTO(client);

        return jobOpeningController.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType, clientDTO,recruitmentProcess);
    }

}
