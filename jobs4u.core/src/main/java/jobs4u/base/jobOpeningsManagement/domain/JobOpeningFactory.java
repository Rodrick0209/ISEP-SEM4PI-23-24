package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.utils.*;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.utils.PostalAddress;

import java.time.LocalDate;
import java.util.Calendar;

public class JobOpeningFactory {

    public JobOpening createJobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate, Client client) {
        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate,client);
    }

    public JobOpening createJobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate, Client client, RecruitmentProcess recruitmentProcess) {
        return new JobOpening(jobReference, workingMode, nrVacancy, address, description, function, contractType, creationDate,client,recruitmentProcess);
    }
}