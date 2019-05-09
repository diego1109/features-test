


import demo.DotNew;
import demo.DotThis;
import demo.DotThis.Inner;
import demo.Parcel1;
import demo.Parcel2;
import demo.Parcel2.Destination;
import demo.Parcel2.Contents;
import innerclasses.Parcel11.ParcelContents;
import innerclasses.Parcel11.ParcelDestination;
import innerclasses.Parcel4;


public class Main {


  public static void parcel1() {
    Parcel1 p = new Parcel1();
    p.ship("Tasmania");
  }

  public static void parcel2() {
    Parcel2 p = new Parcel2();
    p.ship("Tasmania");
    Parcel2 q = new Parcel2();
    Contents c = q.contents();
    Destination d = q.to("Borneo");
  }

  public static void sequence() {
    Sequence sequence = new Sequence(10);
    for (int i = 0; i < 10; i++) {
      sequence.add(Integer.toString(i));
    }
    Selector selector = sequence.selector();
    while (!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }
  }

  public static void dotThis() {
    DotThis dt = new DotThis();
    Inner dti = dt.inner();
    dti.outer().f();
    dti.outer2();

  }

  public static void notNew() {
    DotNew dn = new DotNew();
    DotNew.Inner dni = dn.new Inner();
  }

  public static void parcel3() {
    Parcel3 p = new Parcel3();
    Parcel3.Contents c = p.new Contents();
    Parcel3.Destination d = p.new Destination("Tasmania");
    d.readLabel();
  }

  public static void testparcel() {
    Parcel4 p = new Parcel4();
    //父类引用指向子类对象（向上转型）
    innerclasses.Contents c = p.contents();
    innerclasses.Destination d = p.destination("Tasmania");
  }

  public static void parcel7() {
    Parcel7 p = new Parcel7();
    innerclasses.Contents c = p.contents();
    System.out.println(c.value());
  }

  public static innerclasses.Destination destination(String s) {
    return new ParcelDestination(s);
  }

  public static innerclasses.Contents contents() {
    return new ParcelContents();
  }

  public static void main(String[] args) {
//     parcel1();
//    parcel2();
//    sequence();
//    dotThis();
//    notNew();
//    parcel3();
//    testparcel();
    parcel7();
  }
}
