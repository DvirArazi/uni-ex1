import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar
 * solution implement all needed functions.
 *
 */
public class Ex1Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String num1 = "", num2 = "", quit = "quit";
    while (!num1.equals(quit) && !num2.equals(quit)) {
      System.out.println();
      System.out.println("Ex1 class solution:");
      System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
      num1 = sc.next();
      if (!num1.equals("quit")) {
        // add your code here
        boolean isNumber = Ex1.isNumber(num1);
        int num = Ex1.number2Int(num1);

        System.out.println(
            "num1= " + num1 +
                " is number: " + isNumber +
                " , value: " + num);

        if (!isNumber) {
          System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
          continue;
        }

        System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
        num2 = sc.next();

        if (num2.equals("quit")) {
          break;
        }

        boolean isNumber2 = Ex1.isNumber(num2);
        int num_2 = Ex1.number2Int(num2);

        System.out.println(
            "num2= " + num2 +
                " is number: " + isNumber2 +
                " , value: " + num_2);

        if (!isNumber2) {
          System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
          continue;
        }

        System.out.println("Enter a base for output: (a number [2,16]");
        int base = sc.nextInt();

        if (base < 2 || base > 16) {
          System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
          continue;
        }

        String plus = Ex1.int2Number(num + num_2, base);
        String mult = Ex1.int2Number(num * num_2, base);

        System.out.println(num1 + " + " + num2 + " = " + plus);
        System.out.println(num1 + " * " + num2 + " = " + mult);
        System.out.println(
            "Max number over [" +
                num1 + "," + num2 + "," + plus + "," + mult +
                "] is: " + Ex1.int2Number(Math.max(num + num_2, num * num_2), base));

        /////////////////////
      }
    }
    System.out.println("quiting now...");

    sc.close();
  }
}
