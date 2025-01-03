package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.Scanner;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

/**
 * Main method that will take expressions from the command line and print out results.
 *
 * @author Samuel A. Rebelsky
 * @author Jenifer Silva
 */
public class InteractiveCalculator {
  /**
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner eyes = new Scanner(System.in);
    BFRegisterSet registerSet = new BFRegisterSet();
    BFCalculator calculator = new BFCalculator();

    while (true) {
      pen.print("> ");
      pen.flush();
      String stuff = eyes.nextLine();
      if (stuff.equals("QUIT")) {
        break;
      } // if

      if (stuff.startsWith("STORE")) {
        char letter2Store = stuff.charAt(6);
        if (letter2Store >= 'a' && letter2Store <= 'z') {
          registerSet.store(letter2Store, calculator.get());
          pen.println("STORED");
        } else {
          pen.println("*** ERROR [Invalid expression] ***");
        } // else
      } else {
        String[] equation = stuff.split(" ");
        if (equation.length == 3) {
          BigFraction firstNum;
          if (equation[0].length() != 1) {
            firstNum = new BigFraction(equation[0]);
          } else {
            firstNum = registerSet.get(equation[0].charAt(0));
          } // else

          BigFraction secondNum;
          if (equation[2].length() != 1) {
            secondNum = new BigFraction(equation[2]);
          } else {
            secondNum = registerSet.get(equation[2].charAt(0));
            pen.println(secondNum);
          } // else

          String operation = equation[1];

          calculator.clear();
          calculator.add(firstNum);

          if (operation.equals("+")) {
            calculator.add(secondNum);
          } else if (operation.equals("-")) {
            calculator.subtract(secondNum);
          } else if (operation.equals("*")) {
            calculator.multiply(secondNum);
          } else {
            calculator.divide(secondNum);
          } // if
          pen.println(calculator.get());

        } else {
          pen.println("*** Error [Invalid Expression] ***");
        } // else
      } // else
    } // while
    eyes.close();
  } // main
} // class InteractiveCalculator
