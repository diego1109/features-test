import static food.Food.Coffee;
import static food.Food.Dessert;
import static food.Food.MainCourse;

import constantSpecificMethod.ConstantSpecificMethod;
import food.Food;
import food.Food.Appetizer;
import trafficlight.TrafficLight;

public class Main {

    public static void trafficLight(){
        TrafficLight t = new TrafficLight();
        for(int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }

    public static void randomTest(){
        for(int i = 0; i < 20; i++)
            System.out.print(Enums.random(Activity.class) + " ");
    }

    public static void  typeOfFood(){
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;

        System.out.println(Integer.MAX_VALUE);
    }

    public static void constantMethod(){
        for(ConstantSpecificMethod csm : ConstantSpecificMethod.values())
            System.out.println(csm.getInfo());
    }

    public static void main(String[] args) {
//        trafficLight();
//        randomTest();

//        typeOfFood();
        constantMethod();
    }


}
