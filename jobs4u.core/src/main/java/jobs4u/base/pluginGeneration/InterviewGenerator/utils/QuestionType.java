package jobs4u.base.pluginGeneration.InterviewGenerator.utils;

public enum QuestionType {
    MULTIPLE_CHOICE("Multiple Choice"),
    SHORT_ANSWER("Short Answer"),
    NUMERICAL("Numerical"),
    TRUE_FALSE("True/False"),
    DATE("Date"),
    TIME("Time"),
    NUMERIC_SCALE("Numeric Scale"),
    YES_NO("Yes/No"),
    MINIMUN_REQUIREMENTS("Minimum Requirement"),
    SINGLE_CHOICE("Single Choice");

    private final String label;

    QuestionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    // Método para obter o enum pelo número ordinal
    public static QuestionType getByOrdinal(int ordinal) {
        for (QuestionType type : QuestionType.values()) {
            if (type.ordinal() == ordinal - 1) {
                return type;
            }
        }
        return null;
    }
}