// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/Interview.g4 by ANTLR 4.13.1
package jobs4u.base.interviewManagement.lprog;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewParser#interview}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterview(InterviewParser.InterviewContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(InterviewParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(InterviewParser.AnswerContext ctx);
}