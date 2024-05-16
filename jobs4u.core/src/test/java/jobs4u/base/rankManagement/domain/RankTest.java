package jobs4u.base.rankManagement.domain;

import jobs4u.base.candidateManagement.domain.Candidate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {


    @Test
    void ensureSetRankSizeIsDoneBeforeCreateTheRankFails() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate());

        assertThrows(IllegalArgumentException.class, () -> rank.valueOf(candidates));

    }

    @Test
    void ensureSetRankSizeIsDoneBeforeCreateTheRankWorks() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate());
        rank.setRankSize(2);

        assertNotNull(rank.valueOf(candidates));

    }


    @Test
    void ensureCreateRankWithClientListSizeEqualsAsRankSizeWorks() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate(), new Candidate());
        rank.setRankSize(3);
        assertNotNull(rank.valueOf(candidates));

    }


    @Test
    void ensureCreateRankWithClientListSizeBiggerThanRankSizeFails() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate(), new Candidate());
        rank.setRankSize(2);

        assertThrows(IllegalArgumentException.class, () -> rank.valueOf(candidates));

    }


    @Test
    void ensureCreateRankWithClientListSizeLowerThanRankSizeFails() {
        Rank rank = new Rank();
        List<Candidate> candidates = List.of(new Candidate(), new Candidate(), new Candidate());
        rank.setRankSize(5);
        assertNotNull(rank.valueOf(candidates));

    }


    @Test
    void EnsureToStringMethodWorksAsExpectd(){
        Rank rank = new Rank();

        Candidate candidate1 = new Candidate("nome", "apelidor", "email@email.pt", "965430393");
        Candidate candidate2 = new Candidate("nome", "apelidot", "email2@email.pt", "965434293");
        Candidate candidate3 = new Candidate("nome", "apelidy", "email3@email.pt", "965430693");

        List<Candidate> candidates = List.of(candidate1, candidate2, candidate3);
        rank.setRankSize(3);


        rank.valueOf(candidates);

        String expected = "1. "+candidate1.emailAddress()+"\n2. "+candidate2.emailAddress()+"\n3. "+candidate3.emailAddress()+"\n";


        assertEquals(expected, rank.toString());

    }




}