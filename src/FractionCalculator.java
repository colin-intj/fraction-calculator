// Development Began: November 05, 2021
// Originally Completed: 8:25PM CDT November 17, 2021

import java.util.Scanner;

public class FractionCalculator {
  public static void main(String[] args) {
    System.out.println("Fraction Calculator by Colin Fiedorowicz");
    System.out.println();
    Scanner scanner = new Scanner(System.in);
    calc: while (true) {
      System.out.print("> ");
      String input = scanner.nextLine().toLowerCase();
      /*
       * Exits if the user enters "exit," otherwise sets the `operandsIndex` variable to the index
       * where the operands begin.
       */
      int operandsIndex;
      if (input.equals("exit")) {
        break;
      } else if (input.startsWith("add ")) {
        operandsIndex = 4;
      } else if (input.startsWith("subtract ") || input.startsWith("multiply ")) {
        operandsIndex = 9;
      } else if (input.startsWith("divide ")) {
        operandsIndex = 7;
      } else {
        System.out.println("ERROR: Invalid expression");
        continue;
      }
      String operandsString = input.substring(operandsIndex, input.length());
      int joinerIndex = operandsString.indexOf(" & ");
      if (joinerIndex == -1) {
        System.out.println("ERROR: Missing \" & \" between operands");
        continue;
      }
      // Creates new array containing the operands that the user entered
      String[] operandsArray = {operandsString.substring(0, joinerIndex),
          operandsString.substring(joinerIndex + 3, operandsString.length())};
      /*
       * Attempts to convert the operands to fractions and prints an error message if the user
       * entered an invalid fraction.
       */
      Fraction[] fractions = new Fraction[2];
      for (int i = 0; i <= 1; i++) {
        try {
          fractions[i] = inputToFraction(operandsArray[i]);
        } catch (NumberFormatException e) {
          System.out.println("ERROR: \"" + operandsArray[i] + "\" is not a valid fraction");
          continue calc;
        }
      }
      switch (input.substring(0, operandsIndex - 1)) {
        case "add":
          fractions[0].add(fractions[1]);
          break;
        case "subtract":
          fractions[0].subtract(fractions[1]);
          break;
        case "multiply":
          fractions[0].multiply(fractions[1]);
          break;
        default:
          fractions[0].divide(fractions[1]);
          break;
      }
      System.out.println(fractions[0]); // Prints the result of the calculation
    }
    scanner.close();
  }

  private static Fraction inputToFraction(String input) {
    Fraction fraction;
    try {
      fraction = new Fraction(input);
    } catch (NumberFormatException e) {
      fraction = new Fraction(Double.parseDouble(input));
    }
    return fraction;
  }
}
