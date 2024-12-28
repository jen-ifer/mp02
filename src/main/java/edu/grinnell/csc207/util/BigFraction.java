package edu.grinnell.csc207.util;

import java.math.BigInteger;
import java.util.function.BiFunction;

/**
 * A simple implementation of arbitrary-precision Fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Jenifer Silva
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+

  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented with a
   * negative numerator. Similarly, if a fraction has a negative numerator, it is negative.
   *
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction in simplified
   * form, one must call the `simplify` method.
   */

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /** The default numerator when creating fractions. */
  private static final BigInteger DEFAULT_NUMERATOR = BigInteger.valueOf(2);

  /** The default denominator when creating fractions. */
  private static final BigInteger DEFAULT_DENOMINATOR = BigInteger.valueOf(7);

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   *
   * @param numerator The numerator of the fraction.
   * @param denominator The denominator of the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   *
   * @param numerator The numerator of the fraction.
   * @param denominator The denominator of the fraction.
   */
  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);
  } // BigFraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * @param str The fraction in string form
   */
  public BigFraction(String str) {
    this.num = DEFAULT_NUMERATOR;
    this.denom = DEFAULT_DENOMINATOR;
  } // BigFraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   *
   * @return the fraction approxiamted as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()


  /**
   * Get the denominator of this fraction.
   *
   * @return the denominator
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   *
   * @return the numerator
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Convert this fraction to a string for ease of printing.
   *
   * @return a string that represents the fraction.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string representation of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  // MUltiply 2 fractions
  public BigFraction multiply(BigFraction other) {
    BigInteger top = this.num.multiply(other.num);
    BigInteger bottom = this.denom.multiply(other.denom);
    return new BigFraction(top, bottom);
  }

  public BigFraction fractional() {
    BigInteger top = this.num;
    BigInteger bottom = this.denom;
    BigInteger holder = (top.mod(bottom));
    BigInteger newTop = (bottom.subtract(holder));
    return new BigFraction(newTop, bottom);
  }


  public BigFraction subtract(BigFraction other) {
    BigInteger topF = this.num;
    BigInteger bottomF = this.denom;
    BigInteger topO = other.num;
    BigInteger bottomO = other.denom;

    if(!bottomF.equals(bottomO)) {
      BigInteger commonDenom = bottomF.multiply(bottomO).divide(bottomF.gcd(bottomO));
      topF = topF.multiply((commonDenom.divide(bottomF)));
      topO = topO.multiply((commonDenom.divide(bottomO)));
      bottomF = commonDenom;
    }
    BigInteger endTop = topF.subtract(topO);
    return new BigFraction(endTop,bottomF);
  }

  public BigFraction add(BigFraction other) {
    BigInteger topF = this.num;
    BigInteger bottomF = this.denom;
    BigInteger topO = other.num;
    BigInteger bottomO = other.denom;

    if(!bottomF.equals(bottomO)) {
      BigInteger commonDenom = bottomF.multiply(bottomO).divide(bottomF.gcd(bottomO));
      topF = topF.multiply((commonDenom.divide(bottomF)));
      topO = topO.multiply((commonDenom.divide(bottomO)));
      bottomF = commonDenom;
    }
    BigInteger endTop = topF.add(topO);
    return new BigFraction(endTop,bottomF);

  }

  public BigFraction divide(BigFraction other) {
    BigInteger topF = this.num;
    BigInteger bottomF = this.denom;
    BigInteger reciprocalTopO = other.denom;
    BigInteger reciprocalBottomO = other.num;

    BigInteger finalTop = topF.multiply(reciprocalTopO);
    BigInteger finalBot = bottomF.multiply(reciprocalBottomO);
    return new BigFraction(finalTop,finalBot);

  }

  public BigFraction simplify(BigInteger firstNum, BigInteger secondNum) {
    BigInteger divisor = firstNum.gcd(secondNum);
    firstNum = firstNum.divide(divisor);
    secondNum = secondNum.divide(divisor);
    return new BigFraction(firstNum,secondNum);

  }
} // class BigFraction
