package jobs4u.base.recruitmentProcessManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentProcessDto {

    LocalDate startDateApplicationPhase;
    LocalDate endDateApplicationPhase;

    LocalDate startDateResumeScreenPhase;
    LocalDate endDateResumeScreenPhase;

    LocalDate startDateInterviewsPhase;
    LocalDate endDateInterviewsPhase;

    LocalDate startDateAnalysisPhase;
    LocalDate endDateAnalysisPhase;

    LocalDate startDateResultPhase;
    LocalDate endDateResultPhase;




}

