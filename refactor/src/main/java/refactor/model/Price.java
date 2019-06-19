package refactor.model;

abstract class Price {
  abstract int getPriceCode();

  abstract double getCharge(int daysRented) ;


  public int getFrequentRenterPoints(int dayRented) {
    return 1;
  }
}
