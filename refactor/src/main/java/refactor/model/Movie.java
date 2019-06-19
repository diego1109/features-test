package refactor.model;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private Price _price;

  public Movie(String _title, int _priceCode)throws Exception {
    this._title = _title;
    setPriceCode(_priceCode);
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public String getTitle() {
    return _title;
  }

  public void setPriceCode(int _priceCode) throws Exception {
    switch (_priceCode){
      case REGULAR:
        _price = new RegularPrice();
        break;
      case CHILDRENS:
        _price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        _price = new NewReleasePrice();
        break;
      default:
        throw new IllegalAccessException("Incorrent Price Code");
    }
  }

  public int getFrequentRenterPoints(int daysRented){
    return _price.getFrequentRenterPoints(daysRented);
  }

  public double getCharge(int daysRented){
    return _price.getCharge(daysRented);
  }




}
