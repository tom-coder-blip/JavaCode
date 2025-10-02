package exercisePg343;

// Simple class to represent a mountain with name and height
class Mountain {
    String name;
    int height;

    // Constructor to initialize mountain name and height
    Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // Custom toString method for readable output
    public String toString() {
        return name + " " + height;
    }
}