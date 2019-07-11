package soundsystem;

//@Component
public class StgPeppers implements CompactDisc {

  private String title = "title";
  private String artist = "artist";

  @Override
  public void play() {
    System.out.println("play "+title+" by "+artist);
  }
}
