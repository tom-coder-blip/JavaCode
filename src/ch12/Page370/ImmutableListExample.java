package ch12.Page370;

import java.util.List;

public class ImmutableListExample {
    public static void main(String[] args) {
        List<String> colors = List.of("Red", "Blue", "Yellow");

        for (String color : colors) {
            System.out.println(color);
        }
    }
}
