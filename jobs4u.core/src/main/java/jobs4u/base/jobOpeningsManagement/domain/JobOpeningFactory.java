package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.PostalAddress;

import java.time.LocalDate;

public class JobOpeningFactory {

    public JobOpening createJobOpening(JobReference jobReference, SystemUser user, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, LocalDate creationDate) {
        return new JobOpening(jobReference,user, workingMode, nrVacancy, address, description, function, contractType, creationDate);
    }
}