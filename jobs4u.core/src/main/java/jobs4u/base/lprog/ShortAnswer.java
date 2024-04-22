package jobs4u.base.lprog;


/**
 * Representa a entidade ShortAnswer.
 */
public class ShortAnswer extends Question {

    public ShortAnswer(final String text, final QuestionScore score, final Answer answer) {
        super(text, score, answer);
    }

    protected ShortAnswer() {
        // for ORM only
    }

    @Override
    public String typeQuestionToString () {
        return "Short Answer\n";
    }

    @Override
    public void merge(Question question) {
        if (!(question instanceof ShortAnswer)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);
    }


}
