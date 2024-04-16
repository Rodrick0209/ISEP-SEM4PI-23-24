package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import jobs4u.base.jobOpeningsManagement.domain.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.domain.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.domain.utils.WorkingMode;

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


    public Jobs4uJobOpening(JobReference jobReference) {
        this.jobReference = jobReference;
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
