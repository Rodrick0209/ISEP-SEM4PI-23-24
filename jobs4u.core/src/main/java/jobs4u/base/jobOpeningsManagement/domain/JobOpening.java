package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import jakarta.persistence.*;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.utils.*;

import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PostalAddress;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Calendar;

@XmlRootElement
@Entity
public class JobOpening implements AggregateRoot<JobReference> {

    @Version
    private Long version;

    @EmbeddedId
    private JobReference jobReference;

    @OneToOne
    private SystemUser responsibleUser;

    private WorkingMode workingMode;
    private NrVacancy nrVacancy;
    private PostalAddress address;

    @Column(name = "description")
    private Description description;

    @Column(name = "function")
    private Designation function;
    private ContractType contractType;
    private Calendar creationDate;
    private JobOpeningStatus status;

    @OneToOne
    private JobRequirementSpecification jobRequirementSpecification;


    public JobOpening(JobReference jobReference, SystemUser user, WorkingMode workingMode, Long nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate, JobOpeningStatus status) {

        this.jobReference = jobReference;
        this.workingMode = workingMode;
        this.nrVacancy = NrVacancy.valueOf(nrVacancy);
        this.address = PostalAddress.valueOf(address);
        this.description = Description.valueOf(description);
        this.function = Designation.valueOf(function);
        this.contractType = contractType;
        this.creationDate = creationDate == null ? Calendar.getInstance() : creationDate;
        this.responsibleUser = user;
        this.status = JobOpeningStatus.INACTIVE;

    }


    protected JobOpening() {
    }

    public JobReference jobReference() {
        return jobReference;
    }

    public WorkingMode workingMode() {
        return workingMode;
    }

    public NrVacancy nrVacancy() {
        return nrVacancy;
    }

    public PostalAddress address() {
        return address;
    }

    public Description description() {
        return description;
    }

    public Designation function() {
        return function;
    }

    public ContractType contractType() {
        return contractType;
    }

    public Calendar creationDate() {
        return creationDate;
    }

    public JobOpeningStatus status() {
        return status;
    }

    public SystemUser ResponsibleUser() {
        return responsibleUser;
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

    public void selectJobRequirementSpecification(JobRequirementSpecification jobRequirementSpecification) {
        this.jobRequirementSpecification = jobRequirementSpecification;
    }


}
