package zoo_vehicle_tracker;

public class Duck extends Animal {
    private boolean canFly;

    public Duck(String name) {
        super(name);
        this.canFly = true;
        System.out.println("Duck created: " + name + " (can fly)");
    }

    public Duck(String name, boolean canFly) {
        super(name);
        this.canFly = canFly;
        System.out.println("Duck created: " + name + " (canFly = " + canFly + ")");
    }
}