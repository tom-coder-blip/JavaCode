package streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample7 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60, 70);

        List<Integer> firstThree = numbers.stream()
                .limit(3) //Keeps only the first n elements
                .collect(Collectors.toList());

        System.out.println(firstThree);
    }
}
