package jobs4u.base.lprog.InterviewEvaluation;

import jobs4u.base.lprog.Exceptions.ErrorInFileException;
import jobs4u.base.lprog.Utils.InterviewQuestions;
import jobs4u.base.lprog.InterviewTemplateAnalyze.InterviewModelMain;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvaluationMain {
    public static void main(String[] args) throws IOException {
        InterviewQuestions exam = InterviewModelMain.parseWithVisitor("C:\\Users\\rodri\\Documents\\sem4pi-23-24-2dj2\\jobs4u.core\\src\\main\\java\\jobs4u\\base\\lprog\\TestFiles\\test.txt");
        System.out.println(parseWithVisitor("C:\\Users\\rodri\\Documents\\sem4pi-23-24-2dj2\\jobs4u.core\\src\\main\\java\\jobs4u\\base\\lprog\\TestFiles\\textCorrection.txt", exam));
        //   System.out.println(parseWithVisitor("files/incorrect_resolution.txt", exam));
     //   System.out.println(parseWithVisitor("files/incomplete_resolution.txt", exam));
    }

    public static float parseWithVisitor(final String resolutionFilePath, InterviewQuestions interviewQuestions) {
        try {
            FileInputStream fileInputStream = new FileInputStream(resolutionFilePath);
            EvaluationLexer lexer = new EvaluationLexer(CharStreams.fromStream(fileInputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EvaluationParser parser = new EvaluationParser(tokens);
            EvalVisitor visitor = new EvalVisitor();

            ParseTree tree = parser.answers();
            visitor.registerExam(interviewQuestions);
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
