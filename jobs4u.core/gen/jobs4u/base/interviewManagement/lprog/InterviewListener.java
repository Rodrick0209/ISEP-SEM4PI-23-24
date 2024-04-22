// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/Interview.g4 by ANTLR 4.13.1
package jobs4u.base.interviewManagement.lprog;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewParser}.
 */
public interface InterviewListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewParser#interview}.
	 * @param ctx the parse tree
	 */
	void enterInterview(InterviewParser.InterviewContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#interview}.
	 * @param ctx the parse tree
	 */
	void exitInterview(InterviewParser.InterviewContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(InterviewParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(InterviewParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(InterviewParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(InterviewParser.AnswerContext ctx);
}