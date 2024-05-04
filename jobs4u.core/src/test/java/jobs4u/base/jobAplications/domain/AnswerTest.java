package jobs4u.base.jobAplications.domain;

import jobs4u.base.jobApplications.domain.Answer;
import org.junit.jupiter.api.Test;

import java.io.*;

public class AnswerTest {


    @Test
    public void testIsRecognisingFileAnswer() {
        Answer answer = new Answer("answerFromCandidate1Test.txt");
        try {
            // Supondo que "inputStream" seja seu InputStream
            InputStream inputStream = answer.inputStreamFromResourceOrFile();

            // Cria um BufferedReader para ler o InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Variável para armazenar cada linha lida
            String line;

            // Lê cada linha do InputStream até chegar ao fim
            while ((line = reader.readLine()) != null) {
                // Imprime a linha
                System.out.println(line);
            }

            // Fecha o BufferedReader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }








}
