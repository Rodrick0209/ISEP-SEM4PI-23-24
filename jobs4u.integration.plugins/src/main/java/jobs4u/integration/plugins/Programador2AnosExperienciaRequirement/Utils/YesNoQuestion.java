package jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.Utils;


public class YesNoQuestion extends Question {


    public YesNoQuestion(final String text, final QuestionScore score, final Answer answer, final double questionNumber) {
        super(text, score, answer,questionNumber);
    }

    public YesNoQuestion(final String text, final Answer answer, final double questionNumber) {
        super(text, answer,questionNumber);
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
        if (!(question instanceof YesNoQuestion)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);

        final YesNoQuestion that = (YesNoQuestion) question;
    }


}
