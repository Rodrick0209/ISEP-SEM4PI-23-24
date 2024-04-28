package jobs4u.base.jobAplications.domain;

import com.zaxxer.hikari.util.SuspendResumeLock;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class JobApplication implements AggregateRoot<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "File")
    private List<JobApplicationFile> file = new ArrayList<>();

    private JobApplicationState state;

    private RequirementAnswer requirementAnswer;

    @Column(name = "Interview")
    private Interview interview;


    protected JobApplication() {
        // for ORM
    }

    public JobApplication(Long id, List<JobApplicationFile> file, RequirementAnswer requirementAnswer, Interview interview) {
        Preconditions.noneNull(id, file, state);
        this.id = id;
        this.file = file;
        this.state = JobApplicationState.ACCEPTED;
        this.requirementAnswer = requirementAnswer;
        this.interview = interview;
    }

    public JobApplication(Long id, List<JobApplicationFile> file) {
        Preconditions.noneNull(id, file);
        this.id = id;
        this.file = file;
        this.state = JobApplicationState.ACCEPTED;
        this.requirementAnswer = new RequirementAnswer();
        this.interview = new Interview();
    }

    public Long getId() {
        return id;
    }

    public List<JobApplicationFile> getFile() {
        return file;
    }

    public JobApplicationState getState() {
        return state;
    }

    public RequirementAnswer getRequirementAnswer() {
        return requirementAnswer;
    }

    public Interview getInterview() {
        return interview;
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
