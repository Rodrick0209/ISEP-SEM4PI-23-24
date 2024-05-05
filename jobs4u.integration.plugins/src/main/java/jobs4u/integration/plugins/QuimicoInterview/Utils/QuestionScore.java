package jobs4u.integration.plugins.QuimicoInterview.Utils;

public class QuestionScore {

    private static final long serialVersionUID = 1L;

    private Float score;

    protected QuestionScore(final Float score) {
        setQuestionScore(score);
    }

    protected QuestionScore() {
        // for ORM
    }

    private void setQuestionScore(final Float newScore) {
        if (!questionScoreMeetsMinimumRequirements(newScore)) {
            throw new IllegalArgumentException("The question score is invalid");
        }
        this.score = newScore;
    }

    private boolean questionScoreMeetsMinimumRequirements(final Float score) {
        return score != null && (score >= 0 && score <= 20);
    }

    public static QuestionScore valueOf(final Float score) {
        return new QuestionScore(score);
    }

    public Float score() {
        return score;
    }

    @Override
    public String toString() {
        return "Score: " + this.score;
    }
}





