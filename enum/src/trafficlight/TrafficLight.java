package trafficlight;//: enumerated/trafficlight.TrafficLight.java
// Enums in switch statements.


// Define an enum type:
enum Signal { GREEN, YELLOW, RED, }

public class TrafficLight {

  Signal color = Signal.RED;

  public static final String NAME = "ll";

  public void change() {
    switch (color) {
      // Note that you don't have to say trafficlight.Signal.RED
      // in the case statement:
      case RED:
        color = Signal.GREEN;
        break;
      case GREEN:
        color = Signal.YELLOW;
        break;
      case YELLOW:
        color = Signal.RED;
        break;
    }
  }

  public String toString() {
    return "The traffic light is " + color;
  }

}
