package jobs4u.base.rankManagement.domain;

import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;

import java.util.List;

@Entity
public class Rank {

    @Id
    @GeneratedValue
    private Long id;

    private final int multiplier=2;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Candidate> rank;

    private int rankSize;


    public Rank() {
    }


    private Rank(List<Candidate> rank) {
        this.rank = rank;
        this.rankSize = rank.size();
    }

    public Rank valueOf(List<Candidate> rank) {
        if (rankSize ==0) {
            throw new IllegalArgumentException("Rank size must be set and bigger than 0");
        }

        if (rank.size() > rankSize) {
            throw new IllegalArgumentException("Rank size must be bigger than the number of candidates");

        }else {
            this.rank = rank;
            return this;
        }
    }

    public int getMultiplier() {
        return multiplier;
    }

    public int setRankSize(int rankSize) {
        return this.rankSize= rankSize;
    }


    @Override
    public String toString() {
        String str="";
        int i=1;
        for (Candidate candidate : rank) {
            str = str.concat(i+". "+candidate.emailAddress()+"\n");
            i++;
        }
        return str;
    }

}
