package streams;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "cherry", "blueberry");

        fruits.stream()  // turn the list into a Stream
                .filter(f -> f.startsWith("b")) // keep only items starting with 'b'
                .forEach(System.out::println);  // print each one
    }
}
