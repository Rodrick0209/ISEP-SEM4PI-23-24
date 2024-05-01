package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.interviewModel.domain.InterviewModelSpecification;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.utils.*;

import jobs4u.base.jobRequirement.domain.JobRequirementSpecification;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.utils.PostalAddress;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@XmlRootElement
@Entity
@Getter
public class JobOpening implements AggregateRoot<JobReference> {

    @Version
    private Long version;

    @EmbeddedId
    private JobReference jobReference;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JobApplication> applications = new ArrayList<>();

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

    @ManyToOne
    private Client client;


    @OneToOne(cascade=CascadeType.ALL)
    private RecruitmentProcess recruitmentProcess;

    @OneToOne
    private JobRequirementSpecification jobRequirementSpecification;

    @OneToOne
    private InterviewModelSpecification interviewModelSpecification;


    public JobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate,Client client) {

        this.jobReference = jobReference;
        this.workingMode = workingMode;
        this.nrVacancy = NrVacancy.valueOf(nrVacancy);
        this.address = PostalAddress.valueOf(address);
        this.description = Description.valueOf(description);
        this.function = Designation.valueOf(function);
        this.contractType = contractType;
        this.creationDate = creationDate == null ? Calendar.getInstance() : creationDate;
        this.status = JobOpeningStatus.INACTIVE;
        this.applications = new ArrayList<>();
        this.client = client;
    }

    public JobApplication addJobApplication(JobApplication jobApplication){
        Preconditions.ensure(jobApplication != null, "job application should not be null");
        this.applications.add(jobApplication);
        return jobApplication;
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

    public List<JobApplication> jobApplications() {
        return applications;
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
        Preconditions.ensure(jobRequirementSpecification != null, "job requirement specification should not be null");
        this.jobRequirementSpecification = jobRequirementSpecification;
    }

   public void validateCanAddOrChangeRecruitmentProcess() {
        if (this.recruitmentProcess != null && this.recruitmentProcess.hasRecruitmentStarted()) {
            throw new IllegalArgumentException("Recruitment process has already started");
        }
    }

    public void addRecruitmentProcess(RecruitmentProcess recruitmentProcess) {
        this.recruitmentProcess = recruitmentProcess;
    }

    public void selectInterviewModelSpecification(InterviewModelSpecification interviewModelSpecification){
        Preconditions.ensure(interviewModelSpecification != null, "interview model specification should not be null");
        this.interviewModelSpecification = interviewModelSpecification;
    }

    @Override
    public String toString() {
        return "jobReference:"+jobReference;
    }
}
