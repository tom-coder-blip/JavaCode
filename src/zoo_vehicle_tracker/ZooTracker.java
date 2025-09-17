package zoo_vehicle_tracker;

public class ZooTracker {
    public static void main(String[] args) {
        System.out.println("=== Starting Zoo Tracker ===");

        Hippo h1 = new Hippo("Harry", 1500);
        Duck d1 = new Duck("Daisy");
        Duck d2 = new Duck("Donald", false);

        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle("Golf Cart");
        Vehicle v3 = new Vehicle("Truck", 4);

        // Object reassignment: original Duck is abandoned
        d1 = new Duck("NewDaisy", true); // Old Daisy is toast!

        System.out.println("=== Zoo Tracker Finished ===");
    }
}
