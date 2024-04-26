package jobs4u.base.lprog.InterviewTemplateAnalyze;

import jobs4u.base.lprog.Exceptions.InvalidScoreException;
import jobs4u.base.lprog.Utils.InterviewQuestions;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InterviewModelMain {

    public static void main(String[] args) throws IOException {
        parseWithVisitor("C:\\Users\\rodri\\Documents\\sem4pi-23-24-2dj2\\jobs4u.core\\src\\main\\java\\jobs4u\\base\\lprog\\TestFiles\\test.txt");
    }

    public static InterviewQuestions parseWithVisitor(final String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InterviewLexer lexer = new InterviewLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InterviewParser parser = new InterviewParser(tokens);

            ParseTree tree = parser.interviewQuestion();
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
