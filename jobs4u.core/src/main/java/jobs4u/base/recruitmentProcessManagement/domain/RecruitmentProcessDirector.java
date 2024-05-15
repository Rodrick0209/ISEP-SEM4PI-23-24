package jobs4u.base.recruitmentProcessManagement.domain;

import jobs4u.base.recruitmentProcessManagement.dto.RecruitmentProcessDto;

public class RecruitmentProcessDirector {

    private RecruitmentProcessBuilder builder;

    public RecruitmentProcessDirector(RecruitmentProcessBuilder builder) {
        this.builder = builder;
    }


    public RecruitmentProcess createRecruitmentProcessWithInterview(RecruitmentProcessDto recruitmentProcessDto) {
        this.builder.withApplicationPhase(recruitmentProcessDto.getStartDateApplicationPhase(), recruitmentProcessDto.getEndDateApplicationPhase());
        this.builder.withResumeScreenPhase(recruitmentProcessDto.getStartDateResumeScreenPhase(), recruitmentProcessDto.getEndDateResumeScreenPhase());
        if (recruitmentProcessDto.getStartDateInterviewsPhase() != null) {
            this.builder.withInterviewsPhase(recruitmentProcessDto.getStartDateInterviewsPhase(), recruitmentProcessDto.getEndDateInterviewsPhase());
        }
        this.builder.withAnalysisPhase(recruitmentProcessDto.getStartDateAnalysisPhase(), recruitmentProcessDto.getEndDateAnalysisPhase());
        this.builder.withResultPhase(recruitmentProcessDto.getStartDateResultPhase(), recruitmentProcessDto.getEndDateResultPhase());
        return this.builder.getRecruitmentProcess();

    }


}
