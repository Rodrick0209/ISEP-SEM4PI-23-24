package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.Designation;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.utils.PostalAddress;

public class JobOpeningFactory {

    public JobOpening createJobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType) {
        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType);
    }
}