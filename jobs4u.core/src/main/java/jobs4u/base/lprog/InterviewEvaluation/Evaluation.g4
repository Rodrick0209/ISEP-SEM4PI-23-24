grammar Evaluation;


//Parser rules

answers: answer+;

answer: answerToMultipleChoice | answerToShortAnswer | answerToNumerical | answerToTrueFalse | answerToDate | answerToTime | answerToNumericScale;


answerToMultipleChoice: ANSWER MULTIPLE_CHOICE_ANSWER? NEWLINE?
                        ;

answerToShortAnswer: ANSWER phrase? NEWLINE?
                     ;

answerToNumerical: ANSWER  FLOAT? NEWLINE?
                   ;

answerToTrueFalse: ANSWER TRUE_OR_FALSE? NEWLINE?
                   ;

answerToTime: ANSWER TIME? NEWLINE?
             ;

answerToDate: ANSWER DATE? NEWLINE?
             ;

answerToNumericScale: ANSWER NUMS? NEWLINE?
                      ;


phrase : words+ PUNCTUATION_MARKS?;

words : WORD | NUMS;

//Lexer rules
TRUE_OR_FALSE: 'true' | 'false';
MULTIPLE_CHOICE_ANSWER: [a-z] (',' [a-z])*;
IDENTIFIER: TWO_DOTS SPACE?;
ANSWER: NUMS DASH 'Answer' IDENTIFIER;

NUMS: NUM+;
QUESTION_NUMBER: LEFT_PARENTHESES NUMS RIGHT_PARENTHESES ;

CHAR: [a-zA-Z];
NUM: [0-9];
NEWLINE: [\r\n]+;
SPECIAL_CHAR: [º"%'];
PUNCTUATION_MARKS: [.?!];

DOT: '.';
DASH: '-';
SLASH: '/';
SPACE: ' ';
COMMA: ',';
TWO_DOTS: ':';
UNDERSCORE: '_';
RIGHT_PARENTHESES: ')';
DAY: '0'[1-9]|'1'[0-9]|'2'[0-9]|'3'[01];
MONTH: '0'[1-9]|'1'[012];
YEAR: '19' NUM NUM | '20' NUM NUM;
HOUR: '0'[0-9]|'1'[0-9]|'2'[0-3];
MINUTE: '0'[0-9]|[1-5][0-9];
DATE: DAY '/' MONTH '/' YEAR;
TIME: HOUR ':' MINUTE;
LEFT_PARENTHESES: '(';
FLOAT: NUMS DOT NUMS;
NUMERICAL_OPTION: [1-9]NUM? RIGHT_PARENTHESES;
ALPHABETICAL_OPTION: [a-z] RIGHT_PARENTHESES SPACE?;
WORD: (CHAR | SPECIAL_CHAR | SPACE | COMMA)+;
WS: [ \t\r\n]+ -> skip;