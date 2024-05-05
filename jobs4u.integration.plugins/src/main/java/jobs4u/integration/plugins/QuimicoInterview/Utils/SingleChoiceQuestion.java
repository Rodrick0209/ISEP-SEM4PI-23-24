package jobs4u.integration.plugins.QuimicoInterview.Utils;

public class SingleChoiceQuestion extends Question{


    public SingleChoiceQuestion(final String text,final QuestionScore questionScore ,final Answer answer, final double questionNumber) {
        super(text,questionScore,answer,questionNumber);
    }

    public SingleChoiceQuestion(final String text, final Answer answer, final double questionNumber) {
        super(text,answer,questionNumber);
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
        if (!(question instanceof SingleChoiceQuestion)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);

        final SingleChoiceQuestion that = (SingleChoiceQuestion) question;
    }











}
