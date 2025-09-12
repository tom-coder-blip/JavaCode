package ch7.Page188_189;
//subclasses that extend Animal

//Cat overrides all three methods to behave like a real cat.
public class Cat extends Animal {
    public void eat() {
        System.out.println("Cat is eating.");
    }

    public void roam() {
        System.out.println("Cat is roaming.");
    }

    public void makeNoise() {
        System.out.println("Cat meows.");
    }
}
