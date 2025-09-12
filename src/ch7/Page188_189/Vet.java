package ch7.Page188_189;
//This class contains the method giveShot(Animal a) that takes any Animal

public class Vet {
    public void giveShot(Animal a) {
        // do horrible things to the Animal at the other end of the 'a' parameter
        a.makeNoise();
        System.out.println(); // Adds a blank line
    }

    // New method to handle other behaviors
    public void checkAnimal(Animal a) {
        a.roam();
        a.eat();
        System.out.println();
    }
}
