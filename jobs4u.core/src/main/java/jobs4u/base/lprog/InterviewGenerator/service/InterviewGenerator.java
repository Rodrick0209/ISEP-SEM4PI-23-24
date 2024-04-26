package jobs4u.base.lprog.InterviewGenerator.service;

import eapli.framework.application.ApplicationService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@ApplicationService
public class InterviewGenerator {




    public void generateInterview(Map<String, Map<String, String>> questions, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Map<String, String>> entry : questions.entrySet()) {
                String questionType = entry.getKey();
                Map<String, String> questionData = entry.getValue();

                writer.write(questionType+" "); // Escreve o tipo de pergunta

                // Primeiro escreva a pergunta, se houver
                String question = questionData.get("Question");
                if (question != null) {
                    writer.write(question + "\n");
                }

                // Em seguida, escreva "Score" e "CorrectAnswer", se estiverem presentes
                for (Map.Entry<String, String> questionEntry : questionData.entrySet()) {
                    String key = questionEntry.getKey();
                    String value = questionEntry.getValue();

                    if (!key.equals("Question") && !key.equals("CorrectAnswer")) {
                        writer.write(key + ": " + value + "\n");
                    }
                }

                // Verifica e escreve "CorrectAnswer" se estiver presente
                String correctAnswer = questionData.get("CorrectAnswer");
                if (correctAnswer != null) {
                    writer.write("CorrectAnswer" + ": " + correctAnswer + "\n");
                }

                writer.write("\n"); // Adiciona uma linha em branco entre as perguntas
            }
            System.out.println("Entrevista gerada com sucesso no arquivo: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }









}
