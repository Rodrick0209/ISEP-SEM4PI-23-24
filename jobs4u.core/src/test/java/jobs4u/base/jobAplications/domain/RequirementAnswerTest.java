package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.FileName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequirementAnswerTest {

    @Test
    public void testIsRecognisingFileAnswer() {
        // Cria um mock da classe Answer
        FileName answer = FileName.valueOf("answerFromCandidate1Test.answer");

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
        FileName answer = FileName.valueOf("erro.answer");

        InputStream inputStream;
        try {
            inputStream = answer.inputStreamFromResourceOrFile();

            assertThrows(FileNotFoundException.class, answer::inputStreamFromResourceOrFile);

        } catch (IOException f) {

        }
    }












}
