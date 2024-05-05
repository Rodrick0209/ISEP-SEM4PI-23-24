package jobs4u.integration.plugins.QuimicoInterview.InterviewManagement.InterviewTemplateAnalyze;


import jobs4u.integration.plugins.QuimicoInterview.Utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvalVisitor extends InterviewBaseVisitor<Object> {


    private PluginQuestions interview;

    public EvalVisitor() {
        this.interview = null;
    }

    public PluginQuestions getInterviewQuestions() {
        return this.interview;
    }

    @Override
    public Object visitInterviewQuestion(InterviewParser.InterviewQuestionContext ctx) {
        int totalScore = 0;
        List<Question> questions = new ArrayList<>();
        for (InterviewParser.QuestionContext questionContext : ctx.question()) {
            questions.add((Question) visitQuestion(questionContext));
            totalScore += visitQuestion(questionContext).score();
        }

        if (totalScore != 20){
            throw new IllegalStateException("The total score of the exam is not 20");
        }

        PluginQuestions exam = new PluginQuestions(questions);
        return this.interview = exam;
    }

    @Override
    public Question visitQuestion(InterviewParser.QuestionContext ctx) {
        return (Question) visit(ctx.getChild(0));
    }


    @Override
    public MultipleChoice visitMultipleChoice(InterviewParser.MultipleChoiceContext ctx) {
        String text = visitPhrase(ctx.phrase());

        Map<String, String> options = new HashMap<>();
        for (InterviewParser.OptionContext optionCtx : ctx.option()) {
            String[] option = visitOption(optionCtx).toString().split("\\)");
            options.put(option[0].trim(), option[1].trim());
        }

        float score = convertToFloat(ctx.FLOAT().getText());
        String correctAnswer = ctx.MULTIPLE_CHOICE_ANSWER().getText();
        QuestionScore questionScore = QuestionScore.valueOf(score);
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1,2));
        Answer answer = new Answer(correctAnswer);
        return new MultipleChoice(text, questionScore, answer, options, questionNr);
    }

    @Override
    public ShortAnswer visitShortAnswer(InterviewParser.ShortAnswerContext ctx) {
        String text = visitPhrase(ctx.phrase(0));
        float score = convertToFloat(ctx.FLOAT().getText());
        String correctAnswer = visitPhrase(ctx.phrase(1));
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1,2));
        QuestionScore questionScore = QuestionScore.valueOf(score);
        Answer answer = new Answer(correctAnswer);

        return new ShortAnswer(text, questionScore, answer, questionNr);
    }

    @Override
    public String visitPhrase(InterviewParser.PhraseContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitOption(InterviewParser.OptionContext ctx) {
        return ctx.getText();
    }


    @Override
    public Numerical visitNumerical(InterviewParser.NumericalContext ctx) {
        String text = visitPhrase(ctx.phrase());
        float score = convertToFloat(ctx.FLOAT(0).getText());
        String correctAnswer = ctx.FLOAT(1).getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1,2));
        QuestionScore questionScore = QuestionScore.valueOf(score);
        Answer answer = new Answer(correctAnswer);

        return new Numerical(text, questionScore, answer,questionNr);
    }


    @Override
    public String visitPossibleChoices(InterviewParser.PossibleChoicesContext ctx) {
        return visitWords(ctx.words(0));
    }

    @Override
    public TrueFalse visitTrueFalse(InterviewParser.TrueFalseContext ctx) {
        String text = visitPhrase(ctx.phrase());
        float score = convertToFloat(ctx.FLOAT().getText());
        String correctAnswer = ctx.TRUE_OR_FALSE().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1,2));
        QuestionScore questionScore = QuestionScore.valueOf(score);
        Answer answer = new Answer(correctAnswer);

        return new TrueFalse(text, questionScore, answer,questionNr);
    }

    @Override
    public DateQuestion visitDate(InterviewParser.DateContext ctx) {
        String text = visitPhrase(ctx.phrase());
        float score = convertToFloat(ctx.FLOAT().getText());
        String correctAnswer = ctx.DATE_FORMAT().getText();
        QuestionScore questionScore = QuestionScore.valueOf(score);
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1,2));
        Answer answer = new Answer(correctAnswer);

        return new DateQuestion(text, questionScore, answer,questionNr);
    }


    @Override
    public NumericScale visitNumericScale(InterviewParser.NumericScaleContext ctx) {
        String text = visitPhrase(ctx.phrase());
        float score = convertToFloat(ctx.FLOAT().getText());
        String correctAnswer = ctx.NUMS().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1,2));
        QuestionScore questionScore = QuestionScore.valueOf(score);
        Answer answer = new Answer(correctAnswer);

        return new NumericScale(text, questionScore, answer,questionNr);
    }

    @Override
    public TimeQuestion visitTime(InterviewParser.TimeContext ctx) {
        String text = visitPhrase(ctx.phrase());
        float score = convertToFloat(ctx.FLOAT().getText());
        String correctAnswer = ctx.TIME_FORMAT().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1,2));
        QuestionScore questionScore = QuestionScore.valueOf(score);
        Answer answer = new Answer(correctAnswer);

        return new TimeQuestion(text, questionScore, answer,questionNr);
    }


    public float convertToFloat(String number) {
        return Float.parseFloat(number);
    }

    @Override
    public String visitWords(InterviewParser.WordsContext ctx) {
        return ctx.getText();
    }


}
