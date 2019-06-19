package refactor.model;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

  private String _name;
  private Vector _rentals = new Vector();

  public Customer(String _name) {
    this._name = _name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }


  public double statement() {
    int frequentRenterPoints = 0;
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
    }
    frequentRenterPoints = getTotalFrequentRenterPoints();
    return getTotalCharge();
  }

  private double getTotalCharge(){
    double result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()){
      Rental each = (Rental)rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  private int getTotalFrequentRenterPoints(){
    int result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()){
      Rental each = (Rental)rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

}
