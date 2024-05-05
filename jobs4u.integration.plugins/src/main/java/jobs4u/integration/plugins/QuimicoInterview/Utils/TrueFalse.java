package jobs4u.integration.plugins.QuimicoInterview.Utils;


/**
 * Representa a entidade TrueFalse.
 */
public class TrueFalse extends Question {

    public TrueFalse(final String text, final QuestionScore score, final Answer answer,final double questionNumber) {
        super(text, score, answer,questionNumber);
    }

    public TrueFalse(final String text,  final Answer answer,final double questionNumber) {
        super(text, answer,questionNumber);
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
