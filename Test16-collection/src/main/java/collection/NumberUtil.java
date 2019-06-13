package collection;

public class NumberUtil {

  public static void castDemo(Object number) {
    if (number instanceof Double) {
      System.out.println(number + " is double");
    }
    if (number instanceof Float) {
      System.out.println(number + " is float");
    }
    if (number instanceof Integer) {
      System.out.println(number + " is int");
    }

    if (number instanceof String) {
      System.out.println(number + " is String");
    }
  }

}
