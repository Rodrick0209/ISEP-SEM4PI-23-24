package jobs4u.integration.plugins.QuimicoInterview.Utils;

import eapli.framework.validations.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa a entidade MultipleChoice.
 */
public class MultipleChoice extends Question {

    private Map<String, String> options = new HashMap<>();

    public MultipleChoice(final String text, final QuestionScore score, final Answer answer, final Map<String, String> options, final double questionNumber) {
        super(text, score, answer,questionNumber);

        Preconditions.noneNull(options, "Options cannot be null");
        this.options = options;
    }


    public MultipleChoice(final String text, final Answer answer, final Map<String, String> options, final double questionNumber) {
        super(text,answer,questionNumber);

        Preconditions.noneNull(options, "Options cannot be null");
        this.options = options;
    }
    protected MultipleChoice() {
        // for ORM only
    }

    public Map<String, String> getOptions() {
        return options;
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
