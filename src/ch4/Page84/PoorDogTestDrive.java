package ch4.Page84;

// Define a class called PoorDog
class PoorDog {
    private int size;       // Instance variable to store the dog's size
    private String name;    // Instance variable to store the dog's name

    // Getter method to access the size
    public int getSize() {
        return size;
    }

    // Getter method to access the name
    public String getName() {
        return name;
    }
}

// Test class to run the PoorDog code
public class PoorDogTestDrive {
    public static void main(String[] args) {
        PoorDog one = new PoorDog(); // Create a new PoorDog object

        // Print the size and name of the dog (default values: 0 and null)
        System.out.println("Dog size is " + one.getSize());
        System.out.println("Dog name is " + one.getName());
    }
}

