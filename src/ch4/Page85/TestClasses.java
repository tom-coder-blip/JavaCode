package ch4.Page85;

class Horse {
    private double height = 15.2;
    private String breed;
    // more code...
}

class AddThing {
    int a;
    int b = 12;

    public int add() {
        int total = a + b;
        return total;
    }
}

class Foo {
    int x = 3;
    public int go() {
        int z = x + 3;  // This will cause a compile-time error if run
        return z;
    }
}

public class TestClasses {
    public static void main(String[] args) {
        AddThing at = new AddThing();
        at.a = 5;
        System.out.println("Sum is: " + at.add());
        Foo thefoo = new Foo();
        if (thefoo.x > 4) {
            System.out.println("The sum is: " + thefoo.go());
        }else{
            System.out.println("I only work with numbers greater than 4 " );
        }
    }
}

