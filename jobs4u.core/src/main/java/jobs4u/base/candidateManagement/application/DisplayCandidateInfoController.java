package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DisplayCandidateInfoController {
    private final CandidateRepository candidateRepository;

    public DisplayCandidateInfoController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> candidates() {
        List<Candidate> candidates = new ArrayList<>();

        candidateRepository.findAll().forEach(candidates::add);
        return candidates;
    }

    public String getCandidateInfo(Candidate candidate) {
        StringBuilder info = new StringBuilder();

        info.append("Name: ").append(candidate.name().toString()).append("\n");
        info.append("Email: ").append(candidate.emailAddress().toString()).append("\n");
        info.append("Phone Number: ").append(candidate.phoneNumber().toString()).append("\n");

        return info.toString();
    }

}
