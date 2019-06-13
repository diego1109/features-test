package refactor.model;

public class Rental {
  private Movie _movie;
  private int daysRented;

  public Rental(Movie _movie, int daysRented) {
    this._movie = _movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  public int getDaysRented() {
    return daysRented;
  }
}
