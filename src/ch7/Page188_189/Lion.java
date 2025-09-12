package ch7.Page188_189;
//subclasses that extend Animal

//Lion customizes all behaviors.
public class Lion extends Animal {
    public void eat() {
        System.out.println("Lion is eating.");
    };

    public void roam() {
        System.out.println("Lion is roaming.");
    }

    public void makeNoise() {
        System.out.println("Lion roars.");
    }
}
