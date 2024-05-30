package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@XmlRootElement
@Entity
@Getter
public class JobApplication implements AggregateRoot<Long>, Serializable {



    @Id
    private Long id;
    @Version
    private Long version;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "File")
    private List<JobApplicationFile> file = new ArrayList<>();

    @Getter
    private JobApplicationState state;

    @Getter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private RequirementAnswer requirementAnswer;

    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Interview interview;

    @ManyToOne
    private Candidate candidate;

    private Calendar creationDate;

    @ManyToOne
    @Getter
    private JobOpening jobOpening;



    protected JobApplication() {
        // for ORM
    }

    public JobApplication(Long id, JobOpening jobOpening,List<JobApplicationFile> file, RequirementAnswer requirementAnswer, Interview interview, Candidate candidate) {
        Preconditions.noneNull(id, file, state,jobOpening);
        this.id = id;
        this.jobOpening=jobOpening;
        this.file = file;
        this.state = JobApplicationState.ACCEPTED;
        this.requirementAnswer = requirementAnswer;
        this.interview = interview;
        this.candidate = candidate;
        this.creationDate=Calendar.getInstance();
    }

    public JobApplication(Long id, JobOpening jobOpening,List<JobApplicationFile> file,Candidate candidate) {
        Preconditions.noneNull(id, file);
        this.id = id;
        this.jobOpening=jobOpening;
        this.file = file;
        this.state = JobApplicationState.ACCEPTED;
        this.requirementAnswer = new RequirementAnswer();
        this.interview = null;
        this.candidate = candidate;
        this.creationDate=Calendar.getInstance();

    }

    public void registerInterivew(Date date , Time time){
        this.interview = new Interview(date,time);
    }

    public void registerRequirementAnswer(String fileName){
        this.requirementAnswer = new RequirementAnswer(fileName);
    }


    public Candidate candidate() {
        return candidate;
    }
    public JobApplicationState state() {
        return state;
    }
    public Calendar creationDate() {
        return creationDate;
    }
    public Interview interview() {
        return interview;
    }
    public JobOpening jobOpening() {
        return jobOpening;
    }
   public List<JobApplicationFile> files() {
        return file;
    }

    public RequirementAnswer requirementAnswer() {
        return requirementAnswer;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }


    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof JobApplication)) {
            return false;
        }

        final JobApplication that = (JobApplication) other;
        if (this == that) {
            return true;
        }
        return false;
    }



    @Override
    public Long identity() {
        return id;
    }

    /**
     * Checks if the application has the requirement answer evaluated
     * @return
     */
    public boolean isApplicationRequirementAnswerEvaluated(){
        return this.requirementAnswer.result()!=null;
    }

    /**
     * Checks if the application has the interview evaluation done
     * @return
     */
    public boolean isApplicationInterviewAvaliationDone(){
        if (this.interview == null)
            return false;

        return this.interview.points()!=null;
    }


    /**
     * Checks if the application has the analysis done
     * @return
     */
    public boolean isApplicationAnalysisDone(){
        return this.jobOpening.getRank().rank().contains(this.candidate);
    }

    /**
     * Checks if the application has the result done
     * @return
     */
    public boolean isApplicationResultDone(){
        return true;
    }

    public InputStream interviewAnswer() throws IOException {
        return interview.inputStreamFromResourceOrFile();
    }

}