grammar Dart;

start  :
     expression  EOF
  ;

expression
   :
   |   INT
   |   expression ('+' | '-') expression
   ;

INT    :  '0'..'9'+;
