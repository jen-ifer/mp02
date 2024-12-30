// package edu.grinnell.csc207.main;

// import java.io.PrintWriter;
// import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
// import edu.grinnell.csc207.util.BFCalculator;
// import edu.grinnell.csc207.util.BFRegisterSet;
// import edu.grinnell.csc207.util.BigFraction;

// /**
//  * Main method that will take expressions from the command line and print out results
//  *
//  * @author Samuel A. Rebelsky
//  * @author Jenifer Silva
//  */
// public class InteractiveCalculator {
//   public static void main(String[] args) {

//     PrintWriter pen = new PrintWriter(System.out, true);
//     BFRegisterSet reg = new BFRegisterSet();
//     BFCalculator calculator = new BFCalculator();

//     boolean STORE = false;
//     boolean add = false;
//     boolean subtract = false;
//     boolean divide = false;
//     boolean multiply = false;
//     BigFraction firstNum;
//     BigFraction secondNum;

//     for (int i = 0; i < args.length; i++) {
//       if (args[0].equals("STORE")) {
//         char register = args[1].charAt(6);
//         reg.store(register, calculator.get());
        
//       } else if (args[i].equals("+")) {
//         add = true;
//         calculator.add(firstNum);

//       } else if (args[i].equals("-")) {
//         subtract = true;
//       } else if (args[i].equals("/")) {
//         divide = true;
//       } else if (args[i].equals("*")) {
//         multiply = true;
//       } else {
//         return;
//       }
//     } // if



//     if (STORE) {
      
//     } // if

//     if (caesar && decode) {
//       pen.println(CipherUtils.caesarDecrypt(word, caesarKey));
//     } // if

//     if (vigenere && encode) {
//       String result;
//       result = CipherUtils.vigenereEncrypt(word, key);
//       if (result != null && !result.isEmpty()) {
//         pen.println(result);
//       } // if
//     } // if

//     if (vigenere && decode) {
//       String result;
//       result = CipherUtils.vigenereDecrypt(word, key);
//       if (result != null && !result.isEmpty()) {
//         pen.println(result);
//       } // if
//     } // if
//   } // main
// } // Cipher
