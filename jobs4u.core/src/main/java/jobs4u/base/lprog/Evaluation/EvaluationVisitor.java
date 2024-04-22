// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/Evaluation/Evaluation.g4 by ANTLR 4.13.1
package jobs4u.base.lprog.Evaluation;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EvaluationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EvaluationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswers(EvaluationParser.AnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(EvaluationParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answerToMultipleChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerToMultipleChoice(EvaluationParser.AnswerToMultipleChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answerToShortAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerToShortAnswer(EvaluationParser.AnswerToShortAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answerToNumerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerToNumerical(EvaluationParser.AnswerToNumericalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answerToTrueFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerToTrueFalse(EvaluationParser.AnswerToTrueFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answerToTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerToTime(EvaluationParser.AnswerToTimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answerToDate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerToDate(EvaluationParser.AnswerToDateContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#answerToNumericScale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerToNumericScale(EvaluationParser.AnswerToNumericScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(EvaluationParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluationParser#words}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWords(EvaluationParser.WordsContext ctx);
}