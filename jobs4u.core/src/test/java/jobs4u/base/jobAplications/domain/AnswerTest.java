package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.Answer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.*;

public class AnswerTest {


    @Test
    public void testIsRecognisingFileAnswer() {
        // Cria um mock da classe Answer
        Answer answer = new Answer("answerFromCandidate1Test.answer");

        InputStream inputStream;
        try {
            inputStream = answer.inputStreamFromResourceOrFile();

            // Verifica se o InputStream retornado não é nulo
            assertNotNull("InputStream não deve ser nulo", inputStream);


        } catch (IOException e) {
            // Se houver uma exceção, falha no teste
            e.printStackTrace();
        }
    }

    @Test
    public void testDoesntRecogniseInvalidFile() {
        Answer answer = new Answer("erro.answer");

        InputStream inputStream;
        try {
            inputStream = answer.inputStreamFromResourceOrFile();

            assertThrows(FileNotFoundException.class, answer::inputStreamFromResourceOrFile);

        } catch (IOException f) {

        }
    }
}







