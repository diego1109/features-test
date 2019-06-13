package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.ls.LSException;

public class Main {


  public static void cast() {
    NumberUtil.castDemo(12.3);
    NumberUtil.castDemo(12);
    NumberUtil.castDemo("sgd");
  }

  public static void fillingLists() {
    List<StringAddress> list = new ArrayList<StringAddress>(
        Collections.nCopies(3, new StringAddress("hello")));
    System.out.println(list);
    Collections.fill(list,new StringAddress("world!"));
    System.out.println(list);

    List<StringAddress> list2 = new ArrayList<>();
    Collections.fill(list2,new StringAddress("yy"));
  }

  public static void main(String[] args) {

//    cast();
    fillingLists();

    System.out.println("--- finish all ---");
  }
}
