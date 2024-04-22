// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/InterviewQuestions/Interview.g4 by ANTLR 4.13.1
package jobs4u.base.interviewManagement.lprog.InterviewQuestionsManagement;
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
	 * Visit a parse tree produced by {@link InterviewParser#interviewQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterviewQuestion(InterviewParser.InterviewQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(InterviewParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(InterviewParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(InterviewParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#numericScale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericScale(InterviewParser.NumericScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#multipleChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoice(InterviewParser.MultipleChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#shortAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswer(InterviewParser.ShortAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#numerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical(InterviewParser.NumericalContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#possibleChoices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleChoices(InterviewParser.PossibleChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#trueFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalse(InterviewParser.TrueFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(InterviewParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(InterviewParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#words}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWords(InterviewParser.WordsContext ctx);
}