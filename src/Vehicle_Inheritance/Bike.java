package Vehicle_Inheritance;

// Bike overrides only move()
public class Bike extends Vehicle {
    public void move() {
        System.out.println("Bike pedals forward.");
    }

    // Unique method
    public void ringBell() {
        System.out.println("Bike bell rings: Tring tring!");
    }
}
