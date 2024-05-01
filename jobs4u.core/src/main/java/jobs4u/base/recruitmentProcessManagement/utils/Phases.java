package jobs4u.base.recruitmentProcessManagement.utils;

import java.util.List;

public enum Phases {
    APPLICATION,
    RESUME_SCREEN,
    INTERVIEWS, // optional phase
    ANALYSIS,
    RESULT;

    public static List<String> getExpectedPhases(boolean isInterview) {
        if (isInterview) {
            return List.of(
                Phases.APPLICATION.name(),
                Phases.RESUME_SCREEN.name(),
                Phases.INTERVIEWS.name(),
                Phases.ANALYSIS.name(),
                Phases.RESULT.name());
        } else {
            return List.of(
                Phases.APPLICATION.name(),
                Phases.RESUME_SCREEN.name(),
                Phases.ANALYSIS.name(),
                Phases.RESULT.name());
        }
    }
}
