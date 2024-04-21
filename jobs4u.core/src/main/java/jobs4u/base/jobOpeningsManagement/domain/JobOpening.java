package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import jakarta.persistence.*;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;

import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Entity
public class JobOpening implements AggregateRoot<JobReference> {

    @Version
    private Long version;

    @EmbeddedId
    private JobReference jobReference;

    private WorkingMode workingMode;
    private NrVacancy nrVacancy;
    private PostalAddress address;
    @AttributeOverrides({
            @AttributeOverride(name="name",
                    column=@Column(name="description",
                            insertable=false, updatable=false))
    })
    private Designation description;
    @AttributeOverrides({
            @AttributeOverride(name="name",
                    column=@Column(name="description",
                            insertable=false, updatable=false))
    })
    private Designation function;
    private ContractType contractType;
    private LocalDate creationDate;



    public JobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String  description, String function, ContractType contractType, LocalDate creationDate) {

        this.jobReference = jobReference;
        this.workingMode = workingMode;
        this.nrVacancy = NrVacancy.valueOf(nrVacancy);
        this.address = PostalAddress.valueOf(address);
        this.description = Designation.valueOf(description);
        this.function = Designation.valueOf(function);
        this.contractType = contractType;
        this.creationDate = creationDate;

    }

    protected JobOpening() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobReference identity() {
        return jobReference;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }



}
