package com.example.mockito;


public class MathUtils {
  public int add(int x, int y) {
    System.out.println("--- here ---");
    return x + y;
  }

  public boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  public long squareLong(long l) {
    return l*l;
  }
}
