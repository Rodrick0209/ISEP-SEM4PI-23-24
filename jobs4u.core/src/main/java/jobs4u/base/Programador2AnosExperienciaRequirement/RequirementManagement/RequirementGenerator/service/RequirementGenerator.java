package jobs4u.base.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementGenerator.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RequirementGenerator {



    public void generateRequirement(Map<String, Map<String, String>> questions, String fileName) {
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

                for (Map.Entry<String, String> questionEntry : questionData.entrySet()) {
                    String key = questionEntry.getKey();
                    String value = questionEntry.getValue();

                    if (!key.equals("Question") && !key.equals("Requirement")) {
                        writer.write(key + ": " + value + "\n");
                    }
                }

                String correctAnswer = questionData.get("Requirement");
                if (correctAnswer != null) {
                    writer.write("Requirement" + ": " + correctAnswer + "\n");
                }

                writer.write("\n"); // Adiciona uma linha em branco entre as perguntas
            }
            System.out.println("Entrevista gerada com sucesso no arquivo: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }








}
