package jobs4u.base.lprog;

public class TimeQuestion extends Question {

    public TimeQuestion(final String text, final QuestionScore score, final Answer answer) {
        super(text, score, answer);
    }

    @Override
    public String typeQuestionToString () {
        return "Time\n";
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
        if (!(question instanceof TimeQuestion)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);

        final TimeQuestion that = (TimeQuestion) question;
    }
}