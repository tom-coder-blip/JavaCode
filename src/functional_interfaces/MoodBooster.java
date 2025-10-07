package functional_interfaces;

import java.util.function.Consumer;

public class MoodBooster {
    public static void main(String[] args) {
        Consumer<String> cheerUp = name -> System.out.println("Hey " + name + "! You’re awesome today! 😄");

        cheerUp.accept("Tom");
        cheerUp.accept("Luna");
        cheerUp.accept("Alex");
    }
}
