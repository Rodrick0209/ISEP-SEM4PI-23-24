// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/RequirementTemplateAnalyze/Requirement.g4 by ANTLR 4.13.1
package jobs4u.base.lprog.RequirementTemplateAnalyze;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementParser#requirementQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirementQuestion(RequirementParser.RequirementQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(RequirementParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#singleChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleChoice(RequirementParser.SingleChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#yesNo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYesNo(RequirementParser.YesNoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(RequirementParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(RequirementParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#numericScale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericScale(RequirementParser.NumericScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#multipleChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoice(RequirementParser.MultipleChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#shortAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswer(RequirementParser.ShortAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#numerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical(RequirementParser.NumericalContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#possibleChoices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleChoices(RequirementParser.PossibleChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#trueFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalse(RequirementParser.TrueFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(RequirementParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(RequirementParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementParser#words}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWords(RequirementParser.WordsContext ctx);
}