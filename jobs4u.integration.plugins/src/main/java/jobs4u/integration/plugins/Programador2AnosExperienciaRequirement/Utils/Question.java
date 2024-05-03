package jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.Utils;


import java.util.Objects;


/**
 * Representa a classe abstrata Question.
 */
public abstract class Question {

    private static final long serialVersionUID = 1L;

    private String text;

    private QuestionScore score;

    private Answer answer;

    private String type;

    private double questionNumber;

    public Question(final String text, final QuestionScore score, final Answer answer, final double questionNumber) {
        this.text = text;
        this.score = score;
        this.answer = answer;
        this.questionNumber = questionNumber;
    }

    public Question(final String text, final Answer answer, final double questionNumber) {
        this.text = text;
        this.answer = answer;
        this.questionNumber = questionNumber;
    }

    protected Question() {
        // for ORM only
    }

    public String typeText() {
        return this.typeQuestionToString() + this.text();
    }

    public String text() {
        return text;
    }

    public abstract String typeQuestionToString();

    public Float score() {
        return score.score();
    }

    public double questionNumber(){
        return questionNumber;
    }

    public void merge(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Cannot merge with a question null");
        }

        this.text = question.text;
        this.score = question.score;
        this.answer = question.answer;
    }

    public boolean isCorrectAnswer(String answer) {
        return this.answer.isCorrectAnswer(answer);
    }

    public String correctAnswer() {
        return this.answer.correctAnswer();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return text.equals(question.text) && score.equals(question.score) && answer.equals(question.answer) && type.equals(question.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, score, answer, type);
    }

    @Override
    public String toString() {
        return "-- Question --\n" + "Text: " + this.text + "\n"
                + this.score.toString() + "\n"
                + this.answer.toString() + "\n";
    }
}
