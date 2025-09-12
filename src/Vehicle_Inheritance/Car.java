package Vehicle_Inheritance;

// Car overrides all behaviors
public class Car extends Vehicle {

    // inherited methods
    public void startEngine() {
        System.out.println("Car engine starts with a key or button.");
    }

    public void move() {
        System.out.println("Car drives on the road.");
    }

    public void stop() {
        System.out.println("Car stops using brakes.");
    }

    // Unique method
    public void honk() {
        System.out.println("Car honks: Beep beep!");
    }
}
