package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.FileName;
import jobs4u.base.jobApplications.domain.RequirementAnswer;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequirementAnswerTest {

    @Test
    public void testIsRecognisingFileAnswer() {
        // Cria um mock da classe Answer
        RequirementAnswer answer = new RequirementAnswer("answerFromCandidate1Test.answer");

        InputStream inputStream;
        inputStream = answer.inputStreamFromResourceOrFile();

        // Verifica se o InputStream retornado não é nulo
        assertNotNull("InputStream não deve ser nulo", inputStream);


    }

    @Test
    public void testDoesntRecogniseInvalidFile() {
        /*FileName answer = FileName.valueOf("erro.answer");

        InputStream inputStream;
        try {
            inputStream = answer.inputStreamFromResourceOrFile();

            assertThrows(FileNotFoundException.class, answer::inputStreamFromResourceOrFile);

        } catch (IOException f) {

        }*/
    }












}
