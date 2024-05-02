package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.infrastructure.authz.application.*;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ListJobOpeningControllerTest {

    private ListJobOpeningContoller controller;

    private final AuthorizationService authorizedAuthz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }
        @Override
        public Optional<SystemUser> loggedinUserWithPermissions(Role... roles) {
            return Optional.of(dummyUser());
        }
    };

    private final JobOpeningRepository jobOpeningRepository = new JobOpeningRepository() {
        private List<JobOpening> jobOpenings = new ArrayList<>();

        @Override
        public <S extends JobOpening> S save(S entity) {
            jobOpenings.add(entity);
            return entity;
        }

        @Override
        public Iterable<JobOpening> findAll() {
            return jobOpenings;
        }

        @Override
        public Optional<JobOpening> ofIdentity(JobReference id) {
            return Optional.empty();
        }

        @Override
        public void delete(JobOpening entity) {

        }

        @Override
        public void deleteOfIdentity(JobReference entityId) {

        }

        @Override
        public long count() {
            return jobOpenings.size();
        }

        @Override
        public List<JobOpening> findByCustomerManager(SystemUser customer) {
            List<JobOpening> jobsReturn = new ArrayList<>();
            for (JobOpening job : jobOpenings) {
                if (job.getClient().getCustomerManagerEmail().equals(customer.email())) {
                    jobsReturn.add(job);
                }
            }

            return jobsReturn;
        }

        @Override
        public int countForClientCode(ClientCode clientCode) {
            return 0;
        }

        @Override
        public JobOpening findByJobApplication(JobApplication jobApplication) {
            return null;
        }
    };


    public static SystemUser dummyUser() {
        final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with("teste", "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(Jobs4uRoles.CUSTOMER_MANAGER).build();
    }

    public static SystemUser anotherDummyUser() {
        final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with("test1", "duMMy1", "dummy", "dummy", "teste@gmail.com").withRoles(Jobs4uRoles.CUSTOMER_MANAGER).build();
    }

    public static JobOpening jobOpening() {

        ClientMapper clientMapper = new ClientMapper();
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123",dummyUser().email());
        JobReference jobReference = new JobReference(client.code().toString());

        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(),client);
    }

    public static JobOpening jobOpening2() {

        ClientMapper clientMapper = new ClientMapper();
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123",anotherDummyUser().email());

        JobReference jobReference = new JobReference(client.clientCode().code());

        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(),client);
    }


    @Test
    public void ensureListJobOpeningWorksEmpty() {
        controller = new ListJobOpeningContoller(jobOpeningRepository, authorizedAuthz);

        List<JobOpening> jobOpenings = controller.jobOpeningsFromRepository();
        assertEquals(0, jobOpenings.size());
    }


    @Test
    public void ensureRegisterJobOpeningWorksNotEmpty() {
        jobOpeningRepository.save(jobOpening());

        controller = new ListJobOpeningContoller(jobOpeningRepository, authorizedAuthz);

        List<JobOpening> jobOpenings = controller.jobOpeningsFromRepository();

        assertEquals(1, jobOpenings.size());

    }

    @Test
    public void ensureRegisterJobOpeningWorksJustForJobOpeningOfTheCustomerManager() {
        jobOpeningRepository.save(jobOpening());
        jobOpeningRepository.save(jobOpening2());

        controller = new ListJobOpeningContoller(jobOpeningRepository, authorizedAuthz);


        List<JobOpening> jobOpenings = controller.jobOpeningsFromRepository();


        assertEquals(1, jobOpenings.size());
        assertEquals(2,jobOpeningRepository.count());
    }

}