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
		ENTRY=1, EXIT=2, EXCEPTION=3, IF=4, ELSE=5, BOOLEAN=6, NAME=7, NUMBER=8, 
		STRING_LITERAL=9, REGEXP_LITERAL=10, LITERAL=11, VAR_REF=12, WS=13, TAB=14, 
		NEWLINE=15, COLON=16, COMMA=17, PERIOD=18, SEMI=19, PIPE=20, QUOTE=21, 
		LSBRACKET=22, RSBRACKET=23, PLUS=24, MINUS=25, MULTIPLY=26, PERCENT=27, 
		DIVIDE=28, EQUALS=29, NONEQUALS=30, LE=31, LT=32, GE=33, GT=34, ASSIGN=35, 
		TILDA=36, LCBRACKET=37, RCBRACKET=38, LBRACKET=39, RBRACKET=40, SL_COMMENT=41, 
		ML_COMMENT=42;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'entry'", "'exit'", "'exception'", "'if'", "'else'", "BOOLEAN", "NAME", 
		"NUMBER", "STRING_LITERAL", "REGEXP_LITERAL", "LITERAL", "VAR_REF", "' '", 
		"'\t'", "NEWLINE", "':'", "','", "'.'", "';'", "'|'", "'\"'", "'['", "']'", 
		"'+'", "'-'", "'*'", "'%'", "'/'", "'=='", "'!='", "'<='", "'<'", "'>='", 
		"'>'", "'='", "'~'", "'{'", "'}'", "'('", "')'", "SL_COMMENT", "ML_COMMENT"
	};
	public static final String[] ruleNames = {
		"ENTRY", "EXIT", "EXCEPTION", "IF", "ELSE", "BOOLEAN", "NAME", "NUMBER", 
		"FLOAT", "INTEGER", "STRING_LITERAL", "REGEXP_LITERAL", "LITERAL", "NONCONTROL_CHAR", 
		"LETTER", "LOWER", "UPPER", "DIGIT", "SPACE", "SYMBOL", "VAR_REF", "WS", 
		"TAB", "NEWLINE", "COLON", "COMMA", "PERIOD", "SEMI", "PIPE", "QUOTE", 
		"LSBRACKET", "RSBRACKET", "PLUS", "MINUS", "MULTIPLY", "PERCENT", "DIVIDE", 
		"EQUALS", "NONEQUALS", "LE", "LT", "GE", "GT", "ASSIGN", "TILDA", "LCBRACKET", 
		"RCBRACKET", "LBRACKET", "RBRACKET", "SL_COMMENT", "ML_COMMENT"
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
		case 21: WS_action((RuleContext)_localctx, actionIndex); break;

		case 22: TAB_action((RuleContext)_localctx, actionIndex); break;

		case 23: NEWLINE_action((RuleContext)_localctx, actionIndex); break;

		case 49: SL_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 50: ML_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void ML_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: _channel = HIDDEN;  break;
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
	private void SL_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2,\u0144\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u0090\n\7\3\b\3\b\3\b\3\b\7\b\u0096\n\b\f\b\16\b"+
		"\u0099\13\b\3\t\3\t\5\t\u009d\n\t\3\n\3\n\3\n\6\n\u00a2\n\n\r\n\16\n\u00a3"+
		"\3\13\3\13\5\13\u00a8\n\13\3\13\3\13\7\13\u00ac\n\13\f\13\16\13\u00af"+
		"\13\13\5\13\u00b1\n\13\3\f\3\f\7\f\u00b5\n\f\f\f\16\f\u00b8\13\f\3\f\3"+
		"\f\3\r\3\r\7\r\u00be\n\r\f\r\16\r\u00c1\13\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\5\16\u00c9\n\16\3\17\3\17\3\17\3\17\5\17\u00cf\n\17\3\20\3\20\5\20"+
		"\u00d3\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\5\31\u00eb\n\31\3\31"+
		"\6\31\u00ee\n\31\r\31\16\31\u00ef\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u012e\n"+
		"\63\f\63\16\63\u0131\13\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\7\64"+
		"\u013b\n\64\f\64\16\64\u013e\13\64\3\64\3\64\3\64\3\64\3\64\6\u00b6\u00bf"+
		"\u012f\u013c\65\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\2\1\25\2\1\27\13\1\31\f\1\33\r\1\35\2\1\37\2\1!\2\1#\2\1%\2\1\'\2\1)"+
		"\2\1+\16\1-\17\2/\20\3\61\21\4\63\22\1\65\23\1\67\24\19\25\1;\26\1=\27"+
		"\1?\30\1A\31\1C\32\1E\33\1G\34\1I\35\1K\36\1M\37\1O \1Q!\1S\"\1U#\1W$"+
		"\1Y%\1[&\1]\'\1_(\1a)\1c*\1e+\5g,\6\3\2\4\4\2\13\13\"\"\7\2##%\61<B]b"+
		"}\u0080\u0150\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\3i\3\2\2\2\5o\3\2\2\2\7t\3\2\2\2\t~\3\2\2\2\13\u0081\3\2\2"+
		"\2\r\u008f\3\2\2\2\17\u0091\3\2\2\2\21\u009c\3\2\2\2\23\u009e\3\2\2\2"+
		"\25\u00b0\3\2\2\2\27\u00b2\3\2\2\2\31\u00bb\3\2\2\2\33\u00c8\3\2\2\2\35"+
		"\u00ce\3\2\2\2\37\u00d2\3\2\2\2!\u00d4\3\2\2\2#\u00d6\3\2\2\2%\u00d8\3"+
		"\2\2\2\'\u00da\3\2\2\2)\u00dc\3\2\2\2+\u00de\3\2\2\2-\u00e1\3\2\2\2/\u00e5"+
		"\3\2\2\2\61\u00ed\3\2\2\2\63\u00f3\3\2\2\2\65\u00f5\3\2\2\2\67\u00f7\3"+
		"\2\2\29\u00f9\3\2\2\2;\u00fb\3\2\2\2=\u00fd\3\2\2\2?\u00ff\3\2\2\2A\u0101"+
		"\3\2\2\2C\u0103\3\2\2\2E\u0105\3\2\2\2G\u0107\3\2\2\2I\u0109\3\2\2\2K"+
		"\u010b\3\2\2\2M\u010d\3\2\2\2O\u0110\3\2\2\2Q\u0113\3\2\2\2S\u0116\3\2"+
		"\2\2U\u0118\3\2\2\2W\u011b\3\2\2\2Y\u011d\3\2\2\2[\u011f\3\2\2\2]\u0121"+
		"\3\2\2\2_\u0123\3\2\2\2a\u0125\3\2\2\2c\u0127\3\2\2\2e\u0129\3\2\2\2g"+
		"\u0136\3\2\2\2ij\7g\2\2jk\7p\2\2kl\7v\2\2lm\7t\2\2mn\7{\2\2n\4\3\2\2\2"+
		"op\7g\2\2pq\7z\2\2qr\7k\2\2rs\7v\2\2s\6\3\2\2\2tu\7g\2\2uv\7z\2\2vw\7"+
		"e\2\2wx\7g\2\2xy\7r\2\2yz\7v\2\2z{\7k\2\2{|\7q\2\2|}\7p\2\2}\b\3\2\2\2"+
		"~\177\7k\2\2\177\u0080\7h\2\2\u0080\n\3\2\2\2\u0081\u0082\7g\2\2\u0082"+
		"\u0083\7n\2\2\u0083\u0084\7u\2\2\u0084\u0085\7g\2\2\u0085\f\3\2\2\2\u0086"+
		"\u0087\7v\2\2\u0087\u0088\7t\2\2\u0088\u0089\7w\2\2\u0089\u0090\7g\2\2"+
		"\u008a\u008b\7h\2\2\u008b\u008c\7c\2\2\u008c\u008d\7n\2\2\u008d\u008e"+
		"\7u\2\2\u008e\u0090\7g\2\2\u008f\u0086\3\2\2\2\u008f\u008a\3\2\2\2\u0090"+
		"\16\3\2\2\2\u0091\u0097\5\37\20\2\u0092\u0096\5\37\20\2\u0093\u0096\5"+
		"%\23\2\u0094\u0096\7a\2\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\20\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009d\5\25\13\2\u009b"+
		"\u009d\5\23\n\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\22\3\2\2"+
		"\2\u009e\u009f\5\25\13\2\u009f\u00a1\7\60\2\2\u00a0\u00a2\4\62;\2\u00a1"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\24\3\2\2\2\u00a5\u00b1\7\62\2\2\u00a6\u00a8\7/\2\2\u00a7\u00a6"+
		"\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ad\4\63;\2\u00aa"+
		"\u00ac\4\62;\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00a5\3\2\2\2\u00b0\u00a7\3\2\2\2\u00b1\26\3\2\2\2\u00b2\u00b6\7$\2\2"+
		"\u00b3\u00b5\5\35\17\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00ba\7$\2\2\u00ba\30\3\2\2\2\u00bb\u00bf\7\61\2\2\u00bc\u00be\5\35\17"+
		"\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00c0\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\61\2\2"+
		"\u00c3\32\3\2\2\2\u00c4\u00c9\5\r\7\2\u00c5\u00c9\5\21\t\2\u00c6\u00c9"+
		"\5\27\f\2\u00c7\u00c9\5\31\r\2\u00c8\u00c4\3\2\2\2\u00c8\u00c5\3\2\2\2"+
		"\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\34\3\2\2\2\u00ca\u00cf"+
		"\5\37\20\2\u00cb\u00cf\5%\23\2\u00cc\u00cf\5)\25\2\u00cd\u00cf\5\'\24"+
		"\2\u00ce\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd"+
		"\3\2\2\2\u00cf\36\3\2\2\2\u00d0\u00d3\5!\21\2\u00d1\u00d3\5#\22\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3 \3\2\2\2\u00d4\u00d5\4c|\2\u00d5"+
		"\"\3\2\2\2\u00d6\u00d7\4C\\\2\u00d7$\3\2\2\2\u00d8\u00d9\4\62;\2\u00d9"+
		"&\3\2\2\2\u00da\u00db\t\2\2\2\u00db(\3\2\2\2\u00dc\u00dd\t\3\2\2\u00dd"+
		"*\3\2\2\2\u00de\u00df\7B\2\2\u00df\u00e0\5\17\b\2\u00e0,\3\2\2\2\u00e1"+
		"\u00e2\7\"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\27\2\2\u00e4.\3\2\2\2"+
		"\u00e5\u00e6\7\13\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b\30\3\2\u00e8\60"+
		"\3\2\2\2\u00e9\u00eb\7\17\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2"+
		"\u00eb\u00ec\3\2\2\2\u00ec\u00ee\7\f\2\2\u00ed\u00ea\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f2\b\31\4\2\u00f2\62\3\2\2\2\u00f3\u00f4\7<\2\2\u00f4\64\3\2\2\2\u00f5"+
		"\u00f6\7.\2\2\u00f6\66\3\2\2\2\u00f7\u00f8\7\60\2\2\u00f88\3\2\2\2\u00f9"+
		"\u00fa\7=\2\2\u00fa:\3\2\2\2\u00fb\u00fc\7~\2\2\u00fc<\3\2\2\2\u00fd\u00fe"+
		"\7$\2\2\u00fe>\3\2\2\2\u00ff\u0100\7]\2\2\u0100@\3\2\2\2\u0101\u0102\7"+
		"_\2\2\u0102B\3\2\2\2\u0103\u0104\7-\2\2\u0104D\3\2\2\2\u0105\u0106\7/"+
		"\2\2\u0106F\3\2\2\2\u0107\u0108\7,\2\2\u0108H\3\2\2\2\u0109\u010a\7\'"+
		"\2\2\u010aJ\3\2\2\2\u010b\u010c\7\61\2\2\u010cL\3\2\2\2\u010d\u010e\7"+
		"?\2\2\u010e\u010f\7?\2\2\u010fN\3\2\2\2\u0110\u0111\7#\2\2\u0111\u0112"+
		"\7?\2\2\u0112P\3\2\2\2\u0113\u0114\7>\2\2\u0114\u0115\7?\2\2\u0115R\3"+
		"\2\2\2\u0116\u0117\7>\2\2\u0117T\3\2\2\2\u0118\u0119\7@\2\2\u0119\u011a"+
		"\7?\2\2\u011aV\3\2\2\2\u011b\u011c\7@\2\2\u011cX\3\2\2\2\u011d\u011e\7"+
		"?\2\2\u011eZ\3\2\2\2\u011f\u0120\7\u0080\2\2\u0120\\\3\2\2\2\u0121\u0122"+
		"\7}\2\2\u0122^\3\2\2\2\u0123\u0124\7\177\2\2\u0124`\3\2\2\2\u0125\u0126"+
		"\7*\2\2\u0126b\3\2\2\2\u0127\u0128\7+\2\2\u0128d\3\2\2\2\u0129\u012a\7"+
		"\61\2\2\u012a\u012b\7\61\2\2\u012b\u012f\3\2\2\2\u012c\u012e\13\2\2\2"+
		"\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u0130\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\7\f\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0135\b\63\5\2\u0135f\3\2\2\2\u0136\u0137\7\61\2"+
		"\2\u0137\u0138\7,\2\2\u0138\u013c\3\2\2\2\u0139\u013b\13\2\2\2\u013a\u0139"+
		"\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7,\2\2\u0140\u0141\7\61"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\u0143\b\64\6\2\u0143h\3\2\2\2\24\2\u008f"+
		"\u0095\u0097\u009c\u00a3\u00a7\u00ad\u00b0\u00b6\u00bf\u00c8\u00ce\u00d2"+
		"\u00ea\u00ef\u012f\u013c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}