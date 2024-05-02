// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/RequirementTemplateAnalyze/Requirement.g4 by ANTLR 4.13.1
package lprog.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementTemplateAnalyze;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RequirementParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MININUM_REQUIREMENT=1, SINGLE_CHOICE=2, TRUE_OR_FALSE=3, CHOSING_OPTION_SELECT_MISSING_WORDS=4, 
		QUESTION_NUMBER=5, IDENTIFIER=6, MULTIPLE_CHOICE=7, SHORT_ANSWER=8, NUMERICAL=9, 
		TRUE_FALSE=10, DATE=11, TIME=12, YESNO=13, YES_NO=14, NUMERIC_SCALE=15, 
		SCORE=16, SCORE_PER_LINE=17, CORRECT_ANSWER=18, FEEDBACK=19, ERROR_NUMERICAL=20, 
		POSSIBLE_CHOICES_SELECT_MISSING_WORDS=21, DATE_FORMAT=22, NUMS=23, MULTIPLE_CHOICE_ANSWER=24, 
		CHARMINUSCULA=25, CHAR=26, NUM=27, NEWLINE=28, PUNCTUATION_MARKS=29, DOT=30, 
		DASH=31, SPACE=32, COMMA=33, TWO_DOTS=34, UNDERSCORE=35, RIGHT_PARENTHESES=36, 
		LEFT_PARENTHESES=37, DAY=38, MONTH=39, YEAR=40, HOUR=41, MINUTE=42, TIME_FORMAT=43, 
		DIVISIVE=44, FLOAT=45, NUMERICAL_OPTION=46, ALPHABETICAL_OPTION=47, MATCHING_OPTION_CORRECTION=48, 
		WORD=49, SPECIAL_CHAR=50, WS=51;
	public static final int
		RULE_requirementQuestion = 0, RULE_question = 1, RULE_minimumRequirement = 2, 
		RULE_yesNo = 3, RULE_singleChoice = 4, RULE_date = 5, RULE_time = 6, RULE_numericScale = 7, 
		RULE_multipleChoice = 8, RULE_shortAnswer = 9, RULE_numerical = 10, RULE_possibleChoices = 11, 
		RULE_trueFalse = 12, RULE_phrase = 13, RULE_option = 14, RULE_words = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"requirementQuestion", "question", "minimumRequirement", "yesNo", "singleChoice", 
			"date", "time", "numericScale", "multipleChoice", "shortAnswer", "numerical", 
			"possibleChoices", "trueFalse", "phrase", "option", "words"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'<option>'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "'.'", "'-'", "' '", "','", 
			"':'", "'_'", "')'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MININUM_REQUIREMENT", "SINGLE_CHOICE", "TRUE_OR_FALSE", "CHOSING_OPTION_SELECT_MISSING_WORDS", 
			"QUESTION_NUMBER", "IDENTIFIER", "MULTIPLE_CHOICE", "SHORT_ANSWER", "NUMERICAL", 
			"TRUE_FALSE", "DATE", "TIME", "YESNO", "YES_NO", "NUMERIC_SCALE", "SCORE", 
			"SCORE_PER_LINE", "CORRECT_ANSWER", "FEEDBACK", "ERROR_NUMERICAL", "POSSIBLE_CHOICES_SELECT_MISSING_WORDS", 
			"DATE_FORMAT", "NUMS", "MULTIPLE_CHOICE_ANSWER", "CHARMINUSCULA", "CHAR", 
			"NUM", "NEWLINE", "PUNCTUATION_MARKS", "DOT", "DASH", "SPACE", "COMMA", 
			"TWO_DOTS", "UNDERSCORE", "RIGHT_PARENTHESES", "LEFT_PARENTHESES", "DAY", 
			"MONTH", "YEAR", "HOUR", "MINUTE", "TIME_FORMAT", "DIVISIVE", "FLOAT", 
			"NUMERICAL_OPTION", "ALPHABETICAL_OPTION", "MATCHING_OPTION_CORRECTION", 
			"WORD", "SPECIAL_CHAR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Requirement.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RequirementParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RequirementQuestionContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public RequirementQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirementQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener) ((RequirementListener)listener).enterRequirementQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitRequirementQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor) return ((RequirementVisitor<? extends T>)visitor).visitRequirementQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementQuestionContext requirementQuestion() throws RecognitionException {
		RequirementQuestionContext _localctx = new RequirementQuestionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_requirementQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				question();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 49030L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public MultipleChoiceContext multipleChoice() {
			return getRuleContext(MultipleChoiceContext.class,0);
		}
		public ShortAnswerContext shortAnswer() {
			return getRuleContext(ShortAnswerContext.class,0);
		}
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public TrueFalseContext trueFalse() {
			return getRuleContext(TrueFalseContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public NumericScaleContext numericScale() {
			return getRuleContext(NumericScaleContext.class,0);
		}
		public YesNoContext yesNo() {
			return getRuleContext(YesNoContext.class,0);
		}
		public SingleChoiceContext singleChoice() {
			return getRuleContext(SingleChoiceContext.class,0);
		}
		public MinimumRequirementContext minimumRequirement() {
			return getRuleContext(MinimumRequirementContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				multipleChoice();
				}
				break;
			case SHORT_ANSWER:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				shortAnswer();
				}
				break;
			case NUMERICAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				numerical();
				}
				break;
			case TRUE_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				trueFalse();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				date();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				time();
				}
				break;
			case NUMERIC_SCALE:
				enterOuterAlt(_localctx, 7);
				{
				setState(43);
				numericScale();
				}
				break;
			case YESNO:
				enterOuterAlt(_localctx, 8);
				{
				setState(44);
				yesNo();
				}
				break;
			case SINGLE_CHOICE:
				enterOuterAlt(_localctx, 9);
				{
				setState(45);
				singleChoice();
				}
				break;
			case MININUM_REQUIREMENT:
				enterOuterAlt(_localctx, 10);
				{
				setState(46);
				minimumRequirement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MinimumRequirementContext extends ParserRuleContext {
		public TerminalNode MININUM_REQUIREMENT() { return getToken(RequirementParser.MININUM_REQUIREMENT, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode FLOAT() { return getToken(RequirementParser.FLOAT, 0); }
		public MinimumRequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minimumRequirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterMinimumRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitMinimumRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitMinimumRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinimumRequirementContext minimumRequirement() throws RecognitionException {
		MinimumRequirementContext _localctx = new MinimumRequirementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_minimumRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(MININUM_REQUIREMENT);
			setState(50);
			match(QUESTION_NUMBER);
			setState(51);
			phrase();
			setState(52);
			match(NEWLINE);
			setState(53);
			match(CORRECT_ANSWER);
			setState(54);
			match(FLOAT);
			setState(55);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YesNoContext extends ParserRuleContext {
		public TerminalNode YESNO() { return getToken(RequirementParser.YESNO, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode YES_NO() { return getToken(RequirementParser.YES_NO, 0); }
		public YesNoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yesNo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterYesNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitYesNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitYesNo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YesNoContext yesNo() throws RecognitionException {
		YesNoContext _localctx = new YesNoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_yesNo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(YESNO);
			setState(58);
			match(QUESTION_NUMBER);
			setState(59);
			phrase();
			setState(60);
			match(NEWLINE);
			setState(61);
			match(CORRECT_ANSWER);
			setState(62);
			match(YES_NO);
			setState(63);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SingleChoiceContext extends ParserRuleContext {
		public TerminalNode SINGLE_CHOICE() { return getToken(RequirementParser.SINGLE_CHOICE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode MULTIPLE_CHOICE_ANSWER() { return getToken(RequirementParser.MULTIPLE_CHOICE_ANSWER, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public SingleChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleChoice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterSingleChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitSingleChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitSingleChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleChoiceContext singleChoice() throws RecognitionException {
		SingleChoiceContext _localctx = new SingleChoiceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleChoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(SINGLE_CHOICE);
			setState(66);
			match(QUESTION_NUMBER);
			setState(67);
			phrase();
			setState(68);
			match(NEWLINE);
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				option();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALPHABETICAL_OPTION );
			setState(74);
			match(CORRECT_ANSWER);
			setState(75);
			match(MULTIPLE_CHOICE_ANSWER);
			setState(76);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(RequirementParser.DATE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode DATE_FORMAT() { return getToken(RequirementParser.DATE_FORMAT, 0); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(DATE);
			setState(79);
			match(QUESTION_NUMBER);
			setState(80);
			phrase();
			setState(81);
			match(NEWLINE);
			setState(82);
			match(CORRECT_ANSWER);
			setState(83);
			match(DATE_FORMAT);
			setState(84);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(RequirementParser.TIME, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode TIME_FORMAT() { return getToken(RequirementParser.TIME_FORMAT, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(TIME);
			setState(87);
			match(QUESTION_NUMBER);
			setState(88);
			phrase();
			setState(89);
			match(NEWLINE);
			setState(90);
			match(CORRECT_ANSWER);
			setState(91);
			match(TIME_FORMAT);
			setState(92);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericScaleContext extends ParserRuleContext {
		public TerminalNode NUMERIC_SCALE() { return getToken(RequirementParser.NUMERIC_SCALE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode NUMS() { return getToken(RequirementParser.NUMS, 0); }
		public NumericScaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericScale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterNumericScale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitNumericScale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitNumericScale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericScaleContext numericScale() throws RecognitionException {
		NumericScaleContext _localctx = new NumericScaleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_numericScale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(NUMERIC_SCALE);
			setState(95);
			match(QUESTION_NUMBER);
			setState(96);
			phrase();
			setState(97);
			match(NEWLINE);
			setState(98);
			match(CORRECT_ANSWER);
			setState(99);
			match(NUMS);
			setState(100);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultipleChoiceContext extends ParserRuleContext {
		public TerminalNode MULTIPLE_CHOICE() { return getToken(RequirementParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode MULTIPLE_CHOICE_ANSWER() { return getToken(RequirementParser.MULTIPLE_CHOICE_ANSWER, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public MultipleChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterMultipleChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitMultipleChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitMultipleChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceContext multipleChoice() throws RecognitionException {
		MultipleChoiceContext _localctx = new MultipleChoiceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multipleChoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(MULTIPLE_CHOICE);
			setState(103);
			match(QUESTION_NUMBER);
			setState(104);
			phrase();
			setState(105);
			match(NEWLINE);
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				option();
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALPHABETICAL_OPTION );
			setState(111);
			match(CORRECT_ANSWER);
			setState(112);
			match(MULTIPLE_CHOICE_ANSWER);
			setState(113);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShortAnswerContext extends ParserRuleContext {
		public TerminalNode SHORT_ANSWER() { return getToken(RequirementParser.SHORT_ANSWER, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public ShortAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterShortAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitShortAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitShortAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerContext shortAnswer() throws RecognitionException {
		ShortAnswerContext _localctx = new ShortAnswerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_shortAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(SHORT_ANSWER);
			setState(116);
			match(QUESTION_NUMBER);
			setState(117);
			phrase();
			setState(118);
			match(NEWLINE);
			setState(119);
			match(CORRECT_ANSWER);
			setState(120);
			phrase();
			setState(121);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericalContext extends ParserRuleContext {
		public TerminalNode NUMERICAL() { return getToken(RequirementParser.NUMERICAL, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode FLOAT() { return getToken(RequirementParser.FLOAT, 0); }
		public NumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitNumerical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalContext numerical() throws RecognitionException {
		NumericalContext _localctx = new NumericalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numerical);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(NUMERICAL);
			setState(124);
			match(QUESTION_NUMBER);
			setState(125);
			phrase();
			setState(126);
			match(NEWLINE);
			setState(127);
			match(CORRECT_ANSWER);
			setState(128);
			match(FLOAT);
			setState(129);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PossibleChoicesContext extends ParserRuleContext {
		public TerminalNode UNDERSCORE() { return getToken(RequirementParser.UNDERSCORE, 0); }
		public List<WordsContext> words() {
			return getRuleContexts(WordsContext.class);
		}
		public WordsContext words(int i) {
			return getRuleContext(WordsContext.class,i);
		}
		public PossibleChoicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleChoices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterPossibleChoices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitPossibleChoices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitPossibleChoices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleChoicesContext possibleChoices() throws RecognitionException {
		PossibleChoicesContext _localctx = new PossibleChoicesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_possibleChoices);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				words();
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(136);
			match(UNDERSCORE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrueFalseContext extends ParserRuleContext {
		public TerminalNode TRUE_FALSE() { return getToken(RequirementParser.TRUE_FALSE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(RequirementParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RequirementParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RequirementParser.NEWLINE, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(RequirementParser.CORRECT_ANSWER, 0); }
		public TerminalNode TRUE_OR_FALSE() { return getToken(RequirementParser.TRUE_OR_FALSE, 0); }
		public TrueFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterTrueFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitTrueFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitTrueFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseContext trueFalse() throws RecognitionException {
		TrueFalseContext _localctx = new TrueFalseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_trueFalse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(TRUE_FALSE);
			setState(139);
			match(QUESTION_NUMBER);
			setState(140);
			phrase();
			setState(141);
			match(NEWLINE);
			setState(142);
			match(CORRECT_ANSWER);
			setState(143);
			match(TRUE_OR_FALSE);
			setState(144);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PhraseContext extends ParserRuleContext {
		public List<WordsContext> words() {
			return getRuleContexts(WordsContext.class);
		}
		public WordsContext words(int i) {
			return getRuleContext(WordsContext.class,i);
		}
		public TerminalNode PUNCTUATION_MARKS() { return getToken(RequirementParser.PUNCTUATION_MARKS, 0); }
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				words();
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATION_MARKS) {
				{
				setState(151);
				match(PUNCTUATION_MARKS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionContext extends ParserRuleContext {
		public TerminalNode ALPHABETICAL_OPTION() { return getToken(RequirementParser.ALPHABETICAL_OPTION, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(RequirementParser.NEWLINE, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ALPHABETICAL_OPTION);
			setState(155);
			phrase();
			setState(156);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WordsContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(RequirementParser.WORD, 0); }
		public TerminalNode NUMS() { return getToken(RequirementParser.NUMS, 0); }
		public WordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordsContext words() throws RecognitionException {
		WordsContext _localctx = new WordsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !(_la==NUMS || _la==WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u00a1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000\f\u0000#\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004G\b\u0004\u000b\u0004\f\u0004H\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0004\bl\b\b\u000b\b\f\bm\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0004\u000b\u0085"+
		"\b\u000b\u000b\u000b\f\u000b\u0086\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0004\r\u0094"+
		"\b\r\u000b\r\f\r\u0095\u0001\r\u0003\r\u0099\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0000"+
		"\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e\u0000\u0001\u0002\u0000\u0017\u001711\u009f\u0000!"+
		"\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00041\u0001\u0000"+
		"\u0000\u0000\u00069\u0001\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000"+
		"\nN\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000\u000e^\u0001\u0000"+
		"\u0000\u0000\u0010f\u0001\u0000\u0000\u0000\u0012s\u0001\u0000\u0000\u0000"+
		"\u0014{\u0001\u0000\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000\u0018"+
		"\u008a\u0001\u0000\u0000\u0000\u001a\u0093\u0001\u0000\u0000\u0000\u001c"+
		"\u009a\u0001\u0000\u0000\u0000\u001e\u009e\u0001\u0000\u0000\u0000 \""+
		"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\u0001\u0001"+
		"\u0000\u0000\u0000%0\u0003\u0010\b\u0000&0\u0003\u0012\t\u0000\'0\u0003"+
		"\u0014\n\u0000(0\u0003\u0018\f\u0000)0\u0003\n\u0005\u0000*0\u0003\f\u0006"+
		"\u0000+0\u0003\u000e\u0007\u0000,0\u0003\u0006\u0003\u0000-0\u0003\b\u0004"+
		"\u0000.0\u0003\u0004\u0002\u0000/%\u0001\u0000\u0000\u0000/&\u0001\u0000"+
		"\u0000\u0000/\'\u0001\u0000\u0000\u0000/(\u0001\u0000\u0000\u0000/)\u0001"+
		"\u0000\u0000\u0000/*\u0001\u0000\u0000\u0000/+\u0001\u0000\u0000\u0000"+
		"/,\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/.\u0001\u0000\u0000"+
		"\u00000\u0003\u0001\u0000\u0000\u000012\u0005\u0001\u0000\u000023\u0005"+
		"\u0005\u0000\u000034\u0003\u001a\r\u000045\u0005\u001c\u0000\u000056\u0005"+
		"\u0012\u0000\u000067\u0005-\u0000\u000078\u0005\u001c\u0000\u00008\u0005"+
		"\u0001\u0000\u0000\u00009:\u0005\r\u0000\u0000:;\u0005\u0005\u0000\u0000"+
		";<\u0003\u001a\r\u0000<=\u0005\u001c\u0000\u0000=>\u0005\u0012\u0000\u0000"+
		">?\u0005\u000e\u0000\u0000?@\u0005\u001c\u0000\u0000@\u0007\u0001\u0000"+
		"\u0000\u0000AB\u0005\u0002\u0000\u0000BC\u0005\u0005\u0000\u0000CD\u0003"+
		"\u001a\r\u0000DF\u0005\u001c\u0000\u0000EG\u0003\u001c\u000e\u0000FE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0005\u0012\u0000"+
		"\u0000KL\u0005\u0018\u0000\u0000LM\u0005\u001c\u0000\u0000M\t\u0001\u0000"+
		"\u0000\u0000NO\u0005\u000b\u0000\u0000OP\u0005\u0005\u0000\u0000PQ\u0003"+
		"\u001a\r\u0000QR\u0005\u001c\u0000\u0000RS\u0005\u0012\u0000\u0000ST\u0005"+
		"\u0016\u0000\u0000TU\u0005\u001c\u0000\u0000U\u000b\u0001\u0000\u0000"+
		"\u0000VW\u0005\f\u0000\u0000WX\u0005\u0005\u0000\u0000XY\u0003\u001a\r"+
		"\u0000YZ\u0005\u001c\u0000\u0000Z[\u0005\u0012\u0000\u0000[\\\u0005+\u0000"+
		"\u0000\\]\u0005\u001c\u0000\u0000]\r\u0001\u0000\u0000\u0000^_\u0005\u000f"+
		"\u0000\u0000_`\u0005\u0005\u0000\u0000`a\u0003\u001a\r\u0000ab\u0005\u001c"+
		"\u0000\u0000bc\u0005\u0012\u0000\u0000cd\u0005\u0017\u0000\u0000de\u0005"+
		"\u001c\u0000\u0000e\u000f\u0001\u0000\u0000\u0000fg\u0005\u0007\u0000"+
		"\u0000gh\u0005\u0005\u0000\u0000hi\u0003\u001a\r\u0000ik\u0005\u001c\u0000"+
		"\u0000jl\u0003\u001c\u000e\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000op\u0005\u0012\u0000\u0000pq\u0005\u0018\u0000\u0000"+
		"qr\u0005\u001c\u0000\u0000r\u0011\u0001\u0000\u0000\u0000st\u0005\b\u0000"+
		"\u0000tu\u0005\u0005\u0000\u0000uv\u0003\u001a\r\u0000vw\u0005\u001c\u0000"+
		"\u0000wx\u0005\u0012\u0000\u0000xy\u0003\u001a\r\u0000yz\u0005\u001c\u0000"+
		"\u0000z\u0013\u0001\u0000\u0000\u0000{|\u0005\t\u0000\u0000|}\u0005\u0005"+
		"\u0000\u0000}~\u0003\u001a\r\u0000~\u007f\u0005\u001c\u0000\u0000\u007f"+
		"\u0080\u0005\u0012\u0000\u0000\u0080\u0081\u0005-\u0000\u0000\u0081\u0082"+
		"\u0005\u001c\u0000\u0000\u0082\u0015\u0001\u0000\u0000\u0000\u0083\u0085"+
		"\u0003\u001e\u000f\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005#\u0000\u0000\u0089\u0017\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\n\u0000\u0000\u008b\u008c\u0005\u0005\u0000\u0000\u008c\u008d\u0003\u001a"+
		"\r\u0000\u008d\u008e\u0005\u001c\u0000\u0000\u008e\u008f\u0005\u0012\u0000"+
		"\u0000\u008f\u0090\u0005\u0003\u0000\u0000\u0090\u0091\u0005\u001c\u0000"+
		"\u0000\u0091\u0019\u0001\u0000\u0000\u0000\u0092\u0094\u0003\u001e\u000f"+
		"\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0099\u0005\u001d\u0000"+
		"\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u001b\u0001\u0000\u0000\u0000\u009a\u009b\u0005/\u0000\u0000"+
		"\u009b\u009c\u0003\u001a\r\u0000\u009c\u009d\u0005\u001c\u0000\u0000\u009d"+
		"\u001d\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u0000\u0000\u0000\u009f"+
		"\u001f\u0001\u0000\u0000\u0000\u0007#/Hm\u0086\u0095\u0098";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}