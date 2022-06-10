# Fraction Calculator

My favorite part of the Python programming language is
[the fractions module](https://docs.python.org/3/library/fractions.html). This
module enables programmers to represent irrational numbers as fractions, thus,
increasing accuracy. Since Java doesn't have an equivalent library, I wrote a
Java class that performs a similar function; to demonstrate it, I made this
simple fraction calculator. The calculator can add, subtract, multiply, and
divide expressions containing two operands; the best part is that it also
simplifies the solutions!

## How to Install

This program requires the Java JDK to run, which you can
[download from Oracle's website](https://www.oracle.com/java/technologies/downloads/).
Once you've installed the JDK, download and extract this repository, then
navigate to it from your computer's terminal emulator. Finally, to run the
program, enter the following command:

```console
$ java -jar fraction-calculator.jar
```

If you installed the JDK correctly, then the program will begin running.

## How to Use

When the program starts, it outputs the text below:

    Fraction Calculator by Colin Fiedorowicz

    >

The closing angle bracket designates the start of each expression—similar to how
each line in Bash begins with a dollar sign. Unlike other calculators, which
take expressions in infix form, this calculator takes them in prefix form.
Expressions in prefix form place the operators _before_, not between, the
operands. For example, the equation "a + b" is represented as "+ a b" in prefix
form.

Expressions for this calculator have the following syntax:

    [add|subtract|multiply|divide] <First Operand> & <Second Operand>

You can enter the operands as either an integer, decimal, or fraction in the
form: <code><i>numerator</i>/<i>denominator</i></code>

Here are some examples of valid expressions:

    > add 1/2 & 1/2
    > subtract 2/3 & 5/12
    > multiply 4 & 0.25
    > divide 1 & 1/4

To exit the program, type "exit".
