package lprog.Programador2AnosExperienciaRequirement.RequirementManagement;

import lprog.Programador2AnosExperienciaRequirement.Exceptions.ErrorInFileException;
import lprog.Programador2AnosExperienciaRequirement.Exceptions.InvalidScoreException;
import lprog.Programador2AnosExperienciaRequirement.RequirementManagement.Evaluation.EvalVisitorEvaluation;
import lprog.Programador2AnosExperienciaRequirement.RequirementManagement.Evaluation.EvaluationLexer;
import lprog.Programador2AnosExperienciaRequirement.RequirementManagement.Evaluation.EvaluationParser;
import lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.*;
import lprog.Programador2AnosExperienciaRequirement.Utils.PluginQuestions;
import jobs4u.base.pluginManagement.application.RequirementEvaluation;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RequirementService implements RequirementEvaluation {

    String templatePath = "jobs4u.core/src/main/java/jobs4u/base/Programador2AnosExperienciaRequirement/TemplateFile/requirementTemplate.txt";

    public PluginQuestions checkTemplateSyntax() {
        try {
            FileInputStream fileInputStream = new FileInputStream(templatePath);
            lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.RequirementLexer lexer = new lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.RequirementLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.RequirementParser parser = new lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.RequirementParser(tokens);

            ParseTree tree = parser.requirementQuestion();
            lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.EvalVisitor visitor = new lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze.EvalVisitor();
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
    public boolean evaluate(String answerPath) {
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
            return visitor.evaluateIfRequirementsAreValid();
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
