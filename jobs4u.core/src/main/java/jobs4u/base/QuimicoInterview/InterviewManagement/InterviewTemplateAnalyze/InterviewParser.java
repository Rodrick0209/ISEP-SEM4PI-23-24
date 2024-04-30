// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/InterviewQuestionsManagement/Interview.g4 by ANTLR 4.13.1
package jobs4u.base.QuimicoInterview.InterviewManagement.InterviewTemplateAnalyze;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE_OR_FALSE=1, CHOSING_OPTION_SELECT_MISSING_WORDS=2, QUESTION_NUMBER=3, 
		IDENTIFIER=4, MULTIPLE_CHOICE=5, SHORT_ANSWER=6, NUMERICAL=7, TRUE_FALSE=8, 
		DATE=9, TIME=10, NUMERIC_SCALE=11, SCORE=12, SCORE_PER_LINE=13, CORRECT_ANSWER=14, 
		FEEDBACK=15, ERROR_NUMERICAL=16, POSSIBLE_CHOICES_SELECT_MISSING_WORDS=17, 
		DATE_FORMAT=18, NUMS=19, MULTIPLE_CHOICE_ANSWER=20, CHAR=21, NUM=22, NEWLINE=23, 
		PUNCTUATION_MARKS=24, DOT=25, DASH=26, SPACE=27, COMMA=28, TWO_DOTS=29, 
		UNDERSCORE=30, RIGHT_PARENTHESES=31, LEFT_PARENTHESES=32, DAY=33, MONTH=34, 
		YEAR=35, HOUR=36, MINUTE=37, TIME_FORMAT=38, DIVISIVE=39, FLOAT=40, NUMERICAL_OPTION=41, 
		ALPHABETICAL_OPTION=42, MATCHING_OPTION_CORRECTION=43, WORD=44, SPECIAL_CHAR=45, 
		WS=46;
	public static final int
		RULE_interviewQuestion = 0, RULE_question = 1, RULE_date = 2, RULE_time = 3, 
		RULE_numericScale = 4, RULE_multipleChoice = 5, RULE_shortAnswer = 6, 
		RULE_numerical = 7, RULE_possibleChoices = 8, RULE_trueFalse = 9, RULE_phrase = 10, 
		RULE_option = 11, RULE_words = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"interviewQuestion", "question", "date", "time", "numericScale", "multipleChoice", 
			"shortAnswer", "numerical", "possibleChoices", "trueFalse", "phrase", 
			"option", "words"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<option>'", null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'.'", "'-'", "' '", "','", "':'", "'_'", "')'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE_OR_FALSE", "CHOSING_OPTION_SELECT_MISSING_WORDS", "QUESTION_NUMBER", 
			"IDENTIFIER", "MULTIPLE_CHOICE", "SHORT_ANSWER", "NUMERICAL", "TRUE_FALSE", 
			"DATE", "TIME", "NUMERIC_SCALE", "SCORE", "SCORE_PER_LINE", "CORRECT_ANSWER", 
			"FEEDBACK", "ERROR_NUMERICAL", "POSSIBLE_CHOICES_SELECT_MISSING_WORDS", 
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
	public String getGrammarFileName() { return "Interview.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterviewQuestionContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public InterviewQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interviewQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterInterviewQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitInterviewQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitInterviewQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterviewQuestionContext interviewQuestion() throws RecognitionException {
		InterviewQuestionContext _localctx = new InterviewQuestionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_interviewQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				question();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4064L) != 0) );
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
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				multipleChoice();
				}
				break;
			case SHORT_ANSWER:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				shortAnswer();
				}
				break;
			case NUMERICAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				numerical();
				}
				break;
			case TRUE_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				trueFalse();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(35);
				date();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 6);
				{
				setState(36);
				time();
				}
				break;
			case NUMERIC_SCALE:
				enterOuterAlt(_localctx, 7);
				{
				setState(37);
				numericScale();
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
	public static class DateContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(InterviewParser.DATE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(InterviewParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode SCORE() { return getToken(InterviewParser.SCORE, 0); }
		public TerminalNode FLOAT() { return getToken(InterviewParser.FLOAT, 0); }
		public TerminalNode CORRECT_ANSWER() { return getToken(InterviewParser.CORRECT_ANSWER, 0); }
		public TerminalNode DATE_FORMAT() { return getToken(InterviewParser.DATE_FORMAT, 0); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(DATE);
			setState(41);
			match(QUESTION_NUMBER);
			setState(42);
			phrase();
			setState(43);
			match(NEWLINE);
			setState(44);
			match(SCORE);
			setState(45);
			match(FLOAT);
			setState(46);
			match(NEWLINE);
			setState(47);
			match(CORRECT_ANSWER);
			setState(48);
			match(DATE_FORMAT);
			setState(49);
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
		public TerminalNode TIME() { return getToken(InterviewParser.TIME, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(InterviewParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode SCORE() { return getToken(InterviewParser.SCORE, 0); }
		public TerminalNode FLOAT() { return getToken(InterviewParser.FLOAT, 0); }
		public TerminalNode CORRECT_ANSWER() { return getToken(InterviewParser.CORRECT_ANSWER, 0); }
		public TerminalNode TIME_FORMAT() { return getToken(InterviewParser.TIME_FORMAT, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(TIME);
			setState(52);
			match(QUESTION_NUMBER);
			setState(53);
			phrase();
			setState(54);
			match(NEWLINE);
			setState(55);
			match(SCORE);
			setState(56);
			match(FLOAT);
			setState(57);
			match(NEWLINE);
			setState(58);
			match(CORRECT_ANSWER);
			setState(59);
			match(TIME_FORMAT);
			setState(60);
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
		public TerminalNode NUMERIC_SCALE() { return getToken(InterviewParser.NUMERIC_SCALE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(InterviewParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode SCORE() { return getToken(InterviewParser.SCORE, 0); }
		public TerminalNode FLOAT() { return getToken(InterviewParser.FLOAT, 0); }
		public TerminalNode CORRECT_ANSWER() { return getToken(InterviewParser.CORRECT_ANSWER, 0); }
		public TerminalNode NUMS() { return getToken(InterviewParser.NUMS, 0); }
		public NumericScaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericScale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterNumericScale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitNumericScale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitNumericScale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericScaleContext numericScale() throws RecognitionException {
		NumericScaleContext _localctx = new NumericScaleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_numericScale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(NUMERIC_SCALE);
			setState(63);
			match(QUESTION_NUMBER);
			setState(64);
			phrase();
			setState(65);
			match(NEWLINE);
			setState(66);
			match(SCORE);
			setState(67);
			match(FLOAT);
			setState(68);
			match(NEWLINE);
			setState(69);
			match(CORRECT_ANSWER);
			setState(70);
			match(NUMS);
			setState(71);
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
		public TerminalNode MULTIPLE_CHOICE() { return getToken(InterviewParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(InterviewParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode SCORE() { return getToken(InterviewParser.SCORE, 0); }
		public TerminalNode FLOAT() { return getToken(InterviewParser.FLOAT, 0); }
		public TerminalNode CORRECT_ANSWER() { return getToken(InterviewParser.CORRECT_ANSWER, 0); }
		public TerminalNode MULTIPLE_CHOICE_ANSWER() { return getToken(InterviewParser.MULTIPLE_CHOICE_ANSWER, 0); }
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
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterMultipleChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitMultipleChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitMultipleChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceContext multipleChoice() throws RecognitionException {
		MultipleChoiceContext _localctx = new MultipleChoiceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multipleChoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(MULTIPLE_CHOICE);
			setState(74);
			match(QUESTION_NUMBER);
			setState(75);
			phrase();
			setState(76);
			match(NEWLINE);
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				option();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALPHABETICAL_OPTION );
			setState(82);
			match(SCORE);
			setState(83);
			match(FLOAT);
			setState(84);
			match(NEWLINE);
			setState(85);
			match(CORRECT_ANSWER);
			setState(86);
			match(MULTIPLE_CHOICE_ANSWER);
			setState(87);
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
		public TerminalNode SHORT_ANSWER() { return getToken(InterviewParser.SHORT_ANSWER, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(InterviewParser.QUESTION_NUMBER, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode SCORE() { return getToken(InterviewParser.SCORE, 0); }
		public TerminalNode FLOAT() { return getToken(InterviewParser.FLOAT, 0); }
		public TerminalNode CORRECT_ANSWER() { return getToken(InterviewParser.CORRECT_ANSWER, 0); }
		public ShortAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterShortAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitShortAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitShortAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerContext shortAnswer() throws RecognitionException {
		ShortAnswerContext _localctx = new ShortAnswerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_shortAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(SHORT_ANSWER);
			setState(90);
			match(QUESTION_NUMBER);
			setState(91);
			phrase();
			setState(92);
			match(NEWLINE);
			setState(93);
			match(SCORE);
			setState(94);
			match(FLOAT);
			setState(95);
			match(NEWLINE);
			setState(96);
			match(CORRECT_ANSWER);
			setState(97);
			phrase();
			setState(98);
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
		public TerminalNode NUMERICAL() { return getToken(InterviewParser.NUMERICAL, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(InterviewParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode SCORE() { return getToken(InterviewParser.SCORE, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(InterviewParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(InterviewParser.FLOAT, i);
		}
		public TerminalNode CORRECT_ANSWER() { return getToken(InterviewParser.CORRECT_ANSWER, 0); }
		public NumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitNumerical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalContext numerical() throws RecognitionException {
		NumericalContext _localctx = new NumericalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_numerical);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(NUMERICAL);
			setState(101);
			match(QUESTION_NUMBER);
			setState(102);
			phrase();
			setState(103);
			match(NEWLINE);
			setState(104);
			match(SCORE);
			setState(105);
			match(FLOAT);
			setState(106);
			match(NEWLINE);
			setState(107);
			match(CORRECT_ANSWER);
			setState(108);
			match(FLOAT);
			setState(109);
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
		public TerminalNode UNDERSCORE() { return getToken(InterviewParser.UNDERSCORE, 0); }
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
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterPossibleChoices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitPossibleChoices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitPossibleChoices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleChoicesContext possibleChoices() throws RecognitionException {
		PossibleChoicesContext _localctx = new PossibleChoicesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_possibleChoices);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				words();
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(116);
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
		public TerminalNode TRUE_FALSE() { return getToken(InterviewParser.TRUE_FALSE, 0); }
		public TerminalNode QUESTION_NUMBER() { return getToken(InterviewParser.QUESTION_NUMBER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode SCORE() { return getToken(InterviewParser.SCORE, 0); }
		public TerminalNode FLOAT() { return getToken(InterviewParser.FLOAT, 0); }
		public TerminalNode CORRECT_ANSWER() { return getToken(InterviewParser.CORRECT_ANSWER, 0); }
		public TerminalNode TRUE_OR_FALSE() { return getToken(InterviewParser.TRUE_OR_FALSE, 0); }
		public TrueFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterTrueFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitTrueFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitTrueFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseContext trueFalse() throws RecognitionException {
		TrueFalseContext _localctx = new TrueFalseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_trueFalse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(TRUE_FALSE);
			setState(119);
			match(QUESTION_NUMBER);
			setState(120);
			phrase();
			setState(121);
			match(NEWLINE);
			setState(122);
			match(SCORE);
			setState(123);
			match(FLOAT);
			setState(124);
			match(NEWLINE);
			setState(125);
			match(CORRECT_ANSWER);
			setState(126);
			match(TRUE_OR_FALSE);
			setState(127);
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
		public TerminalNode PUNCTUATION_MARKS() { return getToken(InterviewParser.PUNCTUATION_MARKS, 0); }
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				words();
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATION_MARKS) {
				{
				setState(134);
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
		public TerminalNode ALPHABETICAL_OPTION() { return getToken(InterviewParser.ALPHABETICAL_OPTION, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(InterviewParser.NEWLINE, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ALPHABETICAL_OPTION);
			setState(138);
			phrase();
			setState(139);
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
		public TerminalNode WORD() { return getToken(InterviewParser.WORD, 0); }
		public TerminalNode NUMS() { return getToken(InterviewParser.NUMS, 0); }
		public WordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordsContext words() throws RecognitionException {
		WordsContext _localctx = new WordsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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
		"\u0004\u0001.\u0090\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f\u0000\u001d"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005"+
		"O\b\u0005\u000b\u0005\f\u0005P\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0004\bq\b\b\u000b\b\f\br\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0004\n\u0083\b\n\u000b\n\f\n\u0084\u0001\n\u0003\n"+
		"\u0088\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u0000\u0001\u0002\u0000\u0013\u0013,,\u008d\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004(\u0001\u0000"+
		"\u0000\u0000\u00063\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000"+
		"\nI\u0001\u0000\u0000\u0000\fY\u0001\u0000\u0000\u0000\u000ed\u0001\u0000"+
		"\u0000\u0000\u0010p\u0001\u0000\u0000\u0000\u0012v\u0001\u0000\u0000\u0000"+
		"\u0014\u0082\u0001\u0000\u0000\u0000\u0016\u0089\u0001\u0000\u0000\u0000"+
		"\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000"+
		"\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000"+
		"\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000"+
		"\u001e\u0001\u0001\u0000\u0000\u0000\u001f\'\u0003\n\u0005\u0000 \'\u0003"+
		"\f\u0006\u0000!\'\u0003\u000e\u0007\u0000\"\'\u0003\u0012\t\u0000#\'\u0003"+
		"\u0004\u0002\u0000$\'\u0003\u0006\u0003\u0000%\'\u0003\b\u0004\u0000&"+
		"\u001f\u0001\u0000\u0000\u0000& \u0001\u0000\u0000\u0000&!\u0001\u0000"+
		"\u0000\u0000&\"\u0001\u0000\u0000\u0000&#\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000&%\u0001\u0000\u0000\u0000\'\u0003\u0001\u0000\u0000"+
		"\u0000()\u0005\t\u0000\u0000)*\u0005\u0003\u0000\u0000*+\u0003\u0014\n"+
		"\u0000+,\u0005\u0017\u0000\u0000,-\u0005\f\u0000\u0000-.\u0005(\u0000"+
		"\u0000./\u0005\u0017\u0000\u0000/0\u0005\u000e\u0000\u000001\u0005\u0012"+
		"\u0000\u000012\u0005\u0017\u0000\u00002\u0005\u0001\u0000\u0000\u0000"+
		"34\u0005\n\u0000\u000045\u0005\u0003\u0000\u000056\u0003\u0014\n\u0000"+
		"67\u0005\u0017\u0000\u000078\u0005\f\u0000\u000089\u0005(\u0000\u0000"+
		"9:\u0005\u0017\u0000\u0000:;\u0005\u000e\u0000\u0000;<\u0005&\u0000\u0000"+
		"<=\u0005\u0017\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005\u000b"+
		"\u0000\u0000?@\u0005\u0003\u0000\u0000@A\u0003\u0014\n\u0000AB\u0005\u0017"+
		"\u0000\u0000BC\u0005\f\u0000\u0000CD\u0005(\u0000\u0000DE\u0005\u0017"+
		"\u0000\u0000EF\u0005\u000e\u0000\u0000FG\u0005\u0013\u0000\u0000GH\u0005"+
		"\u0017\u0000\u0000H\t\u0001\u0000\u0000\u0000IJ\u0005\u0005\u0000\u0000"+
		"JK\u0005\u0003\u0000\u0000KL\u0003\u0014\n\u0000LN\u0005\u0017\u0000\u0000"+
		"MO\u0003\u0016\u000b\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RS\u0005\f\u0000\u0000ST\u0005(\u0000\u0000TU\u0005\u0017"+
		"\u0000\u0000UV\u0005\u000e\u0000\u0000VW\u0005\u0014\u0000\u0000WX\u0005"+
		"\u0017\u0000\u0000X\u000b\u0001\u0000\u0000\u0000YZ\u0005\u0006\u0000"+
		"\u0000Z[\u0005\u0003\u0000\u0000[\\\u0003\u0014\n\u0000\\]\u0005\u0017"+
		"\u0000\u0000]^\u0005\f\u0000\u0000^_\u0005(\u0000\u0000_`\u0005\u0017"+
		"\u0000\u0000`a\u0005\u000e\u0000\u0000ab\u0003\u0014\n\u0000bc\u0005\u0017"+
		"\u0000\u0000c\r\u0001\u0000\u0000\u0000de\u0005\u0007\u0000\u0000ef\u0005"+
		"\u0003\u0000\u0000fg\u0003\u0014\n\u0000gh\u0005\u0017\u0000\u0000hi\u0005"+
		"\f\u0000\u0000ij\u0005(\u0000\u0000jk\u0005\u0017\u0000\u0000kl\u0005"+
		"\u000e\u0000\u0000lm\u0005(\u0000\u0000mn\u0005\u0017\u0000\u0000n\u000f"+
		"\u0001\u0000\u0000\u0000oq\u0003\u0018\f\u0000po\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tu\u0005\u001e\u0000\u0000u\u0011\u0001"+
		"\u0000\u0000\u0000vw\u0005\b\u0000\u0000wx\u0005\u0003\u0000\u0000xy\u0003"+
		"\u0014\n\u0000yz\u0005\u0017\u0000\u0000z{\u0005\f\u0000\u0000{|\u0005"+
		"(\u0000\u0000|}\u0005\u0017\u0000\u0000}~\u0005\u000e\u0000\u0000~\u007f"+
		"\u0005\u0001\u0000\u0000\u007f\u0080\u0005\u0017\u0000\u0000\u0080\u0013"+
		"\u0001\u0000\u0000\u0000\u0081\u0083\u0003\u0018\f\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001"+
		"\u0000\u0000\u0000\u0086\u0088\u0005\u0018\u0000\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0015\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005*\u0000\u0000\u008a\u008b\u0003\u0014"+
		"\n\u0000\u008b\u008c\u0005\u0017\u0000\u0000\u008c\u0017\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0007\u0000\u0000\u0000\u008e\u0019\u0001\u0000\u0000"+
		"\u0000\u0006\u001d&Pr\u0084\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}