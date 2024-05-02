package lprog.QuimicoInterview.InterviewManagement;

import lprog.QuimicoInterview.InterviewManagement.Evaluation.EvalVisitorEvaluation;
import lprog.QuimicoInterview.Exceptions.ErrorInFileException;
import lprog.QuimicoInterview.Exceptions.InvalidScoreException;
import lprog.QuimicoInterview.InterviewManagement.Evaluation.EvaluationLexer;
import lprog.QuimicoInterview.InterviewManagement.Evaluation.EvaluationParser;
import lprog.QuimicoInterview.InterviewManagement.InterviewTemplateAnalyze.EvalVisitor;
import lprog.QuimicoInterview.InterviewManagement.InterviewTemplateAnalyze.InterviewLexer;
import lprog.QuimicoInterview.InterviewManagement.InterviewTemplateAnalyze.InterviewParser;
import lprog.QuimicoInterview.Utils.PluginQuestions;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import jobs4u.base.pluginManagement.application.InterviewEvaluation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InterviewService implements InterviewEvaluation {


    String template = "jobs4u.core/src/main/java/jobs4u/base/QuimicoInterview/TemplateFile/template.txt";

    public PluginQuestions checkTemplateSyntax() throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream(template);
            InterviewLexer lexer = new InterviewLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InterviewParser parser = new InterviewParser(tokens);

            ParseTree tree = parser.interviewQuestion();
            EvalVisitor visitor = new EvalVisitor();
            visitor.visit(tree);

            return visitor.getInterviewQuestions();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("The file doesn't exists!");
        } catch (InvalidScoreException e) {
            throw new IllegalArgumentException(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double evaluate(String answerPath) throws Exception {

        PluginQuestions pluginQuestions = checkTemplateSyntax();
        try {
            FileInputStream fileInputStream = new FileInputStream(answerPath);
            EvaluationLexer lexer = new EvaluationLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EvaluationParser parser = new EvaluationParser(tokens);
            EvalVisitorEvaluation visitor = new EvalVisitorEvaluation();

            ParseTree tree = parser.answers();
            visitor.registerExam(pluginQuestions);
            visitor.visit(tree);
            return visitor.getGrade();

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("The file doesn't exists!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new ErrorInFileException("The resolution does not follow the required format!.");
        }



    }
}
