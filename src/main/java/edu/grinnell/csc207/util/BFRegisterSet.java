package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * A set of registers corresponding a-z you can store a value or get a value
 * @author Samuel A. Rebelsky
 * @author Jenifer Silva
 */
public class BFRegisterSet {


  BigFraction[] array = new BigFraction[26];

  /**
   * @param register the 'letter' in which we would like to store
   * @param val the fraction to store
   */
  public void store(char register, BigFraction val) {
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (ch == register) {
        array[ch - 'a'] = val;
      } //if
    } // for

  } //store

  /**
   * @param register the 'letter' we would like to retrieve
   * @return the value in that register
   */
  public BigFraction get(char register) {
    BigFraction valueWanted = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (ch == register) {
        valueWanted = array[ch - 'a'];
      } //if
    } //for
    return valueWanted;
  } //get

} // class BFRegister
