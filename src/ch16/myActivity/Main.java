package ch16.myActivity;

import java.io.*;

// Main program class
public class Main {
    public static void main(String[] args) {
        // Write object to file (serialize)
        Person p = new Person("Anele", 28);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.bin"))) {
            out.writeObject(p); // freeze-dry the object into bytes
            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read object from file (deserialize)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.bin"))) {
            Person loaded = (Person) in.readObject(); // rehydrate the object
            System.out.println(loaded.name + " is " + loaded.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

