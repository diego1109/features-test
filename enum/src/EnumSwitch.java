public class EnumSwitch {
  EnumMoneyType enumMoneyType;

  public EnumSwitch(EnumMoneyType enumMoneyType) {
    this.enumMoneyType = enumMoneyType;
  }

  public void describe(){
    switch (enumMoneyType){
      case ONE:
        System.out.println("money is :"+ enumMoneyType);
      case TWO:
        System.out.println("money is :"+ enumMoneyType);
      case FIFVE:
        System.out.println("money is :"+ enumMoneyType);
      case TEN:
        System.out.println("money is :"+ enumMoneyType);
      case FIFTY:
        System.out.println("money is :"+ enumMoneyType);
      case TWENTY:
        System.out.println("money is :"+ enumMoneyType);
        default:
          System.out.println("money finish");
    }
  }
}
