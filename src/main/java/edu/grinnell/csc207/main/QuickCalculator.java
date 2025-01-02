package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;


/**
 * This is the quick calculator main java file.
 * @author Jenifer Silva
 * @author Samuel A. Rebelsky
 */
public class QuickCalculator {
  /**
   * @param args The arguments in the command line
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet registerSet = new BFRegisterSet();

    for (int i = 0; i < args.length; i++) {
      if (args[i].startsWith("STORE")) {
        char letter2Store = args[i].charAt(6);
        registerSet.store(letter2Store, calculator.get());
        pen.println("STORE" + letter2Store + "-> STORED");
        pen.println(letter2Store + "->" + calculator.get());

      } else if ((args[i].indexOf(" ")) == -1) {
        pen.println(args[i] + "->" + args[i]);
      } else {
        String[] equation = args[i].split(" ");
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
        pen.println(firstNum + operation + secondNum + "->" + calculator.get());
      } // else
    } // for
    pen.close();
  } // main
} // quickcalculator
