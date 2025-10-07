package Testing;

import java.util.*;

public class Candidate4 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        String output = "";

        for (int i = 0; i < nums.size(); i++)
            output += nums.get(i) + " ";

        System.out.println("Candidate 4 Output: " + output.trim()); // Expected: 1 2 3 4 5
    }
}