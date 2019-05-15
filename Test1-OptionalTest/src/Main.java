import java.util.Optional;
import sun.tools.tree.NewArrayExpression;

public class Main {

    public static void main(String[] args) {

        OptionalTest optionalTest = new OptionalTest();
//        optionalTest.whenCreatesEmptyOptional_thenCorrect();
//        optionalTest.givenNonNull_whenCreatesNonNullable_thenCorrect();
//        optionalTest.givenNull_whenThrowsErrorOnCreate_thenCorrent();
//        optionalTest.givenNonNull_whenCreatesNullable_thenCorrect();
//        optionalTest.givenOptional_whenIfPresentWorks_thenCorrect();
//        optionalTest.whenOrElseWorks_thenCorrect();
//        optionalTest.whenOrElseGetWorks_thenCorrect();
//        optionalTest.whenOptionalFilterWorks_thenCorrect();
//        optionalTest.givenOptional_whenIsPresentWorks_thenCorrect();
//        optionalTest.whenOrElseThrowWorks_thenCorrect();
//        optionalTest.givenOptional_whenGetsValue_thenCorrect();
        optionalTest.givenOptional_whenMapWorks_thenCorrect();
        System.out.println("--- finish all ---!");
    }

}
