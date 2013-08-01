grammar BTraceL;

program: cutpoint COLON handlers EOF;

cutpoint:
            cutdef | followdef;

cutdef:
            classmatch COLON methodmatch;

followdef:
            LSBRACKET cutdef RSBRACKET TILDA LSBRACKET cutdef RSBRACKET;

classmatch:
              pkgid | subclasses | regex;

methodmatch:
               methodid | regex;

pkgid:
         NAME (PERIOD NAME)*;

methodid:
            NAME | signature;

signature 
    : (pkgid)? NAME LBRACKET arglist RBRACKET;
      
arglist
    : arg (COMMA arg)*;
      
arg
    : pkgid NAME;

subclasses
    : PLUS pkgid;

regex
    : REGEXP_LITERAL;

handlers:
            handler (COMMA handler)*;

handler:
           type block;

type:
        'entry' | 'exit' | 'exception';

block:
         LCBRACKET statement (statement)* RCBRACKET;

statement: ((assign | functionEval) SEMI) | ifblock;

assign: NAME ASSIGN exp terminator?;

ifblock: 'if' '(' exp ')' block (elseblock)?;
elseblock: 'else' (block | ifblock);

terminator: NEWLINE | EOF;

exp_unary: VAR_REF | NAME | NUMBER | BOOLEAN | STRING_LITERAL | functionEval;

exp_plus: exp_unary '+' exp;
exp_minus: exp_unary '-' exp;
exp_mul: exp_unary '*' exp;
exp_div: exp_unary '/' exp;
exp_mod: exp_unary '%' exp;
exp_compare: exp_unary ('==' | '!=' | '<=' | '>=' | '<' | '>') exp;

exp_binary: exp_plus | exp_minus | exp_mul | exp_compare;

exp: exp_unary | exp_binary | LBRACKET (exp_unary | exp_binary) RBRACKET;

functionEval
    : NAME LBRACKET arguments? RBRACKET;

arguments
    : exp (COMMA exp)*;


// LEXER TOKENS
// Handler keywords
ENTRY: 'entry';
EXIT: 'exit';
EXCEPTION: 'exception';
IF: 'if';
ELSE: 'else';

BOOLEAN: 'true' | 'false';
NAME: LETTER (LETTER | DIGIT | '_')*;
NUMBER: INTEGER | FLOAT;
fragment FLOAT: INTEGER '.' '0'..'9'+;
fragment INTEGER: '0' | '-'? '1'..'9' '0'..'9'*;
STRING_LITERAL: '"' NONCONTROL_CHAR*? '"';
REGEXP_LITERAL: '/' NONCONTROL_CHAR*? '/';
LITERAL: BOOLEAN | NUMBER | STRING_LITERAL | REGEXP_LITERAL;
fragment NONCONTROL_CHAR: LETTER | DIGIT | SYMBOL | SPACE;
fragment LETTER: LOWER | UPPER;
fragment LOWER: 'a'..'z';
fragment UPPER: 'A'..'Z';
fragment DIGIT: '0'..'9';
fragment SPACE: [ \t];
// Note that SYMBOL does not include the double-quote character.
fragment SYMBOL: '!' | '#'..'/' | ':'..'@' | '['..'`' | '{'..'~';

VAR_REF: '@' NAME;

WS: ' ' -> skip;
TAB: '\t' -> skip;

NEWLINE: ('\r'? '\n')+ -> skip;

COLON: ':';
COMMA: ',';
PERIOD: '.';
SEMI: ';';
PIPE:'|';
QUOTE: '"';
LSBRACKET: '[';
RSBRACKET: ']';
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
PERCENT: '%';
DIVIDE: '/';
EQUALS: '==';
NONEQUALS: '!=';
LE: '<=';
LT: '<';
GE: '>=';
GT: '>';
ASSIGN: '=';
TILDA: '~';
LCBRACKET: '{';
RCBRACKET: '}';
LBRACKET: '(';
RBRACKET: ')';

SL_COMMENT: '//' .*? '\n' -> channel(HIDDEN);
ML_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);