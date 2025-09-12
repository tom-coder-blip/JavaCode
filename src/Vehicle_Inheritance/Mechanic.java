package Vehicle_Inheritance;

public class Mechanic {
    public void testDrive(Vehicle v) {
        v.startEngine(); // polymorphism: runs the correct subclass method
        v.move();        // polymorphism
        v.stop();        // polymorphism
        System.out.println();
    }
}
