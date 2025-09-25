package ch10.Page287;

//Instance variable accessed from static method(doesnt work)

public class Foo2 {
    int x;

    public static void go() {
//         System.out.println(x);    // Cannot reference non-static field 'x' from static context
    }

    public static void main(String[] args) {
        go();  // You can uncomment to see the error
    }
}
