package jobs4u.base.jobOpeningsManagement.application;

import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;

public class JobOpeningMapper {

    public JobOpeningDTO toDTO(JobOpening jobOpening){
        JobOpeningDTO dto = new JobOpeningDTO();
        dto.JobReference = jobOpening.jobReference().toString();
        dto.workingMode = jobOpening.workingMode().toString();
        dto.nrVacancy = jobOpening.nrVacancy().toString();
        dto.address = jobOpening.address().toString();
        dto.description = jobOpening.description().toString();
        dto.function = jobOpening.function().toString();
        dto.contractType = jobOpening.contractType().toString();
        dto.creationDate = jobOpening.creationDate().toString();
        return dto;
    }
}
