package jobs4u.base.lprog.RequirementManagement.RequirementTemplateAnalyze;

import jobs4u.base.lprog.Utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvalVisitor extends RequirementBaseVisitor<Object> {

    private PluginQuestions interview;

    public EvalVisitor() {
        this.interview = null;
    }

    public PluginQuestions getQuestions() {
        return this.interview;
    }

    @Override
    public Object visitRequirementQuestion(RequirementParser.RequirementQuestionContext ctx) {
        int totalScore = 0;
        List<Question> questions = new ArrayList<>();
        for (RequirementParser.QuestionContext questionContext : ctx.question()) {
            questions.add((Question) visitQuestion(questionContext));
        }

        PluginQuestions exam = new PluginQuestions(questions);
        return this.interview = exam;
    }

    @Override
    public Question visitQuestion(RequirementParser.QuestionContext ctx) {
        return (Question) visit(ctx.getChild(0));
    }


    @Override
    public YesNoQuestion visitYesNo(RequirementParser.YesNoContext ctx){
        String text = visitPhrase(ctx.phrase());

        String correctAnswer = ctx.YES_NO().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);
        return new YesNoQuestion(text, answer, questionNr);

    }

    @Override
    public SingleChoiceQuestion visitSingleChoice(RequirementParser.SingleChoiceContext ctx){
        String text = visitPhrase(ctx.phrase());
        String correctAnswer = ctx.MULTIPLE_CHOICE_ANSWER().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);
        return new SingleChoiceQuestion(text, answer, questionNr);

    }


    @Override
    public MinimumRequirementQuestion visitMinimumRequirement(RequirementParser.MinimumRequirementContext ctx) {
        String text = visitPhrase(ctx.phrase());
        String correctAnswer = ctx.FLOAT().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);
        return new MinimumRequirementQuestion(text, answer, questionNr);
    }


    @Override
    public MultipleChoice visitMultipleChoice(RequirementParser.MultipleChoiceContext ctx) {
        String text = visitPhrase(ctx.phrase());

        Map<String, String> options = new HashMap<>();
        for (RequirementParser.OptionContext optionCtx : ctx.option()) {
            String[] option = visitOption(optionCtx).toString().split("\\)");
            options.put(option[0].trim(), option[1].trim());
        }

        String correctAnswer = ctx.MULTIPLE_CHOICE_ANSWER().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);
        return new MultipleChoice(text, answer, options, questionNr);
    }

    @Override
    public ShortAnswer visitShortAnswer(RequirementParser.ShortAnswerContext ctx) {
        String text = visitPhrase(ctx.phrase(0));
        String correctAnswer = visitPhrase(ctx.phrase(1));
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);

        return new ShortAnswer(text, answer, questionNr);
    }

    @Override
    public String visitPhrase(RequirementParser.PhraseContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitOption(RequirementParser.OptionContext ctx) {
        return ctx.getText();
    }


    @Override
    public Numerical visitNumerical(RequirementParser.NumericalContext ctx) {
        String text = visitPhrase(ctx.phrase());
        String correctAnswer = ctx.FLOAT().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);
        return new Numerical(text, answer, questionNr);

    }


    @Override
    public String visitPossibleChoices(RequirementParser.PossibleChoicesContext ctx) {
        return visitWords(ctx.words(0));
    }

    @Override
    public TrueFalse visitTrueFalse(RequirementParser.TrueFalseContext ctx) {
        String text = visitPhrase(ctx.phrase());
        String correctAnswer = ctx.TRUE_OR_FALSE().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);

        return new TrueFalse(text, answer, questionNr);
    }

    @Override
    public DateQuestion visitDate(RequirementParser.DateContext ctx) {
        String text = visitPhrase(ctx.phrase());
        String correctAnswer = ctx.DATE_FORMAT().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);

        return new DateQuestion(text, answer, questionNr);
    }




    @Override
    public NumericScale visitNumericScale(RequirementParser.NumericScaleContext ctx) {
        String text = visitPhrase(ctx.phrase());
        String correctAnswer = ctx.NUMS().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);

        return new NumericScale(text, answer, questionNr);
    }

    @Override
    public TimeQuestion visitTime(RequirementParser.TimeContext ctx) {
        String text = visitPhrase(ctx.phrase());
        String correctAnswer = ctx.TIME_FORMAT().getText();
        double questionNr = Double.parseDouble(ctx.QUESTION_NUMBER().getText().substring(1, 2));
        Answer answer = new Answer(correctAnswer);

        return new TimeQuestion(text, answer, questionNr);
    }


    public float convertToFloat(String number) {
        return Float.parseFloat(number);
    }

    @Override
    public String visitWords(RequirementParser.WordsContext ctx) {
        return ctx.getText();
    }


}



