package refactor;

import refactor.model.Customer;
import refactor.model.Movie;
import refactor.model.Rental;

public class Main {
  public static void main(String[] args){
    Customer customer = new Customer("yy");
    Movie movie = new Movie("King",5);
    Rental rental = new Rental(movie,3);
    customer.addRental(rental);
    String result = customer.statement();

    System.out.println("result:"+result);
    System.out.println("--- finish all ---");
  }
}
