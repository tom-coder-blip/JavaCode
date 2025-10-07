package Testing;

import java.util.*;

public class Candidate1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        String output = "";

        for (int i = 1; i < nums.size(); i++)
            output += nums.get(i) + " ";

        System.out.println("Candidate 1 Output: " + output.trim()); // Expected: 2 3 4 5
    }
}
