package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * Where we do computation using our previous value of calculator.
 * @author Jenifer Silva
 */
public class BFCalculator {


  /**
   * The previous or value we are adding to.
   */
  BigFraction lastValue;

  /**
   * create a fraction that starts with num=0, denom=1.
   */
  public BFCalculator() {
    this.lastValue = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
  } //BFCalculator()

  /**
   * @return the last value calculated
   */
  public BigFraction get() {
    if (this.lastValue.equals(null)) {
      return new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
    } else {
      return this.lastValue;
    } //else
  } //get()

  /**
   * @param val the 2nd value you want to add to the 1st
   */
  public void add(BigFraction val) {
    this.lastValue = this.lastValue.add(val);
  } //add(BigFraction val)

  /**
   * @param val the 2nd value you want to subtract to the 1st
   */
  public void subtract(BigFraction val) {
    this.lastValue = this.lastValue.subtract(val);
  } //subtract(BigFraction val)

  /**
   * @param val the 2nd value you want to multiply to the 1st
   */
  public void multiply(BigFraction val) {
    this.lastValue = this.lastValue.multiply(val);
  } //multiply(BigFraction val)

  /**
   * @param val the 2nd value you want to divide to the 1st
   */
  public void divide(BigFraction val) {
    this.lastValue = this.lastValue.divide(val);
  } //divide(BigFraction val)

  /**
   * clears lastValue back to num=0 denom = 1.
   */
  public void clear() {
    this.lastValue = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
  } //clear()

} //class BFCalculator
