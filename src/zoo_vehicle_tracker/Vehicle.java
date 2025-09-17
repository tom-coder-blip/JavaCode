package zoo_vehicle_tracker;

public class Vehicle {
    private String type;
    private int capacity;

    public Vehicle() {
        this.type = "Unknown";
        this.capacity = 0;
        System.out.println("Default vehicle created.");
    }

    public Vehicle(String type) {
        this.type = type;
        this.capacity = 2;
        System.out.println("Vehicle type: " + type);
    }

    public Vehicle(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        System.out.println("Vehicle type: " + type + ", capacity: " + capacity);
    }
}
