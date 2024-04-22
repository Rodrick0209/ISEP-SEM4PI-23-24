package jobs4u.base.lprog;

public class NumericScale extends Question {



    public NumericScale(final String text, final QuestionScore score, final Answer answer) {
        super(text, score, answer);
    }

    @Override
    public String typeQuestionToString () {
        return "Numerical\n";
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        float answerGiven = 0f;
        float correctAnswer = 0f;
        try {
            answerGiven = Float.parseFloat(answer);
            correctAnswer = Float.parseFloat(correctAnswer());
        } catch (NumberFormatException e) {
            return false;
        }

        return (correctAnswer == answerGiven);
    }

    @Override
    public void merge(Question question) {
        if (!(question instanceof Numerical)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);

        final Numerical that = (Numerical) question;
    }


}
