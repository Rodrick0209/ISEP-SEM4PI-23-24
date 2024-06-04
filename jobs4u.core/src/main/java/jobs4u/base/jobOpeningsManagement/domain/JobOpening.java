package jobs4u.base.jobOpeningsManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobApplications.utils.JobApplicationInterviewPointsComparator;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobOpeningsManagement.utils.*;

import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.rankManagement.domain.Position;
import jobs4u.base.rankManagement.domain.Rank;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import jobs4u.base.utils.PostalAddress;
import lombok.Getter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@XmlRootElement
@Entity
@Getter
public class JobOpening implements AggregateRoot<JobReference>, Serializable {


    @EmbeddedId
    private JobReference jobReference;

    @Version
    private Long version;

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
        this.client = client;
        this.rank = new Rank();
    }

    public JobOpening(JobReference jobReference, WorkingMode workingMode, String nrVacancy, String address, String description, String function, ContractType contractType, Calendar creationDate, Client client, RecruitmentProcess recruitmentProcess) {

        this.jobReference = jobReference;
        this.workingMode = workingMode;
        this.nrVacancy = NrVacancy.valueOf(nrVacancy);
        this.address = PostalAddress.valueOf(address);
        this.description = Description.valueOf(description);
        this.function = Designation.valueOf(function);
        this.contractType = contractType;
        this.creationDate = creationDate == null ? Calendar.getInstance() : creationDate;
        //TODO : perguntar ao rodrigo
        this.status = JobOpeningStatus.ACTIVE;
        this.client = client;
        this.recruitmentProcess = recruitmentProcess;
        this.rank = new Rank();
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

    public RecruitmentProcess recruitmentProcess() {
        if (recruitmentProcess == null) {
            throw new IllegalArgumentException("Recruitment process is not defined");
        }
        return recruitmentProcess;
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
        return jobReference + " - " + function;
    }

    /**
     * Method that verifies if applications can be added to the job opening
     *
     * @return true if applications can be added, false otherwise
     */
    public boolean canApplicationsBeaAdded() {
        return status.equals(JobOpeningStatus.ACTIVE) && recruitmentProcess.returnPhaseOpen().designation().toString().equals(Phases.APPLICATION.toString());

    }

    public List<List<Phases>> layoutsRecruitmentProcess() {
        List<List<Phases>> layouts = new ArrayList<>();
        layouts.add(List.of(Phases.APPLICATION, Phases.RESUME_SCREEN, Phases.ANALYSIS, Phases.RESULT));
        layouts.add(List.of(Phases.APPLICATION, Phases.RESUME_SCREEN, Phases.INTERVIEWS, Phases.ANALYSIS, Phases.RESULT));
        return layouts;
    }


    public int getRankSize() {
        int size = calculateRankSize(rank.getMultiplier());
        rank.setRankSize(size);
        return size;
    }


    private int calculateRankSize(int multiplier) {
        return multiplier * Integer.parseInt(nrVacancy.toString());
    }


    public Rank addRankList(List<Candidate> candidates) {
        this.rank = rank.valueOf(candidates, getRankSize());
        return rank;
    }

    public void editWorkingMode(WorkingMode workingMode) {
        Preconditions.ensure(workingMode != null, "working mode must not be null");
        Preconditions.ensure(status == null || status.equals(JobOpeningStatus.INACTIVE), "job opening is active");
        this.workingMode = workingMode;
    }

    public void editNumberVacancies(NrVacancy nrVacancy) {
        Preconditions.ensure(nrVacancy != null, "number of vacancies must not be null");
        Preconditions.ensure(status == null || status.equals(JobOpeningStatus.INACTIVE), "job opening is active");
        this.nrVacancy = nrVacancy;
    }

    public void editAddress(PostalAddress address) {
        Preconditions.ensure(address != null, "address must not be null");
        Preconditions.ensure(status.equals(JobOpeningStatus.INACTIVE), "job opening is active");
        this.address = address;
    }

    public void editDescription(Description description) {
        Preconditions.ensure(description != null, "description must not be null");
        Preconditions.ensure(status.equals(JobOpeningStatus.INACTIVE), "job opening is active");
        this.description = description;
    }

    public void editFunction(Designation function) {
        Preconditions.ensure(function != null, "function must not be null");
        Preconditions.ensure(status.equals(JobOpeningStatus.INACTIVE), "job opening is active");
        this.function = function;
    }

    public void editContractType(ContractType contractType) {
        Preconditions.ensure(contractType != null, "contract type must not be null");
        Preconditions.ensure(status.equals(JobOpeningStatus.INACTIVE), "job opening is active");
        this.contractType = contractType;
    }

    public void editClient(Client client) {
        Preconditions.ensure(client != null, "client must not be null");
        Preconditions.ensure(status.equals(JobOpeningStatus.INACTIVE), "job opening is active");
        this.client = client;
    }

    public Rank updateRankList(List<Candidate> candidates) {
        this.rank = rank.update(candidates, getRankSize());
        return rank;
    }


    public void areAllApplicationsOfThisJobOpening(List<JobApplication> list) {
        for (JobApplication application : list) {
            if (!application.getJobOpening().equals(this)) {
                throw new IllegalArgumentException("Not all applications are from this job opening");
            }
        }
    }

    public RequirementSpecification requirementSpecification(){
        return this.requirementSpecification;
    }


    public void changePhase(List<JobApplication> jobApplications){
        areAllApplicationsOfThisJobOpening(jobApplications);
        if (!recruitmentProcess.hasRecruitmentStarted()) {
            this.status = JobOpeningStatus.ACTIVE;
        }
        State resultPhaseStateBeforeOpenClose = this.recruitmentProcess.resultPhase().state();
        recruitmentProcess.executeActionForOpenClosePhaseAccordinglyWithAvailableChoice(jobApplications);
        if (this.recruitmentProcess.resultPhase().state().equals(State.CLOSED) && resultPhaseStateBeforeOpenClose.equals(State.OPEN)) {
            this.status = JobOpeningStatus.INACTIVE;
        }

    }

    public List<Candidate> getOrderedListOfCandidatesBasedOnInterviewPoints(Iterable<JobApplication> jobApplications){
        Preconditions.ensure(recruitmentProcess.returnPhaseOpen().designation().equals(Phases.ANALYSIS), "job opening is not in analysis phase");
        Preconditions.ensure(recruitmentProcess.interviewsPhase() != null, "job opening has not an interview phase");
        List<Candidate> orderedCandidates = new ArrayList<>();
        List<JobApplication> orderedJobApplications = getOrderedListOfJobApplicationsBasedOnInterviewPoints(jobApplications);

        for(JobApplication jobApplication : orderedJobApplications){
            orderedCandidates.add(jobApplication.candidate());
        }

        return orderedCandidates;
    }

    private List<JobApplication> getOrderedListOfJobApplicationsBasedOnInterviewPoints(Iterable<JobApplication> jobApplications) {
        return StreamSupport.stream(jobApplications.spliterator(), false).sorted(new JobApplicationInterviewPointsComparator().reversed()).collect(Collectors.toList());
    }

    public double evaluateInterview(InputStream interviewAnswer) throws IOException {
        return interviewModelSpecification.buildEvaluator().evaluate(interviewAnswer);
    }

}
