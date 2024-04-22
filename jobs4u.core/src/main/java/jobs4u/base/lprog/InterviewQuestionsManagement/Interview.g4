grammar Interview;


//Parser rules

interviewQuestion: question+;


//Data, Time, NumericScale

question: multipleChoice | shortAnswer | numerical | trueFalse | date | time | numericScale;


date: DATE phrase NEWLINE
      SCORE FLOAT NEWLINE
      CORRECT_ANSWER DATE_FORMAT NEWLINE
    ;

time: TIME phrase NEWLINE
SCORE FLOAT NEWLINE
CORRECT_ANSWER TIME_FORMAT NEWLINE
    ;

numericScale: NUMERIC_SCALE phrase NEWLINE
              SCORE FLOAT NEWLINE
              CORRECT_ANSWER NUMS NEWLINE
              ;

multipleChoice: MULTIPLE_CHOICE phrase NEWLINE
                option+
                SCORE FLOAT NEWLINE
                CORRECT_ANSWER MULTIPLE_CHOICE_ANSWER NEWLINE
                ;

shortAnswer: SHORT_ANSWER phrase NEWLINE
             SCORE FLOAT NEWLINE
             CORRECT_ANSWER phrase NEWLINE
             ;

numerical: NUMERICAL phrase NEWLINE
           SCORE FLOAT NEWLINE
           CORRECT_ANSWER FLOAT NEWLINE
           ;

possibleChoices : words+ UNDERSCORE;

trueFalse: TRUE_FALSE phrase NEWLINE
           SCORE FLOAT NEWLINE
           CORRECT_ANSWER TRUE_OR_FALSE NEWLINE
           ;

phrase : words+ PUNCTUATION_MARKS?;

option: ALPHABETICAL_OPTION phrase NEWLINE;

words : WORD | NUMS;

//Lexer rules

TRUE_OR_FALSE: 'true' | 'false';
CHOSING_OPTION_SELECT_MISSING_WORDS: '<option>';

IDENTIFIER: TWO_DOTS SPACE?;
SECTION: 'Section' IDENTIFIER;
MATCHING: 'Matching' IDENTIFIER;
MULTIPLE_CHOICE: 'Multiple Choice' IDENTIFIER;
SHORT_ANSWER: 'Short Answer' IDENTIFIER;
NUMERICAL: 'Numerical' IDENTIFIER;
SELECT_MISSING_WORDS: 'Select Missing Words' IDENTIFIER;
TRUE_FALSE: 'True/False' IDENTIFIER;
DATE: 'Date' IDENTIFIER;
TIME: 'Time' IDENTIFIER;

NUMERIC_SCALE: 'Numeric Scale' IDENTIFIER;
SCORE: 'Score' IDENTIFIER;
SCORE_PER_LINE: 'Score per line' IDENTIFIER;
CORRECT_ANSWER: 'Correct answer' IDENTIFIER;
FEEDBACK: 'Feedback' IDENTIFIER;
ERROR_NUMERICAL: 'Error' IDENTIFIER;
POSSIBLE_CHOICES_SELECT_MISSING_WORDS: 'Possible choices' IDENTIFIER;

DATE_FORMAT: DAY '/' MONTH '/' YEAR;

NUMS: NUM+;
MULTIPLE_CHOICE_ANSWER: CHAR (',' CHAR)*;
CHAR: [a-zA-Z];
NUM: [0-9];
NEWLINE: [\r\n]+;
PUNCTUATION_MARKS: [.?!];

DOT: '.';
DASH: '-';
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
TIME_FORMAT: HOUR ':' MINUTE;

DIVISIVE: SPACE? DASH SPACE?;
FLOAT: NUMS DOT NUMS;
NUMERICAL_OPTION: [1-9]NUM? RIGHT_PARENTHESES;
ALPHABETICAL_OPTION: [a-z] RIGHT_PARENTHESES SPACE?;
MATCHING_OPTION_CORRECTION: SPACE? NUMS DASH CHAR COMMA?;

WORD: (CHAR | SPECIAL_CHAR | SPACE | COMMA)+;
SPECIAL_CHAR: [º"%'];

WS: [ \t\r\n]+ -> skip;