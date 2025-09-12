package Vehicle_Inheritance;

// Truck overrides startEngine() and stop()
public class Truck extends Vehicle {
    public void startEngine() {
        System.out.println("Truck engine starts with a loud roar.");
    }

    public void stop() {
        System.out.println("Truck uses air brakes to stop.");
    }
}