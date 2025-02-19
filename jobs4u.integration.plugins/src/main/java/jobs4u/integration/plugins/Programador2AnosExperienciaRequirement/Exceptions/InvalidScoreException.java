package jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.Exceptions;

public class InvalidScoreException extends RuntimeException {

    /**
     * Lança a exceção com mensagem por defeito.
     */
    public InvalidScoreException() {
        super("The score for an exam has invalid!");
    }

    /**
     * Lança a exceção com uma string personalizada.
     *
     * @param s String personalizada
     */
    public InvalidScoreException(String s) {
        super(s);
    }
}
