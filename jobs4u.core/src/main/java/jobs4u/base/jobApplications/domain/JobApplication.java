package jobs4u.base.jobApplications.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
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
    private RequirementAnswer requirementAnswer;

    @Column(name = "Interview")
    private Interview interview;

    @ManyToOne
    private Candidate candidate;

    private Calendar creationDate;



    protected JobApplication() {
        // for ORM
    }

    public JobApplication(Long id, List<JobApplicationFile> file, RequirementAnswer requirementAnswer, Interview interview, Candidate candidate) {
        Preconditions.noneNull(id, file, state);
        this.id = id;
        this.file = file;
        this.state = JobApplicationState.ACCEPTED;
        this.requirementAnswer = requirementAnswer;
        this.interview = interview;
        this.candidate = candidate;
        this.creationDate=Calendar.getInstance();
    }

    public JobApplication(Long id, List<JobApplicationFile> file,Candidate candidate) {
        Preconditions.noneNull(id, file);
        this.id = id;
        this.file = file;
        this.state = JobApplicationState.ACCEPTED;
        this.requirementAnswer = new RequirementAnswer();
        this.interview = null;
        this.candidate = candidate;
        this.creationDate=Calendar.getInstance();

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
}