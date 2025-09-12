package Vehicle_Inheritance;

// Superclass

public class Vehicle {
    public void startEngine() {
        System.out.println("Vehicle engine is starting...");
    }

    public void move() {
        System.out.println("Vehicle is moving...");
    }

    public void stop() {
        System.out.println("Vehicle is stopping...");
    }

    // Unique method
    public void loadCargo() {
        System.out.println("Truck is loading heavy cargo.");
    }
}
