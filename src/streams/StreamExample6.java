package streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample6 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "apple", "orange", "banana");

        List<String> uniqueFruits = fruits.stream()
                .distinct() //removes duplicates
                .collect(Collectors.toList());

        System.out.println(uniqueFruits);
    }
}
