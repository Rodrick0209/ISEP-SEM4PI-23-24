package jobs4u.base.persistence.impl.jpa;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import jobs4u.base.utils.ClientCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class JpaJobOpeningRepository extends BaseJpaRepositoryBase<JobOpening, JobReference,JobReference> implements JobOpeningRepository {

    public JpaJobOpeningRepository() {
        super("jobReference");
    }


    public List<JobOpening> findByCustomerManager(SystemUser customerManager) {

            EmailAddress managerEmail = customerManager.email();

            // Consultar JobOpenings associados ao cliente do gerente de cliente logado
            final Map<String, Object> params = new HashMap<>();
            params.put("managerEmail", managerEmail);

            // Consultar usando a query JPQL adequada
            return match("e.client.customerManagerEmail = :managerEmail", params);

    }

    @Override
    public int countForClientCode(ClientCode clientCode) {
        final Map<String, Object> params = new HashMap<>();
        params.put("clientCode", clientCode.code() + "-"); // Append '-' to match the format

        List<JobOpening> jobOpenings = match("e.jobReference.jobReference LIKE CONCAT(:clientCode, '%')", params);
        return jobOpenings.size();
    }

    @Override
    public JobOpening findByJobApplication(JobApplication jobApplication) {
        // Ensure the jobApplication is not null
        if (jobApplication == null) {
            throw new IllegalArgumentException("JobApplication cannot be null");
        }

        // JPQL query
        String jpql = "SELECT jo FROM JobOpening jo " +
                "JOIN jo.applications ja " +
                "WHERE ja = :jobApplication";

        // Execute the query
        List<JobOpening> jobOpenings = entityManager().createQuery(jpql, JobOpening.class)
                .setParameter("jobApplication", jobApplication)
                .getResultList();

        // If there are no jobOpenings found, return null
        if (jobOpenings.isEmpty()) {
            return null;
        }

        // Otherwise, return the first JobOpening found
        return jobOpenings.get(0);
    }

   @Override
    public List<JobOpening> findByCustomerManagerAndInAnalysisPhase(SystemUser customermanager) {


       // Ensure the jobApplication is not null
       if (customermanager == null) {
           throw new IllegalArgumentException("JobApplication cannot be null");
       }

       // JPQL query
       String jpql = "SELECT jo FROM JobOpening jo " +
               "WHERE jo.client.customerManagerEmail = :customermanager " +
                "AND jo.recruitmentProcess.applicationPhase.state = :analysisPhaseState";

       // Execute the query
       List<JobOpening> jobOpenings = entityManager().createQuery(jpql, JobOpening.class)
               .setParameter("customermanager", customermanager.email())
               .setParameter("analysisPhaseState", State.OPEN)
               .getResultList();

       // If there are no jobOpenings found, return null
       if (jobOpenings.isEmpty()) {
           return null;
       }

       // Otherwise, return the first JobOpening found
       return jobOpenings;
    }

    @Override
    public List<JobOpening> findAllInactiveJobOpenings() {
        // JPQL query
        String jpql = "SELECT jo FROM JobOpening jo " +
                "WHERE jo.status = :inactiveStatus";

        // Execute the query
        List<JobOpening> jobOpenings = entityManager().createQuery(jpql, JobOpening.class)
                .setParameter("inactiveStatus", JobOpeningStatus.INACTIVE).getResultList();

        // If there are no jobOpenings found, return null
        if(jobOpenings.isEmpty()){
            return null;
        }

        return jobOpenings;
    }


}
