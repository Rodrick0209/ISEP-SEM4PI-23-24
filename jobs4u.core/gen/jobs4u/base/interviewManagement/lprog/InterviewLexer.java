// Generated from C:/Users/rodri/Documents/sem4pi-23-24-2dj2/jobs4u.core/src/main/java/jobs4u/base/interviewManagement/lprog/Interview.g4 by ANTLR 4.13.1
package jobs4u.base.interviewManagement.lprog;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class InterviewLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, QUESTION_TYPE=4, QUESTION_TEXT=5, STRING=6, INT=7, 
		FLOAT=8, DATE=9, TIME=10, INT_RANGE=11, NEWLINE=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "QUESTION_TYPE", "QUESTION_TEXT", "STRING", "INT", 
			"FLOAT", "DATE", "TIME", "INT_RANGE", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Answer:'", "'Yes'", "'No'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "QUESTION_TYPE", "QUESTION_TEXT", "STRING", "INT", 
			"FLOAT", "DATE", "TIME", "INT_RANGE", "NEWLINE", "WS"
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


	public InterviewLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Interview.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 8:
			DATE_action((RuleContext)_localctx, actionIndex);
			break;
		case 9:
			TIME_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void DATE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			4
			break;
		case 1:
			2
			break;
		case 2:
			2
			break;
		}
	}
	private void TIME_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			2
			break;
		case 4:
			2
			break;
		case 5:
			2
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\rr\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0004\u0003-\b\u0003\u000b\u0003\f\u0003.\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0004\u00044\b\u0004\u000b\u0004\f\u00045\u0001"+
		"\u0005\u0001\u0005\u0005\u0005:\b\u0005\n\u0005\f\u0005=\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0004\u0006B\b\u0006\u000b\u0006\f\u0006"+
		"C\u0001\u0007\u0004\u0007G\b\u0007\u000b\u0007\f\u0007H\u0001\u0007\u0001"+
		"\u0007\u0004\u0007M\b\u0007\u000b\u0007\f\u0007N\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0004\u000bh\b\u000b\u000b\u000b\f\u000bi\u0001"+
		"\f\u0004\fm\b\f\u000b\f\f\fn\u0001\f\u0001\f\u0000\u0000\r\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0005\u0001"+
		"\u0000))\u0002\u0000\n\n\r\r\u0003\u0000\n\n\r\r\"\"\u0001\u000009\u0002"+
		"\u0000\t\t  y\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000"+
		"\u0003#\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007"+
		"*\u0001\u0000\u0000\u0000\t3\u0001\u0000\u0000\u0000\u000b7\u0001\u0000"+
		"\u0000\u0000\rA\u0001\u0000\u0000\u0000\u000fF\u0001\u0000\u0000\u0000"+
		"\u0011P\u0001\u0000\u0000\u0000\u0013Y\u0001\u0000\u0000\u0000\u0015b"+
		"\u0001\u0000\u0000\u0000\u0017g\u0001\u0000\u0000\u0000\u0019l\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0005A\u0000\u0000\u001c\u001d\u0005n\u0000\u0000"+
		"\u001d\u001e\u0005s\u0000\u0000\u001e\u001f\u0005w\u0000\u0000\u001f "+
		"\u0005e\u0000\u0000 !\u0005r\u0000\u0000!\"\u0005:\u0000\u0000\"\u0002"+
		"\u0001\u0000\u0000\u0000#$\u0005Y\u0000\u0000$%\u0005e\u0000\u0000%&\u0005"+
		"s\u0000\u0000&\u0004\u0001\u0000\u0000\u0000\'(\u0005N\u0000\u0000()\u0005"+
		"o\u0000\u0000)\u0006\u0001\u0000\u0000\u0000*,\u0005(\u0000\u0000+-\b"+
		"\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000"+
		".,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000"+
		"\u000001\u0005)\u0000\u00001\b\u0001\u0000\u0000\u000024\b\u0001\u0000"+
		"\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u00006\n\u0001\u0000\u0000\u00007;\u0005"+
		"\"\u0000\u00008:\b\u0002\u0000\u000098\u0001\u0000\u0000\u0000:=\u0001"+
		"\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005\"\u0000\u0000"+
		"?\f\u0001\u0000\u0000\u0000@B\u0007\u0003\u0000\u0000A@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000D\u000e\u0001\u0000\u0000\u0000EG\u0007\u0003\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0005.\u0000"+
		"\u0000KM\u0007\u0003\u0000\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0010"+
		"\u0001\u0000\u0000\u0000PQ\u0007\u0003\u0000\u0000QR\u0006\b\u0000\u0000"+
		"RS\u0005-\u0000\u0000ST\u0007\u0003\u0000\u0000TU\u0006\b\u0001\u0000"+
		"UV\u0005-\u0000\u0000VW\u0007\u0003\u0000\u0000WX\u0006\b\u0002\u0000"+
		"X\u0012\u0001\u0000\u0000\u0000YZ\u0007\u0003\u0000\u0000Z[\u0006\t\u0003"+
		"\u0000[\\\u0005:\u0000\u0000\\]\u0007\u0003\u0000\u0000]^\u0006\t\u0004"+
		"\u0000^_\u0005:\u0000\u0000_`\u0007\u0003\u0000\u0000`a\u0006\t\u0005"+
		"\u0000a\u0014\u0001\u0000\u0000\u0000bc\u0003\r\u0006\u0000cd\u0005-\u0000"+
		"\u0000de\u0003\r\u0006\u0000e\u0016\u0001\u0000\u0000\u0000fh\u0007\u0001"+
		"\u0000\u0000gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u0018\u0001\u0000\u0000"+
		"\u0000km\u0007\u0004\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pq\u0006\f\u0006\u0000q\u001a\u0001\u0000\u0000\u0000"+
		"\t\u0000.5;CHNin\u0007\u0001\b\u0000\u0001\b\u0001\u0001\b\u0002\u0001"+
		"\t\u0003\u0001\t\u0004\u0001\t\u0005\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}