package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class JobReferenceServiceTest {

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
            return List.of();
        }

        @Override
        public int countForClientCode(ClientCode clientCode) {
            return 0;
        }
    };

    public static JobOpening jobOpening() {

        ClientMapper clientMapper = new ClientMapper();
        WorkingMode workingMode = WorkingMode.REMOTE;
        String nrVacancy = "5";
        String address = "1234-123";
        String description = "Software Developer";
        String function = "Develop software";
        ContractType contractType = ContractType.FULL_TIME;
        Client client = new Client("ISEP123","ISEP", "4123-123", EmailAddress.valueOf("email@gmail.com"));

        JobReference jobReference = new JobReference(client.code().toString());

        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, Calendar.getInstance(),null);
    }

    @Test
    public void testCreateJobReference() {
        JobReferenceService jobReferenceService = new JobReferenceService(jobOpeningRepository);

        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference expectedJobReference = new JobReference(clientCode.code()+"-1");
        JobReference actualJobReference = jobReferenceService.createJobReference(clientCode);
        assertEquals(expectedJobReference, actualJobReference);
    }


    @Test
    public void ensureReferenceNumberDoesntCounterReset() {
        JobReferenceService jobReferenceService = new JobReferenceService(jobOpeningRepository);
        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference expectedJobReference = new JobReference(clientCode.code()+"-1");
        JobReference actualJobReference = jobReferenceService.createJobReference(clientCode);
        assertEquals(expectedJobReference, actualJobReference);

        jobOpeningRepository.save(jobOpening());

        ClientCode clientCode1 = ClientCode.valueOf("isep");
        JobReference expectedJobReference1 = new JobReference(clientCode1.code()+"-2");
        JobReference actualJobReference1 = jobReferenceService.createJobReference(clientCode1);


        assertEquals(expectedJobReference1, actualJobReference1);

    }

}