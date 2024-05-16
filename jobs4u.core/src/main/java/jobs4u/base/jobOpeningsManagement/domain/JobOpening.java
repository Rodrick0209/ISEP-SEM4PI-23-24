package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.utils.*;

import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.rankManagement.domain.Rank;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.utils.PostalAddress;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@XmlRootElement
@Entity
@Getter
public class JobOpening implements AggregateRoot<JobReference>, Serializable {


    @EmbeddedId
    private JobReference jobReference;

    @Version
    private Long version;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Rank rank;

    @ManyToOne
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    private RecruitmentProcess recruitmentProcess;

    @OneToOne
    private RequirementSpecification requirementSpecification;

    @OneToOne
    private InterviewModelSpecification interviewModelSpecification;

    public JobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate, Client client) {

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
        this.rank = new Rank();
    }

    public JobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate, Client client,RecruitmentProcess recruitmentProcess) {

        this.jobReference = jobReference;
        this.workingMode = workingMode;
        this.nrVacancy = NrVacancy.valueOf(nrVacancy);
        this.address = PostalAddress.valueOf(address);
        this.description = Description.valueOf(description);
        this.function = Designation.valueOf(function);
        this.contractType = contractType;
        this.creationDate = creationDate == null ? Calendar.getInstance() : creationDate;
        this.status = JobOpeningStatus.ACTIVE;
        this.applications = new ArrayList<>();
        this.client = client;
        this.recruitmentProcess = recruitmentProcess;
        this.rank = new Rank();
    }

    public JobApplication addJobApplication(JobApplication jobApplication) {
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

    public void selectJobRequirementSpecification(RequirementSpecification requirementSpecification) {
        Preconditions.ensure(requirementSpecification != null, "job requirement specification should not be null");
        this.requirementSpecification = requirementSpecification;
    }

    public void validateCanAddOrChangeRecruitmentProcess() {
        if (this.recruitmentProcess != null && this.recruitmentProcess.hasRecruitmentStarted()) {
            throw new IllegalArgumentException("Recruitment process has already started");
        }
    }

    public void addRecruitmentProcess(RecruitmentProcess recruitmentProcess) {
        this.recruitmentProcess = recruitmentProcess;
    }

    public void selectInterviewModelSpecification(InterviewModelSpecification interviewModelSpecification) {
        Preconditions.ensure(interviewModelSpecification != null, "interview model specification should not be null");
        this.interviewModelSpecification = interviewModelSpecification;
    }

    @Override
    public String toString() {
        return "jobReference:" + jobReference;
    }

    /**
     * Method that verifies if applications can be added to the job opening
     * @return true if applications can be added, false otherwise
     */
    public boolean canApplicationsBeaAdded() {
        return  status.equals(JobOpeningStatus.ACTIVE) && recruitmentProcess.returnActivePhase().designation().toString().equals(Phases.APPLICATION.toString());

    }

    public List<List<Phases>> layoutsRecruitmentProcess() {
        List<List<Phases>> layouts = new ArrayList<>();
        layouts.add(List.of(Phases.APPLICATION, Phases.RESUME_SCREEN, Phases.ANALYSIS, Phases.RESULT));
        layouts.add(List.of(Phases.APPLICATION, Phases.RESUME_SCREEN, Phases.INTERVIEWS, Phases.ANALYSIS, Phases.RESULT));
        return layouts;
    }


    public List<Candidate> getCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        for (JobApplication application : applications) {
            candidates.add(application.candidate());
        }
        return candidates;
    }

    public int getRankSize(){
        int size = calculateRankSize(rank.getMultiplier());
        rank.setRankSize(size);
        return size;
    }


    private int calculateRankSize(int multiplier){
        return multiplier * Integer.parseInt(nrVacancy.toString());
    }


    public Rank addRankList(List<Candidate> candidates){
       return this.rank.valueOf(candidates);
    }
}
