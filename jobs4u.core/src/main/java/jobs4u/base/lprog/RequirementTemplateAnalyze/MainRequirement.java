package jobs4u.base.lprog.RequirementTemplateAnalyze;

import jobs4u.base.lprog.Exceptions.InvalidScoreException;
import jobs4u.base.lprog.InterviewTemplateAnalyze.EvalVisitor;
import jobs4u.base.lprog.Utils.PluginQuestions;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainRequirement {


    public static void main(String[] args) throws IOException {
        parseWithVisitor("C:\\Users\\rodri\\Documents\\sem4pi-23-24-2dj2\\jobs4u.core\\src\\main\\java\\jobs4u\\base\\lprog\\TestFiles\\requirementTemplate.txt");
    }

    public static PluginQuestions parseWithVisitor(final String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            RequirementLexer lexer = new RequirementLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            RequirementParser parser = new RequirementParser(tokens);

            ParseTree tree = parser.requirementQuestion();
            EvalVisitor visitor = new EvalVisitor();
            visitor.visit(tree);

            return visitor.getExam();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("The file doesn't exists!");
        } catch (InvalidScoreException e) {
            throw new IllegalArgumentException(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




}
