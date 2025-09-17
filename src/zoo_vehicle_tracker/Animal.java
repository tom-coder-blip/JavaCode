package zoo_vehicle_tracker;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal created: " + name);
    }

    public String getName() {
        return name;
    }
}
