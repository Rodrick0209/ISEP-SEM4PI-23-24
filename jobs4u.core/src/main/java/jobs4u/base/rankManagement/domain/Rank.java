package jobs4u.base.rankManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;
import jobs4u.base.candidateManagement.domain.Candidate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rank implements DTOable<RankDTO>, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private final int multiplier=2;

    @JsonProperty
    @ElementCollection
    private List<Position> rank = new ArrayList<>();

    @Setter
    @Getter
    private int rankSize;


    public Rank() {
    }



    private Rank(List<Position> rank, int rankSize) {
        this.rank = rank;
        this.rankSize = rankSize;
    }

    public Rank valueOf(List<Candidate> candidates, int rankSize) {

        if (rankSize ==0) {
            throw new IllegalArgumentException("Rank size must be set and bigger than 0");
        }
        if (rank.size() > rankSize) {
            throw new IllegalArgumentException("Rank size must be bigger than the number of candidates");

        }else {
            Rank r =new Rank(rank, rankSize);

            for (Candidate candidate: candidates) {
                r.addElementToRank(candidate);
            }
            return r;
        }
    }


    @Override
    public String toString() {
        String str="";
        int i;
        for (i = 0; i < rank.size(); i++) {
            str = str.concat(i+1+". "+rank.get(i).getCandidate().emailAddress()+"\n");
        }


        for (int j = (i); j < (rankSize); j++) {
            str = str.concat(j+1+". \n");
        }
        return str;
    }


    @Override
    public RankDTO toDTO() {

        //Put rank as String (email separated by commas)

        String rankStr = "";
        for (Position position : rank) {
            rankStr=rankStr.concat(position.getCandidate().emailAddress().toString()).concat(",");
        }

        //delete last element
        if (!rankStr.isEmpty()){
            rankStr = rankStr.substring(0, rankStr.length() - 1);
        }


        return new RankDTO(id, multiplier, rankSize, rankStr);
    }


    //create update
    public Rank update(List<Candidate> rank, int rankSize) {
        this.rank.clear();
        for (Candidate candidate: rank) {
            addElementToRank(candidate);
        }
        this.rankSize = rankSize;
        return this;
    }

    public List<Position> rank() {
        return this.rank;
    }

    public boolean hasCandidate() {
        return !rank.isEmpty();
    }

    public Position addElementToRank(Candidate candidate){
        Position pos =Position.valueOf(rank.size(), candidate);
        rank.add(pos);
        return pos;
    }

    public boolean isRankCompleted() {
        if (rank.isEmpty()){
            return false;
        }
        return rank.size() == rankSize;
    }

}
