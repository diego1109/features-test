package demo;//: innerclasses/demo.Parcel2.java
// Returning a reference to an inner class.

public class Parcel2 {

  public class Contents {

    private int i = 11;

    public int value() {
      return i;
    }
  }

  public class Destination {

    private String label;

    Destination(String whereTo) {
      label = whereTo;
    }

    String readLabel() {
      return label;
    }
  }

  public Destination to(String s) {
    return new Destination(s);
  }

  public Contents contents() {
    return new Contents();
  }

  public void ship(String dest) {
    Contents c = contents();
    Destination d = to(dest);
    System.out.println(d.readLabel());
  }

} /* Output:
Tasmania
*///:~
