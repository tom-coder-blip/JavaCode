package ch10.Page287;

//Final instance variable must be initialized

public class Foo3 {
    final int x = 42;  // final must be initialized

    public void go() {
        System.out.println(x);  // Output: 42
    }

    public static void main(String[] args) {
        Foo3 f = new Foo3();
        f.go();
    }
}

