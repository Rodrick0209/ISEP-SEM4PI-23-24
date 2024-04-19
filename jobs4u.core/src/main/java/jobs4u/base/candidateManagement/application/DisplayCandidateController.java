package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class DisplayCandidateController {

    private final CandidateMapper candidateMapper = new CandidateMapper();

    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    private List<CandidateDTO> candidatesFromRepository() {

        ArrayList<CandidateDTO> candidates = new ArrayList<>();

        candidateRepository.findAll().forEach(candidate -> {
            candidates.add(candidateMapper.toDTO(candidate));
        });

        return candidates;

    }


}
