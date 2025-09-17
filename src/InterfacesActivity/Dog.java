package InterfacesActivity;

public class Dog extends Animal implements Pet {
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public void beFriendly() {
        System.out.println("Dog wags tail");
    }

    public void play() {
        System.out.println("Dog plays fetch");
    }
}


