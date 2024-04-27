// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/lprog/InterviewEvaluation/Evaluation.g4 by ANTLR 4.13.1
package jobs4u.base.lprog.Evaluation;
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
		TRUE_OR_FALSE=1, YES_OR_NO=2, MULTIPLE_CHOICE_ANSWER=3, IDENTIFIER=4, 
		ANSWER=5, NUMS=6, QUESTION_NUMBER=7, CHAR=8, NUM=9, NEWLINE=10, SPECIAL_CHAR=11, 
		PUNCTUATION_MARKS=12, DOT=13, DASH=14, SLASH=15, SPACE=16, COMMA=17, TWO_DOTS=18, 
		UNDERSCORE=19, RIGHT_PARENTHESES=20, DAY=21, MONTH=22, YEAR=23, HOUR=24, 
		MINUTE=25, DATE=26, TIME=27, LEFT_PARENTHESES=28, FLOAT=29, NUMERICAL_OPTION=30, 
		ALPHABETICAL_OPTION=31, WORD=32, WS=33;
	public static final int
		RULE_answers = 0, RULE_answer = 1, RULE_answerToYesNo = 2, RULE_answerToMultipleChoice = 3, 
		RULE_answerToShortAnswer = 4, RULE_answerToNumerical = 5, RULE_answerToTrueFalse = 6, 
		RULE_answerToTime = 7, RULE_answerToDate = 8, RULE_answerToNumericScale = 9, 
		RULE_phrase = 10, RULE_words = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"answers", "answer", "answerToYesNo", "answerToMultipleChoice", "answerToShortAnswer", 
			"answerToNumerical", "answerToTrueFalse", "answerToTime", "answerToDate", 
			"answerToNumericScale", "phrase", "words"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'.'", "'-'", "'/'", "' '", "','", "':'", "'_'", "')'", null, null, 
			null, null, null, null, null, "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE_OR_FALSE", "YES_OR_NO", "MULTIPLE_CHOICE_ANSWER", "IDENTIFIER", 
			"ANSWER", "NUMS", "QUESTION_NUMBER", "CHAR", "NUM", "NEWLINE", "SPECIAL_CHAR", 
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
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				answer();
				}
				}
				setState(27); 
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
		public AnswerToYesNoContext answerToYesNo() {
			return getRuleContext(AnswerToYesNoContext.class,0);
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
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				answerToMultipleChoice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				answerToShortAnswer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				answerToNumerical();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				answerToTrueFalse();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				answerToDate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(34);
				answerToTime();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(35);
				answerToNumericScale();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(36);
				answerToYesNo();
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
	public static class AnswerToYesNoContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(EvaluationParser.ANSWER, 0); }
		public TerminalNode YES_OR_NO() { return getToken(EvaluationParser.YES_OR_NO, 0); }
		public TerminalNode NEWLINE() { return getToken(EvaluationParser.NEWLINE, 0); }
		public AnswerToYesNoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerToYesNo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterAnswerToYesNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitAnswerToYesNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitAnswerToYesNo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerToYesNoContext answerToYesNo() throws RecognitionException {
		AnswerToYesNoContext _localctx = new AnswerToYesNoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_answerToYesNo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(ANSWER);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YES_OR_NO) {
				{
				setState(40);
				match(YES_OR_NO);
				}
			}

			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(43);
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
		enterRule(_localctx, 6, RULE_answerToMultipleChoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(ANSWER);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MULTIPLE_CHOICE_ANSWER) {
				{
				setState(47);
				match(MULTIPLE_CHOICE_ANSWER);
				}
			}

			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(50);
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
		enterRule(_localctx, 8, RULE_answerToShortAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(ANSWER);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMS || _la==WORD) {
				{
				setState(54);
				phrase();
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(57);
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
		enterRule(_localctx, 10, RULE_answerToNumerical);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(ANSWER);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLOAT) {
				{
				setState(61);
				match(FLOAT);
				}
			}

			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(64);
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
		enterRule(_localctx, 12, RULE_answerToTrueFalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(ANSWER);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE_OR_FALSE) {
				{
				setState(68);
				match(TRUE_OR_FALSE);
				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(71);
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
		enterRule(_localctx, 14, RULE_answerToTime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(ANSWER);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIME) {
				{
				setState(75);
				match(TIME);
				}
			}

			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(78);
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
		enterRule(_localctx, 16, RULE_answerToDate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ANSWER);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DATE) {
				{
				setState(82);
				match(DATE);
				}
			}

			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(85);
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
		enterRule(_localctx, 18, RULE_answerToNumericScale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(ANSWER);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMS) {
				{
				setState(89);
				match(NUMS);
				}
			}

			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(92);
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
		enterRule(_localctx, 20, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				words();
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATION_MARKS) {
				{
				setState(100);
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
		enterRule(_localctx, 22, RULE_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
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
		"\u0004\u0001!j\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001\u0000"+
		"\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002*\b\u0002"+
		"\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"1\b\u0003\u0001\u0003\u0003\u00034\b\u0003\u0001\u0004\u0001\u0004\u0003"+
		"\u00048\b\u0004\u0001\u0004\u0003\u0004;\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0003\u0005?\b\u0005\u0001\u0005\u0003\u0005B\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0003\u0006F\b\u0006\u0001\u0006\u0003\u0006I\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0003\u0007M\b\u0007\u0001\u0007\u0003\u0007P\b\u0007\u0001"+
		"\b\u0001\b\u0003\bT\b\b\u0001\b\u0003\bW\b\b\u0001\t\u0001\t\u0003\t["+
		"\b\t\u0001\t\u0003\t^\b\t\u0001\n\u0004\na\b\n\u000b\n\f\nb\u0001\n\u0003"+
		"\nf\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001\u0002\u0000"+
		"\u0006\u0006  w\u0000\u0019\u0001\u0000\u0000\u0000\u0002%\u0001\u0000"+
		"\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006.\u0001\u0000\u0000"+
		"\u0000\b5\u0001\u0000\u0000\u0000\n<\u0001\u0000\u0000\u0000\fC\u0001"+
		"\u0000\u0000\u0000\u000eJ\u0001\u0000\u0000\u0000\u0010Q\u0001\u0000\u0000"+
		"\u0000\u0012X\u0001\u0000\u0000\u0000\u0014`\u0001\u0000\u0000\u0000\u0016"+
		"g\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0001"+
		"\u0001\u0000\u0000\u0000\u001d&\u0003\u0006\u0003\u0000\u001e&\u0003\b"+
		"\u0004\u0000\u001f&\u0003\n\u0005\u0000 &\u0003\f\u0006\u0000!&\u0003"+
		"\u0010\b\u0000\"&\u0003\u000e\u0007\u0000#&\u0003\u0012\t\u0000$&\u0003"+
		"\u0004\u0002\u0000%\u001d\u0001\u0000\u0000\u0000%\u001e\u0001\u0000\u0000"+
		"\u0000%\u001f\u0001\u0000\u0000\u0000% \u0001\u0000\u0000\u0000%!\u0001"+
		"\u0000\u0000\u0000%\"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000"+
		"%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000\u0000\')\u0005\u0005"+
		"\u0000\u0000(*\u0005\u0002\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001"+
		"\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+-\u0005\n\u0000\u0000,+\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0005\u0001\u0000\u0000"+
		"\u0000.0\u0005\u0005\u0000\u0000/1\u0005\u0003\u0000\u00000/\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000024\u0005"+
		"\n\u0000\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u00004\u0007"+
		"\u0001\u0000\u0000\u000057\u0005\u0005\u0000\u000068\u0003\u0014\n\u0000"+
		"76\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000"+
		"\u00009;\u0005\n\u0000\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;\t\u0001\u0000\u0000\u0000<>\u0005\u0005\u0000\u0000=?\u0005\u001d"+
		"\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001"+
		"\u0000\u0000\u0000@B\u0005\n\u0000\u0000A@\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000B\u000b\u0001\u0000\u0000\u0000CE\u0005\u0005\u0000"+
		"\u0000DF\u0005\u0001\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FH\u0001\u0000\u0000\u0000GI\u0005\n\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000I\r\u0001\u0000\u0000\u0000JL\u0005"+
		"\u0005\u0000\u0000KM\u0005\u001b\u0000\u0000LK\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000NP\u0005\n\u0000\u0000"+
		"ON\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u000f\u0001\u0000"+
		"\u0000\u0000QS\u0005\u0005\u0000\u0000RT\u0005\u001a\u0000\u0000SR\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000"+
		"UW\u0005\n\u0000\u0000VU\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"W\u0011\u0001\u0000\u0000\u0000XZ\u0005\u0005\u0000\u0000Y[\u0005\u0006"+
		"\u0000\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001"+
		"\u0000\u0000\u0000\\^\u0005\n\u0000\u0000]\\\u0001\u0000\u0000\u0000]"+
		"^\u0001\u0000\u0000\u0000^\u0013\u0001\u0000\u0000\u0000_a\u0003\u0016"+
		"\u000b\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000"+
		"df\u0005\f\u0000\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000"+
		"f\u0015\u0001\u0000\u0000\u0000gh\u0007\u0000\u0000\u0000h\u0017\u0001"+
		"\u0000\u0000\u0000\u0014\u001b%),037:>AEHLOSVZ]be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}