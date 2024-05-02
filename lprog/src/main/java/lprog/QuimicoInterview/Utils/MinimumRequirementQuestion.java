package jobs4u.base.QuimicoInterview.Utils;

public class MinimumRequirementQuestion extends Question {


    public MinimumRequirementQuestion(final String text, final QuestionScore score, final Answer answer, double questionNumber) {
        super(text, score, answer, questionNumber);
    }


    public MinimumRequirementQuestion(final String text, final Answer answer, double questionNumber) {
        super(text, answer, questionNumber);
    }


    @Override
    public String typeQuestionToString() {
        return "Minimum Requirement\n";
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        float userAnswer = Float.parseFloat(answer);
        float correctAnswer = Float.parseFloat(this.correctAnswer());

        return userAnswer >= correctAnswer;
    }


    @Override
    public void merge(Question question) {
        if (!(question instanceof DateQuestion)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);

        final MinimumRequirementQuestion that = (MinimumRequirementQuestion) question;
    }


}
