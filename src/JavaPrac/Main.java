package JavaPrac;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Declare and initialize the map
        Map<String, List<String>> stateCitiesMap = new HashMap<>();

        // Create a list of cities
        List<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Albany");

        // Put the list into the map under the key "NY"
        stateCitiesMap.put("NY", cities);

        // Print the map to verify
        System.out.println(stateCitiesMap);

    }
}
