grammar Requirement;


// parser rules

requirementQuestion : question+;


question: multipleChoice | shortAnswer | numerical | trueFalse | date | time | numericScale | yesNo | singleChoice;

singleChoice : SINGLE_CHOICE QUESTION_NUMBER phrase NEWLINE
               option+
               CORRECT_ANSWER NUMERICAL_OPTION NEWLINE
               ;

yesNo: YESNO QUESTION_NUMBER phrase NEWLINE
      CORRECT_ANSWER YES_NO NEWLINE
    ;

date: DATE QUESTION_NUMBER phrase NEWLINE
      CORRECT_ANSWER DATE_FORMAT NEWLINE
    ;

time: TIME QUESTION_NUMBER phrase NEWLINE
      CORRECT_ANSWER TIME_FORMAT NEWLINE
    ;

numericScale: NUMERIC_SCALE QUESTION_NUMBER phrase NEWLINE
              CORRECT_ANSWER NUMS NEWLINE
              ;

multipleChoice: MULTIPLE_CHOICE QUESTION_NUMBER phrase NEWLINE
                option+
                CORRECT_ANSWER MULTIPLE_CHOICE_ANSWER NEWLINE
                ;

shortAnswer: SHORT_ANSWER QUESTION_NUMBER phrase NEWLINE
             CORRECT_ANSWER phrase NEWLINE
             ;

numerical: NUMERICAL QUESTION_NUMBER phrase NEWLINE
           CORRECT_ANSWER FLOAT NEWLINE
           ;

possibleChoices : words+ UNDERSCORE;

trueFalse: TRUE_FALSE QUESTION_NUMBER phrase NEWLINE
           CORRECT_ANSWER TRUE_OR_FALSE NEWLINE
           ;

phrase : words+ PUNCTUATION_MARKS?;

option: ALPHABETICAL_OPTION phrase NEWLINE;

words : WORD | NUMS;

//Lexer rules
SINGLE_CHOICE: 'Single Choice' IDENTIFIER;
TRUE_OR_FALSE: 'true' | 'false';
CHOSING_OPTION_SELECT_MISSING_WORDS: '<option>';
QUESTION_NUMBER: LEFT_PARENTHESES NUMS RIGHT_PARENTHESES ;
IDENTIFIER: TWO_DOTS SPACE?;
MULTIPLE_CHOICE: 'Multiple Choice' IDENTIFIER;
SHORT_ANSWER: 'Short Answer' IDENTIFIER;
NUMERICAL: 'Numerical' IDENTIFIER;
TRUE_FALSE: 'True/False' IDENTIFIER;
DATE: 'Date' IDENTIFIER;
TIME: 'Time' IDENTIFIER;
YESNO: 'Yes/No' IDENTIFIER;
YES_NO: 'Yes' | 'No';
NUMERIC_SCALE: 'Numeric Scale' IDENTIFIER;
SCORE: 'Score' IDENTIFIER;
SCORE_PER_LINE: 'Score per line' IDENTIFIER;
CORRECT_ANSWER: 'Requirement' IDENTIFIER;
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
LEFT_PARENTHESES: '(';
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

WORD: (CHAR | SPECIAL_CHAR | SPACE | COMMA | DASH)+;
SPECIAL_CHAR: [º"%'];

WS: [ \t\r\n]+ -> skip;