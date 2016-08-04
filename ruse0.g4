grammar ruse0;

@header {
package ruse0;
import java.util.*;
}

eval:    expr NEWLINE    {System.out.println($expr.v);} 
    |    NEWLINE
    ;

expr returns [Integer v]
    :    LPAREN PLUS e1=expr e2=expr RPAREN   { $v = $e1.v + $e2.v; }
    |    LPAREN MINUS e1=expr e2=expr RPAREN { $v = 0; }
         // Add matching rules for TIMES and DIVIDE
         // Add matching rules to handle arbitrarily long sequences of operands
    |    INT {$v = new Integer($INT.int);} 
    |    MINUS INT {$v = 0 - new Integer($INT.int);}
    ;

sequence returns [ArrayList<Integer> vals]
@init {
    // Add Java code here to create an ArrayList
}
     : 
         // Add the matching rule here and the Java code
         // to add elements to the ArrayList.
;


// ------ Lexer rules -------
// DO NOT MODIFY BELOW THIS POINT!

WS  :   [ \t]+ -> skip ; // ignore whitespace
INT :   [0-9]+ ;         // simple integer match
NEWLINE:'\r'? '\n' ;    
TIMES : '*' ;
DIVIDE : '/' ;
PLUS : '+' ;
MINUS : '-' ;
LPAREN: '(';
RPAREN: ')';
CAR: 'car';
CDR: 'cdr';
CONS: 'cons';
