import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamTest {

    public void streamTest1(){

      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
      List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(
          Collectors.toList());

      System.out.println("筛选列表: " + filtered);
      String mergedString = strings.stream().filter(string -> !string.isEmpty())
          .collect(Collectors.joining(", "));
      System.out.println("合并字符串: " + mergedString);

      System.out.println("---- finish all ----");
      String mergedString2 = strings.stream().filter(string -> !string.isEmpty())
          .collect(Collectors.joining("--"));
      System.out.println("合并字符串: " + mergedString2);

    }

  /**
   * distinct:保证输出流中包含唯一元素，去重操作
   */
  public void distinct(){
      List<String> str = new ArrayList<String>();
      str.add("a");
      str.add("b");
      str.add("c");
      str.add("b");
      System.out.println(str);
      List<String>l = str.stream().distinct().collect(Collectors.toList());
      System.out.println(l);
    }

  /**
   * filter:返回流中只满足断言(predicate)的数据
   */
  public void filter(){
    List<Integer> l = IntStream.range(1,10)
        .filter( i -> i % 2 == 0)
        .boxed()
        .collect(Collectors.toList());
    System.out.println(l); //[2, 4, 6, 8]

  }

  /**
   * map:将流中的元素映射成另外的值，新的值类型可以和原来的类型不同
   */
  public void map(){
    List<Integer> l = Stream.of('a','b','c')
        .map( c -> c.hashCode())
        .collect(Collectors.toList());
    System.out.println(l); //[97, 98, 99]
  }

  public void reduce(){
    Optional<Integer> total = Stream.of(1,2,3,4,5).reduce( (x, y) -> x +y);
    System.out.println(total);
  }

  public void mapValueMethod(){
    Map<String,Integer> m = new HashMap<String,Integer>();

    m.put("zhangsan", 19);
    m.put("lisi", 49);
    m.put("wangwu", 19);
    m.put("lisi",20);
    m.put("hanmeimei", null);
    System.out.println(m);

    System.out.println(m.values());
  }
}

class User {
  private String name;
  private String age;
}