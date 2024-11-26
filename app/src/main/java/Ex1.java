/**
 * This class represents a simple solution for Ex1.
 * As defined here:
 * https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and
 * calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following
 * format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base),
 * “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

  static final String digits = "0123456789ABCDEFG";

  /**
   * Convert the given number (num) to a decimal representation (as int).
   * It the given number is not in a valid format returns -1.
   * 
   * @param num a String representing a number in basis [2,16]
   * @return
   */
  public static int number2Int(String num) {
    int ans = -1;
    // add your code here
    if (!isNumber(num))
      return -1;

    String[] parts = num.split("b");
    String numStr = parts[0];
    int base = parts.length == 1 ? 10 : digits.indexOf(parts[1]);

    ans = 0;
    for (int i = 0; i < numStr.length(); i++) {
      ans *= base;
      int digit = digits.indexOf(numStr.charAt(i));
      ans += digit;
    }
    ////////////////////
    return ans;
  }

  /**
   * This static function checks if the given String (g) is in a valid "number"
   * format.
   * 
   * @param a a String representing a number
   * @return true iff the given String is in a number format
   */
  public static boolean isNumber(String a) {
    boolean ans = true;
    // add your code here
    String[] parts = a.split("b");

    if (parts.length != 1 && parts.length != 2)
      return false;

    String number = parts[0];
    String base = parts.length == 1 ? "A" : parts[1];
    boolean isBase = base.length() == 1 &&
        digits.chars().anyMatch(d -> d == base.charAt(0));

    if (!isBase)
      return false;

    boolean isNumber = number.length() != 0 && number.chars().allMatch(
        c -> digits
            .substring(0, digits.indexOf(base.charAt(0))).chars()
            .anyMatch(d -> d == c));

    if (!isNumber)
      return false;

    ////////////////////
    return ans;
  }

  /**
   * Calculate the number representation (in basis base)
   * of the given natural number (represented as an integer).
   * If num<0 or base is not in [2,16] the function should return "" (the empty
   * String).
   * 
   * @param num  the natural number (include 0).
   * @param base the basis [2,16]
   * @return a String representing a number (in base) equals to num, or an empty
   *         String (in case of wrong input).
   */
  public static String int2Number(int num, int base) {
    String ans = "";
    // add your code here\
    if (num < 0 || base < 2 || base > 16)
      return "";

    while (num != 0) {
      int mod = num % base;
      ans = digits.charAt(mod) + ans;
      num /= base;
    }

    ans += "b" + digits.charAt(base);
    ////////////////////
    return ans;
  }

  /**
   * Checks if the two numbers have the same value.
   * 
   * @param n1 first number
   * @param n2 second number
   * @return true iff the two numbers have the same values.
   */
  public static boolean equals(String n1, String n2) {
    boolean ans = true;
    // add your code here

    ////////////////////
    return ans;
  }

  /**
   * This static function search for the array index with the largest number (in
   * value).
   * In case there are more than one maximum - returns the first index.
   * Note: you can assume that the array is not null and is not empty, yet it may
   * contain null or none-valid numbers (with value -1).
   * 
   * @param arr an array of numbers
   * @return the index in the array in with the largest number (in value).
   *
   */
  public static int maxIndex(String[] arr) {
    int ans = 0;
    // add your code here
    int maxValue = 0;
    for (int i = 0; i < arr.length; i++) {
      int crntValue = number2Int(arr[i]);
      if (maxValue < crntValue) {
        maxValue = crntValue;
        ans = i;
      }
    }
    ////////////////////
    return ans;
  }
}