package zoo_vehicle_tracker;

public class Hippo extends Animal {
    private int weight;

    public Hippo(String name, int weight) {
        super(name); // Calls Animal constructor
        this.weight = weight;
        System.out.println("Hippo created with weight: " + weight + "kg");
    }
}
