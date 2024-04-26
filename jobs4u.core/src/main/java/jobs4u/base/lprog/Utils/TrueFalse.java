package jobs4u.base.lprog.Utils;


/**
 * Representa a entidade TrueFalse.
 */
public class TrueFalse extends Question {

    public TrueFalse(final String text, final QuestionScore score, final Answer answer,final double questionNumber) {
        super(text, score, answer,questionNumber);
    }

    protected TrueFalse() {
        // for ORM only
    }

    @Override
    public String typeQuestionToString () {
        return "True/False\n";
    }

    @Override
    public void merge(Question question) {
        if (!(question instanceof TrueFalse)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);
    }


}
