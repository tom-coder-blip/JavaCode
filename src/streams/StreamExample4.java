package streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample4 {
    public static void main(String[] args) {
        List<String> names = List.of("Charlie", "Alice", "Bob");

        List<String> sortedNames = names.stream()
                .sorted() // Sorts the elements (alphabetically, numerically,
                .collect(Collectors.toList());

        System.out.println(sortedNames);
    }
}
