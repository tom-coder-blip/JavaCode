package JavaPrac;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        // Compiler infers the generic types from the left-hand side
        Map<String, List<? extends CharSequence>> stateTitleMap = new HashMap<>();

        List<String> titles = new ArrayList<>();
        titles.add("Premier");
        titles.add("Councillor");

        stateTitleMap.put("ZA", titles);

        System.out.println(stateTitleMap);
    }
}