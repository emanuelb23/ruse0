#CSC 3311, Fall 2014, Programming Assignment 2#
#RUSE0

##Checkpoints:
While the entire assignment is due by 10/6, in order to “encourage” you to not start on 10/5, different parts of this assignment will be due at different times
you may, of course, complete parts early):

	* CP1 - 9/24

	* CP2 - 10/1

	* CP3 - 10/6

	* Extra Credit - 10/6

For the first two checkpoints, you will demonstrate, in class, that your code works on the test examples given in the assignment.  If your code does not work on the test examples you will lose (up to) 5 points from your score for the assignment.  If it is evident that you have done no work toward meeting the checkpoint, 10 points will be deducted.  For the last checkpoint, you will turn in the code for your completed parser and I will test the cons pair section and run additional tests to look at the functionality of for the simple and arbitrary length arithmetic sections.  You will work with one other person in the class on this assignment, and you will be evaluating your partner and yourself as part of what you will turn in by the due date.  The form for that evaluation will be forthcoming.

## Background
Writing an interpreter for one language in another language is a great exercise to learn about interpreted languages, programming languages in general, the language you are interpreting, and the language you are writing the interpreter in.  In this programming assignment you will be using Java as well as ANTLR to build an interpreter for a very limited subset of Scheme, called ruse0.  (Note, you may choose to use a different programming language than Java, but you will not be able to use the code I am supplying.)

[ANTLR](http://antlr.org) is a tool to automatically create lexers and parsers for programming languages.  I’m supplying you a base ANTLR grammar file `ruse0.g4` within a NetBeans project `ruse0` which you will modify.  `ruse0.g4` is the only file you will need to modify for this assignment.  You will be adding grammar rules and tweaking existing rules.

Your code will parse and execute Scheme-like arithmetic and cons expressions.  Scheme uses a parenthesized prefix notation.  For example:

`(+ 4 3)`  adds 4 and 3 together and returns 7.

`(* (- 3 1) 4)` subtracts 1 from 3 then multiplies by 4 giving the result 8.

The operators, `+`, `-`, `*`, and `/` all accept arbitrary length lists of arguments.  For example:

`(+ 1 2 3 4 5)` sums 1, 2, 3, 4, and 5 returning 15.

Scheme also has three basic primitive operators for creating pairwise data structures: `cons`, `car`, and `cdr`.  For example:

`(cons 3 4)` produces a pair with left-hand-side of 3 and right-hand-side of 4.  This is typically displayed as: `(3 . 4)`

Left and right hand sides can consist of arbitrary data, including other pairs.  For example:

`(cons (cons 1 2) (cons 3 4))`
creates a pair of 1 and 2, another of 3 and 4, then hooks those two pairs together.  The result would look like:
`((1 . 2) 3 . 4)`

(Actually, different Scheme interpreters may display those pairs differently, so:
	`((1 . 2) . (3 . 4))`
is a perfectly acceptable alternative printed version.  Mostly, I’m lazy, so that is what my print routine in `Pair.java` does.  Feel free to change it if you want!)
The operator `car` returns the left-hand-side of one of these pairs, and the operator cdr returns the right-hand-side.  For example:
`(car (cons 3 1))` returns simply, 3.
`(cdr (cons 4 (cons 1 2)))` returns the pair 1, 2 or:`(1 . 2)`

The only type you have to worry about in this exercise is integers, although real Scheme supports strings, floats, etc.

##Simple Arithmetic - CP1
The grammar/code you have been given fully implements the `+` (PLUS) operator for two operands, and negative numbers.  Also, the grammar rule is there for `-` (MINUS) but no code to produce a result.  You should complete `-`, `*`, `/`, and `%` (modulo).  Your code should properly parse and evaluate AT LEAST the following expressions:

        (+ 4 (- 2 3))
        (* (* 3 4) (* 2 (- 4 2)))
        (/ (+ 2 (- 10 4)) 2)
        (+ -2 (* 3 3))
        (% (+ 5 6) (- 9 5))

To double-check your results, run some test expressions through Dr. Racket and compare the results.  (Or try out this Scheme interpreter: www.wescheme.org. )  **The modulo operator in Racket is NOT `%` but simply the keyword `modulo`**.

##Arbitrary Length Arithmetic Expressions - CP2

Extend your arithmetic operators to work on expressions of arbitrary length.  For example, you should properly parse and execute AT LEAST the following expressions:

    (+ 3 2 4 5 3)
    (* 2 3 (+ 4 1 3) (- 8 2 1))
    (- 100 (/ 8 2 2))
    (+ (- 7 -2 -2) (* 1 2 3))
    (% 10 11 4)

You will need to add grammar rules to do this properly.  For example you might consider an additional grammar rule in
the matches for `expr` that looks like this:

    LPAREN PLUS e1=expr e2=expr s=sequence RPAREN

where the new non-terminal `sequence` is an arbitrarily long list of expr’s.  You may want to consider using Java’s 
[ArrayList class](http://www.tutorialspoint.com/java/java_arraylist_class.htm), to build up the list of things that you will add together.  Then your code for the above grammar rule would have to iterate through this `ArrayList` and add things up appropriately and return the result.  (Notice, that a preliminary grammar for `sequence` is already supplied in the `ruse0.g4`, and that this rule returns an `ArrayList` of `Integers`.  You will need to complete this rule, and the corresponding rules in `expr` for `+`, `-`, `*`, and `/` of sequences.)

Note that following ANTLR rule matches any number of expr’s greater than or equal to 1:

    ( e=expr )+

To double-check your results, run some test expressions through Dr. Racket and compare the results.  (Or try out this [Scheme interpreter](www.wescheme.org). )  **The modulo operator in Racket is NOT` %` but simply the keyword @`modulo`.  Also `modulo` only takes two arguments
in Racket, but `%` in your ruse implmentation should take an arbitrary number of arguments!**

##cons pairs - CP3

You need to make your parser correctly parse and evaluate `cons`, `car`, and @`cdr` expressions involving integers.  Java code is provided for you that implements a simple Pair class (see `Pair.java`).  The class `Pair` overrides `tostring()` so you can simply call any standard Java print routine to output your pair.  Your code should properly parse and evaluate at least the following expressions:

    (cons (cons 3 4) 9)
    (cons 5 6)
    (car (cons (cons 1 2) 3))
    (cdr (cons 3 (cons 1 2)))
    (car (cdr (cons 3 (cons (cons 4 5) 6))))


Notice that `cons` can take either an integer or another cons-pair as arguments.  For this section, you should assume that `car` and `cdr` 
always return cons pairs.  That is `(car (cons 1 2))` does **not** have to work correctly (since in this case `car` would need
to return a single integer instead of a pair.)

You should begin by adding a an additional rule to the grammar rule for `eval` like this:

    |  conspair NEWLINE    {System.out.println($conspair.p);}

Within the new non-terminal `conspair` you will add rules to match `cons`, `car`, and `cdr`.  You will start `conspair` like this:

    conspair returns [Pair p]

##Extra Credit (due with CP3)

The parser you built in the previous section (probably) allows evaluation of arithmetic *or* evaluation of `cons`/`car`/`cdr` expressions but not mixed together.  In real Scheme, however, these can be mixed as long as the types line up.  For example:
`(+ 1 (cons 3 4))`
would result in an error since we can’t add a cons-pair to an integer.  But:

`(+ 6 (car (cons 3 4)))`

is perfectly legal, since the `car` expression evaluates to 3.  The whole expression would then evaluate to 9.  This is also legal: 
`(cons (+ 3 4) (- 8 2))`
resulting in the cons-pair `(7 . 6)`

This is tricky to do completely in a simple grammar/action system.  See what you can do with mixing the types, and at least try to get some combinations working.  In another lab you will build abstract syntax trees that will be evaluated in Java code apart from the grammar rules, and things like type-checking become much easier.  But for this lab, just try to use the ANTLR file with Java code attached to the rules.

You have the potential to earn up to 5 bonus points depending on how many different expressions your interpreter will correctly evaluate.  Here are the 10 expressions I will try.  You will earn 1/2 bonus point for each expression that is interpreted correctly.


    (car (cons 3 (+ 4 5)))
    (cons (* 1 2) (- 8 1))
    (cons (cons 3 4) (* 4 5))
    (+ (car (cons 2 3)) (car (cons 2 3)) 8)
    (/ (cdr (cons 7 10)) 2 1)
    (- (car (cons 9 3)) (cdr (cons 9 3)))
    (car (cons (cdr (cons (* 2 2) (cons (* 3 3) (* 4 4)))) (cons 4 5)))
    (* 4 2 (cdr (cons 5 5)))
    (cdr (cons 4 (cons (+ 1 1 1) (- 1 1 1))))
    (cons (+ -1 -4 3 4) (* 1 2 3 4))]

Some of these, like `(cons (cons 3 4) (* 4 5))` will be easy to do with a simple change to your `conspair` rule.  (If you haven't
already implemented it that way.)  The others may be more of a challenge.  The catch can be illustrated by the following example.
`(car (cons 3 (+ 4 5)))` should return simply the integer `3`.  However, 

    (car (cons (cons 1 2) 3))

would return
the Pair `(1 . 2)`.  You'll need to create different matching rules to catch different kinds of conspairs.  For example you
could have a matching rule for `cons_int_int`, which would match a conspair with only 2 ints in it.  Then you could add a matching rule
to `expr` that would match `car` or `cdr` of a `pair_int_int`.  You could have a matching rule for `cons_pair_pair` which would represent
a conspair consisting of two other pairs.  You would *not* match `car` or `cdr` to this in `expr` since neither the right-hand
side or the left-hand side of the pair is a simple integer.  However, you could add a rule to match `car` of a `cons_pair_pair` within your `conspair` rule since it returns a `Pair`.