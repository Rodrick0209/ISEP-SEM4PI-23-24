// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/Evaluation/Evaluation.g4 by ANTLR 4.13.1
package jobs4u.base.interviewManagement.lprog.Evaluation;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EvaluationParser}.
 */
public interface EvaluationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#resolution}.
	 * @param ctx the parse tree
	 */
	void enterResolution(EvaluationParser.ResolutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#resolution}.
	 * @param ctx the parse tree
	 */
	void exitResolution(EvaluationParser.ResolutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(EvaluationParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(EvaluationParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#answerToMultipleChoice}.
	 * @param ctx the parse tree
	 */
	void enterAnswerToMultipleChoice(EvaluationParser.AnswerToMultipleChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#answerToMultipleChoice}.
	 * @param ctx the parse tree
	 */
	void exitAnswerToMultipleChoice(EvaluationParser.AnswerToMultipleChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#answerToShortAnswer}.
	 * @param ctx the parse tree
	 */
	void enterAnswerToShortAnswer(EvaluationParser.AnswerToShortAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#answerToShortAnswer}.
	 * @param ctx the parse tree
	 */
	void exitAnswerToShortAnswer(EvaluationParser.AnswerToShortAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#answerToNumerical}.
	 * @param ctx the parse tree
	 */
	void enterAnswerToNumerical(EvaluationParser.AnswerToNumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#answerToNumerical}.
	 * @param ctx the parse tree
	 */
	void exitAnswerToNumerical(EvaluationParser.AnswerToNumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#answerToTrueFalse}.
	 * @param ctx the parse tree
	 */
	void enterAnswerToTrueFalse(EvaluationParser.AnswerToTrueFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#answerToTrueFalse}.
	 * @param ctx the parse tree
	 */
	void exitAnswerToTrueFalse(EvaluationParser.AnswerToTrueFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(EvaluationParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(EvaluationParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EvaluationParser#words}.
	 * @param ctx the parse tree
	 */
	void enterWords(EvaluationParser.WordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EvaluationParser#words}.
	 * @param ctx the parse tree
	 */
	void exitWords(EvaluationParser.WordsContext ctx);
}