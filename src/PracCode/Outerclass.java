package PracCode;

public class Outerclass {
    static class StaticNestedClass {
        String name;
        StaticNestedClass(String name) {
            this.name = name;
        }
        void display() {
            System.out.println("Inside static nested class created by: " + name);
        }
}

    public static void main(String[] args) {
        // You can create the static nested class without creating OuterClass
        StaticNestedClass nested = new StaticNestedClass("Tom");

        nested.display();
    }
}
