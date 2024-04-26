// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/RequirementTemplateAnalyze/Requirement.g4 by ANTLR 4.13.1
package jobs4u.base.lprog.RequirementTemplateAnalyze;
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
		SINGLE_CHOICE=1, TRUE_OR_FALSE=2, CHOSING_OPTION_SELECT_MISSING_WORDS=3, 
		QUESTION_NUMBER=4, IDENTIFIER=5, MULTIPLE_CHOICE=6, SHORT_ANSWER=7, NUMERICAL=8, 
		TRUE_FALSE=9, DATE=10, TIME=11, YESNO=12, YES_NO=13, NUMERIC_SCALE=14, 
		SCORE=15, SCORE_PER_LINE=16, CORRECT_ANSWER=17, FEEDBACK=18, ERROR_NUMERICAL=19, 
		POSSIBLE_CHOICES_SELECT_MISSING_WORDS=20, DATE_FORMAT=21, NUMS=22, MULTIPLE_CHOICE_ANSWER=23, 
		CHAR=24, NUM=25, NEWLINE=26, PUNCTUATION_MARKS=27, DOT=28, DASH=29, SPACE=30, 
		COMMA=31, TWO_DOTS=32, UNDERSCORE=33, RIGHT_PARENTHESES=34, LEFT_PARENTHESES=35, 
		DAY=36, MONTH=37, YEAR=38, HOUR=39, MINUTE=40, TIME_FORMAT=41, DIVISIVE=42, 
		FLOAT=43, NUMERICAL_OPTION=44, ALPHABETICAL_OPTION=45, MATCHING_OPTION_CORRECTION=46, 
		WORD=47, SPECIAL_CHAR=48, WS=49;
	public static final int
		RULE_requirementQuestion = 0, RULE_question = 1, RULE_singleChoice = 2, 
		RULE_yesNo = 3, RULE_date = 4, RULE_time = 5, RULE_numericScale = 6, RULE_multipleChoice = 7, 
		RULE_shortAnswer = 8, RULE_numerical = 9, RULE_possibleChoices = 10, RULE_trueFalse = 11, 
		RULE_phrase = 12, RULE_option = 13, RULE_words = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"requirementQuestion", "question", "singleChoice", "yesNo", "date", "time", 
			"numericScale", "multipleChoice", "shortAnswer", "numerical", "possibleChoices", 
			"trueFalse", "phrase", "option", "words"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'<option>'", null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'.'", "'-'", "' '", "','", "':'", "'_'", 
			"')'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SINGLE_CHOICE", "TRUE_OR_FALSE", "CHOSING_OPTION_SELECT_MISSING_WORDS", 
			"QUESTION_NUMBER", "IDENTIFIER", "MULTIPLE_CHOICE", "SHORT_ANSWER", "NUMERICAL", 
			"TRUE_FALSE", "DATE", "TIME", "YESNO", "YES_NO", "NUMERIC_SCALE", "SCORE", 
			"SCORE_PER_LINE", "CORRECT_ANSWER", "FEEDBACK", "ERROR_NUMERICAL", "POSSIBLE_CHOICES_SELECT_MISSING_WORDS", 
			"DATE_FORMAT", "NUMS", "MULTIPLE_CHOICE_ANSWER", "CHAR", "NUM", "NEWLINE", 
			"PUNCTUATION_MARKS", "DOT", "DASH", "SPACE", "COMMA", "TWO_DOTS", "UNDERSCORE", 
			"RIGHT_PARENTHESES", "LEFT_PARENTHESES", "DAY", "MONTH", "YEAR", "HOUR", 
			"MINUTE", "TIME_FORMAT", "DIVISIVE", "FLOAT", "NUMERICAL_OPTION", "ALPHABETICAL_OPTION", 
			"MATCHING_OPTION_CORRECTION", "WORD", "SPECIAL_CHAR", "WS"
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
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).enterRequirementQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementListener ) ((RequirementListener)listener).exitRequirementQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementVisitor ) return ((RequirementVisitor<? extends T>)visitor).visitRequirementQuestion(this);
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
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				question();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24514L) != 0) );
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
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				multipleChoice();
				}
				break;
			case SHORT_ANSWER:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				shortAnswer();
				}
				break;
			case NUMERICAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				numerical();
				}
				break;
			case TRUE_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				trueFalse();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				date();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				time();
				}
				break;
			case NUMERIC_SCALE:
				enterOuterAlt(_localctx, 7);
				{
				setState(41);
				numericScale();
				}
				break;
			case YESNO:
				enterOuterAlt(_localctx, 8);
				{
				setState(42);
				yesNo();
				}
				break;
			case SINGLE_CHOICE:
				enterOuterAlt(_localctx, 9);
				{
				setState(43);
				singleChoice();
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
		public TerminalNode NUMERICAL_OPTION() { return getToken(RequirementParser.NUMERICAL_OPTION, 0); }
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
		enterRule(_localctx, 4, RULE_singleChoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(SINGLE_CHOICE);
			setState(47);
			match(QUESTION_NUMBER);
			setState(48);
			phrase();
			setState(49);
			match(NEWLINE);
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				option();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALPHABETICAL_OPTION );
			setState(55);
			match(CORRECT_ANSWER);
			setState(56);
			match(NUMERICAL_OPTION);
			setState(57);
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
			setState(59);
			match(YESNO);
			setState(60);
			match(QUESTION_NUMBER);
			setState(61);
			phrase();
			setState(62);
			match(NEWLINE);
			setState(63);
			match(CORRECT_ANSWER);
			setState(64);
			match(YES_NO);
			setState(65);
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
		enterRule(_localctx, 8, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(DATE);
			setState(68);
			match(QUESTION_NUMBER);
			setState(69);
			phrase();
			setState(70);
			match(NEWLINE);
			setState(71);
			match(CORRECT_ANSWER);
			setState(72);
			match(DATE_FORMAT);
			setState(73);
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
		enterRule(_localctx, 10, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(TIME);
			setState(76);
			match(QUESTION_NUMBER);
			setState(77);
			phrase();
			setState(78);
			match(NEWLINE);
			setState(79);
			match(CORRECT_ANSWER);
			setState(80);
			match(TIME_FORMAT);
			setState(81);
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
		enterRule(_localctx, 12, RULE_numericScale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(NUMERIC_SCALE);
			setState(84);
			match(QUESTION_NUMBER);
			setState(85);
			phrase();
			setState(86);
			match(NEWLINE);
			setState(87);
			match(CORRECT_ANSWER);
			setState(88);
			match(NUMS);
			setState(89);
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
		enterRule(_localctx, 14, RULE_multipleChoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(MULTIPLE_CHOICE);
			setState(92);
			match(QUESTION_NUMBER);
			setState(93);
			phrase();
			setState(94);
			match(NEWLINE);
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				option();
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALPHABETICAL_OPTION );
			setState(100);
			match(CORRECT_ANSWER);
			setState(101);
			match(MULTIPLE_CHOICE_ANSWER);
			setState(102);
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
		enterRule(_localctx, 16, RULE_shortAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(SHORT_ANSWER);
			setState(105);
			match(QUESTION_NUMBER);
			setState(106);
			phrase();
			setState(107);
			match(NEWLINE);
			setState(108);
			match(CORRECT_ANSWER);
			setState(109);
			phrase();
			setState(110);
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
		enterRule(_localctx, 18, RULE_numerical);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(NUMERICAL);
			setState(113);
			match(QUESTION_NUMBER);
			setState(114);
			phrase();
			setState(115);
			match(NEWLINE);
			setState(116);
			match(CORRECT_ANSWER);
			setState(117);
			match(FLOAT);
			setState(118);
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
		enterRule(_localctx, 20, RULE_possibleChoices);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				words();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(125);
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
		enterRule(_localctx, 22, RULE_trueFalse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(TRUE_FALSE);
			setState(128);
			match(QUESTION_NUMBER);
			setState(129);
			phrase();
			setState(130);
			match(NEWLINE);
			setState(131);
			match(CORRECT_ANSWER);
			setState(132);
			match(TRUE_OR_FALSE);
			setState(133);
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
		enterRule(_localctx, 24, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				words();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATION_MARKS) {
				{
				setState(140);
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
		enterRule(_localctx, 26, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(ALPHABETICAL_OPTION);
			setState(144);
			phrase();
			setState(145);
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
		enterRule(_localctx, 28, RULE_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
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
		"\u0004\u00011\u0096\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0004\u0000"+
		" \b\u0000\u000b\u0000\f\u0000!\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0004\u00024\b\u0002\u000b\u0002\f\u00025\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007a\b\u0007\u000b\u0007"+
		"\f\u0007b\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0004\nz\b\n\u000b"+
		"\n\f\n{\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\f\u0089"+
		"\b\f\u000b\f\f\f\u008a\u0001\f\u0003\f\u008e\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u0000\u0001\u0002\u0000\u0016\u0016//\u0094\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0002,\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u0006"+
		";\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nK\u0001\u0000\u0000"+
		"\u0000\fS\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000\u0010"+
		"h\u0001\u0000\u0000\u0000\u0012p\u0001\u0000\u0000\u0000\u0014y\u0001"+
		"\u0000\u0000\u0000\u0016\u007f\u0001\u0000\u0000\u0000\u0018\u0088\u0001"+
		"\u0000\u0000\u0000\u001a\u008f\u0001\u0000\u0000\u0000\u001c\u0093\u0001"+
		"\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f\u001e\u0001\u0000"+
		"\u0000\u0000 !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\"\u0001\u0001\u0000\u0000\u0000#-\u0003\u000e"+
		"\u0007\u0000$-\u0003\u0010\b\u0000%-\u0003\u0012\t\u0000&-\u0003\u0016"+
		"\u000b\u0000\'-\u0003\b\u0004\u0000(-\u0003\n\u0005\u0000)-\u0003\f\u0006"+
		"\u0000*-\u0003\u0006\u0003\u0000+-\u0003\u0004\u0002\u0000,#\u0001\u0000"+
		"\u0000\u0000,$\u0001\u0000\u0000\u0000,%\u0001\u0000\u0000\u0000,&\u0001"+
		"\u0000\u0000\u0000,\'\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000"+
		",)\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000"+
		"\u0000-\u0003\u0001\u0000\u0000\u0000./\u0005\u0001\u0000\u0000/0\u0005"+
		"\u0004\u0000\u000001\u0003\u0018\f\u000013\u0005\u001a\u0000\u000024\u0003"+
		"\u001a\r\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"78\u0005\u0011\u0000\u000089\u0005,\u0000\u00009:\u0005\u001a\u0000\u0000"+
		":\u0005\u0001\u0000\u0000\u0000;<\u0005\f\u0000\u0000<=\u0005\u0004\u0000"+
		"\u0000=>\u0003\u0018\f\u0000>?\u0005\u001a\u0000\u0000?@\u0005\u0011\u0000"+
		"\u0000@A\u0005\r\u0000\u0000AB\u0005\u001a\u0000\u0000B\u0007\u0001\u0000"+
		"\u0000\u0000CD\u0005\n\u0000\u0000DE\u0005\u0004\u0000\u0000EF\u0003\u0018"+
		"\f\u0000FG\u0005\u001a\u0000\u0000GH\u0005\u0011\u0000\u0000HI\u0005\u0015"+
		"\u0000\u0000IJ\u0005\u001a\u0000\u0000J\t\u0001\u0000\u0000\u0000KL\u0005"+
		"\u000b\u0000\u0000LM\u0005\u0004\u0000\u0000MN\u0003\u0018\f\u0000NO\u0005"+
		"\u001a\u0000\u0000OP\u0005\u0011\u0000\u0000PQ\u0005)\u0000\u0000QR\u0005"+
		"\u001a\u0000\u0000R\u000b\u0001\u0000\u0000\u0000ST\u0005\u000e\u0000"+
		"\u0000TU\u0005\u0004\u0000\u0000UV\u0003\u0018\f\u0000VW\u0005\u001a\u0000"+
		"\u0000WX\u0005\u0011\u0000\u0000XY\u0005\u0016\u0000\u0000YZ\u0005\u001a"+
		"\u0000\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0005\u0006\u0000\u0000\\]"+
		"\u0005\u0004\u0000\u0000]^\u0003\u0018\f\u0000^`\u0005\u001a\u0000\u0000"+
		"_a\u0003\u001a\r\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000de\u0005\u0011\u0000\u0000ef\u0005\u0017\u0000\u0000fg\u0005\u001a"+
		"\u0000\u0000g\u000f\u0001\u0000\u0000\u0000hi\u0005\u0007\u0000\u0000"+
		"ij\u0005\u0004\u0000\u0000jk\u0003\u0018\f\u0000kl\u0005\u001a\u0000\u0000"+
		"lm\u0005\u0011\u0000\u0000mn\u0003\u0018\f\u0000no\u0005\u001a\u0000\u0000"+
		"o\u0011\u0001\u0000\u0000\u0000pq\u0005\b\u0000\u0000qr\u0005\u0004\u0000"+
		"\u0000rs\u0003\u0018\f\u0000st\u0005\u001a\u0000\u0000tu\u0005\u0011\u0000"+
		"\u0000uv\u0005+\u0000\u0000vw\u0005\u001a\u0000\u0000w\u0013\u0001\u0000"+
		"\u0000\u0000xz\u0003\u001c\u000e\u0000yx\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}~\u0005!\u0000\u0000~\u0015\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0005\t\u0000\u0000\u0080\u0081\u0005\u0004\u0000\u0000"+
		"\u0081\u0082\u0003\u0018\f\u0000\u0082\u0083\u0005\u001a\u0000\u0000\u0083"+
		"\u0084\u0005\u0011\u0000\u0000\u0084\u0085\u0005\u0002\u0000\u0000\u0085"+
		"\u0086\u0005\u001a\u0000\u0000\u0086\u0017\u0001\u0000\u0000\u0000\u0087"+
		"\u0089\u0003\u001c\u000e\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c"+
		"\u008e\u0005\u001b\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0001\u0000\u0000\u0000\u008e\u0019\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005-\u0000\u0000\u0090\u0091\u0003\u0018\f\u0000\u0091\u0092"+
		"\u0005\u001a\u0000\u0000\u0092\u001b\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0007\u0000\u0000\u0000\u0094\u001d\u0001\u0000\u0000\u0000\u0007!,5"+
		"b{\u008a\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}