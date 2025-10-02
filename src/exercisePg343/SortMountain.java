package exercisePg343;

import java.util.*;

    public class SortMountain {
        public static void main(String[] args) {
            new SortMountain().go(); // Start the sorting demo
        }

        public void go() {
        // Create a list of Mountain objects
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain("Longs", 14255));
        mountains.add(new Mountain("Elbert", 14433));
        mountains.add(new Mountain("Maroon", 14156));
        mountains.add(new Mountain("Castle", 14265));

        // Print the list in the order it was added
        System.out.println("as entered:\n" + mountains);

        // Sort the list alphabetically by mountain name
        mountains.sort((mount1, mount2) -> mount1.name.compareTo(mount2.name));
        System.out.println("by name:\n" + mountains);

        // Sort the list by height in descending order
        mountains.sort((mount1, mount2) -> mount2.height - mount1.height);
        System.out.println("by height:\n" + mountains);
    }
}