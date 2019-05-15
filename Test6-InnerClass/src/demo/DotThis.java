package demo;//: innerclasses/demo.DotThis.java
// Qualifying access to the outer-class object.

public class DotThis {

  public void f() {
    System.out.println("demo.DotThis.f()");
  }

  public class Inner {

    public DotThis outer() {
      return DotThis.this;
      // A plain "this" would be Inner's "this"
    }

    public void outer2(){
      f();
    }
  }

  public Inner inner() {
    return new Inner();
  }

} /* Output:
demo.DotThis.f()
*///:~
