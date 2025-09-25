package JavaPrac;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        // Java infers the full type from the right-hand side
        var stateTitleMap = new HashMap<String, List<? extends CharSequence>>();

        List<String> titles = new ArrayList<>();
        titles.add("President");
        titles.add("Senator");

        stateTitleMap.put("US", titles);

        System.out.println(stateTitleMap);
    }
}
