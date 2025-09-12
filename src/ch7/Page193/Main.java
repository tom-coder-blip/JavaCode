package ch7.Page193;

public class Main {
    public static void main(String[] args) {
        Overloads obj = new Overloads();

        // Test overloaded addNums
        System.out.println("int addNums: " + obj.addNums(3, 4));          // Should print 7
        System.out.println("double addNums: " + obj.addNums(3.5, 4.5));   // Should print 8.0

        // Test overloaded setUniqueID
        obj.setUniqueID("ABC123");
        System.out.println("Unique ID (string): " + obj.getUniqueID());

        obj.setUniqueID(98765);  // Calls int version, which internally calls String version
        System.out.println("Unique ID (int): " + obj.getUniqueID());
    }
}
