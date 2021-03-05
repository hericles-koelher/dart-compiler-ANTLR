grammar Dart;

start: expression EOF;

expression:
    | NUMBER
    | expression '+' expression
    ;

NUMBER:
    '0'..'9';