package jobs4u.base.persistence.impl.jpa;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUser;
import jobs4u.base.utils.ClientCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class JpaJobOpeningRepository extends BasepaRepositoryBase<JobOpening, JobReference,JobReference> implements JobOpeningRepository {

    public JpaJobOpeningRepository() {
        super("jobReference");
    }


    @Override
    public List<JobOpening> findByCustomerManager(SystemUser customer) {

        final Map<String, Object> params = new HashMap<>();
        params.put("customerEmail", customer.email());
        return match("e.customerManager = :customerEmail", params);

    }

    @Override
    public int countForClientCode(ClientCode clientCode) {
        final Map<String, Object> params = new HashMap<>();
        params.put("clientCode", clientCode.code() + "-"); // Append '-' to match the format

        List<JobOpening> jobOpenings = match("e.jobReference.jobReference LIKE CONCAT(:clientCode, '%')", params);
        return jobOpenings.size();
    }











}
