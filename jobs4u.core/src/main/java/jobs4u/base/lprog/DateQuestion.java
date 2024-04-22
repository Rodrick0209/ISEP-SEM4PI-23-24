package jobs4u.base.lprog;

public class DateQuestion extends Question {

    public DateQuestion(final String text, final QuestionScore score, final Answer answer) {
        super(text, score, answer);
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