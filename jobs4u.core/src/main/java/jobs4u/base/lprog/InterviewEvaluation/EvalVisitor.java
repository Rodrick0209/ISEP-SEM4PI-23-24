package jobs4u.base.lprog.InterviewEvaluation;

import jobs4u.base.lprog.Utils.PluginQuestions;
import jobs4u.base.lprog.Utils.MultipleChoice;
import jobs4u.base.lprog.Utils.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvalVisitor extends EvaluationBaseVisitor<Object> {

    int numberAnswers = 0;

    private PluginQuestions pluginQuestions;

    private final List<AnswerFromUser> answers = new ArrayList<>();

    public void registerExam(PluginQuestions examSolution) {
        pluginQuestions = examSolution;
    }

    public float getGrade() {

        List<Question> questions = pluginQuestions.getQuestions();
        int counter = 0;
        float grade = 0;

        //validar nr de respostas vs numero de perguntas
        if (questions.size() != answers.size()) {
            throw new IllegalStateException("The number of answers is different from the number of questions");
        }
        for (int j = 0; j < questions.size(); j++) {
            Question question = questions.get(j);
            double questionNumber = questions.get(j).questionNumber();
            for (AnswerFromUser a : answers) {
                if (question instanceof MultipleChoice && questionNumber == a.answerNumber() && isValidMultipleChoiceAnswer(a.correctAnswer())) {
                    Float scoreDestaPergunta = question.score();

                    int length = ((MultipleChoice) question).correctAnswer().split(",").length;
                    Float pontuacaoCadaRespostaCertas = scoreDestaPergunta / length;
                    Float pontuacaoDestasRespostas = 0.0f;
                    String[] answersGiven = a.correctAnswer().split(",");
                    String[] correctAnswers = question.correctAnswer().split(",");
                    boolean flag;

                    for (String s : Arrays.stream(answersGiven).distinct().toArray(String[]::new)) {
                        flag = false;
                        for (String s2 : correctAnswers) {
                            if (s.equals(s2)) {
                                pontuacaoDestasRespostas += pontuacaoCadaRespostaCertas;
                                flag = true;

                            }

                        }
                        if (!flag) {
                            pontuacaoDestasRespostas = pontuacaoDestasRespostas - pontuacaoCadaRespostaCertas;
                        }

                    }
                    if (pontuacaoDestasRespostas > 0) {
                        grade += pontuacaoDestasRespostas;
                    }
                    break;

                } else if (questionNumber == a.answerNumber() && question.isCorrectAnswer(a.correctAnswer())) {
                    grade += question.score();
                    break;
                }
            }
        }

        return grade;
    }

    @Override
    public Object visitAnswers(EvaluationParser.AnswersContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }
        return null;
    }


    @Override
    public Object visitAnswer(EvaluationParser.AnswerContext ctx) {
        visit(ctx.getChild(0));

        return null;
    }


    @Override
    public Object visitAnswerToMultipleChoice(EvaluationParser.AnswerToMultipleChoiceContext ctx) {
        numberAnswers++;

        String answer = ctx.MULTIPLE_CHOICE_ANSWER().getText();
        double questionNr = Double.parseDouble(ctx.ANSWER().getText().substring(0, 1));
        answer = answer.trim();
        answers.add(new AnswerFromUser(answer, questionNr));


        return null;
    }

    @Override
    public Object visitAnswerToShortAnswer(EvaluationParser.AnswerToShortAnswerContext ctx) {
        numberAnswers++;
        String answer = visitPhrase(ctx.phrase());
        double questionNr = Double.parseDouble(ctx.ANSWER().getText().substring(0, 1));
        answer = answer.trim();
        answers.add(new AnswerFromUser(answer, questionNr));

        return null;
    }

    @Override
    public String visitPhrase(EvaluationParser.PhraseContext ctx) {
        return ctx != null ? ctx.getText() : "";
    }


    @Override
    public Object visitAnswerToNumerical(EvaluationParser.AnswerToNumericalContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.FLOAT());
        double questionNr = Double.parseDouble(ctx.ANSWER().getText().substring(0, 1));
        answer = answer.trim();
        answers.add(new AnswerFromUser(answer, questionNr));

        return null;
    }


    @Override
    public Object visitAnswerToTrueFalse(EvaluationParser.AnswerToTrueFalseContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.TRUE_OR_FALSE());
        double questionNr = Double.parseDouble(ctx.ANSWER().getText().substring(0, 1));
        answer = answer.trim();
        answers.add(new AnswerFromUser(answer, questionNr));

        return null;
    }

    public Object visitAnswerToDate(EvaluationParser.AnswerToDateContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.DATE());
        double questionNr = Double.parseDouble(ctx.ANSWER().getText().substring(0, 1));
        answer = answer.trim();
        answers.add(new AnswerFromUser(answer, questionNr));

        return null;
    }

    public Object visitAnswerToTime(EvaluationParser.AnswerToTimeContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.TIME());
        double questionNr = Double.parseDouble(ctx.ANSWER().getText().substring(0, 1));
        answer = answer.trim();
        answers.add(new AnswerFromUser(answer, questionNr));

        return null;
    }


    public Object visitAnswerToNumericScale(EvaluationParser.AnswerToNumericScaleContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.NUMS());
        double questionNr = Double.parseDouble(ctx.ANSWER().getText().substring(0, 1));
        answer = answer.trim();
        answers.add(new AnswerFromUser(answer, questionNr));


        return null;
    }


    @Override
    public String visitWords(EvaluationParser.WordsContext ctx) {
        return ctx != null ? ctx.getText() : "";
    }

    public boolean isValidMultipleChoiceAnswer(String answer) {
        // Expressão regular para validar a resposta de escolha múltipla
        String regex = "^[a-z](,[a-z])*$";

        // Retorna true se a resposta corresponder à expressão regular, false caso contrário
        return answer.matches(regex);
    }
}
