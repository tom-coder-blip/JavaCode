package ch4.Page73;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog one = new Dog(); //instance
        one.size = 70;
        Dog two = new Dog();
        two.size = 8;
        Dog three = new Dog();
        three.size = 35;
        one.bark();
        two.bark();
        three.bark();
    }
}
