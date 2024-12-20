package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * Where we do computation using our previous value of calculator
 * @author Jenifer Silva
 */public class BFCalculator {
  

  BigFraction lastValue;

  public BFCalculator() {
    this.lastValue = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
  }

  public BigFraction get() {
    if(this.lastValue.equals(null)) {
      return new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
    }
    else {
      return this.lastValue;
    }
  }

public void add(BigFraction val) {
  this.lastValue = this.lastValue.add(val);

}

public void subtract(BigFraction val) {
  this.lastValue = this.lastValue.subtract(val);
}

public void multiply(BigFraction val) {
  this.lastValue = this.lastValue.multiply(val);
}

public void divide(BigFraction val) {
  this.lastValue = this.lastValue.divide(val);
}

public void clear () {
  this.lastValue = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
}
































}