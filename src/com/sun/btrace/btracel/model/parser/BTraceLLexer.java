// Generated from /home/jbachorik/src/java/btracel/src/BTraceL.g4 by ANTLR 4.1
package com.sun.btrace.btracel.model.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BTraceLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, NAME=4, NUMBER=5, STRING_LITERAL=6, REGEXP_LITERAL=7, 
		VAR_REF=8, WS=9, TAB=10, NEWLINE=11, COLON=12, COMMA=13, PERIOD=14, SEMI=15, 
		PIPE=16, QUOTE=17, LSBRACKET=18, RSBRACKET=19, PLUS=20, MINUS=21, MULTIPLY=22, 
		PERCENT=23, DIVIDE=24, ASSIGN=25, TILDA=26, LCBRACKET=27, RCBRACKET=28, 
		LBRACKET=29, RBRACKET=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'entry'", "'exit'", "'exception'", "NAME", "NUMBER", "STRING_LITERAL", 
		"REGEXP_LITERAL", "VAR_REF", "' '", "'\t'", "NEWLINE", "':'", "','", "'.'", 
		"';'", "'|'", "'\"'", "'['", "']'", "'+'", "'-'", "'*'", "'%'", "'/'", 
		"'='", "'~'", "'{'", "'}'", "'('", "')'"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "NAME", "NUMBER", "FLOAT", "INTEGER", "STRING_LITERAL", 
		"REGEXP_LITERAL", "NONCONTROL_CHAR", "LETTER", "LOWER", "UPPER", "DIGIT", 
		"SPACE", "SYMBOL", "VAR_REF", "WS", "TAB", "NEWLINE", "COLON", "COMMA", 
		"PERIOD", "SEMI", "PIPE", "QUOTE", "LSBRACKET", "RSBRACKET", "PLUS", "MINUS", 
		"MULTIPLY", "PERCENT", "DIVIDE", "ASSIGN", "TILDA", "LCBRACKET", "RCBRACKET", 
		"LBRACKET", "RBRACKET"
	};


	public BTraceLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BTraceL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 17: WS_action((RuleContext)_localctx, actionIndex); break;

		case 18: TAB_action((RuleContext)_localctx, actionIndex); break;

		case 19: NEWLINE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2 \u00e8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\6\3\6\5\6r\n\6\3\7\3\7\3\7\6\7w\n"+
		"\7\r\7\16\7x\3\b\3\b\5\b}\n\b\3\b\3\b\7\b\u0081\n\b\f\b\16\b\u0084\13"+
		"\b\5\b\u0086\n\b\3\t\3\t\7\t\u008a\n\t\f\t\16\t\u008d\13\t\3\t\3\t\3\n"+
		"\3\n\7\n\u0093\n\n\f\n\16\n\u0096\13\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13"+
		"\u009e\n\13\3\f\3\f\5\f\u00a2\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25"+
		"\5\25\u00ba\n\25\3\25\6\25\u00bd\n\25\r\25\16\25\u00be\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3\'\3\'\3(\3(\4\u008b\u0094)\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\2\1\17"+
		"\2\1\21\b\1\23\t\1\25\2\1\27\2\1\31\2\1\33\2\1\35\2\1\37\2\1!\2\1#\n\1"+
		"%\13\2\'\f\3)\r\4+\16\1-\17\1/\20\1\61\21\1\63\22\1\65\23\1\67\24\19\25"+
		"\1;\26\1=\27\1?\30\1A\31\1C\32\1E\33\1G\34\1I\35\1K\36\1M\37\1O \1\3\2"+
		"\4\4\2\13\13\"\"\7\2##%\61<B]b}\u0080\u00ee\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5W\3\2\2\2\7\\"+
		"\3\2\2\2\tf\3\2\2\2\13q\3\2\2\2\rs\3\2\2\2\17\u0085\3\2\2\2\21\u0087\3"+
		"\2\2\2\23\u0090\3\2\2\2\25\u009d\3\2\2\2\27\u00a1\3\2\2\2\31\u00a3\3\2"+
		"\2\2\33\u00a5\3\2\2\2\35\u00a7\3\2\2\2\37\u00a9\3\2\2\2!\u00ab\3\2\2\2"+
		"#\u00ad\3\2\2\2%\u00b0\3\2\2\2\'\u00b4\3\2\2\2)\u00bc\3\2\2\2+\u00c2\3"+
		"\2\2\2-\u00c4\3\2\2\2/\u00c6\3\2\2\2\61\u00c8\3\2\2\2\63\u00ca\3\2\2\2"+
		"\65\u00cc\3\2\2\2\67\u00ce\3\2\2\29\u00d0\3\2\2\2;\u00d2\3\2\2\2=\u00d4"+
		"\3\2\2\2?\u00d6\3\2\2\2A\u00d8\3\2\2\2C\u00da\3\2\2\2E\u00dc\3\2\2\2G"+
		"\u00de\3\2\2\2I\u00e0\3\2\2\2K\u00e2\3\2\2\2M\u00e4\3\2\2\2O\u00e6\3\2"+
		"\2\2QR\7g\2\2RS\7p\2\2ST\7v\2\2TU\7t\2\2UV\7{\2\2V\4\3\2\2\2WX\7g\2\2"+
		"XY\7z\2\2YZ\7k\2\2Z[\7v\2\2[\6\3\2\2\2\\]\7g\2\2]^\7z\2\2^_\7e\2\2_`\7"+
		"g\2\2`a\7r\2\2ab\7v\2\2bc\7k\2\2cd\7q\2\2de\7p\2\2e\b\3\2\2\2fl\5\27\f"+
		"\2gk\5\27\f\2hk\5\35\17\2ik\7a\2\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2kn\3\2"+
		"\2\2lj\3\2\2\2lm\3\2\2\2m\n\3\2\2\2nl\3\2\2\2or\5\17\b\2pr\5\r\7\2qo\3"+
		"\2\2\2qp\3\2\2\2r\f\3\2\2\2st\5\17\b\2tv\7\60\2\2uw\4\62;\2vu\3\2\2\2"+
		"wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\16\3\2\2\2z\u0086\7\62\2\2{}\7/\2\2|{"+
		"\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\u0082\4\63;\2\177\u0081\4\62;\2\u0080\177"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085z\3\2\2\2\u0085|\3\2\2\2\u0086"+
		"\20\3\2\2\2\u0087\u008b\7$\2\2\u0088\u008a\5\25\13\2\u0089\u0088\3\2\2"+
		"\2\u008a\u008d\3\2\2\2\u008b\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7$\2\2\u008f\22\3\2\2\2\u0090"+
		"\u0094\7\61\2\2\u0091\u0093\5\25\13\2\u0092\u0091\3\2\2\2\u0093\u0096"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u0098\7\61\2\2\u0098\24\3\2\2\2\u0099\u009e\5\27"+
		"\f\2\u009a\u009e\5\35\17\2\u009b\u009e\5!\21\2\u009c\u009e\5\37\20\2\u009d"+
		"\u0099\3\2\2\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2"+
		"\2\2\u009e\26\3\2\2\2\u009f\u00a2\5\31\r\2\u00a0\u00a2\5\33\16\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\30\3\2\2\2\u00a3\u00a4\4c|\2"+
		"\u00a4\32\3\2\2\2\u00a5\u00a6\4C\\\2\u00a6\34\3\2\2\2\u00a7\u00a8\4\62"+
		";\2\u00a8\36\3\2\2\2\u00a9\u00aa\t\2\2\2\u00aa \3\2\2\2\u00ab\u00ac\t"+
		"\3\2\2\u00ac\"\3\2\2\2\u00ad\u00ae\7B\2\2\u00ae\u00af\5\t\5\2\u00af$\3"+
		"\2\2\2\u00b0\u00b1\7\"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\23\2\2\u00b3"+
		"&\3\2\2\2\u00b4\u00b5\7\13\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\24\3"+
		"\2\u00b7(\3\2\2\2\u00b8\u00ba\7\17\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\7\f\2\2\u00bc\u00b9\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\b\25\4\2\u00c1*\3\2\2\2\u00c2\u00c3\7<\2\2\u00c3,\3\2"+
		"\2\2\u00c4\u00c5\7.\2\2\u00c5.\3\2\2\2\u00c6\u00c7\7\60\2\2\u00c7\60\3"+
		"\2\2\2\u00c8\u00c9\7=\2\2\u00c9\62\3\2\2\2\u00ca\u00cb\7~\2\2\u00cb\64"+
		"\3\2\2\2\u00cc\u00cd\7$\2\2\u00cd\66\3\2\2\2\u00ce\u00cf\7]\2\2\u00cf"+
		"8\3\2\2\2\u00d0\u00d1\7_\2\2\u00d1:\3\2\2\2\u00d2\u00d3\7-\2\2\u00d3<"+
		"\3\2\2\2\u00d4\u00d5\7/\2\2\u00d5>\3\2\2\2\u00d6\u00d7\7,\2\2\u00d7@\3"+
		"\2\2\2\u00d8\u00d9\7\'\2\2\u00d9B\3\2\2\2\u00da\u00db\7\61\2\2\u00dbD"+
		"\3\2\2\2\u00dc\u00dd\7?\2\2\u00ddF\3\2\2\2\u00de\u00df\7\u0080\2\2\u00df"+
		"H\3\2\2\2\u00e0\u00e1\7}\2\2\u00e1J\3\2\2\2\u00e2\u00e3\7\177\2\2\u00e3"+
		"L\3\2\2\2\u00e4\u00e5\7*\2\2\u00e5N\3\2\2\2\u00e6\u00e7\7+\2\2\u00e7P"+
		"\3\2\2\2\20\2jlqx|\u0082\u0085\u008b\u0094\u009d\u00a1\u00b9\u00be";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}