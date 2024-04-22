// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/Evaluation/Evaluation.g4 by ANTLR 4.13.1
package jobs4u.base.interviewManagement.lprog.Evaluation;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EvaluationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE_OR_FALSE=1, IDENTIFIER=2, SECTION=3, ANSWER=4, NUMS=5, CHAR=6, NUM=7, 
		NEWLINE=8, SPECIAL_CHAR=9, PUNCTUATION_MARKS=10, DOT=11, DASH=12, SLASH=13, 
		SPACE=14, COMMA=15, TWO_DOTS=16, UNDERSCORE=17, RIGHT_PARENTHESES=18, 
		FLOAT=19, NUMERICAL_OPTION=20, ALPHABETICAL_OPTION=21, WORD=22, WS=23;
	public static final int
		RULE_resolution = 0, RULE_answer = 1, RULE_answerToMultipleChoice = 2, 
		RULE_answerToShortAnswer = 3, RULE_answerToNumerical = 4, RULE_answerToTrueFalse = 5, 
		RULE_phrase = 6, RULE_words = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"resolution", "answer", "answerToMultipleChoice", "answerToShortAnswer", 
			"answerToNumerical", "answerToTrueFalse", "phrase", "words"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "'.'", 
			"'-'", "'/'", "' '", "','", "':'", "'_'", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE_OR_FALSE", "IDENTIFIER", "SECTION", "ANSWER", "NUMS", "CHAR", 
			"NUM", "NEWLINE", "SPECIAL_CHAR", "PUNCTUATION_MARKS", "DOT", "DASH", 
			"SLASH", "SPACE", "COMMA", "TWO_DOTS", "UNDERSCORE", "RIGHT_PARENTHESES", 
			"FLOAT", "NUMERICAL_OPTION", "ALPHABETICAL_OPTION", "WORD", "WS"
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
	public static class ResolutionContext extends ParserRuleContext {
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public ResolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).enterResolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluationListener ) ((EvaluationListener)listener).exitResolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluationVisitor ) return ((EvaluationVisitor<? extends T>)visitor).visitResolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResolutionContext resolution() throws RecognitionException {
		ResolutionContext _localctx = new ResolutionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_resolution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				answer();
				}
				}
				setState(19); 
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
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				answerToMultipleChoice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				answerToShortAnswer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				answerToNumerical();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(24);
				answerToTrueFalse();
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
		public TerminalNode CHAR() { return getToken(EvaluationParser.CHAR, 0); }
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
			setState(27);
			match(ANSWER);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHAR) {
				{
				setState(28);
				match(CHAR);
				}
			}

			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(31);
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
			setState(34);
			match(ANSWER);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMS || _la==WORD) {
				{
				setState(35);
				phrase();
				}
			}

			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(38);
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
			setState(41);
			match(ANSWER);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLOAT) {
				{
				setState(42);
				match(FLOAT);
				}
			}

			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(45);
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
			setState(48);
			match(ANSWER);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE_OR_FALSE) {
				{
				setState(49);
				match(TRUE_OR_FALSE);
				}
			}

			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(52);
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
		enterRule(_localctx, 12, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				words();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMS || _la==WORD );
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNCTUATION_MARKS) {
				{
				setState(60);
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
		enterRule(_localctx, 14, RULE_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
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
		"\u0004\u0001\u0017B\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\u001e\b\u0002\u0001\u0002\u0003\u0002!\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0003\u0003%\b\u0003\u0001\u0003\u0003\u0003"+
		"(\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004,\b\u0004\u0001\u0004\u0003"+
		"\u0004/\b\u0004\u0001\u0005\u0001\u0005\u0003\u00053\b\u0005\u0001\u0005"+
		"\u0003\u00056\b\u0005\u0001\u0006\u0004\u00069\b\u0006\u000b\u0006\f\u0006"+
		":\u0001\u0006\u0003\u0006>\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0001\u0002\u0000"+
		"\u0005\u0005\u0016\u0016G\u0000\u0011\u0001\u0000\u0000\u0000\u0002\u0019"+
		"\u0001\u0000\u0000\u0000\u0004\u001b\u0001\u0000\u0000\u0000\u0006\"\u0001"+
		"\u0000\u0000\u0000\b)\u0001\u0000\u0000\u0000\n0\u0001\u0000\u0000\u0000"+
		"\f8\u0001\u0000\u0000\u0000\u000e?\u0001\u0000\u0000\u0000\u0010\u0012"+
		"\u0003\u0002\u0001\u0000\u0011\u0010\u0001\u0000\u0000\u0000\u0012\u0013"+
		"\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0014"+
		"\u0001\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000\u0000\u0015\u001a"+
		"\u0003\u0004\u0002\u0000\u0016\u001a\u0003\u0006\u0003\u0000\u0017\u001a"+
		"\u0003\b\u0004\u0000\u0018\u001a\u0003\n\u0005\u0000\u0019\u0015\u0001"+
		"\u0000\u0000\u0000\u0019\u0016\u0001\u0000\u0000\u0000\u0019\u0017\u0001"+
		"\u0000\u0000\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u0003\u0001"+
		"\u0000\u0000\u0000\u001b\u001d\u0005\u0004\u0000\u0000\u001c\u001e\u0005"+
		"\u0006\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d\u001e\u0001"+
		"\u0000\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f!\u0005\b\u0000"+
		"\u0000 \u001f\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0005"+
		"\u0001\u0000\u0000\u0000\"$\u0005\u0004\u0000\u0000#%\u0003\f\u0006\u0000"+
		"$#\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000"+
		"\u0000&(\u0005\b\u0000\u0000\'&\u0001\u0000\u0000\u0000\'(\u0001\u0000"+
		"\u0000\u0000(\u0007\u0001\u0000\u0000\u0000)+\u0005\u0004\u0000\u0000"+
		"*,\u0005\u0013\u0000\u0000+*\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,.\u0001\u0000\u0000\u0000-/\u0005\b\u0000\u0000.-\u0001\u0000\u0000"+
		"\u0000./\u0001\u0000\u0000\u0000/\t\u0001\u0000\u0000\u000002\u0005\u0004"+
		"\u0000\u000013\u0005\u0001\u0000\u000021\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u000035\u0001\u0000\u0000\u000046\u0005\b\u0000\u000054\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u00006\u000b\u0001\u0000\u0000"+
		"\u000079\u0003\u000e\u0007\u000087\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001"+
		"\u0000\u0000\u0000<>\u0005\n\u0000\u0000=<\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>\r\u0001\u0000\u0000\u0000?@\u0007\u0000\u0000\u0000"+
		"@\u000f\u0001\u0000\u0000\u0000\f\u0013\u0019\u001d $\'+.25:=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}