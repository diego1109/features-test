package collection;

public class StringAddress {
  private String s;

  @Override
  public String toString() {
    return "StringAddress{" +
        "s='" + s + '\'' +
        '}';
  }

  public StringAddress(String s) {
    this.s = s;
  }
}
