package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListCandidateController {

    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    public List<Candidate> candidates(){
        List<Candidate> candidates = new ArrayList<>();

        candidateRepository.findAll().forEach(candidates::add);
        sortCandidates(candidates);
        return candidates;
    }

    private void sortCandidates(List<Candidate> candidates){

        candidates.sort(Comparator.comparing(Candidate::nameString));

    }

}
