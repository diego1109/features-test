import com.sun.corba.se.spi.copyobject.CopyobjectDefaults;
import com.sun.xml.internal.xsom.impl.parser.SubstGroupBaseTypeRef;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import jdk.nashorn.internal.runtime.regexp.joni.Option;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

public class OptionalTest {

//  Optional<String> name;
//
//  public OptionalTest(){
//    this.name = Optional.empty();
//  }
//  public OptionalTest(String name) {
//    this.name = Optional.of(name);
//  }

  public void whenCreatesEmptyOptional_thenCorrect() {
    Optional<String> empty = Optional.empty();
    System.out.println(empty.isPresent());
  }

  public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
    String name = "baeldung";
    Optional<String> opt = Optional.of(name);
    System.out.println(opt.isPresent());
    System.out.println(opt);
  }

  public void givenNull_whenThrowsErrorOnCreate_thenCorrent(){
    String name = null;
    Optional<String> opt = Optional.of(name);
  }

  public void givenNonNull_whenCreatesNullable_thenCorrect() {
    String name = "baeldung";
    String name2 = null;
    Optional<String> opt = Optional.ofNullable(name2);
    System.out.println(opt);
    System.out.println(opt.isPresent());
  }

  public void givenOptional_whenIfPresentWorks_thenCorrect() {
    Optional<String> opt = Optional.of("baeldung2");
    opt.ifPresent(name -> System.out.println(name.length()));

    Optional<String> opt2 = Optional.empty();
    opt2.ifPresent(name -> System.out.println(name));
  }
  public void whenOrElseWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElse("john");
    System.out.println(name);

    String nullName1 = "ZN";
    String name1 = Optional.ofNullable(nullName1).orElse("john");
    System.out.println(name1);
  }
  public void whenOrElseGetWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
    System.out.println(name.equals("john"));
  }

  public void whenOptionalFilterWorks_thenCorrect() {
    Integer year = 2016;
    Optional<Integer> yearOptional = Optional.of(year);
    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
    System.out.println(is2016);
    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
    System.out.println(is2017);
  }

  public void givenOptional_whenIsPresentWorks_thenCorrect() {
    Optional<String> opt = Optional.of("Baeldung");
    System.out.println(opt.isPresent());

    opt = Optional.ofNullable(null);
    System.out.println(opt.isPresent());
  }
  public void whenOrElseThrowWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseThrow(
        IllegalArgumentException::new);
  }
  public void givenOptional_whenGetsValue_thenCorrect() {
    Optional<String> opt = Optional.of("baeldung");
    String name = opt.get();
    System.out.println("baeldung".equals(name) );
  }

  public void givenOptional_whenMapWorks_thenCorrect() {
    List<String> companyNames = Arrays.asList(
        "paypal", "oracle", "", "microsoft", "", "apple");

    Optional<List<String>> listOptional = Optional.of(companyNames);

    int size = listOptional
        .map(List::size)
        .orElse(0);
    System.out.println(listOptional.map(List::size));
    System.out.println(listOptional.map(list -> list.get(0)));
    System.out.println(listOptional.map(elem -> elem.size()));
    System.out.println(listOptional.map(elem -> elem.size()));

    Optional<String> name = Optional.ofNullable(null);
    int len = name.map(elem -> elem.length()).orElse(0);
    System.out.println(len);
    System.out.println(name.map(String::length));
  }
}
