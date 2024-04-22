package jobs4u.base.lprog;

import eapli.framework.validations.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa a entidade MultipleChoice.
 */
public class MultipleChoice extends Question {

    private Map<String, String> options = new HashMap<>();

    public MultipleChoice(final String text, final QuestionScore score, final Answer answer, final Map<String, String> options) {
        super(text, score, answer);

        Preconditions.noneNull(options, "Options cannot be null");
        this.options = options;
    }

    protected MultipleChoice() {
        // for ORM only
    }

    @Override
    public String text() {
        StringBuilder options = new StringBuilder();

        for (String key : this.options.keySet()) {
            options.append(key).append(") ").append(this.options.get(key)).append("\n");
        }

        return super.text() + "\n" + options;
    }

    @Override
    public String typeQuestionToString () {
        return "Multiple Choice\n";
    }

    @Override
    public void merge(Question question) {
        if (!(question instanceof MultipleChoice)) {
            throw new IllegalArgumentException("Cannot merge with a different type");
        }

        super.merge(question);

        final MultipleChoice that = (MultipleChoice) question;
        this.options = that.options;
    }


}
