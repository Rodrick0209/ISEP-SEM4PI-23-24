// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/RequirementTemplateAnalyze/Requirement.g4 by ANTLR 4.13.1
package jobs4u.base.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementParser}.
 */
public interface RequirementListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementParser#requirementQuestion}.
	 * @param ctx the parse tree
	 */
	void enterRequirementQuestion(RequirementParser.RequirementQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#requirementQuestion}.
	 * @param ctx the parse tree
	 */
	void exitRequirementQuestion(RequirementParser.RequirementQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(RequirementParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(RequirementParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#minimumRequirement}.
	 * @param ctx the parse tree
	 */
	void enterMinimumRequirement(RequirementParser.MinimumRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#minimumRequirement}.
	 * @param ctx the parse tree
	 */
	void exitMinimumRequirement(RequirementParser.MinimumRequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#yesNo}.
	 * @param ctx the parse tree
	 */
	void enterYesNo(RequirementParser.YesNoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#yesNo}.
	 * @param ctx the parse tree
	 */
	void exitYesNo(RequirementParser.YesNoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#singleChoice}.
	 * @param ctx the parse tree
	 */
	void enterSingleChoice(RequirementParser.SingleChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#singleChoice}.
	 * @param ctx the parse tree
	 */
	void exitSingleChoice(RequirementParser.SingleChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(RequirementParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(RequirementParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(RequirementParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(RequirementParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#numericScale}.
	 * @param ctx the parse tree
	 */
	void enterNumericScale(RequirementParser.NumericScaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#numericScale}.
	 * @param ctx the parse tree
	 */
	void exitNumericScale(RequirementParser.NumericScaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#multipleChoice}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoice(RequirementParser.MultipleChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#multipleChoice}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoice(RequirementParser.MultipleChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#shortAnswer}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswer(RequirementParser.ShortAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#shortAnswer}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswer(RequirementParser.ShortAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#numerical}.
	 * @param ctx the parse tree
	 */
	void enterNumerical(RequirementParser.NumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#numerical}.
	 * @param ctx the parse tree
	 */
	void exitNumerical(RequirementParser.NumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#possibleChoices}.
	 * @param ctx the parse tree
	 */
	void enterPossibleChoices(RequirementParser.PossibleChoicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#possibleChoices}.
	 * @param ctx the parse tree
	 */
	void exitPossibleChoices(RequirementParser.PossibleChoicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#trueFalse}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalse(RequirementParser.TrueFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#trueFalse}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalse(RequirementParser.TrueFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(RequirementParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(RequirementParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(RequirementParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(RequirementParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementParser#words}.
	 * @param ctx the parse tree
	 */
	void enterWords(RequirementParser.WordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementParser#words}.
	 * @param ctx the parse tree
	 */
	void exitWords(RequirementParser.WordsContext ctx);
}