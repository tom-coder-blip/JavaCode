package streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(n -> n * n) //Transforms each item into something else
                .collect(Collectors.toList());

        System.out.println(squares);
    }
}
