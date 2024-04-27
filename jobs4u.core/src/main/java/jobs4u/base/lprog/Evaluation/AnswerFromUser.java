package jobs4u.base.lprog.Evaluation;

import java.util.Objects;

public class AnswerFromUser {

    private static final long serialVersionUID = 1L;

    private String answerText;

    private double answerNumber;

    public AnswerFromUser(final String answerText, final double answerNumber) {

        if (answerNumber <= 0) {
            throw new IllegalArgumentException("The answer number is invalid");
        }

        this.answerText = answerText;
        this.answerNumber = answerNumber;
    }

    public AnswerFromUser(final String answerText) {
        this.answerText = answerText;
        this.answerNumber = 0;
    }

    public double answerNumber() {
        return answerNumber;
    }


    public boolean isCorrectAnswer(String answer) {
        return answer.equalsIgnoreCase(this.answerText);
    }

    public String correctAnswer() {
        return answerText;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerFromUser)) return false;
        AnswerFromUser that = (AnswerFromUser) o;
        return Double.compare(that.answerNumber, answerNumber) == 0 && answerText.equals(that.answerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerText, answerNumber);
    }

    @Override
    public String toString() {
        return "Correct answer: " + this.answerText;

    }
}
