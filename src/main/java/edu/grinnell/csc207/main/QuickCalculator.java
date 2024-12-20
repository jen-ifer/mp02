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
    if (args.length >= 2) {
      System.err.println("Error:  not enough arguments");
      pen.close();
      return;
    } // This if is to make sure I am only given 2 parameters for this to run

    String firstNum = args[0];
    String secondNum = args[2];
    String operation = args[1];

   switch(operation) {
    case "+":
      BFCalculator.add()
   }

    




    String encoOrDeco = args[0];
    String str = args[1];
    if (encoOrDeco.equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      } // for
    } else if (encoOrDeco.equals("decode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
      } // for
    } else {
      System.err.println(
          "Error: Invalid option: " + encoOrDeco + " Valid options are \"encode\" or \"decode\".");
    } // if the user doesn't input encode or decode when running the code then we will give the user
      // an error
    pen.close();
  } // main
} // Allcaesar