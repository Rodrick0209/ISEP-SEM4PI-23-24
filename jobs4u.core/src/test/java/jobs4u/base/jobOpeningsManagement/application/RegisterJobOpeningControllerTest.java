//package jobs4u.base.jobOpeningsManagement.application;
//
//import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
//import jobs4u.base.jobOpeningsManagement.domain.JobOpeningFactory;
//import jobs4u.base.jobOpeningsManagement.domain.JobReferenceService;
//import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
//import jobs4u.base.jobOpeningsManagement.utils.ContractType;
//import jobs4u.base.jobOpeningsManagement.utils.JobReference;
//import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
//import jobs4u.base.utils.ClientCode;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//public class RegisterJobOpeningControllerTest {
//
//    private RegisterJobOpeningController controller;
//    private JobOpeningRepository jobOpeningRepository;
//    private JobReferenceService jobReferenceService;
//    private JobOpeningFactory jobOpeningFactory;
//
//    @BeforeEach
//    public void setup() {
//        jobOpeningRepository = Mockito.mock(JobOpeningRepository.class);
//        jobReferenceService = Mockito.mock(JobReferenceService.class);
//        jobOpeningFactory = Mockito.mock(JobOpeningFactory.class);
//        controller = new RegisterJobOpeningController();
//    }
//
//    @Test
//    public void testRegisterJobOpening() {
//        JobReference jobReference = new JobReference(ClientCode.valueOf("isep"), 1);
//        WorkingMode workingMode = WorkingMode.REMOTE;
//        String nrVacancy = "5";
//        String address = "1234-123";
//        String description = "Software Developer";
//        String function = "Develop software";
//        ContractType contractType = ContractType.FULL_TIME;
//
//        JobOpening expectedJobOpening = new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType);
//
//        when(jobReferenceService.createJobReference(any(ClientCode.class))).thenReturn(jobReference);
//        when(jobOpeningFactory.createJobOpening(any(JobReference.class), any(WorkingMode.class), any(String.class), any(String.class), any(String.class), any(String.class), any(ContractType.class))).thenReturn(expectedJobOpening);
//        when(jobOpeningRepository.save(any(JobOpening.class))).thenReturn(expectedJobOpening);
//
//        JobOpening actualJobOpening = controller.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType, "isep");
//
//        assertEquals(expectedJobOpening, actualJobOpening);
//    }
//}