package InterfacesActivity;

public class Parrot extends Animal implements Pet {
    public void makeSound() {
        System.out.println("Parrot squawks");
    }

    public void beFriendly() {
        System.out.println("Parrot mimics your voice");
    }

    public void play() {
        System.out.println("Parrot plays with toys");
    }
}
