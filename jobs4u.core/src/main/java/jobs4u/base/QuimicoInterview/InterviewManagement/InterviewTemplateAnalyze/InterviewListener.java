// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/InterviewQuestionsManagement/Interview.g4 by ANTLR 4.13.1
package jobs4u.base.QuimicoInterview.InterviewManagement.InterviewTemplateAnalyze;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewParser}.
 */
public interface InterviewListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewParser#interviewQuestion}.
	 * @param ctx the parse tree
	 */
	void enterInterviewQuestion(InterviewParser.InterviewQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#interviewQuestion}.
	 * @param ctx the parse tree
	 */
	void exitInterviewQuestion(InterviewParser.InterviewQuestionContext ctx);
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
	 * Enter a parse tree produced by {@link InterviewParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(InterviewParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(InterviewParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(InterviewParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(InterviewParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#numericScale}.
	 * @param ctx the parse tree
	 */
	void enterNumericScale(InterviewParser.NumericScaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#numericScale}.
	 * @param ctx the parse tree
	 */
	void exitNumericScale(InterviewParser.NumericScaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#multipleChoice}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoice(InterviewParser.MultipleChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#multipleChoice}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoice(InterviewParser.MultipleChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#shortAnswer}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswer(InterviewParser.ShortAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#shortAnswer}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswer(InterviewParser.ShortAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#numerical}.
	 * @param ctx the parse tree
	 */
	void enterNumerical(InterviewParser.NumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#numerical}.
	 * @param ctx the parse tree
	 */
	void exitNumerical(InterviewParser.NumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#possibleChoices}.
	 * @param ctx the parse tree
	 */
	void enterPossibleChoices(InterviewParser.PossibleChoicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#possibleChoices}.
	 * @param ctx the parse tree
	 */
	void exitPossibleChoices(InterviewParser.PossibleChoicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#trueFalse}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalse(InterviewParser.TrueFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#trueFalse}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalse(InterviewParser.TrueFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(InterviewParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(InterviewParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(InterviewParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(InterviewParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#words}.
	 * @param ctx the parse tree
	 */
	void enterWords(InterviewParser.WordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#words}.
	 * @param ctx the parse tree
	 */
	void exitWords(InterviewParser.WordsContext ctx);
}