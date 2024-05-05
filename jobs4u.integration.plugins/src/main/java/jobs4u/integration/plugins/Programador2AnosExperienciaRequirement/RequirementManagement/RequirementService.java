package jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement;

import jobs4u.base.pluginManagement.application.RequirementEvaluation;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.Exceptions.InvalidScoreException;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.Evaluation.EvaluationLexer;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.Exceptions.ErrorInFileException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.Evaluation.EvalVisitorEvaluation;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.Evaluation.EvaluationParser;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.EvalVisitor;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.RequirementLexer;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.RequirementParser;
import jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.Utils.PluginQuestions;

public class RequirementService implements RequirementEvaluation {

    String templatePath = "jobs4u.integration.plugins.Programador2AnosExperienciaRequirement/Programador2AnosExperienciaRequirement/TemplateFile/requirementTemplate.txt";


    /*public PluginQuestions checkTemplateSyntax() {
        try {
            FileInputStream fileInputStream = new FileInputStream(templatePath);
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
    }*/



    @Override
    public boolean evaluate(InputStream answerPath) {
       /* PluginQuestions pluginQuestions = checkTemplateSyntax();
        try {
            FileInputStream fileInputStream = new FileInputStream(answerPath);
            EvaluationLexer lexer = new EvaluationLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EvaluationParser parser = new EvaluationParser(tokens);
            EvalVisitorEvaluation visitor = new EvalVisitorEvaluation();


            ParseTree tree = parser.answers();
            visitor.registerExam(pluginQuestions);
            visitor.visit(tree);
            return visitor.evaluateIfRequirementsAreValid();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("The file doesn't exists!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new ErrorInFileException("The resolution does not follow the required format!.");
        }*/
        System.out.println("Requirement 2 anos experiencia Plugin Integration is working");
        return true;
    }
}
