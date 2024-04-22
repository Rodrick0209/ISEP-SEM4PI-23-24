package jobs4u.base.lprog.Evaluation;

import jobs4u.base.lprog.InterviewQuestions;
import jobs4u.base.lprog.MultipleChoice;
import jobs4u.base.lprog.Question;

import java.util.ArrayList;
import java.util.List;

public class EvalVisitor extends EvaluationBaseVisitor<Object> {

    int numberAnswers = 0;

    private InterviewQuestions interviewQuestions;

    private List<String> answers = new ArrayList<>();

    public void registerExam(InterviewQuestions examSolution) {
        interviewQuestions = examSolution;
    }

    public float getGrade() {

        List<Question> questions = interviewQuestions.getQuestions();
        int counter = 0;
        float grade = 0;

                //validar nr de respostas vs numero de perguntas

        if (questions.size() != numberAnswers) {
            throw new IllegalStateException("The number of answers is different from the number of questions");
        }


        //Percorre as perguntas
        for (int j = 0; j < questions.size(); j++) {
            Question question = questions.get(j);

            //Verifica se a pergunta é do tipo MultipleChoice e temos de tratar de forma diferente
            if (question instanceof MultipleChoice) {
                String[] correctAnswers = question.correctAnswer().split(",");
                String[] answersGiven = answers.get(counter).split(",");
                Float scoreDestaPergunta = questions.get(j).score();
                Float pontuacaoCadaRespostaCertas = scoreDestaPergunta / correctAnswers.length;
                Float pontuacaoDestasRespostas = 0.0f;
                boolean flag;
                for (String s : answersGiven) {
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
                System.out.println("Resposta obtido em escolha multiplo com multiplas opcoes  "+pontuacaoDestasRespostas);
                if (pontuacaoDestasRespostas > 0){
                    grade += pontuacaoDestasRespostas;
                }

            }//Se as respostas estiverem corretas aumenta a nota
            else if
            (question.isCorrectAnswer(answers.get(counter))) {
                grade += question.score();
            }
            counter++;

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
        String answer = ctx.CHAR() != null ? ctx.CHAR().getText() : "";

        answer = answer.trim();
        answers.add(answer);

        return null;
    }

    @Override
    public Object visitAnswerToShortAnswer(EvaluationParser.AnswerToShortAnswerContext ctx) {
        numberAnswers++;
        String answer = visitPhrase(ctx.phrase());

        answer = answer.trim();
        answers.add(answer);

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

        answer = answer.trim();
        answers.add(answer);

        return null;
    }


    @Override
    public Object visitAnswerToTrueFalse(EvaluationParser.AnswerToTrueFalseContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.TRUE_OR_FALSE());

        answer = answer.trim();
        answers.add(answer);

        return null;
    }

    public Object visitAnswerToDate(EvaluationParser.AnswerToDateContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.DATE());

        answer = answer.trim();
        answers.add(answer);

        return null;
    }

    public Object visitAnswerToTime(EvaluationParser.AnswerToTimeContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.TIME());

        answer = answer.trim();
        answers.add(answer);

        return null;
    }


    public Object visitAnswerToNumericScale(EvaluationParser.AnswerToNumericScaleContext ctx) {
        numberAnswers++;
        String answer = String.valueOf(ctx.NUMS());

        answer = answer.trim();
        answers.add(answer);

        return null;
    }


    @Override
    public String visitWords(EvaluationParser.WordsContext ctx) {
        return ctx != null ? ctx.getText() : "";
    }
}
