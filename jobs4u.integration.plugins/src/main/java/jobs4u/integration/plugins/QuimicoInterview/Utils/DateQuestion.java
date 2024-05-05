package jobs4u.integration.plugins.QuimicoInterview.Utils;

public class DateQuestion extends Question {

    public DateQuestion(final String text, final QuestionScore score, final Answer answer, double questionNumber) {
        super(text, score, answer,questionNumber);
    }


    public DateQuestion(final String text, final Answer answer, double questionNumber) {
        super(text, answer,questionNumber);
    }
    @Override
    public String typeQuestionToString () {
        return "Date\n";
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        if (answer.equals(this.correctAnswer()))
            return true;
        else
            return false;

    }

    @Override
    public void merge(Question question) {
        if (!(question instanceof DateQuestion)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);

        final DateQuestion that = (DateQuestion) question;
    }
}