package jobs4u.base.lprog.InterviewManagement.InterviewGenerator.utils;

public enum InterviewQuestionsType {
    MULTIPLE_CHOICE("Multiple Choice"),
    SHORT_ANSWER("Short Answer"),
    NUMERICAL("Numerical"),
    TRUE_FALSE("True/False"),
    DATE("Date"),
    TIME("Time"),
    NUMERIC_SCALE("Numeric Scale");

    private final String label;

    InterviewQuestionsType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    // Método para obter o enum pelo número ordinal
    public static InterviewQuestionsType getByOrdinal(int ordinal) {
        for (InterviewQuestionsType type : InterviewQuestionsType.values()) {
            if (type.ordinal() == ordinal - 1) {
                return type;
            }
        }
        return null;
    }
}