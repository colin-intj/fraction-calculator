public class Fraction {

  private double numerator;
  private double denominator;

  /**
   * Creates a new Fraction object and simplifies it.
   *
   * @param numerator The numerator of the fraction
   * @param denominator The denominator of the fraction
   */
  public Fraction(double numerator, double denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    simplify();
  }

  /**
   * Creates a new Fraction object and simplifies it.
   *
   * @param doubleNumber Double number to convert to a fraction
   */
  public Fraction(double doubleNumber) {
    this.numerator = doubleNumber;
    this.denominator = 1;
    simplify();
  }

  /**
   * Creates a new Fraction object and simplifies it.
   *
   * @param stringFraction String in form "[numerator]/[denominator]" to convert to fraction
   */
  public Fraction(String stringFraction) {
    int SLASH_INDEX = stringFraction.indexOf('/');
    if (SLASH_INDEX == -1) {
      throw new NumberFormatException(
          "Make sure that fraction is in the form: \"[numerator]/[denominator]\"");
    }
    try {
      this.numerator = Double.parseDouble(stringFraction.substring(0, SLASH_INDEX));
      this.denominator =
          Double.parseDouble(stringFraction.substring(SLASH_INDEX + 1, stringFraction.length()));
      simplify();
    } catch (NumberFormatException e) {
      throw new NumberFormatException(
          "Make sure that fraction is in the form: \"[numerator]/[denominator]\"");
    }
  }

  private void simplify() {
    if (numerator != (int) numerator || denominator != (int) denominator) {
      int[] numFrac = fracArr(numerator);
      int[] denFrac = fracArr(denominator);
      numerator = numFrac[0] * denFrac[1];
      denominator = numFrac[1] * denFrac[0];
    }
    final double GCD = gcd(numerator, denominator);
    numerator /= GCD;
    denominator /= GCD;
  }

  private int[] fracArr(double doubleNum) {
    int[] fracArr = new int[2];
    if (doubleNum != (int) doubleNum) {
      String decStr = String.valueOf(doubleNum - (int) doubleNum);
      decStr = decStr.substring(2, decStr.length());
      fracArr[0] = (int) (doubleNum * Math.pow(10, decStr.length()));
      fracArr[1] = (int) Math.pow(10, decStr.length());
    } else {
      fracArr[0] = (int) doubleNum;
      fracArr[1] = 1;
    }
    return fracArr;
  }

  private double gcd(double num1, double num2) {
    return num2 == 0 ? num1 : gcd(num2, num1 % num2);
  }

  public int getNumerator() {
    return (int) numerator;
  }

  /**
   * Sets a new value for the numerator and then simplifies the fraction.
   */
  public void setNumerator(double numerator) {
    this.numerator = numerator;
    simplify();
  }

  public int getDenominator() {
    return (int) denominator;
  }

  /**
   * Sets a new value for the denominator and then simplifies the fraction.
   */
  public void setDenominator(double denominator) {
    this.denominator = denominator;
    simplify();
  }

  /**
   * Adds a second fraction to the current fraction object and simplifies it.
   *
   * @param addend Fraction to add
   */
  public void add(Fraction addend) {
    numerator = numerator * addend.getDenominator() + addend.getNumerator() * denominator;
    denominator *= addend.getDenominator();
    simplify();
  }

  /**
   * Subtracts a second fraction to the current fraction object and simplifies it.
   *
   * @param subtrahend Fraction to subtract
   */
  public void subtract(Fraction subtrahend) {
    numerator = numerator * subtrahend.getDenominator() - subtrahend.getNumerator() * denominator;
    denominator *= subtrahend.getDenominator();
    simplify();
  }

  /**
   * Multiplies a second fraction to the current fraction object and simplifies it.
   *
   * @param multiplicand Fraction to multiply
   */
  public void multiply(Fraction multiplicand) {
    numerator *= multiplicand.getNumerator();
    denominator *= multiplicand.getDenominator();
    simplify();
  }

  /**
   * Divides the current fraction object from a second fraction passed as the parameter and
   * simplifies the resulting fraction.
   *
   * @param divisor Fraction to divide
   */
  public void divide(Fraction divisor) {
    numerator *= divisor.getDenominator();
    denominator *= divisor.getNumerator();
    simplify();
  }

  /**
   * Returns the fraction as a String in the form: "[numerator] / [denominator]".
   */
  @Override
  public String toString() {
    return (int) numerator + "/" + (int) denominator;
  }
}
