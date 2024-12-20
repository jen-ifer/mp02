package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;


/**
 * This is the quick calculator main java file.
 * 
 * @author Jenifer Silva
 * @author Samuel A. Rebelsky
 * 
 */
public class QuickCalculator {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BigFraction firstNum = new BigFraction(args[0]);
    BigFraction secondNum = new BigFraction(args[2]);
    String operation = args[1];
    BFCalculator calculator = new BFCalculator();
    calculator.add(firstNum);

    if (operation.equals("+")) {
      calculator.add(secondNum);
    } else if (operation.equals("-")) {
      calculator.subtract(secondNum);
    } else if (operation.equals("*")) {
      calculator.multiply(secondNum);
    } else {
      calculator.divide(secondNum);
    }

    pen.println(calculator.get());
    pen.close();

  } // main
} // quickcalculator
