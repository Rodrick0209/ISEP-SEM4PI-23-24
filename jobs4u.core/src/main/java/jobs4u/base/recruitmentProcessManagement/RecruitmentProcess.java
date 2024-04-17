package jobs4u.base.recruitmentProcessManagement;


import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.base.jobOpeningsManagement.domain.utils.JobReference;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RecruitmentProcess {
    private static final long serialVersionUID = 1L;

    @Version
    private Long version;


    @Id
    private JobReference jobReference;

    //TODO jakart ou hibernate import??
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phase> phases;


    protected RecruitmentProcess() {
    }

    public RecruitmentProcess(List<Phase> phases, JobReference jobReference) {
        validatePhases(phases);
        this.jobReference = jobReference;
        this.phases = phases;
    }



    private void validatePhases(List<Phase> phases) {
        Preconditions.nonEmpty(phases);
        validateNumberOfPhases(phases);
        validatePhasesOrder();

    }

    private void validateNumberOfPhases(List<Phase> phases) {
        if(phases.size() != 5 && phases.size() != 6){
            throw new IllegalArgumentException("Recruitment process must have 5 or 6 phases");
        }
    }

    private void validatePhasesOrder(){
        List<String> expectedPhaseIfInterview = List.of("application", "resume screen", "interviews", "analysis", "result");
        List<String> expectedPhaseIfNotInterview = List.of("application", "resume screen", "analysis", "result");
        List<String> currentPhases = new ArrayList<>();

        for (Phase phase : phases) {
            currentPhases.add(phase.designation().toString().toLowerCase());
        }

        if (!currentPhases.equals(expectedPhaseIfInterview) && !currentPhases.equals(expectedPhaseIfNotInterview)) {
            throw new IllegalArgumentException("Phases are not in the correct order");
        }



    }



}

