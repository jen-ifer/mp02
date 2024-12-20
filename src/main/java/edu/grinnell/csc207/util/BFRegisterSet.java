package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * A set of registers corresponding a-z you can store a value or get a value
 *
 * @author Samuel A. Rebelsky
 * @author Jenifer Silva
 */
public class BFRegisterSet {


  BigFraction[] array = new BigFraction[26];

  public void store(char register, BigFraction val) {
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (ch == register) {
        array[ch] = val;
      }
    } // for

  }

  public BigFraction get(char register) {
    BigFraction valueWanted = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (ch == register) {
        valueWanted = array[ch];
      }
    }
    return valueWanted;
  }

}
