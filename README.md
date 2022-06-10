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

The syntax of the calculator commands is:

    [operation] [fraction] & [fraction]

The list of appropiate operations are:

- add
- subtract
- multiply
- divide

Fractions can be entered as either a decimal, whole number, or fraction in the
form: "[numerator] / [denominator]"

To exit the program, type "exit".

## Sample Run

    Fraction Calculator by Colin Fiedorowicz

    > add 1/2 & 1/2
    1/1
    > exit

    PROGRAM TERMINATED
