package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.candidateManagement.domain.CandidateDTO;

public class CandidateMapper {

    public CandidateDTO toDTO(Candidate candidate){
        CandidateDTO dto = new CandidateDTO();
        dto.name = candidate.name().toString();
        dto.email = candidate.emailAddress().toString();
        dto.phoneNumber = candidate.phoneNumber().toString();
        return dto;
    }
}
