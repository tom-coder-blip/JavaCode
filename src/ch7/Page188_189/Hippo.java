package ch7.Page188_189;
//subclasses that extend Animal

//Hippo overrides eat() and makeNoise(), but still uses the default roam() from Animal.
public class Hippo extends Animal {
        public void eat() {
            System.out.println("Hippo is eating.");
        }

        public void makeNoise() {
            System.out.println("Hippo grunts.");
        }
}
