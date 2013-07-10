grammar BTraceL;

program: cutpoint ':' handlers EOF!;

cutpoint:
            cutdef | followdef;

cutdef:
            classmatch ':' methodmatch;

followdef:
            '[' cutdef ']' '~' '[' cutdef ']';

classmatch:
              pkgid | subclasses | regex;

methodmatch:
               methodid | regex;

pkgid:
         NAME ('.' NAME)*;

methodid:
            NAME;

subclasses
    : '+' pkgid;

regex
    : REGEXP_LITERAL;

handlers:
            handler (',' handler)*;

handler:
           type block;

type:
        'entry' | 'exit' | 'exception';

block:
         '{' statement (';' statement)* '}';

statement: assign | functionEval;

assign: NAME ASSIGN exp terminator?;

terminator: NEWLINE | EOF;

exp_unary: VAR_REF | NUMBER | NAME | STRING_LITERAL | functionEval;

exp_plus: exp_unary '+' exp;
exp_minus: exp_unary '-' exp;
exp_mul: exp_unary '*' exp;
exp_div: exp_unary '/' exp;
exp_mod: exp_unary '%' exp;

exp_binary: exp_plus | exp_minus | exp_mul;

exp: exp_unary | exp_binary | '(' (exp_unary | exp_binary) ')';

functionEval
    : NAME '(' arguments? ')';

arguments
    : exp (',' exp)*;


// LEXER TOKENS
NAME: LETTER (LETTER | DIGIT | '_')*;
NUMBER: INTEGER | FLOAT;
fragment FLOAT: INTEGER '.' '0'..'9'+;
fragment INTEGER: '0' | '-'? '1'..'9' '0'..'9'*;
STRING_LITERAL: '"' NONCONTROL_CHAR*? '"';
REGEXP_LITERAL: '/' NONCONTROL_CHAR*? '/';
fragment NONCONTROL_CHAR: LETTER | DIGIT | SYMBOL | SPACE;
fragment LETTER: LOWER | UPPER;
fragment LOWER: 'a'..'z';
fragment UPPER: 'A'..'Z';
fragment DIGIT: '0'..'9';
fragment SPACE: [ \t];
// Note that SYMBOL does not include the double-quote character.
fragment SYMBOL: '!' | '#'..'/' | ':'..'@' | '['..'`' | '{'..'~';

VAR_REF: '@' NAME;

WS: [ \t\r\n]+ -> skip;

NEWLINE: ('\r'? '\n')+;

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
ASSIGN: '=';
TILDA: '~';
LCBRACKET: '{';
RCBRACKET: '}';
LBRACKET: '(';
RBRACKET: ')';