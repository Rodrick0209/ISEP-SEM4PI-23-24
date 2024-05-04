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
import jobs4u.base.pluginManagement.domain.JobRequirementSpecification;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
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

    final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();


    @Override
    public boolean execute() {

        //---------------------------------------------------------------------------------------------------
        //Register user
        //---------------------------------------------------------------------------------------------------
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


        //---------------------------------------------------------------------------------------------------
        //Register clients
        //---------------------------------------------------------------------------------------------------
        Client client = clientController.registerClient("Isep1",
                "instituto Superior de Engenharia do Porto",
                "isep@gmail.com",
                "919111222", "1234-123",
                "Luis",
                "Gonçalves",
                EmailAddress.valueOf("customermanager@gmail.com"));


        Client client1 = clientController.registerClient(
                "MTN1",
                "medicina do trabalho do Norte",
                "mtn@gmail.com",
                "919112223", "1224-133",
                "Sergio",
                "Augusto",
                EmailAddress.valueOf("customermanager@gmail.com"));

        Client client3 = clientController.registerClient(
                "IBM",
                "IBM",
                "ibm@gmail.com",
                "919112323", "1224-123",
                "Sergio",
                "Augusto",
                EmailAddress.valueOf("customermanager@gmail.com"));


        Client client2 = clientController.registerClient("MTN2",
                "Ministerio da terra e natureza",
                "mtneza@gmail.com",
                "919111232",
                "1434-123",
                "Oscar",
                "Cardoso",
                EmailAddress.valueOf("anothercustomermanager@gmail.com"));





        //---------------------------------------------------------------------------------------------------
        //create Recruitment Process
        //---------------------------------------------------------------------------------------------------
        List<Phase> phases = List.of(
                new Phase(Phases.APPLICATION, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 30)),
                new Phase(Phases.RESUME_SCREEN, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 5)),
                new Phase(Phases.ANALYSIS, LocalDate.of(2024, 6, 6), LocalDate.of(2024, 7, 1)),
                new Phase(Phases.RESULT, LocalDate.of(2024, 7, 2), LocalDate.of(2024, 8, 1)));

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(phases);




        //---------------------------------------------------------------------------------------------------
        //Register Job Openings
        //---------------------------------------------------------------------------------------------------
        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Software Engineer designs, develops, and maintains software applications. They work on various stages of software development lifecycle, from designing algorithms to debugging and testing code.",
                "Software Engineer", ContractType.FULL_TIME, client,recruitmentProcess);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Data Scientist analyzes and interprets complex data to inform business decision-making. They use statistical techniques and machine learning algorithms to extract insights from data",
                "Data Scientist", ContractType.FULL_TIME, client1,recruitmentProcess);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Marketing Manager develops and implements marketing strategies to promote products or services. They conduct market research, identify target audiences, and oversee advertising campaigns.",
                "Marketing Manager", ContractType.FULL_TIME, client);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Financial Analyst evaluates financial data to provide insights and recommendations for business decision-making. They analyze market trends, assess investment opportunities, and prepare financial reports.",
                "Financial Analyst", ContractType.FULL_TIME, client2);

        JobOpening jobOpening = registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Software Engineer designs, develops, and maintains software applications. They work on various stages of software development lifecycle, from designing algorithms to debugging and testing code.",
                "Software Engineer", ContractType.FULL_TIME, client1,recruitmentProcess);


        //Register IBM-000123 jobOpening
        registerJobOpening("IBM-000123",WorkingMode.REMOTE, "1", "1234-123",
                "A Software Engineer designs, develops, and maintains software applications. They work on various stages of software development lifecycle, from designing algorithms to debugging and testing code.",
                "Software Engineer", ContractType.FULL_TIME, client3,recruitmentProcess);

        //---------------------------------------------------------------------------------------------------
        //Register Candidate
        //---------------------------------------------------------------------------------------------------
        Candidate candidate = new Candidate("Amilcar",
                "Leitão","amilcar@gmail.com","919111228");
        candidateRepository.save(candidate);


        Candidate candidate1 = new Candidate("Sebastião", "Tobaldo","sebtob@gmail.com","919131222");
        candidateRepository.save(candidate1);



        //---------------------------------------------------------------------------------------------------
        //Register Job Application
        //---------------------------------------------------------------------------------------------------
        List<JobApplicationFile> file = List.of(new JobApplicationFile("file1", new Path("file1.pdf")));
        List<JobApplicationFile> file1 = List.of(new JobApplicationFile("file2", new Path("file1.pdf")));


        JobApplication jobApplication = new JobApplication(1L,file,candidate);
        JobApplication jobApplication1 = new JobApplication(2L,file1,candidate);
        jobOpeningController.addJobApplicationToJobOpening(jobOpening, List.of(jobApplication,jobApplication1));


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

    public JobOpening registerJobOpening(
            String JobReference
            , WorkingMode workingMode
            , String nrVacancy
            , String address
            , String description
            , String function
            , ContractType contractType
            , Client client
            , RecruitmentProcess recruitmentProcess){

        ClientDTO clientDTO = new ClientMapper().toDTO(client);

        return jobOpeningController.registerJobOpening(JobReference,workingMode, nrVacancy, address, description, function, contractType, clientDTO,recruitmentProcess);
    }

}
