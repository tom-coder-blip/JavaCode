package ch7.Page188_189;
//subclasses that extend Animal

//Dog inherits makeNoise() and roam() from Animal, but it overrides eat() to say something specific for dogs.
public class Dog extends Animal {

    public void eat() {
        System.out.println("Dog is eating.");
    }
}
