package lprog.Programador2AnosExperienciaRequirement.Utils;

import java.util.Objects;


public class Answer  {

    private static final long serialVersionUID = 1L;



    private String correctAnswer;


    public Answer(final String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrectAnswer(String answer) {
        return answer.equalsIgnoreCase(this.correctAnswer);
    }

    public String correctAnswer() {
        return correctAnswer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer = (Answer) o;
        return correctAnswer.equals(answer.correctAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctAnswer);
    }

    @Override
    public String toString() {
        return "Correct answer: " + this.correctAnswer;

    }
}
