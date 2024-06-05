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
import jakarta.persistence.criteria.CriteriaBuilder;
import jobs4u.base.Application;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.application.RegisterClientController;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.application.RegisterJobApplicationController;
import jobs4u.base.jobApplications.domain.*;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.application.RegisterJobOpeningController;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import jobs4u.base.recruitmentProcessManagement.domain.Phase;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcessBuilder;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcessDirector;
import jobs4u.base.recruitmentProcessManagement.dto.RecruitmentProcessDto;
import jobs4u.base.recruitmentProcessManagement.utils.DateUtils;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import eapli.framework.actions.Action;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.Path;

import java.time.ZoneId;

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

    final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();

    final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    final JobRequirementSpecificationRepository jobRequirementSpecificationRepository = PersistenceContext.repositories().jobRequirementsSpecification();
    final InterviewModelSpecificationRepository interviewModelSpecificationRepository = PersistenceContext.repositories().interviewModelsSpecification();
    final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

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

        SystemUser user = registerCustomer("customer@gmail.com", TestDataConstants.PASSWORD1, "customer", "Doe customer",
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
        client.setUser(user);


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

        RecruitmentProcessDto recruitmentProcessDto = new RecruitmentProcessDto(
                DateUtils.parseDate("18-04-2024"),
                DateUtils.parseDate("18-05-2024"), DateUtils.parseDate("19-05-2024"),
                DateUtils.parseDate("20-05-2024"), DateUtils.parseDate("21-05-2024"),
                DateUtils.parseDate("22-05-2024"), DateUtils.parseDate("23-05-2024"),
                DateUtils.parseDate("01-06-2024"), DateUtils.parseDate("29-06-2024"),
                DateUtils.parseDate("30-06-2024"));
        RecruitmentProcessBuilder recruitmentProcessBuilder = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector = new RecruitmentProcessDirector(recruitmentProcessBuilder);
        RecruitmentProcess recruitmentProcess = recruitmentProcessDirector.createRecruitmentProcessWithInterview(recruitmentProcessDto);
        recruitmentProcess.analysisPhase().openPhase();

        RecruitmentProcessDto recruitmentProcessDto1 = new RecruitmentProcessDto(
                DateUtils.parseDate("18-04-2024"),
                DateUtils.parseDate("18-05-2024"), DateUtils.parseDate("28-05-2024"),
                DateUtils.parseDate("29-05-2024"), DateUtils.parseDate("30-05-2024"),
                DateUtils.parseDate("01-06-2024"), DateUtils.parseDate("23-07-2024"),
                DateUtils.parseDate("24-08-2024"), DateUtils.parseDate("29-09-2024"),
                DateUtils.parseDate("30-10-2024"));
        RecruitmentProcessBuilder recruitmentProcessBuilder1 = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector1 = new RecruitmentProcessDirector(recruitmentProcessBuilder1);
        RecruitmentProcess recruitmentProcess1 = recruitmentProcessDirector1.createRecruitmentProcessWithInterview(recruitmentProcessDto1);

        RecruitmentProcessDto recruitmentProcessDto2 = new RecruitmentProcessDto(
                DateUtils.parseDate("18-06-2024"),
                DateUtils.parseDate("18-06-2024"), DateUtils.parseDate("19-06-2024"),
                DateUtils.parseDate("20-06-2024"), DateUtils.parseDate("21-06-2024"),
                DateUtils.parseDate("22-06-2024"), DateUtils.parseDate("23-06-2024"),
                DateUtils.parseDate("24-06-2024"), DateUtils.parseDate("29-06-2024"),
                DateUtils.parseDate("30-06-2024"));
        RecruitmentProcessBuilder recruitmentProcessBuilder2 = new RecruitmentProcessBuilder();
        RecruitmentProcessDirector recruitmentProcessDirector2 = new RecruitmentProcessDirector(recruitmentProcessBuilder2);
        RecruitmentProcess recruitmentProcess2 = recruitmentProcessDirector2.createRecruitmentProcessWithInterview(recruitmentProcessDto2);
        recruitmentProcess2.interviewsPhase().openPhase();

        //---------------------------------------------------------------------------------------------------
        //Register Job Openings
        //---------------------------------------------------------------------------------------------------
        JobOpening j = registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Software Engineer designs, develops, and maintains software applications. They work on various stages of software development lifecycle, from designing algorithms to debugging and testing code.",
                "Software Engineer", ContractType.FULL_TIME, client, recruitmentProcess);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Data Scientist analyzes and interprets complex data to inform business decision-making. They use statistical techniques and machine learning algorithms to extract insights from data",
                "Data Scientist", ContractType.FULL_TIME, client1);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Marketing Manager develops and implements marketing strategies to promote products or services. They conduct market research, identify target audiences, and oversee advertising campaigns.",
                "Marketing Manager", ContractType.FULL_TIME, client, recruitmentProcess);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Financial Analyst evaluates financial data to provide insights and recommendations for business decision-making. They analyze market trends, assess investment opportunities, and prepare financial reports.",
                "Financial Analyst", ContractType.FULL_TIME, client2);

        JobOpening jobOpening = registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "A Software Engineer designs, develops, and maintains software applications. They work on various stages of software development lifecycle, from designing algorithms to debugging and testing code.",
                "Software Engineer", ContractType.FULL_TIME, client1, recruitmentProcess);

        //Register IBM-000123 jobOpening
        JobOpening jobOpening1 = registerJobOpening("IBM-000123", WorkingMode.REMOTE, "1", "1234-123",
                "A Software Engineer designs, develops, and maintains software applications. They work on various stages of software development lifecycle, from designing algorithms to debugging and testing code.",
                "Software Engineer", ContractType.FULL_TIME, client3, recruitmentProcess1);

        RequirementSpecification jobRequirementSpecification = new RequirementSpecification("programador2AnosExperiencia", "jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementService");
        jobRequirementSpecificationRepository.save(jobRequirementSpecification);

        jobOpening1.selectJobRequirementSpecification(jobRequirementSpecification);
        jobOpeningRepository.save(jobOpening1);

        JobOpening jobOpening2 = registerJobOpening("GTECH-001241", WorkingMode.REMOTE, "1", "1234-123",
                "GreenTech Solutions is at the forefront of sustainable technology development, specializing in creating innovative chemical processes that minimize environmental impact.",
                "Chemical Engineer", ContractType.FULL_TIME, client3, recruitmentProcess2);

        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification("quimicoInterview", "jobs4u.integration.plugins.QuimicoInterview.InterviewManagement.InterviewService");
        interviewModelSpecificationRepository.save(interviewModelSpecification);

        jobOpening2.selectInterviewModelSpecification(interviewModelSpecification);
        jobOpeningRepository.save(jobOpening2);

        //---------------------------------------------------------------------------------------------------
        //Register Candidate
        //---------------------------------------------------------------------------------------------------
        Candidate candidate = new Candidate("Amilcar",
                "Leitão", "amilcar@gmail.com", "919111228");
        candidateRepository.save(candidate);


        Candidate candidate1 = new Candidate("Sebastião", "Tobaldo", "sebtob@gmail.com", "919131222");
        candidateRepository.save(candidate1);

        Candidate candidate2 = new Candidate("Carlos", "Tesmeão", "cates@gmail.com", "919131322");
        candidateRepository.save(candidate2);

        Candidate candidate3 = new Candidate("teste", "Teste", "teste@gmail.com", "919131325");
        candidateRepository.save(candidate3);

        Candidate candidate4 = new Candidate("candidate", "candidato", "candidate@gmail.com", "919121299");
        candidateRepository.save(candidate4);


        //---------------------------------------------------------------------------------------------------
        //Register Job Application
        //---------------------------------------------------------------------------------------------------
        List<JobApplicationFile> file = List.of(
                new JobApplicationFile("2-candidate-data.txt", new Path("SCOMP/output/MTN1-2/2/2-candidate-data.txt")),
                new JobApplicationFile("2-cv.txt", new Path("SCOMP/output/MTN1-2/2/2-cv.txt")),
                new JobApplicationFile("2-email.txt", new Path("SCOMP/output/MTN1-2/2/2-big-file1.txt")));

        List<JobApplicationFile> file1 = List.of(new JobApplicationFile("2-cv.txt", new Path("SCOMP/output/MTN1-2/2/2-cv.txt")));
        List<JobApplicationFile> file2 = List.of(new JobApplicationFile("2-email.txt", new Path("SCOMP/output/MTN1-2/2/2-email.txt")));


        JobApplication jobApplication = new JobApplication(1L, j, file, candidate);
        jobApplication.registerRequirementAnswer("answerFromCandidate1Test.answer");
        jobApplication.registerInterivew(Date.valueOf(LocalDate.now().toString()), Time.valueOf("23:48"));
        jobApplication.interview().registerInterviewAnswer("answerFromCandidate2Test.answer");
        jobApplication.interview().grade(InterviewPoints.valueOf(65));
        JobApplication jobApplication1 = new JobApplication(2L, jobOpening, file1, candidate1);
        jobApplication1.registerRequirementAnswer("answerFromCandidate1Test.answer");
        jobApplication1.registerInterivew(Date.valueOf(LocalDate.now().toString()), Time.valueOf("23:48"));
        jobApplication1.interview().registerInterviewAnswer("answerFromCandidate2Test.answer");
        jobApplication1.interview().grade(InterviewPoints.valueOf(10));
        JobApplication jobApplication2 = new JobApplication(3L, jobOpening, file2, candidate2);
        jobApplication2.registerRequirementAnswer("answerFromCandidate1Test.answer");
        jobApplication2.registerInterivew(Date.valueOf(LocalDate.now().toString()), Time.valueOf("23:48"));
        jobApplication2.interview().registerInterviewAnswer("answerFromCandidate2Test.answer");
        jobApplication2.interview().grade(InterviewPoints.valueOf(60));
        JobApplication jobApplication3 = new JobApplication(4L, jobOpening2, file2, candidate3);
        jobApplication3.registerInterivew(Date.valueOf(LocalDate.now().toString()), Time.valueOf("23:48"));
        jobApplication3.interview().registerInterviewAnswer("answerFromCandidate2Test.answer");
        jobApplication3.interview().grade(InterviewPoints.valueOf(23));
        JobApplication jobApplication4 = new JobApplication(5L, jobOpening2, file2, candidate2);
        jobApplication4.registerInterivew(Date.valueOf(LocalDate.now().toString()), Time.valueOf("23:48"));
        jobApplication4.interview().registerInterviewAnswer("answerFromCandidate2Test.answer");


        jobApplicationRepository.save(jobApplication);
        jobApplicationRepository.save(jobApplication1);
        jobApplicationRepository.save(jobApplication2);
        jobApplicationRepository.save(jobApplication3);
        jobApplicationRepository.save(jobApplication4);

        Notification notification = new Notification(client.getUser().email(), jobOpening);
        notificationRepository.save(notification);
        Notification notification1 = new Notification(client.getUser().email(), jobOpening1);
        notificationRepository.save(notification1);


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

    private SystemUser registerCustomer(final String username, final String password, final String firstName,
                                  final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.CUSTOMER);

        return registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerLanguageEngineer(final String username, final String password, final String firstName,
                                          final String lastName, final String email) {
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
            , RecruitmentProcess recruitmentProcess) {

        ClientDTO clientDTO = new ClientMapper().toDTO(client);

        return jobOpeningController.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType, clientDTO, recruitmentProcess);
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
            , RecruitmentProcess recruitmentProcess) {

        ClientDTO clientDTO = new ClientMapper().toDTO(client);

        return jobOpeningController.registerJobOpening(JobReference, workingMode, nrVacancy, address, description, function, contractType, clientDTO, recruitmentProcess);
    }

}
