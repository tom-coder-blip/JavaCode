package streams;

import java.util.List;
import java.util.stream.Collectors;

public class CombinedStreamExample {
    public static void main(String[] args) {
        List<String> words = List.of("Stream", "filter", "map", "collect", "lambda");

        List<String> result = words.stream()
                .filter(w -> w.length() > 4)     // keep longer words
                .map(String::toUpperCase)        // make them uppercase
                .sorted()                        // sort alphabetically
                .limit(3)                    // only first 3
                .collect(Collectors.toList());   // gather result

        System.out.println(result);
    }
}