package ch5.SinkTheStartup;

// Main class to test the SimpleStartup game
public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        SimpleStartup dot = new SimpleStartup(); // Create a startup object
        int[] locations = {2, 3, 4};              // Set its location on the grid
        dot.setLocationCells(locations);         // Assign locations to the startup

        int userGuess = 2;                        // Simulate a user guess
        String result = dot.checkYourself(userGuess); // Check the guess

        String testResult = "failed";            // Default test result
        if (result.equals("hit")) {              // If guess was a hit
            testResult = "passed";               // Mark test as passed
        }
        System.out.println(testResult);          // Print the test result
    }
}

// Class that handles startup logic
class SimpleStartup {
    private int[] locationCells;                 // Stores startup location
    private int numOfHits = 0;                   // Tracks number of hits

    public void setLocationCells(int[] locs) {   // Set location cells
        locationCells = locs;
    }

    public String checkYourself(int guess) {     // Check user's guess
        String result = "miss";                  // Default result
        for (int cell : locationCells) {         // Loop through location cells
            if (guess == cell) {                 // If guess matches a cell
                result = "hit";                  // It's a hit
                numOfHits++;                     // Increase hit count
                break;                           // Exit loop after hit
            }
        }

        if (numOfHits == locationCells.length) { // If all cells are hit
            result = "kill";                     // Startup is sunk
        }

        System.out.println(result);              // Show result
        return result;                           // Return result
    }
}

