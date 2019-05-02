import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

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

//    String name  = Optional.ofNullable("name");

  }
}
