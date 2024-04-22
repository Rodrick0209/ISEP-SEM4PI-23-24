// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/InterviewQuestionsManagement/Interview.g4 by ANTLR 4.13.1
package jobs4u.base.interviewManagement.lprog.InterviewQuestionsManagement;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE_OR_FALSE=1, CHOSING_OPTION_SELECT_MISSING_WORDS=2, IDENTIFIER=3, 
		SECTION=4, MATCHING=5, MULTIPLE_CHOICE=6, SHORT_ANSWER=7, NUMERICAL=8, 
		SELECT_MISSING_WORDS=9, TRUE_FALSE=10, DATE=11, TIME=12, NUMERIC_SCALE=13, 
		SCORE=14, SCORE_PER_LINE=15, CORRECT_ANSWER=16, FEEDBACK=17, ERROR_NUMERICAL=18, 
		POSSIBLE_CHOICES_SELECT_MISSING_WORDS=19, DATE_FORMAT=20, NUMS=21, MULTIPLE_CHOICE_ANSWER=22, 
		CHAR=23, NUM=24, NEWLINE=25, PUNCTUATION_MARKS=26, DOT=27, DASH=28, SPACE=29, 
		COMMA=30, TWO_DOTS=31, UNDERSCORE=32, RIGHT_PARENTHESES=33, DAY=34, MONTH=35, 
		YEAR=36, HOUR=37, MINUTE=38, TIME_FORMAT=39, DIVISIVE=40, FLOAT=41, NUMERICAL_OPTION=42, 
		ALPHABETICAL_OPTION=43, MATCHING_OPTION_CORRECTION=44, WORD=45, SPECIAL_CHAR=46, 
		WS=47;
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
			null, null, null, null, "'.'", "'-'", "' '", "','", "':'", "'_'", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE_OR_FALSE", "CHOSING_OPTION_SELECT_MISSING_WORDS", "IDENTIFIER", 
			"SECTION", "MATCHING", "MULTIPLE_CHOICE", "SHORT_ANSWER", "NUMERICAL", 
			"SELECT_MISSING_WORDS", "TRUE_FALSE", "DATE", "TIME", "NUMERIC_SCALE", 
			"SCORE", "SCORE_PER_LINE", "CORRECT_ANSWER", "FEEDBACK", "ERROR_NUMERICAL", 
			"POSSIBLE_CHOICES_SELECT_MISSING_WORDS", "DATE_FORMAT", "NUMS", "MULTIPLE_CHOICE_ANSWER", 
			"CHAR", "NUM", "NEWLINE", "PUNCTUATION_MARKS", "DOT", "DASH", "SPACE", 
			"COMMA", "TWO_DOTS", "UNDERSCORE", "RIGHT_PARENTHESES", "DAY", "MONTH", 
			"YEAR", "HOUR", "MINUTE", "TIME_FORMAT", "DIVISIVE", "FLOAT", "NUMERICAL_OPTION", 
			"ALPHABETICAL_OPTION", "MATCHING_OPTION_CORRECTION", "WORD", "SPECIAL_CHAR", 
			"WS"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15808L) != 0) );
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
			phrase();
			setState(42);
			match(NEWLINE);
			setState(43);
			match(SCORE);
			setState(44);
			match(FLOAT);
			setState(45);
			match(NEWLINE);
			setState(46);
			match(CORRECT_ANSWER);
			setState(47);
			match(DATE_FORMAT);
			setState(48);
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
			setState(50);
			match(TIME);
			setState(51);
			phrase();
			setState(52);
			match(NEWLINE);
			setState(53);
			match(SCORE);
			setState(54);
			match(FLOAT);
			setState(55);
			match(NEWLINE);
			setState(56);
			match(CORRECT_ANSWER);
			setState(57);
			match(TIME_FORMAT);
			setState(58);
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
			setState(60);
			match(NUMERIC_SCALE);
			setState(61);
			phrase();
			setState(62);
			match(NEWLINE);
			setState(63);
			match(SCORE);
			setState(64);
			match(FLOAT);
			setState(65);
			match(NEWLINE);
			setState(66);
			match(CORRECT_ANSWER);
			setState(67);
			match(NUMS);
			setState(68);
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
			setState(70);
			match(MULTIPLE_CHOICE);
			setState(71);
			phrase();
			setState(72);
			match(NEWLINE);
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				option();
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALPHABETICAL_OPTION );
			setState(78);
			match(SCORE);
			setState(79);
			match(FLOAT);
			setState(80);
			match(NEWLINE);
			setState(81);
			match(CORRECT_ANSWER);
			setState(82);
			match(MULTIPLE_CHOICE_ANSWER);
			setState(83);
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
			setState(85);
			match(SHORT_ANSWER);
			setState(86);
			phrase();
			setState(87);
			match(NEWLINE);
			setState(88);
			match(SCORE);
			setState(89);
			match(FLOAT);
			setState(90);
			match(NEWLINE);
			setState(91);
			match(CORRECT_ANSWER);
			setState(92);
			phrase();
			setState(93);
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
			setState(95);
			match(NUMERICAL);
			setState(96);
			phrase();
			setState(97);
			match(NEWLINE);
			setState(98);
			match(SCORE);
			setState(99);
			match(FLOAT);
			setState(100);
			match(NEWLINE);
			setState(101);
			match(CORRECT_ANSWER);
			setState(102);
			match(FLOAT);
			setState(103);
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
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				words();
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(110);
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
			setState(112);
			match(TRUE_FALSE);
			setState(113);
			phrase();
			setState(114);
			match(NEWLINE);
			setState(115);
			match(SCORE);
			setState(116);
			match(FLOAT);
			setState(117);
			match(NEWLINE);
			setState(118);
			match(CORRECT_ANSWER);
			setState(119);
			match(TRUE_OR_FALSE);
			setState(120);
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
			setState(123); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(122);
				words();
				}
				}
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATION_MARKS) {
				{
				setState(127);
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
			setState(130);
			match(ALPHABETICAL_OPTION);
			setState(131);
			phrase();
			setState(132);
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
			setState(134);
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
		"\u0004\u0001/\u0089\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f\u0000\u001d"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005K\b\u0005\u000b\u0005\f\u0005L\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0004\bk\b\b\u000b\b\f\bl\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0004\n|\b\n\u000b\n\f\n}\u0001\n\u0003\n\u0081\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0000\u0000"+
		"\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000"+
		"\u0001\u0002\u0000\u0015\u0015--\u0086\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0002&\u0001\u0000\u0000\u0000\u0004(\u0001\u0000\u0000\u0000\u00062"+
		"\u0001\u0000\u0000\u0000\b<\u0001\u0000\u0000\u0000\nF\u0001\u0000\u0000"+
		"\u0000\fU\u0001\u0000\u0000\u0000\u000e_\u0001\u0000\u0000\u0000\u0010"+
		"j\u0001\u0000\u0000\u0000\u0012p\u0001\u0000\u0000\u0000\u0014{\u0001"+
		"\u0000\u0000\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018\u0086\u0001"+
		"\u0000\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001b\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0001\u0001"+
		"\u0000\u0000\u0000\u001f\'\u0003\n\u0005\u0000 \'\u0003\f\u0006\u0000"+
		"!\'\u0003\u000e\u0007\u0000\"\'\u0003\u0012\t\u0000#\'\u0003\u0004\u0002"+
		"\u0000$\'\u0003\u0006\u0003\u0000%\'\u0003\b\u0004\u0000&\u001f\u0001"+
		"\u0000\u0000\u0000& \u0001\u0000\u0000\u0000&!\u0001\u0000\u0000\u0000"+
		"&\"\u0001\u0000\u0000\u0000&#\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000"+
		"\u0000&%\u0001\u0000\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000()\u0005"+
		"\u000b\u0000\u0000)*\u0003\u0014\n\u0000*+\u0005\u0019\u0000\u0000+,\u0005"+
		"\u000e\u0000\u0000,-\u0005)\u0000\u0000-.\u0005\u0019\u0000\u0000./\u0005"+
		"\u0010\u0000\u0000/0\u0005\u0014\u0000\u000001\u0005\u0019\u0000\u0000"+
		"1\u0005\u0001\u0000\u0000\u000023\u0005\f\u0000\u000034\u0003\u0014\n"+
		"\u000045\u0005\u0019\u0000\u000056\u0005\u000e\u0000\u000067\u0005)\u0000"+
		"\u000078\u0005\u0019\u0000\u000089\u0005\u0010\u0000\u00009:\u0005\'\u0000"+
		"\u0000:;\u0005\u0019\u0000\u0000;\u0007\u0001\u0000\u0000\u0000<=\u0005"+
		"\r\u0000\u0000=>\u0003\u0014\n\u0000>?\u0005\u0019\u0000\u0000?@\u0005"+
		"\u000e\u0000\u0000@A\u0005)\u0000\u0000AB\u0005\u0019\u0000\u0000BC\u0005"+
		"\u0010\u0000\u0000CD\u0005\u0015\u0000\u0000DE\u0005\u0019\u0000\u0000"+
		"E\t\u0001\u0000\u0000\u0000FG\u0005\u0006\u0000\u0000GH\u0003\u0014\n"+
		"\u0000HJ\u0005\u0019\u0000\u0000IK\u0003\u0016\u000b\u0000JI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0005\u000e\u0000\u0000"+
		"OP\u0005)\u0000\u0000PQ\u0005\u0019\u0000\u0000QR\u0005\u0010\u0000\u0000"+
		"RS\u0005\u0016\u0000\u0000ST\u0005\u0019\u0000\u0000T\u000b\u0001\u0000"+
		"\u0000\u0000UV\u0005\u0007\u0000\u0000VW\u0003\u0014\n\u0000WX\u0005\u0019"+
		"\u0000\u0000XY\u0005\u000e\u0000\u0000YZ\u0005)\u0000\u0000Z[\u0005\u0019"+
		"\u0000\u0000[\\\u0005\u0010\u0000\u0000\\]\u0003\u0014\n\u0000]^\u0005"+
		"\u0019\u0000\u0000^\r\u0001\u0000\u0000\u0000_`\u0005\b\u0000\u0000`a"+
		"\u0003\u0014\n\u0000ab\u0005\u0019\u0000\u0000bc\u0005\u000e\u0000\u0000"+
		"cd\u0005)\u0000\u0000de\u0005\u0019\u0000\u0000ef\u0005\u0010\u0000\u0000"+
		"fg\u0005)\u0000\u0000gh\u0005\u0019\u0000\u0000h\u000f\u0001\u0000\u0000"+
		"\u0000ik\u0003\u0018\f\u0000ji\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000no\u0005 \u0000\u0000o\u0011\u0001\u0000\u0000\u0000pq\u0005"+
		"\n\u0000\u0000qr\u0003\u0014\n\u0000rs\u0005\u0019\u0000\u0000st\u0005"+
		"\u000e\u0000\u0000tu\u0005)\u0000\u0000uv\u0005\u0019\u0000\u0000vw\u0005"+
		"\u0010\u0000\u0000wx\u0005\u0001\u0000\u0000xy\u0005\u0019\u0000\u0000"+
		"y\u0013\u0001\u0000\u0000\u0000z|\u0003\u0018\f\u0000{z\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007f\u0081\u0005\u001a\u0000"+
		"\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000"+
		"\u0000\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u0083\u0005+\u0000\u0000"+
		"\u0083\u0084\u0003\u0014\n\u0000\u0084\u0085\u0005\u0019\u0000\u0000\u0085"+
		"\u0017\u0001\u0000\u0000\u0000\u0086\u0087\u0007\u0000\u0000\u0000\u0087"+
		"\u0019\u0001\u0000\u0000\u0000\u0006\u001d&Ll}\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}