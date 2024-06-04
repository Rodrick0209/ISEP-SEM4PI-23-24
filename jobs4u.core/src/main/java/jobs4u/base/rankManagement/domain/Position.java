package jobs4u.base.rankManagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jobs4u.base.candidateManagement.domain.Candidate;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
public class Position implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;

    private int position;

    @Getter
    @ManyToOne
    private Candidate candidate;

    private Position(int position, Candidate candidate) {
        this.position = position;
        this.candidate = candidate;
    }


    public Position() {

    }

    public static Position valueOf(int position, Candidate candidate) {
        return new Position(position, candidate);
    }
}
