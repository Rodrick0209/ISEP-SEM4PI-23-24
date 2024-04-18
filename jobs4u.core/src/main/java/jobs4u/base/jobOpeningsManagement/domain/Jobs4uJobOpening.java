package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;

import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;

@Entity
public class Jobs4uJobOpening implements AggregateRoot<JobReference> {

    @Version
    private Long version;

    @EmbeddedId
    private JobReference jobReference;

    private WorkingMode workingMode;
    private NrVacancy nrVacancy;
    private PostalAddress address;
    private Designation description;
    private Designation function;
    private ClientCode clientCode;


    public Jobs4uJobOpening(JobReference jobReference, WorkingMode workingMode, NrVacancy nrVacancy, PostalAddress address, Designation description, Designation function) {
        this.jobReference = jobReference;
        this.workingMode = workingMode;
        this.nrVacancy = nrVacancy;
        this.address = address;
        this.description = description;
        this.function = function;
    }

    protected Jobs4uJobOpening() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobReference identity() {
        return jobReference;
    }

}
