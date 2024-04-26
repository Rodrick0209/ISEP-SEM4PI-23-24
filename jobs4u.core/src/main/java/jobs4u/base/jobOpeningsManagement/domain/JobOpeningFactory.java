package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.jobOpeningsManagement.utils.*;
import jobs4u.base.utils.PostalAddress;

import java.time.LocalDate;
import java.util.Calendar;

public class JobOpeningFactory {

    public JobOpening createJobOpening(JobReference jobReference,  WorkingMode workingMode, Long nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate) {
        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate);
    }
}