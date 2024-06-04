package jobs4u.base.rankManagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {


    @Test
    void ensureSetRankSizeIsDoneBeforeCreateTheRankFails() {
        Rank rank = new Rank();


        assertThrows(IllegalArgumentException.class, () -> rank.valueOf(List.of(new Candidate(), new Candidate()), 0));

    }

    @Test
    void ensurePositionsWithSameNumberFails() {
        Rank rank= new Rank();
        rank= rank.valueOf(List.of(new Candidate(), new Candidate()),2);
        assertNotEquals(rank.rank().get(0),rank.rank().get(1));

    }

    @Test
    void ensurePositionsWithDIFFNumberWorks() {
        Rank rank = new Rank();
        Position position = Position.valueOf(1, new Candidate());
        Position position2 = Position.valueOf(2, new Candidate());



    }


    @Test
    void ensureSetRankSizeIsDoneBeforeCreateTheRankWorks() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate());
        assertNotNull(rank.addElementToRank(new Candidate()));

    }


    @Test
    void ensureCreateRankWithClientListSizeEqualsAsRankSizeWorks() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate(), new Candidate());

        assertNotNull(rank.addElementToRank(new Candidate()));

    }


    @Test
    void ensureCreateRankWithClientListSizeBiggerThanRankSizeFails() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate(), new Candidate());


        assertThrows(IllegalArgumentException.class, () -> rank.valueOf(List.of(new Candidate()),0));

    }


    @Test
    void ensureCreateRankWithClientListSizeLowerThanRankSizeFails() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate(), new Candidate());

        assertNotNull(rank.addElementToRank(new Candidate()));

    }

/*
    @Test
    void EnsureToStringMethodWorksAsExpectd(){

        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nome", "apelidot", "email2@email.pt", "965434293");
        Candidate candidate3 = new Candidate("nome", "apelidy", "email3@email.pt", "965430693");

        List<Candidate> candidates = List.of(candidate1, candidate2,candidate3);

        Rank rank = new Rank();
        Rank r =rank.valueOf(candidates,3);

        String expected = "1. "+candidate1.emailAddress()+"\n2. "+candidate2.emailAddress()+"\n3. "+ candidate3.emailAddress()+"\n";

        assertEquals(expected.trim(), r.toString().trim());

    }



    @Test
    void EnsureToStringMethodWorksAsExpectd2(){

        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nome", "apelidot", "email2@email.pt", "965434293");

        List<Candidate> candidates = List.of(candidate1, candidate2);

        Rank rank = new Rank();
        Rank r =rank.valueOf(candidates,3);

        String expected = "1. "+candidate1.emailAddress()+"\n2. "+candidate2.emailAddress()+"\n3. \n";


        assertEquals(expected.trim(), r.toString().trim());

    }
*/




}