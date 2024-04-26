// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/Evaluation/Evaluation.g4 by ANTLR 4.13.1
package jobs4u.base.lprog.InterviewEvaluation;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EvaluationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE_OR_FALSE=1, MULTIPLE_CHOICE_ANSWER=2, IDENTIFIER=3, ANSWER=4, NUMS=5, 
		QUESTION_NUMBER=6, CHAR=7, NUM=8, NEWLINE=9, SPECIAL_CHAR=10, PUNCTUATION_MARKS=11, 
		DOT=12, DASH=13, SLASH=14, SPACE=15, COMMA=16, TWO_DOTS=17, UNDERSCORE=18, 
		RIGHT_PARENTHESES=19, DAY=20, MONTH=21, YEAR=22, HOUR=23, MINUTE=24, DATE=25, 
		TIME=26, LEFT_PARENTHESES=27, FLOAT=28, NUMERICAL_OPTION=29, ALPHABETICAL_OPTION=30, 
		WORD=31, WS=32;
	public static final int
		RULE_answers = 0, RULE_answer = 1, RULE_answerToMultipleChoice = 2, RULE_answerToShortAnswer = 3, 
		RULE_answerToNumerical = 4, RULE_answerToTrueFalse = 5, RULE_answerToTime = 6, 
		RULE_answerToDate = 7, RULE_answerToNumericScale = 8, RULE_phrase = 9, 
		RULE_words = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"answers", "answer", "answerToMultipleChoice", "answerToShortAnswer", 
			"answerToNumerical", "answerToTrueFalse", "answerToTime", "answerToDate", 
			"answerToNumericScale", "phrase", "words"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'.'", "'-'", "'/'", "' '", "','", "':'", "'_'", "')'", null, null, null, 
			null, null, null, null, "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE_OR_FALSE", "MULTIPLE_CHOICE_ANSWER", "IDENTIFIER", "ANSWER", 
			"NUMS", "QUESTION_NUMBER", "CHAR", "NUM", "NEWLINE", "SPECIAL_CHAR", 
			"PUNCTUATION_MARKS", "DOT", "DASH", "SLASH", "SPACE", "COMMA", "TWO_DOTS", 
			"UNDERSCORE", "RIGHT_PARENTHESES", "DAY", "MONTH", "YEAR", "HOUR", "MINUTE", 
			"DATE", "TIME", "LEFT_PARENTHESES", "FLOAT", "NUMERICAL_OPTION", "ALPHABETICAL_OPTION", 
			"WORD", "WS"
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
	public String getGrammarFileName() { return "Evaluation.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EvaluationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnswersContext extends ParserRuleContext {
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public AnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswersContext answers() throws RecognitionException {
		AnswersContext _localctx = new AnswersContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_answers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				answer();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ANSWER );
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
	public static class AnswerContext extends ParserRuleContext {
		public AnswerToMultipleChoiceContext answerToMultipleChoice() {
			return getRuleContext(AnswerToMultipleChoiceContext.class,0);
		}
		public AnswerToShortAnswerContext answerToShortAnswer() {
			return getRuleContext(AnswerToShortAnswerContext.class,0);
		}
		public AnswerToNumericalContext answerToNumerical() {
			return getRuleContext(AnswerToNumericalContext.class,0);
		}
		public AnswerToTrueFalseContext answerToTrueFalse() {
			return getRuleContext(AnswerToTrueFalseContext.class,0);
		}
		public AnswerToDateContext answerToDate() {
			return getRuleContext(AnswerToDateContext.class,0);
		}
		public AnswerToTimeContext answerToTime() {
			return getRuleContext(AnswerToTimeContext.class,0);
		}
		public AnswerToNumericScaleContext answerToNumericScale() {
			return getRuleContext(AnswerToNumericScaleContext.class,0);
		}
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_answer);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				answerToMultipleChoice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				answerToShortAnswer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				answerToNumerical();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(30);
				answerToTrueFalse();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(31);
				answerToDate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(32);
				answerToTime();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(33);
				answerToNumericScale();
				}
				break;
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
	public static class AnswerToMultipleChoiceContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public TerminalNode MULTIPLE_CHOICE_ANSWER() { return getToken(EvaluationParser.MULTIPLE_CHOICE_ANSWER, 0); }
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToMultipleChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToMultipleChoice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToMultipleChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToMultipleChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToMultipleChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToMultipleChoiceContext answerToMultipleChoice() throws RecognitionException {
		AnswerToMultipleChoiceContext _localctx = new AnswerToMultipleChoiceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_answerToMultipleChoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(ANSWER);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MULTIPLE_CHOICE_ANSWER) {
				{
				setState(37);
				match(MULTIPLE_CHOICE_ANSWER);
				}
			}

			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(40);
				match(NEWLINE);
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
	public static class AnswerToShortAnswerContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToShortAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToShortAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToShortAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToShortAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToShortAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToShortAnswerContext answerToShortAnswer() throws RecognitionException {
		AnswerToShortAnswerContext _localctx = new AnswerToShortAnswerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_answerToShortAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(ANSWER);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMS || _la==WORD) {
				{
				setState(44);
				phrase();
				}
			}

			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(47);
				match(NEWLINE);
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
	public static class AnswerToNumericalContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public TerminalNode FLOAT() { return getToken(EvaluationParser.FLOAT, 0); }
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToNumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToNumerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToNumerical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToNumericalContext answerToNumerical() throws RecognitionException {
		AnswerToNumericalContext _localctx = new AnswerToNumericalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_answerToNumerical);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ANSWER);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLOAT) {
				{
				setState(51);
				match(FLOAT);
				}
			}

			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(54);
				match(NEWLINE);
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
	public static class AnswerToTrueFalseContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public TerminalNode TRUE_OR_FALSE() { return getToken(EvaluationParser.TRUE_OR_FALSE, 0); }
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToTrueFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToTrueFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToTrueFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToTrueFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToTrueFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToTrueFalseContext answerToTrueFalse() throws RecognitionException {
		AnswerToTrueFalseContext _localctx = new AnswerToTrueFalseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_answerToTrueFalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ANSWER);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE_OR_FALSE) {
				{
				setState(58);
				match(TRUE_OR_FALSE);
				}
			}

			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(61);
				match(NEWLINE);
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
	public static class AnswerToTimeContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public TerminalNode TIME() { return getToken(EvaluationParser.TIME, 0); }
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToTimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToTime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToTimeContext answerToTime() throws RecognitionException {
		AnswerToTimeContext _localctx = new AnswerToTimeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_answerToTime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(ANSWER);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIME) {
				{
				setState(65);
				match(TIME);
				}
			}

			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(68);
				match(NEWLINE);
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
	public static class AnswerToDateContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public TerminalNode DATE() { return getToken(EvaluationParser.DATE, 0); }
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToDateContext answerToDate() throws RecognitionException {
		AnswerToDateContext _localctx = new AnswerToDateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_answerToDate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(ANSWER);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DATE) {
				{
				setState(72);
				match(DATE);
				}
			}

			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(75);
				match(NEWLINE);
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
	public static class AnswerToNumericScaleContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public TerminalNode NUMS() { return getToken(EvaluationParser.NUMS, 0); }
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToNumericScaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToNumericScale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToNumericScale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToNumericScale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToNumericScale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToNumericScaleContext answerToNumericScale() throws RecognitionException {
		AnswerToNumericScaleContext _localctx = new AnswerToNumericScaleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_answerToNumericScale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(ANSWER);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMS) {
				{
				setState(79);
				match(NUMS);
				}
			}

			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(82);
				match(NEWLINE);
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
	public static class PhraseContext extends ParserRuleContext {
		public List<WordsContext> words() {
			return getRuleContexts(WordsContext.class);
		}
		public WordsContext words(int i) {
			return getRuleContext(WordsContext.class,i);
		}
		public TerminalNode PUNCTUATION_MARKS() { return getToken(EvaluationParser.PUNCTUATION_MARKS, 0); }
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				words();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATION_MARKS) {
				{
				setState(90);
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
	public static class WordsContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(EvaluationParser.WORD, 0); }
		public TerminalNode NUMS() { return getToken(EvaluationParser.NUMS, 0); }
		public WordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordsContext words() throws RecognitionException {
		WordsContext _localctx = new WordsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
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
		"\u0004\u0001 `\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0004\u0000\u0018\b\u0000"+
		"\u000b\u0000\f\u0000\u0019\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0002\u0003\u0002*\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0003\u0003.\b\u0003\u0001\u0003\u0003\u00031\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u00045\b\u0004\u0001\u0004\u0003\u0004"+
		"8\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005<\b\u0005\u0001\u0005\u0003"+
		"\u0005?\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006C\b\u0006\u0001\u0006"+
		"\u0003\u0006F\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007J\b\u0007\u0001"+
		"\u0007\u0003\u0007M\b\u0007\u0001\b\u0001\b\u0003\bQ\b\b\u0001\b\u0003"+
		"\bT\b\b\u0001\t\u0004\tW\b\t\u000b\t\f\tX\u0001\t\u0003\t\\\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0000\u0001\u0002\u0000\u0005\u0005\u001f\u001fk\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004$"+
		"\u0001\u0000\u0000\u0000\u0006+\u0001\u0000\u0000\u0000\b2\u0001\u0000"+
		"\u0000\u0000\n9\u0001\u0000\u0000\u0000\f@\u0001\u0000\u0000\u0000\u000e"+
		"G\u0001\u0000\u0000\u0000\u0010N\u0001\u0000\u0000\u0000\u0012V\u0001"+
		"\u0000\u0000\u0000\u0014]\u0001\u0000\u0000\u0000\u0016\u0018\u0003\u0002"+
		"\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000"+
		"\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u0001\u0001\u0000\u0000\u0000\u001b#\u0003\u0004\u0002"+
		"\u0000\u001c#\u0003\u0006\u0003\u0000\u001d#\u0003\b\u0004\u0000\u001e"+
		"#\u0003\n\u0005\u0000\u001f#\u0003\u000e\u0007\u0000 #\u0003\f\u0006\u0000"+
		"!#\u0003\u0010\b\u0000\"\u001b\u0001\u0000\u0000\u0000\"\u001c\u0001\u0000"+
		"\u0000\u0000\"\u001d\u0001\u0000\u0000\u0000\"\u001e\u0001\u0000\u0000"+
		"\u0000\"\u001f\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"!\u0001"+
		"\u0000\u0000\u0000#\u0003\u0001\u0000\u0000\u0000$&\u0005\u0004\u0000"+
		"\u0000%\'\u0005\u0002\u0000\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\')\u0001\u0000\u0000\u0000(*\u0005\t\u0000\u0000)(\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*\u0005\u0001\u0000\u0000"+
		"\u0000+-\u0005\u0004\u0000\u0000,.\u0003\u0012\t\u0000-,\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/1\u0005\t\u0000"+
		"\u00000/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0007\u0001"+
		"\u0000\u0000\u000024\u0005\u0004\u0000\u000035\u0005\u001c\u0000\u0000"+
		"43\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000"+
		"\u000068\u0005\t\u0000\u000076\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008\t\u0001\u0000\u0000\u00009;\u0005\u0004\u0000\u0000:<\u0005\u0001"+
		"\u0000\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001"+
		"\u0000\u0000\u0000=?\u0005\t\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?\u000b\u0001\u0000\u0000\u0000@B\u0005\u0004\u0000"+
		"\u0000AC\u0005\u001a\u0000\u0000BA\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000CE\u0001\u0000\u0000\u0000DF\u0005\t\u0000\u0000ED\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000F\r\u0001\u0000\u0000\u0000GI\u0005"+
		"\u0004\u0000\u0000HJ\u0005\u0019\u0000\u0000IH\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KM\u0005\t\u0000\u0000"+
		"LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u000f\u0001\u0000"+
		"\u0000\u0000NP\u0005\u0004\u0000\u0000OQ\u0005\u0005\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000"+
		"RT\u0005\t\u0000\u0000SR\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"T\u0011\u0001\u0000\u0000\u0000UW\u0003\u0014\n\u0000VU\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000Y[\u0001\u0000\u0000\u0000Z\\\u0005\u000b\u0000\u0000[Z\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0013\u0001\u0000\u0000"+
		"\u0000]^\u0007\u0000\u0000\u0000^\u0015\u0001\u0000\u0000\u0000\u0012"+
		"\u0019\"&)-047;>BEILPSX[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}