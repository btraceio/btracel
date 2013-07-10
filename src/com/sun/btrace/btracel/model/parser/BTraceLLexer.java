// Generated from /home/jbachorik/Desktop/BTraceL.g4 by ANTLR 4.1
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
		VAR_REF=8, WS=9, NEWLINE=10, COLON=11, COMMA=12, PERIOD=13, SEMI=14, PIPE=15, 
		QUOTE=16, LSBRACKET=17, RSBRACKET=18, PLUS=19, MINUS=20, MULTIPLY=21, 
		PERCENT=22, DIVIDE=23, ASSIGN=24, TILDA=25, LCBRACKET=26, RCBRACKET=27, 
		LBRACKET=28, RBRACKET=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'entry'", "'exit'", "'exception'", "NAME", "NUMBER", "STRING_LITERAL", 
		"REGEXP_LITERAL", "VAR_REF", "WS", "NEWLINE", "':'", "','", "'.'", "';'", 
		"'|'", "'\"'", "'['", "']'", "'+'", "'-'", "'*'", "'%'", "'/'", "'='", 
		"'~'", "'{'", "'}'", "'('", "')'"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "NAME", "NUMBER", "FLOAT", "INTEGER", "STRING_LITERAL", 
		"REGEXP_LITERAL", "NONCONTROL_CHAR", "LETTER", "LOWER", "UPPER", "DIGIT", 
		"SPACE", "SYMBOL", "VAR_REF", "WS", "NEWLINE", "COLON", "COMMA", "PERIOD", 
		"SEMI", "PIPE", "QUOTE", "LSBRACKET", "RSBRACKET", "PLUS", "MINUS", "MULTIPLY", 
		"PERCENT", "DIVIDE", "ASSIGN", "TILDA", "LCBRACKET", "RCBRACKET", "LBRACKET", 
		"RBRACKET"
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
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\37\u00e3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\7\5i\n\5\f\5\16\5l\13\5\3\6\3\6\5\6p\n\6\3\7\3\7\3\7\6\7u\n\7"+
		"\r\7\16\7v\3\b\3\b\5\b{\n\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\5"+
		"\b\u0084\n\b\3\t\3\t\7\t\u0088\n\t\f\t\16\t\u008b\13\t\3\t\3\t\3\n\3\n"+
		"\7\n\u0091\n\n\f\n\16\n\u0094\13\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u009c"+
		"\n\13\3\f\3\f\5\f\u00a0\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\6\23\u00b0\n\23\r\23\16\23\u00b1\3\23\3\23\3"+
		"\24\5\24\u00b7\n\24\3\24\6\24\u00ba\n\24\r\24\16\24\u00bb\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&"+
		"\3&\3\'\3\'\4\u0089\u0092(\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\2\1\17\2\1"+
		"\21\b\1\23\t\1\25\2\1\27\2\1\31\2\1\33\2\1\35\2\1\37\2\1!\2\1#\n\1%\13"+
		"\2\'\f\1)\r\1+\16\1-\17\1/\20\1\61\21\1\63\22\1\65\23\1\67\24\19\25\1"+
		";\26\1=\27\1?\30\1A\31\1C\32\1E\33\1G\34\1I\35\1K\36\1M\37\1\3\2\5\4\2"+
		"\13\13\"\"\7\2##%\61<B]b}\u0080\5\2\13\f\17\17\"\"\u00ea\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5U\3\2\2\2\7"+
		"Z\3\2\2\2\td\3\2\2\2\13o\3\2\2\2\rq\3\2\2\2\17\u0083\3\2\2\2\21\u0085"+
		"\3\2\2\2\23\u008e\3\2\2\2\25\u009b\3\2\2\2\27\u009f\3\2\2\2\31\u00a1\3"+
		"\2\2\2\33\u00a3\3\2\2\2\35\u00a5\3\2\2\2\37\u00a7\3\2\2\2!\u00a9\3\2\2"+
		"\2#\u00ab\3\2\2\2%\u00af\3\2\2\2\'\u00b9\3\2\2\2)\u00bd\3\2\2\2+\u00bf"+
		"\3\2\2\2-\u00c1\3\2\2\2/\u00c3\3\2\2\2\61\u00c5\3\2\2\2\63\u00c7\3\2\2"+
		"\2\65\u00c9\3\2\2\2\67\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00cf\3\2\2\2=\u00d1"+
		"\3\2\2\2?\u00d3\3\2\2\2A\u00d5\3\2\2\2C\u00d7\3\2\2\2E\u00d9\3\2\2\2G"+
		"\u00db\3\2\2\2I\u00dd\3\2\2\2K\u00df\3\2\2\2M\u00e1\3\2\2\2OP\7g\2\2P"+
		"Q\7p\2\2QR\7v\2\2RS\7t\2\2ST\7{\2\2T\4\3\2\2\2UV\7g\2\2VW\7z\2\2WX\7k"+
		"\2\2XY\7v\2\2Y\6\3\2\2\2Z[\7g\2\2[\\\7z\2\2\\]\7e\2\2]^\7g\2\2^_\7r\2"+
		"\2_`\7v\2\2`a\7k\2\2ab\7q\2\2bc\7p\2\2c\b\3\2\2\2dj\5\27\f\2ei\5\27\f"+
		"\2fi\5\35\17\2gi\7a\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2"+
		"\2\2jk\3\2\2\2k\n\3\2\2\2lj\3\2\2\2mp\5\17\b\2np\5\r\7\2om\3\2\2\2on\3"+
		"\2\2\2p\f\3\2\2\2qr\5\17\b\2rt\7\60\2\2su\4\62;\2ts\3\2\2\2uv\3\2\2\2"+
		"vt\3\2\2\2vw\3\2\2\2w\16\3\2\2\2x\u0084\7\62\2\2y{\7/\2\2zy\3\2\2\2z{"+
		"\3\2\2\2{|\3\2\2\2|\u0080\4\63;\2}\177\4\62;\2~}\3\2\2\2\177\u0082\3\2"+
		"\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083x\3\2\2\2\u0083z\3\2\2\2\u0084\20\3\2\2\2\u0085\u0089\7"+
		"$\2\2\u0086\u0088\5\25\13\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008c\u008d\7$\2\2\u008d\22\3\2\2\2\u008e\u0092\7\61\2\2\u008f\u0091"+
		"\5\25\13\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0093\3\2\2\2"+
		"\u0092\u0090\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096"+
		"\7\61\2\2\u0096\24\3\2\2\2\u0097\u009c\5\27\f\2\u0098\u009c\5\35\17\2"+
		"\u0099\u009c\5!\21\2\u009a\u009c\5\37\20\2\u009b\u0097\3\2\2\2\u009b\u0098"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\26\3\2\2\2\u009d"+
		"\u00a0\5\31\r\2\u009e\u00a0\5\33\16\2\u009f\u009d\3\2\2\2\u009f\u009e"+
		"\3\2\2\2\u00a0\30\3\2\2\2\u00a1\u00a2\4c|\2\u00a2\32\3\2\2\2\u00a3\u00a4"+
		"\4C\\\2\u00a4\34\3\2\2\2\u00a5\u00a6\4\62;\2\u00a6\36\3\2\2\2\u00a7\u00a8"+
		"\t\2\2\2\u00a8 \3\2\2\2\u00a9\u00aa\t\3\2\2\u00aa\"\3\2\2\2\u00ab\u00ac"+
		"\7B\2\2\u00ac\u00ad\5\t\5\2\u00ad$\3\2\2\2\u00ae\u00b0\t\4\2\2\u00af\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\b\23\2\2\u00b4&\3\2\2\2\u00b5\u00b7\7\17\2"+
		"\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba"+
		"\7\f\2\2\u00b9\u00b6\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc(\3\2\2\2\u00bd\u00be\7<\2\2\u00be*\3\2\2\2\u00bf"+
		"\u00c0\7.\2\2\u00c0,\3\2\2\2\u00c1\u00c2\7\60\2\2\u00c2.\3\2\2\2\u00c3"+
		"\u00c4\7=\2\2\u00c4\60\3\2\2\2\u00c5\u00c6\7~\2\2\u00c6\62\3\2\2\2\u00c7"+
		"\u00c8\7$\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7]\2\2\u00ca\66\3\2\2\2\u00cb"+
		"\u00cc\7_\2\2\u00cc8\3\2\2\2\u00cd\u00ce\7-\2\2\u00ce:\3\2\2\2\u00cf\u00d0"+
		"\7/\2\2\u00d0<\3\2\2\2\u00d1\u00d2\7,\2\2\u00d2>\3\2\2\2\u00d3\u00d4\7"+
		"\'\2\2\u00d4@\3\2\2\2\u00d5\u00d6\7\61\2\2\u00d6B\3\2\2\2\u00d7\u00d8"+
		"\7?\2\2\u00d8D\3\2\2\2\u00d9\u00da\7\u0080\2\2\u00daF\3\2\2\2\u00db\u00dc"+
		"\7}\2\2\u00dcH\3\2\2\2\u00dd\u00de\7\177\2\2\u00deJ\3\2\2\2\u00df\u00e0"+
		"\7*\2\2\u00e0L\3\2\2\2\u00e1\u00e2\7+\2\2\u00e2N\3\2\2\2\21\2hjovz\u0080"+
		"\u0083\u0089\u0092\u009b\u009f\u00b1\u00b6\u00bb";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}