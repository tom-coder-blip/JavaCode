package Vehicle_Inheritance;

// Airplane overrides everything
public class Airplane extends Vehicle {
    public void startEngine() {
        System.out.println("Airplane engines roar to life.");
    }

    public void move() {
        System.out.println("Airplane flies in the sky.");
    }

    public void stop() {
        System.out.println("Airplane slows down after landing.");
    }

    // Unique method
    public void deployLandingGear() {
        System.out.println("Airplane deploys landing gear.");
    }
}
