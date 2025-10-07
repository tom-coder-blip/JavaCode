package streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        List<String> shortNames = names.stream()
                .filter(name -> name.length() <= 4) //Keeps only items that match a condition
                .collect(Collectors.toList()); //Turns the stream back into a List, Set, Map, etc.

        System.out.println(shortNames);
    }
}