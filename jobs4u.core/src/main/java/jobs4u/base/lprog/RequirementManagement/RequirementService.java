package jobs4u.base.lprog.RequirementManagement;

import jobs4u.base.lprog.Exceptions.ErrorInFileException;
import jobs4u.base.lprog.Exceptions.InvalidScoreException;
import jobs4u.base.lprog.Evaluation.EvaluationLexer;
import jobs4u.base.lprog.Evaluation.EvaluationParser;
import jobs4u.base.lprog.Plugin;
import jobs4u.base.lprog.RequirementManagement.RequirementTemplateAnalyze.EvalVisitor;
import jobs4u.base.lprog.RequirementManagement.RequirementTemplateAnalyze.RequirementLexer;
import jobs4u.base.lprog.RequirementManagement.RequirementTemplateAnalyze.RequirementParser;
import jobs4u.base.lprog.Utils.PluginQuestions;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RequirementService implements Plugin {


    public PluginQuestions checkTemplateSyntax(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            RequirementLexer lexer = new RequirementLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            RequirementParser parser = new RequirementParser(tokens);

            ParseTree tree = parser.requirementQuestion();
            EvalVisitor visitor = new EvalVisitor();
            visitor.visit(tree);

            return visitor.getQuestions();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("The file doesn't exists!");
        } catch (InvalidScoreException e) {
            throw new IllegalArgumentException(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void evaluate(String templatePath, String answerPath) {
        PluginQuestions pluginQuestions = checkTemplateSyntax(templatePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(answerPath);
            EvaluationLexer lexer = new EvaluationLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EvaluationParser parser = new EvaluationParser(tokens);
            jobs4u.base.lprog.Evaluation.EvalVisitor visitor = new jobs4u.base.lprog.Evaluation.EvalVisitor();

            ParseTree tree = parser.answers();
            visitor.registerExam(pluginQuestions);
            visitor.visit(tree);
            System.out.println(visitor.evaluateIfRequirementsAreValid());
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
