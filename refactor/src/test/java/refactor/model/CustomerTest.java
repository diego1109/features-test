package refactor.model;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

  Customer customer = new Customer("yy");

  @Before
  public void setUp() {
    Movie movie = null;
    try {
      movie = new Movie("King", 2);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Rental rental = new Rental(movie, 3);
    customer.addRental(rental);
  }

  @Test
  public void should_get_statement_result() {
    double result = customer.statement();
    assertThat(result, is(1.5));
    System.out.println(result);
  }
}