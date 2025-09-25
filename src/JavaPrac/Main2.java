package JavaPrac;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        // Create the map
        Map<String, List<String>> stateCitiesMap = new HashMap<>();

        // Cities for NY
        List<String> nyCities = new ArrayList<>();
        nyCities.add("New York");
        nyCities.add("Albany");
        stateCitiesMap.put("NY", nyCities);

        // Cities for CA
        List<String> caCities = new ArrayList<>();
        caCities.add("Los Angeles");
        caCities.add("San Francisco");
        stateCitiesMap.put("CA", caCities);

        // Print the map
        System.out.println(stateCitiesMap);
    }
}
